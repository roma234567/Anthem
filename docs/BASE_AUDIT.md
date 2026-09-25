# Anthem / Wyvern — разбор базы

Дата: 23 сентября 2026 года. Каталог исходников: [`wyvern-dlc/`](../wyvern-dlc/).

## Краткий вывод

Это **Java-клиент Wyvern для Fabric 1.21.4**, а не пустой каркас и пока не переименованный Anthem. Есть собственная система модулей, событий, настроек, ClickGUI, HUD, ротаций и рендера. **Kotlin в архиве отсутствует**; Kotlin Gradle plugin и Fabric Language Kotlin не подключены.

База пригодна как материал для дальнейшей работы, но её **нельзя считать проверенной рабочей сборкой**. Самый важный риск — смешение Yarn named и intermediary в миксинах. Кроме этого, найдены конкретные дефекты жизненного цикла и несколько не подключённых подсистем.

**Исходники не изменены.** Добавлена только документация. Gradle, клиент, DLL и модели из архива не запускались.

### Что охвачено

| Объект | Количество / результат |
|---|---:|
| Файлы исходного архива | **516** |
| Текстовые / бинарные | 477 / 39 |
| Java-файлы | **370**, 40 587 строк |
| Kotlin-файлы | **0** |
| Классы модулей / зарегистрированные модули | **76 / 72** |
| Классы событий проекта | 44 + 2 базовые обёртки |
| Обработчики `@EventTarget` | 129 |
| Файлы миксинов / записи в конфигурации | **45 / 45** |
| Реализации настроек | 9 |
| Файлы ресурсов | 118 |
| Локальные файлы IDEA | 17, исключены существующим `.gitignore` |
| Файлы сборки и остальные служебные файлы | 11 |

Дополнительно прочитан корневой `README.md`, содержащий только название Anthem.

**Полный указатель каждого файла:** [FILE_INDEX.md](FILE_INDEX.md). Там же находятся таблицы всех модулей, событий, миксинов и контрольные суммы бинарных файлов.

Метод: полный файловый инвентарь, чтение текстовых файлов статическими проверками, сопоставление регистраций, импортов, событий и ресурсов; углублённое прослеживание ключевых цепочек и найденных проблем. Это **не** построчное доказательство корректности всех алгоритмов, не проверка обходов античитов и не заключение о безопасности нативных бинарников.

## 1. Сборка и зависимости

Источники: [`gradle.properties`](../wyvern-dlc/gradle.properties), [`build.gradle`](../wyvern-dlc/build.gradle), [`gradle-wrapper.properties`](../wyvern-dlc/gradle/wrapper/gradle-wrapper.properties), [`fabric.mod.json`](../wyvern-dlc/src/main/resources/fabric.mod.json).

| Компонент | Задано в проекте |
|---|---|
| Minecraft | `1.21.4` |
| Маппинги | **Yarn `1.21.4+build.8`, v2** |
| Fabric Loader | `0.16.10` |
| Fabric API | `0.119.3+1.21.4` |
| Java release | **21** |
| Gradle Wrapper | `8.14.1` |
| Fabric Loom | `1.10-SNAPSHOT` |
| Shadow | `9.0.0-beta15` |
| Lombok | `1.18.38`, compileOnly + annotationProcessor |
| Discord IPC | `meteordevelopment:discord-ipc:1.1`, включается в мод |
| Orbit | `meteordevelopment:orbit:0.2.3`, включается, но явных использований в исходниках нет |
| Media Player Info | `dev.redstones.mediaplayerinfo:media-player-info:0.1.0`, Shadow; явных использований нет |
| Maven group | `fun.wyvernpepe` |
| Имя артефакта | `wyvernpepe` |
| Версия Gradle-проекта | `0.1-recode` |
| Mod ID / версия в метаданных | `wyvern` / `1.0-SNAPSHOT` |

`remapJar` получает результат `shadowJar`. Шейдинг и Fabric `include` используются одновременно для разных зависимостей. Внешние библиотеки Minecraft — Gson, Guava, Brigadier, JOML, LWJGL, JNA — видны в импортах; фактическое разрешение classpath в этой сессии не проверялось.

Рабочий каталог Gradle — **`wyvern-dlc`**, не корень репозитория. Для будущей проверки после установки JDK 21: `cd wyvern-dlc && bash gradlew build`. Эта команда **не выполнялась**: в текущей среде нет `java`/`javac`, а прямое скачивание с Maven Fabric завершилось ошибкой TLS.

`build_output.txt` содержит **старый** `compileJava FAILED` без диагностики компилятора. Это не результат текущей проверки и не позволяет определить причину того сбоя.

## 2. Как стартует клиент

[`fabric.mod.json`](../wyvern-dlc/src/main/resources/fabric.mod.json#L13) объявляет client entrypoint `wtf.wyvern.Wyvern::INSTANCE`. [`Wyvern`](../wyvern-dlc/src/main/java/wtf/wyvern/Wyvern.java#L33) — enum-singleton, реализующий `ClientModInitializer`.

`init()` также вызывается из [`MinecraftClientMixin`](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java#L29). Повторный вход ограничен флагом `initialized`.

Порядок внутри `init()`:

1. Каталог `<Minecraft runDirectory>/Wyvern`, shutdown hook.
2. Friends → Macros → Staff → Notifications → ServerHandler → RCTRepository.
3. ThemeManager → **ModuleManager** → **ConfigManager**, сразу загружающий `current_config`.
4. AutoBuyManager → Commands → **ScriptManager** → Discord IPC.
5. ToggleNotify → Waypoints → **MenuScreen**.
6. Resource reload listener → регистрация шейдерных программ.

Важное следствие: загрузка конфигурации может включать модули **раньше**, чем готовы ScriptManager, MenuScreen и часть остальных менеджеров. Это нужно учитывать при любых новых `onEnable()`.

При завершении сохраняются friends, staff, current config и macros, останавливается Discord. Сам shutdown hook не защищён от частично завершившейся инициализации: поля менеджеров могут быть `null`.

## 3. Контракт модулей — под что писать новые

Ключевые файлы:

- [`Module.java`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Module.java) — состояние, lifecycle, бинды, настройки, сериализация.
- [`ModuleAnnotation.java`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/ModuleAnnotation.java) — `name`, `category`, `description`.
- [`Category.java`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Category.java) — `COMBAT`, `MOVEMENT`, `RENDER`, `PLAYER`, `MISC`, `THEMES`.
- [`ModuleManager.java`](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L48) — ручная регистрация, клавиши, анимации и часть возврата ротации.

### Правила этой базы

1. Класс наследуется от `Module` и имеет `@ModuleAnnotation`. Без аннотации конструктор базы обращается к `null`.
2. Обычный стиль — `public static final … INSTANCE` и закрытый конструктор. Исключение уже есть: `new ClientBow()`.
3. Модуль добавляется вручную в соответствующий `registerCombat/Movement/Render/Player/Misc`. Поиска классов на classpath нет.
4. Настройки — поля класса, наследующие `Setting`. `getSettings()` обнаруживает их reflection через **`getDeclaredFields()`**. Наследованные поля настроек автоматически не собираются; списка `addSettings()` в этой базе нет.
5. Подписка на события — `com.darkmagician6.eventapi.EventTarget`.
6. Базовые `onEnable()` / `onDisable()` регистрируют и снимают обработчики. При переопределении нужен вызов `super`, плюс очистка собственного состояния.
7. `KeySetting` обрабатывает сам модуль. ModuleManager автоматически переключает бинды модулей и `BooleanSetting`, но не выполняет произвольные действия `KeySetting`.
8. Имена из аннотаций используются в GUI и ключах конфигов. Имя Java-класса может отличаться: `Aura` → `AttackAura`, `GuiWalk` → `GuiMove`, `Interface` → `HUD`, `EntityESP` → `NameTags`.

**Образец, который действительно есть в базе:** [полный `AutoSprint.java`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AutoSprint.java). В нём есть аннотация, singleton, `BooleanSetting`, `@EventTarget`, проверка `mc.player` и освобождение состояния в `onDisable()`. Зарегистрирован в ModuleManager на строке 76.

### Регистрация по категориям аннотаций

| Категория | Зарегистрировано |
|---|---:|
| Combat | 11 |
| Movement | 11 |
| Render | 29 |
| Player | 8 |
| Misc | 13 |
| Themes | 0 — это раздел выбора тем |
| **Всего** | **72** |

Четыре класса **не зарегистрированы**:

- `combat/Velocity.java`;
- `misc/AHHelper.java` — обращения из mixin аукционного экрана есть, но обычного включения через ModuleManager нет;
- `movement/NoFall.java` — используется **другой** `player/NoFall.java`, выбранный явным импортом в ModuleManager;
- `render/NameTags.java` — зарегистрирован `EntityESP`, уже имеющий имя `NameTags`.

Одинаковые имена двух `NoFall` и двух `NameTags` сейчас **не являются конфликтом двух зарегистрированных модулей**. Но простое добавление оставшихся классов создаст коллизии поиска и сохранения конфигураций.

## 4. События и миксины

Действующий event bus — **встроенный `com.darkmagician6.eventapi`**, не Orbit. `ClientTickEvents` / `WorldRenderEvents` не являются основой модулей: игровые события публикуются миксинами.

[`EventManager`](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/EventManager.java) использует reflection и dispatch по **точному классу** события. Обработчики наследуемых методов не сканируются: используется `getDeclaredMethods()`. Приоритеты — байты `0…4`, по умолчанию `2`.

| Событие | Реальный источник / смысл |
|---|---|
| `EventTick` | `MinecraftClient.tick`, HEAD; может приходить без мира и игрока |
| `EventUpdate` | `ClientPlayerEntity.tick`, HEAD; логика локального игрока |
| `EventGameUpdate` | `MinecraftClient.render`, цикл с шагом `4 166 666 ns`, примерно 240 обновлений/с и catch-up до 240 за кадр; **не обычный игровой тик** |
| `EventTickMovement` | `PlayerEntity.tick`, без проверки `this == mc.player`; не гарантирует один вызов на тик локального игрока |
| `EventMoveInput` | миксин KeyboardInput; изменение forward/strafe/jump и др. |
| `EventMotion` | перезапись отправки движения локального игрока |
| `EventRotation` | CameraMixin; поворот камеры; не путать с `EventRotate` |
| `EventPacket` | ClientConnection: приём `handlePacket` и отправка перегрузки `send(Packet)`; есть отмена и замена |
| `EventRender2D` | InGameHudMixin |
| `EventHudRender` | MixinGameRenderer, пользовательский HUD-контекст |
| `EventRender3D` | MixinGameRenderer; матрицы камеры и tickDelta |

`EventRotate` **не публикуется** существующим кодом, хотя ScriptManager на него подписан. В текущих найденных задачах используется `EventUpdate`, поэтому нельзя приписывать всем задачам зависание из-за этого события.

Также не найдены места создания `EventDirection`, `EventEntityHitBox`, `EventJump`, `EventRenderName`, `EventChatReceive`, `EventPacketPost`. Часть опубликованных событий пока не имеет обработчиков — это свободные точки расширения, а не само по себе ошибка.

45 записей `wyvern.mixins.json` соответствуют 45 исходным файлам. Конфигурация требует применения миксинов (`required: true`, `defaultRequire: 1`). Три зарегистрированных класса пустые: `client/render/ScreenMixin`, `minecraft/entity/LivingEntityMixin`, `minecraft/render/FeatureRendererMixin`.

**Потоки:** dispatch синхронный, перехода на главный поток нет. Сетевые хуки могут вызывать обработчики с сетевого потока; `REGISTRY_MAP` — обычный `HashMap`. `CopyOnWriteArrayList` внутри значений не делает всю систему потокобезопасной.

## 5. Настройки и сохранение

| Тип | Назначение | В текущем ClickGUI |
|---|---|---|
| `BooleanSetting` | переключатель, отдельный бинд | Да |
| `NumberSetting` | float, min/max/step, callback | Да |
| `ModeSetting` | один выбранный режим | Да |
| `MultiBooleanSetting` | несколько выбранных значений | Да |
| `KeySetting` | код клавиши/кнопки | Да |
| `StringSetting` | строка с ограничением длины | Да |
| `ColorSetting` | RGBA и значение по умолчанию | Нет отдельной ветки отображения/ввода |
| `ButtonSetting` | `Runnable`-действие | Нет отдельной ветки отображения/ввода |
| `ItemSelectSetting` | список идентификаторов предметов | Нет отдельной ветки отображения/ввода |

Базовый [`Setting`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/Setting.java) содержит `name`, `Supplier<Boolean> visible` и методы **`safe(JsonObject)`** / `load(JsonObject)`. `safe` — фактическое название метода сохранения, не выдуманный `save`.

Конфиги: `Wyvern/configs/<имя>.wyvern`; внутри JSON с `Modules`, `Theme`, состояниями, биндами и `Settings`. У HUD добавляется `HudElements`. JSON шифруется AES-CBC, PBKDF2, затем Base64; пароль фиксирован в исходнике (`config`). Это формат хранения/обфускация, не секретное хранилище.

`current_config` загружается при создании ConfigManager, сохраняется каждые пять минут и при shutdown. `friends.json`, `staffName.json`, `macro.json` — обычный JSON рядом с `configs`.

## 6. Остальные подсистемы

| Каталог | Что в нём |
|---|---|
| `base/comand` | Brigadier-команды `.friend`, `.macro`, `.vclip`, `.cfg`, `.rct`, `.gps`; имя каталога действительно `comand` |
| `base/autobuy` | каталог обычных и серверных предметов, NBT, скины голов, обычные/кастомные зачарования; отдельного подключённого модуля автоматической покупки нет |
| `base/request` | ScriptManager — очередь Java-задач по событиям, **не** загрузчик внешних скриптов; RequestHandler — заготовленный механизм приоритетных запросов без найденных внешних использований |
| `base/player`, `utility/game/player` | тайминг атаки, слоты/инвентарь, raycast, выбор точек/целей, симуляция движения |
| `utility/component` | общий RotationComponent и FreeLookComponent |
| `client/modules/impl/combat/rotation` | 14 реализаций ротации + базовый класс; Aura создаёт 7 из них |
| `client/screens/menu/wonderful` | state/layout/render/settings/input/theme; это фактически используемое ClickGUI |
| `client/hud` | draggable-компоненты, два варианта HUD, watermark, эффекты, бинды, цель, staff, уведомления |
| `base/font` | MSDF-шрифты, метрики, глифы, kerning, форматированный текст |
| `utility/render` | 2D/3D-отрисовка, clipping/stencil, framebuffer, blur, glow, шейдеры рук/блока/неба |
| `base/theme` | палитры и темы, выбранная тема сохраняется в конфиг |
| `base/repository`, `utility/game/server` | определение серверного режима, TPS, PvP-индикатор, RCT-переходы |
| `base/discord` | активный Discord IPC и отдельно оставшийся старый JNA RPC-код |
| `ru/nexusguard` | интерфейс/заглушка профиля и маркерные аннотации; готовой системы авторизации здесь не видно |

ClickGUI по умолчанию открывается на **Right Shift**, код `344`, только при наличии мира. `Panel`, `TextBox` и часть общих UI-классов не входят в текущую цепочку MenuScreen — их нельзя принимать за основной UI без проверки ссылок.

`ScoreboardHealth` и `FullBright` — не обязательно «пустые неработающие модули»: их флаги читаются из других классов/миксинов. И наоборот, наличие зарегистрированного класса само по себе не означает подключённую функциональность — пример `TpsSync` ниже.

## 7. Найденные проблемы

Обозначения: **подтверждено по исходникам** — видна конкретная несогласованность; **риск** — необходим build/runtime-тест для оценки проявления. Приоритет отражает порядок проверки, а не заявленный результат запуска.

### P0 / первая проверка — M-01: named Yarn смешан с intermediary

**Подтверждено: 13 файлов миксинов содержат 59 уникальных в пределах каждого файла идентификаторов `field_…` / `method_…`.** В проекте при этом выбраны named Yarn mappings.

Пример: [`ClientPlayerEntityMixin.java:37–77`](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L37) содержит `@Shadow field_3941`, `field_3937`, `method_46742`, а [строка 166](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L166) — `@Overwrite method_3136()`.

В исходниках [Yarn для ветки 1.21.4, commit `6bc65dadc544e56210613c2db253c5325eef335a`](https://github.com/FabricMC/yarn/blob/6bc65dadc544e56210613c2db253c5325eef335a/mappings/net/minecraft/client/network/ClientPlayerEntity.mapping) это соответственно `lastYaw`, `client`, `sendSprintingPacket`, `sendMovementPackets`. Проверен файл маппингов этой ветки, **не** скачанный Maven-артефакт `build.8`.

Это конкретный конфликт пространств имён и ожидаемый блокер named dev-сборки либо применения миксинов. **Фактические сообщения компилятора/загрузчика ещё не получены.** Обычные reflection-fallback строки в ShulkerPreview и собственный метод SimulatedPlayer в эти 13 файлов не включены.

### P1 — L-01: Blink не подключён к событиям и не накапливает пакеты

[`Blink.java:35–68`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/Blink.java#L35): `onEnable()` и `onDisable()` не вызывают базовые методы. Поэтому `onUpdate` не подписывается обычным включением модуля. `packets` только очищается/читается, нет обработчика `EventPacket` и нет добавления в очередь. Обращений к Blink, подключающих очередь извне, не найдено.

**Итог:** переключатель присутствует, заявленный механизм задержки пакетов в этой версии не реализован до рабочего состояния.

### P1 — L-02: уведомления используют два разных NotifyManager

[`Wyvern.java:89`](../wyvern-dlc/src/main/java/wtf/wyvern/Wyvern.java#L89) создаёт менеджер конструктором; [`Interface.java:59`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java#L59) прикрепляет HUD к этому объекту. Однако [`NotifyManager.getInstance():37–42`](../wyvern-dlc/src/main/java/wtf/wyvern/base/notify/NotifyManager.java#L37) создаёт второй объект, поскольку конструктор не присваивает статическое `instance`.

RCT-команды и RCTRepository обращаются именно ко второму объекту, у которого пустой список HUD-компонентов. Их текстовые уведомления не достигают зарегистрированного NotifyComponent.

### P1 — L-03: GPS игрока читает не тот waypoint

[`WaypointManager.java:50–53`](../wyvern-dlc/src/main/java/wtf/wyvern/base/waypoint/WaypointManager.java#L50): `removePlayerWaypoint()` проверяет `activePlayerWaypoint`, но сравнивает `activeWaypoint`.

[`WaypointManager.java:94–100`](../wyvern-dlc/src/main/java/wtf/wyvern/base/waypoint/WaypointManager.java#L94): отрисовка player-waypoint берёт координаты обычного `activeWaypoint`. При установленной только точке игрока это даёт `null`-доступ; при двух точках — координаты не той точки. Исключение обработчика скрывается event bus.

### P1 — E-01: event bus скрывает ошибки обработчиков

[`EventManager.java:139–143`](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/EventManager.java#L139) полностью игнорирует `InvocationTargetException`, `IllegalAccessException`, `IllegalArgumentException`. Сбой модуля выглядит как отсутствие реакции без полезной диагностики.

Дополнительный риск — конкурентная работа обычного `HashMap` реестра с сетевыми событиями. Логирование и явный контракт потоков нужны до отладки сложных модулей.

### P1 — L-04: lifecycle API допускает рассогласование

[`Module.java:35–42`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Module.java#L35): `setToggled(state)` сначала вызывает lifecycle, а затем меняет `enabled`; `EventModuleToggle` получает прежнее состояние. Повторная установка `true` может зарегистрировать обработчики ещё раз, поскольку [`EventManager.java:73`](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/EventManager.java#L73) не исключает дубликаты.

`setEnabled()` меняет только флаг. Закрытие GUI через [`MenuScreen.java:89–94`](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/MenuScreen.java#L89) использует этот путь вместо `onDisable()`. FakePlayer также обходит базовые lifecycle-уведомления.

Это дефекты контракта. Явных внешних вызовов `setToggled()` сейчас не найдено — проблема этого метода латентная, особенно важная для следующих модулей.

### P1 — I-01: конфиг активирует модуль до загрузки его настроек

[`Module.java:96–122`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Module.java#L96): `toggle()` выполняется раньше `setting.load()`. `onEnable()` видит прежние значения. При старте это дополнительно пересекается с незавершённой инициализацией менеджеров.

[`Wyvern.java:74`](../wyvern-dlc/src/main/java/wtf/wyvern/Wyvern.java#L74) устанавливает `initialized = true` до успешного окончания `init()`. При исключении повторная попытка инициализации уже будет пропущена. Это риск нестабильного старта и восстановления.

### P1 / проверка — E-02: события имеют неожиданные частоты

[`PlayerEntityMixin.java:13–19`](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/PlayerEntityMixin.java#L13) публикует `EventTickMovement` из базового PlayerEntity без фильтра локального игрока. На него подписаны Aura, ElytraHelper, ServerHelper. Число вызовов может зависеть от тикающих игроков.

[`MinecraftClientMixin.java:51–62`](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java#L51) публикует `EventGameUpdate` примерно с частотой 240 Гц. Оба события нельзя использовать как синоним стандартного клиентского тика.

### P2 — N-01: отмена и замена исходящего пакета не согласованы

[`ClientConnectionMixin.java:46–57`](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientConnectionMixin.java#L46): после отмены события код всё равно отправляет заменённый пакет, если обработчик поменял ссылку. Защитный флаг рекурсии снимается не в `finally`; исключение при отправке может оставить его выставленным.

Это дефект инфраструктурного сценария «отмена + замена», а не утверждение, что каждый текущий модуль его воспроизводит.

### P2 — R-01: не все классы и функции подключены

- Четыре незарегистрированных модуля перечислены в разделе 3.
- [`TpsSync`](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/TpsSync.java) зарегистрирован, но его `getAdjustedCooldown` / `canAttack` не вызываются из других исходников. Изменение тайминга атаки через этот модуль не прослеживается.
- [`StaffCommand`](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/StaffCommand.java#L13) не регистрируется и содержит `super("friend")`; простая регистрация без переименования пересечётся с FriendCommand.
- `CfgArgumentType`, `ModuleArgumentType`, часть ротаций и несколько UI/utility-классов не имеют найденных прямых потребителей. Это кандидаты на разбор зависимостей, не автоматическое разрешение удалить их.

### P2 — C-01: сохранение конфигураций хрупкое

[`ConfigManager.java:34–40`](../wyvern-dlc/src/main/java/wtf/wyvern/base/config/ConfigManager.java#L34) сохраняет конфиг фоновым executor. [`saveConfig():96–102`](../wyvern-dlc/src/main/java/wtf/wyvern/base/config/ConfigManager.java#L96) пишет сразу в целевой файл, без временного файла/atomic replace и без согласованного снимка состояния.

Возможны неполный файл при прерывании записи и гонки с изменением настроек. Широкие `catch` скрывают детали. `NumberSetting.setCurrent()` не проверяет min/max/finite при загрузке; ограничения применяет GUI, а не сам тип настройки. `ItemSelectSetting` принимает `visible`, но в конструкторе не вызывает `setVisible`.

### P2 — U-01: GUI поддерживает только 6 из 9 типов настроек

[`ClickGuiSettingRenderer.java:45–63`](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiSettingRenderer.java#L45), `ClickGuiLayout`, `ClickGuiInputHandler`: нет отдельных веток для ColorSetting, ButtonSetting, ItemSelectSetting. Новый модуль с такими полями может сохранять их, но не получит полноценного редактора в действующем GUI.

### P2 — A-01: ссылки на отсутствующие ресурсы

- [`fabric.mod.json:11`](../wyvern-dlc/src/main/resources/fabric.mod.json#L11) ссылается на `assets/wyvern/icons/avatar.png`, которого нет.
- [`sky/sky_shader.json`](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/sky/sky_shader.json) ссылается на два пути в namespace `javelin`, отсутствующем в архиве. Текущий CustomSky использует другую группу `skyshader`; поэтому этот дефект старого ресурса **не объявляется доказанным падением активного CustomSky**.

### P2 — B-01: CI в текущем расположении не работает

[`wyvern-dlc/.github/workflows/gradle.yml`](../wyvern-dlc/.github/workflows/gradle.yml) лежит внутри подпапки: GitHub не обнаружит его как workflow репозитория. Даже после переноса остаются:

- триггер на `master`, тогда как основная ветка репозитория — `main`;
- команды `./gradlew` без рабочего каталога `wyvern-dlc`;
- путь к `javelinpepe-0.1-recode.jar`, хотя Gradle задаёт `wyvernpepe`;
- избыточное `permissions: write-all`.

### P3 — B-02: метаданные и наследие базы

`build.gradle` пытается включить `LICENSE`, но в архиве `LICENSE.txt`. Версия Fabric-метаданных не синхронизирована с `mod_version`. Есть старые имена Javelin/pepejavelin, IDEA launch-конфигурации с локальными путями и незакреплённый Loom snapshot. В сочетании с `var1`, `$values`, intermediary-именами это **признаки частично восстановленного/переработанного кода**, но не доказательство его происхождения.

## 8. Ресурсы, бинарники и внешние взаимодействия

### Проверено без исполнения

- **43/43 JSON** синтаксически читаются.
- **15/15 XML/IML** читаются XML-парсером.
- **32/32 PNG**: сигнатуры, размеры, CRC чанков до IEND корректны.
- **16/16 шрифтовых JSON** имеют PNG-пару подходящего размера; повторяющихся Unicode-ключей глифов не найдено.
- **24 shader JSON**: проверены ссылки на vertex/fragment; две отсутствующие ссылки относятся к старому `sky_shader.json`. GLSL на GPU не компилировался.
- Оба звука из `sounds.json` имеют соответствующий OGG-файл; аудио не воспроизводилось.
- Gradle Wrapper JAR: ZIP CRC корректен; **побайтно совпадает** с [официальным файлом Gradle v8.14.1](https://github.com/gradle/gradle/blob/v8.14.1/gradle/wrapper/gradle-wrapper.jar). SHA-256: `7d3a4ac4de1c32b59bc6a4eb8ecb8e612ccd0cf1ae1e99f66902da64df296172`.
- `discord-rpc.dll`: PE machine `0x014c`, **32-битный x86**. Не дизассемблировалась и не запускалась. Активный DiscordManager использует отдельную библиотеку Discord IPC, а не этот JNA-интерфейс.
- Три `.params` имеют сигнатуру `DJL@`; явных загрузчиков этих файлов в Java-исходниках не найдено. Веса не десериализовывались.
- В `icons/snow.png` после корректного IEND есть **22 798 дополнительных байтов**. Это отмеченная особенность контейнера; происхождение хвоста не установлено, вывод о вредоносности из этого не делается.

### Что делает код за пределами игровой логики

- DiscordManager подключается к Discord IPC и обновляет Rich Presence.
- `.cfg dir` запускает `explorer` для открытия каталога: Windows-специфичная команда, не произвольный shell-скрипт.
- В ServerHandler есть вспомогательные HTTP HEAD-методы чтения заголовка `Date`; вызовов из рабочей логики не найдено.
- В SkinItemBuy используются профили текстур голов; данные каталога содержат Base64-представления Minecraft texture URL.
- Запись собственных конфигов и списков ограничена описанными менеджерами по обычным путям их хранения.

Это обзор видимых исходников, **не сертификат отсутствия вредоносного поведения**: нативная DLL, сторонние зависимости и фактическое выполнение вне области этой проверки.

## 9. Порядок дальнейшей работы

1. **Получить чистую сборку на JDK 21.** Сначала нормализовать имена миксинов по закреплённому Yarn, проверить shadow/overwrite/access widener и только затем разбирать оставшуюся диагностику Gradle.
2. **Привести в порядок инфраструктуру:** logging event bus, однозначный lifecycle, порядок инициализации/конфигов, единственный NotifyManager, GPS. Подтвердить контракт потоков и частот событий.
3. **Определить действующие реализации:** выбрать NoFall/NameTags, решить судьбу Blink, TpsSync и незарегистрированных модулей. Не включать всё автоматически.
4. **Проверить UI и ресурсы:** загрузка шейдеров, resource reload, HUD/ClickGUI, сохранение настроек и выход/вход в мир.
5. **Дальше писать модули по одному** под существующие `ModuleAnnotation`, `ModuleManager`, `@EventTarget` и поля `Setting`, без перестройки архитектуры целиком.

### Чего этот разбор не подтверждает

Нет результата свежего `build`, запуска клиента, проверки Mixin на реальном classpath, GPU-компиляции шейдеров, тестирования производительности и серверного поведения. В проекте не найдены тестовые исходники `src/test` и настроенная отдельная тестовая база.

На момент завершения сверены SHA-256 всех 516 исходных файлов: содержимое осталось неизменным. Удаление архива, выполненное ранее по запросу, не отменялось. Коммитов и push в этой операции не делалось.
