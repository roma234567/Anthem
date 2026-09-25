# Указатель всех файлов базы Wyvern

Дата: 23 сентября 2026 года. Основной анализ и приоритеты: [BASE_AUDIT.md](BASE_AUDIT.md).

В разделе «Пофайловый указатель» **516 строк — по одной на каждый файл исходного архива**. Пути разделов указаны относительно `wyvern-dlc/`. Дополнительные таблицы ниже показывают связи модулей, событий и миксинов.

Назначение модулей описывает код/аннотации, а не подтверждает работоспособность на сервере. «Нет источника/ссылок» означает результат статического поиска в этой базе, не доказательство недостижимости через reflection. Бинарники проверялись по контейнерам/заголовкам и хешам, не исполнялись.

## Навигация

- [Пофайловый указатель](#files)
- [Все 76 модулей](#modules)
- [Все 44 события](#events)
- [Все 45 миксинов](#mixins)
- [Бинарники: SHA-256](#binaries)

<a id="files"></a>
## Пофайловый указатель

Формат объёма: строки для текстовых файлов, байты для бинарных. JSON/XML синтаксически прочитаны; Java/GLSL не компилировались.

### `./` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [.gitignore](../wyvern-dlc/.gitignore) | 10 строк | Исключения IDEA, Gradle cache/build/run и старых launcher-файлов. |
| [LICENSE.txt](../wyvern-dlc/LICENSE.txt) | 2 строк | All rights reserved; build.gradle ссылается на другое имя LICENSE. |
| [build.gradle](../wyvern-dlc/build.gradle) | 66 строк | Fabric Loom/Shadow, зависимости, Java 21, access widener и remapJar. |
| [build_output.txt](../wyvern-dlc/build_output.txt) | 16 строк | Архивный лог compileJava FAILED без самой диагностики; не результат текущего запуска. |
| [gradle.properties](../wyvern-dlc/gradle.properties) | 11 строк | Закреплённые Minecraft/Yarn/Loader/Fabric API, версия и имя артефакта. |
| [gradlew](../wyvern-dlc/gradlew) | 251 строк | Unix shell launcher Gradle Wrapper; чтение, без исполнения. В архиве не имел executable-бита. |
| [gradlew.bat](../wyvern-dlc/gradlew.bat) | 94 строк | Windows launcher Gradle Wrapper; без исполнения. |
| [settings.gradle](../wyvern-dlc/settings.gradle) | 10 строк | pluginManagement: Fabric Maven и Gradle Plugin Portal; rootProject.name не задан. |

### `.github/workflows/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [gradle.yml](../wyvern-dlc/.github/workflows/gradle.yml) | 39 строк | CI-файл внутри подпапки: GitHub его не обнаружит. master/путь артефакта/working directory требуют исправления. |

### `.idea/` — 9

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [.gitignore](../wyvern-dlc/.idea/.gitignore) | 10 строк | Дополнительные исключения локальных IDEA-файлов. Исключён из Git правилами проекта. |
| [.name](../wyvern-dlc/.idea/.name) | 1 строк | Локальное имя IDEA-проекта, оставшееся от базы. Исключён из Git правилами проекта. |
| [AndroidProjectSystem.xml](../wyvern-dlc/.idea/AndroidProjectSystem.xml) | 6 строк | Метаданные Android-интеграции IDE, не Android-модуль клиента. Исключён из Git правилами проекта. |
| [compiler.xml](../wyvern-dlc/.idea/compiler.xml) | 78 строк | Локальные настройки Java compiler/annotation processing и старые имена модулей. Исключён из Git правилами проекта. |
| [gradle.xml](../wyvern-dlc/.idea/gradle.xml) | 19 строк | Локальная связь IDEA с Gradle и настройки импорта. Исключён из Git правилами проекта. |
| [jarRepositories.xml](../wyvern-dlc/.idea/jarRepositories.xml) | 60 строк | Список Maven-репозиториев, сохранённый IDE; не заменяет build.gradle. Исключён из Git правилами проекта. |
| [misc.xml](../wyvern-dlc/.idea/misc.xml) | 7 строк | Настройки project SDK/framework detection IDEA. Исключён из Git правилами проекта. |
| [modules.xml](../wyvern-dlc/.idea/modules.xml) | 8 строк | Список IDEA-модулей. Исключён из Git правилами проекта. |
| [workspace.xml](../wyvern-dlc/.idea/workspace.xml) | 256 строк | Локальный workspace: история задач, окна, запуски и пути; не часть логики клиента. Исключён из Git правилами проекта. |

### `.idea/modules/` — 6

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Javelinpepe.main.iml](../wyvern-dlc/.idea/modules/Javelinpepe.main.iml) | 18 строк | Локальное описание IDEA-модуля, включая наследие прежних имён проекта. Исключён из Git правилами проекта. |
| [Javelinpepe.test.iml](../wyvern-dlc/.idea/modules/Javelinpepe.test.iml) | 18 строк | Локальное описание IDEA-модуля, включая наследие прежних имён проекта. Исключён из Git правилами проекта. |
| [pepejavelin.main.iml](../wyvern-dlc/.idea/modules/pepejavelin.main.iml) | 8 строк | Локальное описание IDEA-модуля, включая наследие прежних имён проекта. Исключён из Git правилами проекта. |
| [wyvern-dlc.main.iml](../wyvern-dlc/.idea/modules/wyvern-dlc.main.iml) | 8 строк | Локальное описание IDEA-модуля, включая наследие прежних имён проекта. Исключён из Git правилами проекта. |
| [еуые.main.iml](../wyvern-dlc/.idea/modules/%D0%B5%D1%83%D1%8B%D0%B5.main.iml) | 18 строк | Локальное описание IDEA-модуля, включая наследие прежних имён проекта. Исключён из Git правилами проекта. |
| [еуые.test.iml](../wyvern-dlc/.idea/modules/%D0%B5%D1%83%D1%8B%D0%B5.test.iml) | 18 строк | Локальное описание IDEA-модуля, включая наследие прежних имён проекта. Исключён из Git правилами проекта. |

### `.idea/runConfigurations/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Minecraft_Client.xml](../wyvern-dlc/.idea/runConfigurations/Minecraft_Client.xml) | 16 строк | Локальная IDE run-конфигурация клиента с машинно-зависимыми параметрами. Исключён из Git правилами проекта. |
| [Minecraft_Server.xml](../wyvern-dlc/.idea/runConfigurations/Minecraft_Server.xml) | 16 строк | Локальная IDE run-конфигурация сервера; мод в fabric.mod.json объявлен client-only. Исключён из Git правилами проекта. |

### `gradle/wrapper/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [gradle-wrapper.jar](../wyvern-dlc/gradle/wrapper/gradle-wrapper.jar) | 43 764 байт | Официальный Gradle Wrapper: совпал побайтно с Gradle v8.14.1, ZIP CRC корректен; не запускался. |
| [gradle-wrapper.properties](../wyvern-dlc/gradle/wrapper/gradle-wrapper.properties) | 7 строк | URL Gradle 8.14.1, cache-пути, timeout и проверка URL. |

### `src/main/java/com/darkmagician6/eventapi/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventAPI.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/EventAPI.java) | 9 строк | Метаданные встроенной библиотеки EventAPI; не основной диспетчер событий. |
| [EventManager.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/EventManager.java) | 169 строк | Reflection event bus: register/unregister, приоритеты, синхронный dispatch по точному классу; ошибки обработчиков скрываются. |
| [EventTarget.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/EventTarget.java) | 14 строк | Runtime-аннотация обработчика, приоритет по умолчанию 2. |

### `src/main/java/com/darkmagician6/eventapi/events/` — 4

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Cancellable.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/events/Cancellable.java) | 7 строк | Контракт отменяемого события. |
| [Event.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/events/Event.java) | 4 строк | Маркерный интерфейс события. |
| [EventStoppable.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/events/EventStoppable.java) | 16 строк | Событие с остановкой дальнейшего обхода обработчиков. |
| [Typed.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/events/Typed.java) | 5 строк | Контракт события с байтовым типом. |

### `src/main/java/com/darkmagician6/eventapi/events/callables/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventCancellable.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/events/callables/EventCancellable.java) | 19 строк | Базовая реализация флага отмены события. |
| [EventTyped.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/events/callables/EventTyped.java) | 16 строк | Базовая реализация байтового типа события. |

### `src/main/java/com/darkmagician6/eventapi/types/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventType.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/types/EventType.java) | 9 строк | Константы стадий PRE/POST встроенной EventAPI. |
| [Priority.java](../wyvern-dlc/src/main/java/com/darkmagician6/eventapi/types/Priority.java) | 10 строк | Константы и порядок приоритетов обработчиков. |

### `src/main/java/ru/nexusguard/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [IGuard.java](../wyvern-dlc/src/main/java/ru/nexusguard/IGuard.java) | 13 строк | Интерфейс профиля: имя, HWID, роль, UID. |
| [UserProfile.java](../wyvern-dlc/src/main/java/ru/nexusguard/UserProfile.java) | 135 строк | Локальные значения-заглушки профиля и IRC-префикса; внешних потребителей класса не найдено. |

### `src/main/java/ru/nexusguard/protection/annotations/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Compile.java](../wyvern-dlc/src/main/java/ru/nexusguard/protection/annotations/Compile.java) | 12 строк | Маркерная аннотация упаковки/защиты с параметром PackerType; сама код не компилирует. |
| [Native.java](../wyvern-dlc/src/main/java/ru/nexusguard/protection/annotations/Native.java) | 11 строк | Маркерная аннотация с RetentionPolicy.CLASS; не JNI-реализация. |
| [PackerType.java](../wyvern-dlc/src/main/java/ru/nexusguard/protection/annotations/PackerType.java) | 12 строк | Перечень режимов упаковщика для аннотации Compile. |

### `src/main/java/wtf/wyvern/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Wyvern.java](../wyvern-dlc/src/main/java/wtf/wyvern/Wyvern.java) | 228 строк | Client entrypoint и enum-singleton: порядок менеджеров, ресурсы, каталог Wyvern, shutdown. |

### `src/main/java/wtf/wyvern/base/animations/base/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Animation.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/animations/base/Animation.java) | 160 строк | Состояние анимации, время, обновление и интерполяция через Easing. |
| [Easing.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/animations/base/Easing.java) | 308 строк | Набор кривых интерполяции, включая elastic/back и стандартные функции easing. |

### `src/main/java/wtf/wyvern/base/animations/types/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ColorCycleRGBA.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/animations/types/ColorCycleRGBA.java) | 74 строк | Циклическая анимация цвета и преобразование в Gradient; прямых потребителей не найдено. |

### `src/main/java/wtf/wyvern/base/autobuy/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AutoBuyManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/AutoBuyManager.java) | 225 строк | Каталоги Vanilla/FunTime/HolyWorld: предметы, серверные NBT, зачарования и скины голов; не автоматический покупатель. |

### `src/main/java/wtf/wyvern/base/autobuy/enchantes/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Enchant.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/enchantes/Enchant.java) | 44 строк | Базовая модель требуемого зачарования и уровня. |

### `src/main/java/wtf/wyvern/base/autobuy/enchantes/container/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EnchantContainer.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/enchantes/container/EnchantContainer.java) | 96 строк | Разбор строковых описаний списков обычных и кастомных зачарований. |

### `src/main/java/wtf/wyvern/base/autobuy/enchantes/custom/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EnchantCustom.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/enchantes/custom/EnchantCustom.java) | 32 строк | Модель серверного/кастомного зачарования. |

### `src/main/java/wtf/wyvern/base/autobuy/enchantes/minecraft/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EnchantVanilla.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/enchantes/minecraft/EnchantVanilla.java) | 36 строк | Модель обычного Minecraft-зачарования. |

### `src/main/java/wtf/wyvern/base/autobuy/item/` — 4

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EnchantItemBuy.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/item/EnchantItemBuy.java) | 45 строк | Элемент каталога покупки с набором зачарований. |
| [ItemBuy.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/item/ItemBuy.java) | 60 строк | Базовый элемент каталога покупки: ItemStack, название и категория. |
| [NbtItemBuy.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/item/NbtItemBuy.java) | 58 строк | Элемент каталога с признаками в NBT/custom data. |
| [SkinItemBuy.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/autobuy/item/SkinItemBuy.java) | 55 строк | Элемент каталога на основе головы игрока и профиля текстуры. |

### `src/main/java/wtf/wyvern/base/comand/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CommandManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/CommandManager.java) | 67 строк | Brigadier dispatcher, префикс «.», регистрация шести клиентских команд. |

### `src/main/java/wtf/wyvern/base/comand/api/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CommandAbstract.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/api/CommandAbstract.java) | 41 строк | База команды, построение literal/argument и регистрация в dispatcher. |

### `src/main/java/wtf/wyvern/base/comand/impl/` — 7

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ClipCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/ClipCommand.java) | 100 строк | Команда .vclip: вертикальное перемещение, поиск границ свободного пространства. |
| [ConfigCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/ConfigCommand.java) | 62 строк | Команда .cfg save/load/dir; dir открывает каталог через Windows explorer. |
| [FriendCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/FriendCommand.java) | 46 строк | Команда .friend add/remove/list. |
| [GPSCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/GPSCommand.java) | 55 строк | Команда .gps: обычная точка и именованная точка игрока, удаление точек. |
| [MacroCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/MacroCommand.java) | 83 строк | Команда .macro: сохранение текста на бинд, удаление и список. |
| [RCTCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/RCTCommand.java) | 53 строк | Команда .rct: переход между серверными режимами через RCTRepository. |
| [StaffCommand.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/StaffCommand.java) | 41 строк | Незарегистрированная команда списка staff; конструктор ошибочно использует имя friend. |

### `src/main/java/wtf/wyvern/base/comand/impl/args/` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CfgArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/CfgArgumentType.java) | 42 строк | Парсер/подсказки имён конфигов; в действующем ConfigCommand не используется. |
| [CommandArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/CommandArgumentType.java) | 35 строк | Парсер текста макроса и подсказок команды. |
| [CoordinateArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/CoordinateArgumentType.java) | 36 строк | Парсер координат/смещения для vclip. |
| [FriendArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/FriendArgumentType.java) | 40 строк | Подсказки аргумента из списка друзей. |
| [MacroArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/MacroArgumentType.java) | 41 строк | Парсер клавиши для создания макроса. |
| [MacroRemoveArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/MacroRemoveArgumentType.java) | 43 строк | Подсказки существующих макросов для удаления. |
| [ModuleArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/ModuleArgumentType.java) | 42 строк | Подсказки имён модулей; подключённой команды-потребителя не найдено. |
| [PlayerArgumentType.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/comand/impl/args/PlayerArgumentType.java) | 33 строк | Парсер имени игрока с подсказками сетевого списка. |

### `src/main/java/wtf/wyvern/base/config/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Config.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/config/Config.java) | 96 строк | JSON-структура Modules/Theme и путь к одному файлу .wyvern. |
| [ConfigManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/config/ConfigManager.java) | 172 строк | Загрузка/сохранение/поиск/удаление конфигов, шифрование, автосохранение current_config раз в 5 минут. |

### `src/main/java/wtf/wyvern/base/discord/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [DiscordInfo.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/DiscordInfo.java) | 21 строк | Отдельный record профиля Discord; одноимённый вложенный record также объявлен в DiscordManager. |
| [DiscordManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/DiscordManager.java) | 95 строк | Активный Discord IPC, Rich Presence и daemon-обновление; load() пустой, профиль по умолчанию Unknown. |

### `src/main/java/wtf/wyvern/base/discord/callbacks/` — 6

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [DisconnectedCallback.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/callbacks/DisconnectedCallback.java) | 7 строк | JNA callback старого Discord RPC: Disconnected. Активный DiscordManager использует Discord IPC. |
| [ErroredCallback.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/callbacks/ErroredCallback.java) | 7 строк | JNA callback старого Discord RPC: Errored. Активный DiscordManager использует Discord IPC. |
| [JoinGameCallback.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/callbacks/JoinGameCallback.java) | 7 строк | JNA callback старого Discord RPC: JoinGame. Активный DiscordManager использует Discord IPC. |
| [JoinRequestCallback.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/callbacks/JoinRequestCallback.java) | 8 строк | JNA callback старого Discord RPC: JoinRequest. Активный DiscordManager использует Discord IPC. |
| [ReadyCallback.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/callbacks/ReadyCallback.java) | 8 строк | JNA callback старого Discord RPC: Ready. Активный DiscordManager использует Discord IPC. |
| [SpectateGameCallback.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/callbacks/SpectateGameCallback.java) | 7 строк | JNA callback старого Discord RPC: SpectateGame. Активный DiscordManager использует Discord IPC. |

### `src/main/java/wtf/wyvern/base/discord/utils/` — 5

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [DiscordEventHandlers.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/utils/DiscordEventHandlers.java) | 62 строк | Структура callback-функций старого JNA Discord RPC. |
| [DiscordRPC.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/utils/DiscordRPC.java) | 48 строк | Старый JNA-интерфейс Native.load("discord-rpc"); текущий DiscordManager его не использует. |
| [DiscordRichPresence.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/utils/DiscordRichPresence.java) | 152 строк | JNA-структура presence и builder старого RPC. |
| [DiscordUser.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/utils/DiscordUser.java) | 22 строк | JNA-структура пользователя старого RPC. |
| [RPCButton.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/discord/utils/RPCButton.java) | 37 строк | Описание кнопки старого Discord presence. |

### `src/main/java/wtf/wyvern/base/events/callables/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventCancellable.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/callables/EventCancellable.java) | 23 строк | Дубликат базовой обёртки EventAPI в namespace Wyvern. Базовая реализация флага отмены события. |
| [EventTyped.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/callables/EventTyped.java) | 16 строк | Дубликат базовой обёртки EventAPI в namespace Wyvern. Базовая реализация байтового типа события. |

### `src/main/java/wtf/wyvern/base/events/impl/entity/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventEntityColor.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/entity/EventEntityColor.java) | 23 строк | Изменяемый цвет/прозрачность сущности. |

### `src/main/java/wtf/wyvern/base/events/impl/input/` — 6

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventChatSend.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventChatSend.java) | 23 строк | Отправка сообщения чата. |
| [EventHotBarScroll.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventHotBarScroll.java) | 35 строк | Прокрутка выбора слота hotbar. |
| [EventKey.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventKey.java) | 46 строк | Код клавиши/кнопки и действие ввода. |
| [EventMouse.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventMouse.java) | 25 строк | Событие кнопки мыши. |
| [EventMouseRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventMouseRotation.java) | 35 строк | Изменение мышиного поворота. |
| [EventSetScreen.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventSetScreen.java) | 69 строк | Возможность заменить открываемый Screen. |

### `src/main/java/wtf/wyvern/base/events/impl/other/` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventClickSlot.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventClickSlot.java) | 60 строк | Взаимодействие с инвентарным слотом. |
| [EventCloseScreen.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventCloseScreen.java) | 14 строк | Закрытие контейнерного экрана. |
| [EventGameUpdate.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventGameUpdate.java) | 6 строк | Высокочастотное обновление из render, около 240 Гц. |
| [EventModuleToggle.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventModuleToggle.java) | 26 строк | Модуль и его состояние при lifecycle. |
| [EventSpawnEntity.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventSpawnEntity.java) | 19 строк | Добавление сущности в ClientWorld. |
| [EventTick.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventTick.java) | 6 строк | MinecraftClient.tick, также без игрока/мира. |
| [EventTickMovement.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventTickMovement.java) | 6 строк | PlayerEntity.tick без фильтра локального игрока. |
| [EventWindowResize.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventWindowResize.java) | 7 строк | Изменение размера окна. |

### `src/main/java/wtf/wyvern/base/events/impl/player/` — 14

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventAttack.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventAttack.java) | 19 строк | Атака сущности. |
| [EventDirection.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventDirection.java) | 72 строк | Объект события направления; источник/потребители не найдены. |
| [EventEntityHitBox.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventEntityHitBox.java) | 84 строк | Объект изменения хитбокса; источник/потребители не найдены. |
| [EventJump.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventJump.java) | 6 строк | Событие прыжка; источник/потребители не найдены. |
| [EventLook.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventLook.java) | 35 строк | Изменение свободного взгляда от мыши. |
| [EventMotion.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventMotion.java) | 37 строк | Yaw/pitch перед отправкой движения; экземпляр переиспользуется. |
| [EventMove.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventMove.java) | 24 строк | Изменяемый вектор движения. |
| [EventMoveInput.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventMoveInput.java) | 48 строк | Изменяемый клавиатурный ввод движения. |
| [EventPickupItem.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventPickupItem.java) | 85 строк | Подбор предмета из серверного пакета. |
| [EventRotate.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventRotate.java) | 7 строк | Отменяемое событие; ScriptManager слушает, источник не найден. |
| [EventRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventRotation.java) | 47 строк | Поворот камеры; другое событие, не EventRotate. |
| [EventSlowWalking.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventSlowWalking.java) | 7 строк | Возможность отменить замедление при использовании предмета. |
| [EventSprintUpdate.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventSprintUpdate.java) | 6 строк | Возможность отменить отправку состояния sprint. |
| [EventUpdate.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventUpdate.java) | 7 строк | Тик локального ClientPlayerEntity. |

### `src/main/java/wtf/wyvern/base/events/impl/render/` — 12

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventAspectRatio.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventAspectRatio.java) | 18 строк | Изменяемое соотношение сторон проекции. |
| [EventCamera.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventCamera.java) | 48 строк | Параметры/режим камеры. |
| [EventCameraPosition.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventCameraPosition.java) | 24 строк | Позиция камеры. |
| [EventFog.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventFog.java) | 29 строк | Параметры и цвет тумана. |
| [EventFov.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventFov.java) | 18 строк | Изменяемый FOV. |
| [EventHandledScreen.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventHandledScreen.java) | 41 строк | Контекст отрисовки контейнерного экрана. |
| [EventHudRender.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventHudRender.java) | 26 строк | Кастомный HUD с CustomDrawContext. |
| [EventRender2D.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRender2D.java) | 26 строк | 2D-отрисовка из InGameHud. |
| [EventRender3D.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRender3D.java) | 26 строк | 3D-отрисовка, матрицы и tickDelta. |
| [EventRenderName.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRenderName.java) | 7 строк | Отрисовка имени сущности; источник не найден. |
| [EventRenderScreen.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRenderScreen.java) | 19 строк | Отрисовка Screen с UIContext. |
| [EventRenderSky.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRenderSky.java) | 29 строк | Окончание renderSky, матрицы и tickDelta. |

### `src/main/java/wtf/wyvern/base/events/impl/server/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [EventChatReceive.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/server/EventChatReceive.java) | 24 строк | Объект принятого чата; источник/потребители не найдены. |
| [EventPacket.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/server/EventPacket.java) | 48 строк | Отмена/замена пакета, Action SENT/RECEIVE. |
| [EventPacketPost.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/server/EventPacketPost.java) | 24 строк | Объект постобработки пакета; источник/потребители не найдены. |

### `src/main/java/wtf/wyvern/base/filemanager/api/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ManagerFileAbstract.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/filemanager/api/ManagerFileAbstract.java) | 120 строк | Общий JSON-файловый менеджер коллекций; необязательное шифрование. |

### `src/main/java/wtf/wyvern/base/filemanager/impl/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [FriendManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/filemanager/impl/FriendManager.java) | 23 строк | Множество друзей в Wyvern/friends.json; проверка по имени. |
| [StaffManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/filemanager/impl/StaffManager.java) | 17 строк | Множество staff в Wyvern/staffName.json. |

### `src/main/java/wtf/wyvern/base/font/` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Font.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/Font.java) | 37 строк | Пара MSDF-шрифт/размер, расчёт ширины и высоты текста. |
| [FontData.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/FontData.java) | 135 строк | Модель JSON MSDF: atlas, metrics, glyphs, kerning. |
| [Fonts.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/Fonts.java) | 28 строк | Статический набор 16 MSDF-шрифтов/иконных атласов. |
| [FormattedTextProcessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/FormattedTextProcessor.java) | 67 строк | Разбор форматированного Minecraft Text на сегменты для MSDF-рендера. |
| [MsdfFont.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/MsdfFont.java) | 207 строк | Загрузка атласа/метрик, сбор глифов, kerning и измерение текста. |
| [MsdfGlyph.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/MsdfGlyph.java) | 71 строк | Геометрия и UV одного глифа. |
| [MsdfRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/MsdfRenderer.java) | 201 строк | Рисование обычного/форматированного текста MSDF-шейдером. |
| [ResourceProvider.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/font/ResourceProvider.java) | 77 строк | Получение JSON-ресурса Minecraft и десериализация в заданный тип. |

### `src/main/java/wtf/wyvern/base/macro/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Macro.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/macro/Macro.java) | 82 строк | Данные одного макроса: bind и text. |
| [MacroManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/macro/MacroManager.java) | 19 строк | Коллекция макросов в Wyvern/macro.json. |

### `src/main/java/wtf/wyvern/base/modules/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ModuleManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java) | 314 строк | Ручная регистрация 72 модулей, бинды и анимации; также содержит возврат ротации Aura. |

### `src/main/java/wtf/wyvern/base/notify/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [NotifyManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/notify/NotifyManager.java) | 68 строк | Маршрутизация уведомлений в HUD; singleton не совпадает с объектом, создаваемым Wyvern. |

### `src/main/java/wtf/wyvern/base/player/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AttackUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/player/AttackUtil.java) | 85 строк | Общий вызов атаки, таймер и условия критического удара/движения. |

### `src/main/java/wtf/wyvern/base/repository/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [RCTRepository.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/repository/RCTRepository.java) | 111 строк | Состояние перехода lobby/anarchy, реакция на серверные сообщения и тики. |

### `src/main/java/wtf/wyvern/base/request/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [RequestHandler.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/request/RequestHandler.java) | 59 строк | Очередь приоритетных запросов с временем жизни и модулем-провайдером; прямых внешних использований не найдено. |
| [ScriptManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/request/ScriptManager.java) | 113 строк | Очередь Java ScriptTask/Step по классам событий; не загрузчик сторонних скриптов. |

### `src/main/java/wtf/wyvern/base/theme/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Theme.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/theme/Theme.java) | 301 строк | Цветовая тема, производные цвета, анимация и общие стили рисования. |
| [ThemeManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/theme/ThemeManager.java) | 175 строк | Каталог тем и выбранная тема, получение клиентского градиента. |

### `src/main/java/wtf/wyvern/base/waypoint/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Waypoint.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/waypoint/Waypoint.java) | 35 строк | Данные точки GPS: имя, X, Z. |
| [WaypointManager.java](../wyvern-dlc/src/main/java/wtf/wyvern/base/waypoint/WaypointManager.java) | 124 строк | Две GPS-точки и HUD-стрелки; player-ветка ошибочно читает обычный activeWaypoint. |

### `src/main/java/wtf/wyvern/client/hud/elements/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [HudElement.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/HudElement.java) | 59 строк | Небольшой текстовый HUD-элемент с prefix/supplier. |
| [ToggleNotify.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/ToggleNotify.java) | 82 строк | Самостоятельная анимированная индикация переключения модулей. |

### `src/main/java/wtf/wyvern/client/hud/elements/component/` — 11

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ArrayListComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/ArrayListComponent.java) | 122 строк | HUD-список активных модулей. |
| [HootBarComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/HootBarComponent.java) | 244 строк | Кастомный hotbar и его слоты/подписи; в активные списки Interface не добавлен. |
| [InformationComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/InformationComponent.java) | 34 строк | Информационный текстовый HUD-блок. |
| [InventoryComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/InventoryComponent.java) | 121 строк | HUD-отображение инвентаря; в активные списки Interface не добавлен. |
| [KeybindsComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/KeybindsComponent.java) | 270 строк | HUD включённых биндов модулей и BooleanSetting, стили classic/V2. |
| [NotifyComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/NotifyComponent.java) | 260 строк | HUD-очередь уведомлений о модулях, тексте и предметах. |
| [NotifyComponentV2.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/NotifyComponentV2.java) | 202 строк | Альтернативный HUD уведомлений; в текущие списки Interface не добавлен. |
| [PotionsComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/PotionsComponent.java) | 289 строк | HUD активных эффектов и длительности, стили classic/V2. |
| [StaffComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/StaffComponent.java) | 368 строк | HUD списка staff, состояния и кэш текстур игроков. |
| [TargetHudComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/TargetHudComponent.java) | 280 строк | HUD выбранной цели: здоровье, броня и оформление; учитывает ScoreboardHealth. |
| [WatermarkComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/component/WatermarkComponent.java) | 133 строк | HUD названия клиента/информации, classic/compact оформление. |

### `src/main/java/wtf/wyvern/client/hud/elements/draggable/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [DraggableHudElement.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/draggable/DraggableHudElement.java) | 409 строк | База перетаскиваемого HUD: позиция, привязки, resize, внутренние настройки, save/load. |

### `src/main/java/wtf/wyvern/client/modules/api/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Category.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Category.java) | 34 строк | Категории COMBAT/MOVEMENT/RENDER/PLAYER/MISC/THEMES, подписи и иконки. |
| [Module.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Module.java) | 310 строк | База модулей: annotation, state/bind, lifecycle, reflection настроек, JSON save/load. |
| [ModuleAnnotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/ModuleAnnotation.java) | 13 строк | Runtime-метаданные name/category/description класса модуля. |

### `src/main/java/wtf/wyvern/client/modules/api/setting/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Setting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/Setting.java) | 49 строк | База настройки: имя, видимость, анимация и методы safe/load. |

### `src/main/java/wtf/wyvern/client/modules/api/setting/impl/` — 9

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [BooleanSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/BooleanSetting.java) | 104 строк | Переключатель, описание и отдельный бинд; JSON boolean + _bind. GUI поддерживает. |
| [ButtonSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/ButtonSetting.java) | 34 строк | Runnable-действие; safe/load пустые намеренно. В текущем GUI редактора/кнопки нет. |
| [ColorSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/ColorSetting.java) | 84 строк | RGBA/default color/reset, сериализация целым цветом; нет редактора в текущем ClickGUI. |
| [ItemSelectSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/ItemSelectSetting.java) | 91 строк | Список предметов/блоков, JSON-массив; visible из конструктора не применяется, GUI не поддерживает. |
| [KeySetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/KeySetting.java) | 61 строк | Код клавиши и отображаемое имя; действие обрабатывает владеющий модуль. GUI поддерживает. |
| [ModeSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/ModeSetting.java) | 191 строк | Одно выбранное Value из списка; JSON строка, GUI поддерживает. |
| [MultiBooleanSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/MultiBooleanSetting.java) | 166 строк | Несколько Value, JSON строка со списком через перенос строки; GUI поддерживает. |
| [NumberSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/NumberSetting.java) | 120 строк | Float, границы/шаг/callback; setCurrent/load без проверки диапазона. GUI поддерживает. |
| [StringSetting.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/setting/impl/StringSetting.java) | 56 строк | Строка, ограничение длины и видимость; GUI поддерживает. |

### `src/main/java/wtf/wyvern/client/modules/impl/combat/` — 12

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AimBow.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AimBow.java) | 296 строк | Модуль «AimBow», COMBAT; зарегистрирован. Аим на лук с ротациями как в Aura и предсказанием. |
| [AntiBot.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AntiBot.java) | 83 строк | Модуль «AntiBot», COMBAT; зарегистрирован. Убирает бота вызванного от античита. |
| [Aura.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java) | 695 строк | Модуль «AttackAura», COMBAT; зарегистрирован. Автоматически бьет цель. |
| [AutoExplosion.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoExplosion.java) | 176 строк | Модуль «AutoExplosion», COMBAT; зарегистрирован. Automatically places and explodes crystals on recently placed obsidian. |
| [AutoSwap.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoSwap.java) | 123 строк | Модуль «AutoSwap», COMBAT; зарегистрирован. Свап предметов по бинду. |
| [AutoTotem.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoTotem.java) | 344 строк | Модуль «AutoTotem», COMBAT; зарегистрирован. Автоматически берёт тотем в опасности. |
| [ClickPearl.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/ClickPearl.java) | 125 строк | Модуль «ClickPearl», COMBAT; зарегистрирован. Кидает перку по бинду. |
| [CrystalAura.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/CrystalAura.java) | 738 строк | Модуль «CrystallAura», COMBAT; зарегистрирован. CrystallAura. |
| [PacketCriticals.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/PacketCriticals.java) | 73 строк | Модуль «PacketCriticals», COMBAT; зарегистрирован. Бьет критами под эффект плавного падения / в паутине. |
| [PearlTarget.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/PearlTarget.java) | 93 строк | Модуль «PearlTarget», COMBAT; зарегистрирован. Throws an ender pearl at the same target as the nearest entity. |
| [TpsSync.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/TpsSync.java) | 54 строк | Модуль «TpsSync», COMBAT; зарегистрирован. Синхронизация с TPS сервера. Методы расчёта cooldown не вызываются извне. |
| [Velocity.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Velocity.java) | 177 строк | Модуль «Velocity», COMBAT; **не зарегистрирован**. Убирает или уменьшает отдачу. |

### `src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/` — 15

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CakeWorldRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/CakeWorldRotation.java) | 20 строк | Делегирует алгоритм LegendsGriefRotation. Текущая Aura не выбирает эту реализацию. |
| [FunTimeRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/FunTimeRotation.java) | 119 строк | Сглаживание поворота, шум и коррекция движения. Создаётся текущей Aura. |
| [HVHRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/HVHRotation.java) | 26 строк | Прямое наведение с квантованием чувствительности. Создаётся текущей Aura. |
| [HolyWorld2Rotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/HolyWorld2Rotation.java) | 125 строк | Изменяемое ускорение и смещение точки наведения. Текущая Aura не выбирает эту реализацию. |
| [LegendsGriefRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/LegendsGriefRotation.java) | 163 строк | Ускорение/замедление и отдельные ветки при наведении/движении. Текущая Aura не выбирает эту реализацию. |
| [LonyGrief2Rotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/LonyGrief2Rotation.java) | 114 строк | История положения цели, импульс и задержка поворота. Текущая Aura не выбирает эту реализацию. |
| [LonyGriefRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/LonyGriefRotation.java) | 60 строк | Вариант сглаживания поворота и случайных смещений. Текущая Aura не выбирает эту реализацию. |
| [LonyGriefv2Rotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/LonyGriefv2Rotation.java) | 69 строк | Отдельная версия алгоритма ротации LonyGrief. Текущая Aura не выбирает эту реализацию. |
| [ReallyWorldRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/ReallyWorldRotation.java) | 19 строк | Передаёт целевой Rotation в общий RotationComponent. Создаётся текущей Aura. |
| [RotationBase.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/RotationBase.java) | 35 строк | База yaw/pitch, SecureRandom, флаг noCircling и абстрактный update. |
| [Sloth1Rotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/Sloth1Rotation.java) | 88 строк | Вариант ротации Sloth1 с собственной динамикой yaw/pitch. Создаётся текущей Aura. |
| [Sloth2Rotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/Sloth2Rotation.java) | 88 строк | Вариант Sloth2: задержка реакции, скорость и aim fatigue. Создаётся текущей Aura. |
| [UniversalRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/UniversalRotation.java) | 118 строк | Сглаживание, импульс, задержка реакции и случайное смещение. Создаётся текущей Aura. |
| [VanillaRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/VanillaRotation.java) | 26 строк | Прямое наведение с квантованием чувствительности. Создаётся текущей Aura. |
| [WellMineRotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/rotation/WellMineRotation.java) | 95 строк | Multipoint/предсказание и чередование ускорения/возврата. Текущая Aura не выбирает эту реализацию. |

### `src/main/java/wtf/wyvern/client/modules/impl/misc/` — 14

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AHHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AHHelper.java) | 45 строк | Модуль «AH Helper», MISC; **не зарегистрирован**. помощник в поиске дешевых предметов. Хуки в HandledScreenMixin есть, регистрации модуля нет. |
| [AutoAccept.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AutoAccept.java) | 62 строк | Модуль «AutoAccept», MISC; зарегистрирован. Автоматически принимает телепортацию. |
| [AutoRespawn.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AutoRespawn.java) | 34 строк | Модуль «AutoRespawn», MISC; зарегистрирован. Автовозраждение после смерти. |
| [ChatHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ChatHelper.java) | 61 строк | Модуль «ChatHelper», MISC; зарегистрирован. Помощник чата. |
| [ClickAction.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ClickAction.java) | 45 строк | Модуль «ClickFriend», MISC; зарегистрирован. Добавляет друга по бинду. |
| [CrystalOptimizer.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/CrystalOptimizer.java) | 178 строк | Модуль «CrystalOptimizer», MISC; зарегистрирован. Спамит кристаллами и взрывает их при зажатии ПКМ. |
| [ElytraHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ElytraHelper.java) | 192 строк | Модуль «ElytraHelper», MISC; зарегистрирован. Помощник для элитр. |
| [FakePlayer.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FakePlayer.java) | 47 строк | Модуль «FakePlayer», MISC; зарегистрирован. Создает локального фейкового игрока для тестов. Создаёт локального OtherClientPlayerEntity; нет super lifecycle. |
| [FreeCam.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java) | 94 строк | Модуль «FreeCam», MISC; зарегистрирован. Обзор местности за фейк игрока. |
| [ItemScroller.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ItemScroller.java) | 29 строк | Модуль «ItemScroller», MISC; зарегистрирован. Перемещение преметов без задержки. |
| [NameProtect.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/NameProtect.java) | 99 строк | Модуль «NameProtect», MISC; зарегистрирован. Защищает имена игроков. |
| [NoInteract.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/NoInteract.java) | 21 строк | Модуль «NoInteract», MISC; зарегистрирован. Не дает открыть контейнера. |
| [ScoreboardHealth.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ScoreboardHealth.java) | 14 строк | Модуль «ScoreboardHealth», MISC; зарегистрирован. Фиксит хп цели если оно фейк. Флаг читается из TargetHudComponent/EntityESP. |
| [ServerHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ServerHelper.java) | 111 строк | Модуль «ServerHelper», MISC; зарегистрирован. Серверные действия по бинду. |

### `src/main/java/wtf/wyvern/client/modules/impl/movement/` — 11

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AirStuck.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java) | 169 строк | Модуль «AirStuck», MOVEMENT; зарегистрирован. Зависает в воздухе. |
| [AutoSprint.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AutoSprint.java) | 77 строк | Модуль «AutoSprint», MOVEMENT; зарегистрирован. Автоматически включает спринт. |
| [ElytraBooster.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraBooster.java) | 126 строк | Модуль «ElytraBooster», MOVEMENT; зарегистрирован. Ускоряет на элитрах. |
| [ElytraMotion.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraMotion.java) | 67 строк | Модуль «ElytraMotion», MOVEMENT; зарегистрирован. Зависает в воздухе на элитрах рядом с целью. |
| [ElytraRecast.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraRecast.java) | 87 строк | Модуль «ElytraRecast», MOVEMENT; зарегистрирован. Позволяет выше прыгать на элитрах. |
| [GrimGlide.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GrimGlide.java) | 56 строк | Модуль «GrimGlide», MOVEMENT; зарегистрирован. Управление вводом/планированием движения. |
| [GuiWalk.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GuiWalk.java) | 89 строк | Модуль «GuiMove», MOVEMENT; зарегистрирован. Позволяет двигаться с открытым инвентарем. |
| [NoFall.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoFall.java) | 52 строк | Модуль «NoFall», MOVEMENT; **не зарегистрирован**. Предотвращает получение урона от падения. Не используется: явный импорт менеджера выбирает player.NoFall. |
| [NoSlow.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoSlow.java) | 79 строк | Модуль «NoSlow», MOVEMENT; зарегистрирован. Убирает замедление во время еды. |
| [NoWeb.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoWeb.java) | 140 строк | Модуль «NoWeb», MOVEMENT; зарегистрирован. Меняет замедление от паутины. |
| [Speed.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/Speed.java) | 74 строк | Модуль «Speed», MOVEMENT; зарегистрирован. Ускоряет вас возле цели ауры. |

### `src/main/java/wtf/wyvern/client/modules/impl/player/` — 9

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AutoArmor.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/AutoArmor.java) | 82 строк | Модуль «AutoArmor», PLAYER; зарегистрирован. Автоматически экипирует броню. |
| [AutoTool.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/AutoTool.java) | 192 строк | Модуль «AutoTool», PLAYER; зарегистрирован. При копании берет лучший предмет. |
| [Blink.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/Blink.java) | 84 строк | Модуль «Blink», PLAYER; зарегистрирован. Задержка пакетов движения. Нет super lifecycle и наполнения очереди packets; см. L-01. |
| [FastBreak.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/FastBreak.java) | 45 строк | Модуль «FastBreak», PLAYER; зарегистрирован. Ускоряет добычу блоков. |
| [FastUse.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/FastUse.java) | 59 строк | Модуль «FastUse», PLAYER; зарегистрирован. Позволяет использовать предметы быстрее. |
| [LevitationControl.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/LevitationControl.java) | 299 строк | Модуль «LevitationControl», PLAYER; зарегистрирован. Контроль левитации через свап элитры. |
| [NoDelay.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoDelay.java) | 23 строк | Модуль «NoJumpDelay», PLAYER; зарегистрирован. Убирает задержку на прыжок. |
| [NoFall.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoFall.java) | 30 строк | Модуль «NoFall», MOVEMENT; зарегистрирован. Убирает урон от падения. Именно эта реализация выбрана ModuleManager; категория MOVEMENT. |
| [NoPush.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoPush.java) | 70 строк | Модуль «NoPush», PLAYER; зарегистрирован. Убирает отталкивание от обьектов. |

### `src/main/java/wtf/wyvern/client/modules/impl/render/` — 30

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Ambience.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Ambience.java) | 55 строк | Модуль «Ambience», RENDER; зарегистрирован. Управляет атмосферой мира: временем и туманом. |
| [AntiInvisible.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/AntiInvisible.java) | 35 строк | Модуль «AntiInvis», RENDER; зарегистрирован. Видно инвизок. |
| [Arrows.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Arrows.java) | 108 строк | Модуль «Arrows», RENDER; зарегистрирован. Показывает стрелки в сторону игроков. |
| [AspectRatio.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/AspectRatio.java) | 28 строк | Модуль «AspectRatio», RENDER; зарегистрирован. Изменяет соотношение сторон экрана. |
| [BloomBlock.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/BloomBlock.java) | 177 строк | Модуль «BlockOverlay», RENDER; зарегистрирован. 3D обводка блока в фокусе цветом темы. |
| [ClientBow.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ClientBow.java) | 113 строк | Модуль «ClientBow», RENDER; зарегистрирован. Визуальная траектория полета стрелы. |
| [ClientSounds.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ClientSounds.java) | 39 строк | Модуль «ClientSounds», RENDER; зарегистрирован. Звуки при включении/выключении модулей. |
| [Cosmetics.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cosmetics.java) | 854 строк | Модуль «Cosmetics», RENDER; зарегистрирован. Визуальные украшения. |
| [Crosshair.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Crosshair.java) | 60 строк | Модуль «Crosshair», RENDER; зарегистрирован. Кастомный прицел. |
| [Cubes.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cubes.java) | 627 строк | Модуль «Cubes», RENDER; зарегистрирован. 3D Кубы по миру. |
| [CustomSky.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/CustomSky.java) | 154 строк | Модуль «CustomSky», RENDER; зарегистрирован. Красивый кастомный шейдер неба. |
| [EntityESP.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/EntityESP.java) | 377 строк | Модуль «NameTags», RENDER; зарегистрирован. Показывает информацию о игроке. В GUI называется NameTags; это зарегистрированный вариант. |
| [FireworkESP.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/FireworkESP.java) | 185 строк | Модуль «FireworkESP», RENDER; зарегистрирован. Показывает теги и трейлы фейерверков. |
| [FullBright.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/FullBright.java) | 14 строк | Модуль «FullBright», RENDER; зарегистрирован. Максимальное освещение. Логика включения находится в LightmapTextureManagerMixin. |
| [HitMarker.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/HitMarker.java) | 245 строк | Модуль «HitMarker», RENDER; зарегистрирован. Показывает маркер при ударе. |
| [Interface.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java) | 352 строк | Модуль «HUD», RENDER; зарегистрирован. Интерфейс Клиента. Содержит два списка HUD, сохранение позиций и настройку элементов. |
| [JumpCircle.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/JumpCircle.java) | 203 строк | Модуль «JumpCircle», RENDER; зарегистрирован. Рисует круг при прыжке. |
| [KillEffect.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/KillEffect.java) | 224 строк | Модуль «KillEffect», RENDER; зарегистрирован. Визуальные эффекты при убийстве. |
| [LineGlyphes.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/LineGlyphes.java) | 310 строк | Модуль «LineGlyphes», RENDER; зарегистрирован. Анимированные линии в 3D пространстве. |
| [Menu.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Menu.java) | 44 строк | Модуль «ClickGUI», RENDER; зарегистрирован. Меню чита. Right Shift (344); открывает MenuScreen только с загруженным миром. |
| [NameTags.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NameTags.java) | 231 строк | Модуль «NameTags», RENDER; **не зарегистрирован**. Отображает теги над сущностями. Отдельный незарегистрированный вариант; имя совпадает с EntityESP. |
| [NoRender.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NoRender.java) | 57 строк | Модуль «NoRender», RENDER; зарегистрирован. Убирает лишние элементы с экрана. |
| [Particles.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Particles.java) | 485 строк | Модуль «Particles», RENDER; зарегистрирован. Красивые частицы при различных действиях. |
| [Predictions.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Predictions.java) | 194 строк | Модуль «Predictions», RENDER; зарегистрирован. Показывает куда упадет предмет. |
| [ShaderHands.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ShaderHands.java) | 39 строк | Модуль «ShaderHands», RENDER; зарегистрирован. Красивый шейдер на руки и предметы. |
| [ShulkerPreview.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ShulkerPreview.java) | 287 строк | Модуль «ShulkerPreview», RENDER; зарегистрирован. Показывает содержимое шалкера при наведении + CTRL. |
| [SwingAnimation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/SwingAnimation.java) | 131 строк | Модуль «SwingAnimation», RENDER; зарегистрирован. Кастомные анимации удара. |
| [TargetESP.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TargetESP.java) | 1101 строк | Модуль «TargetESP», RENDER; зарегистрирован. Выделяет цель. |
| [TotemPop.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TotemPop.java) | 165 строк | Модуль «TotemPop», RENDER; зарегистрирован. Показывает призрачную копию игрока при срабатывании тотема. |
| [ViewModel.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ViewModel.java) | 54 строк | Модуль «ViewModel», RENDER; зарегистрирован. Настройка позиции. |

### `src/main/java/wtf/wyvern/client/screens/menu/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [MenuScreen.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/MenuScreen.java) | 113 строк | Действующий Minecraft Screen ClickGUI, делегирует wonderful state/render/input. |
| [Panel.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/Panel.java) | 266 строк | Отдельная реализация панели категорий; текущий MenuScreen использует другую цепочку. |

### `src/main/java/wtf/wyvern/client/screens/menu/components/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [UserComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/components/UserComponent.java) | 93 строк | Отрисовка профиля/аватара Discord в UI. |

### `src/main/java/wtf/wyvern/client/screens/menu/wonderful/` — 6

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ClickGuiInputHandler.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiInputHandler.java) | 396 строк | Ввод ClickGUI: клики, бинды, поиск, строковые поля, ползунки, режимы, прокрутка. |
| [ClickGuiLayout.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiLayout.java) | 157 строк | Размеры/геометрия категорий и высоты поддержанных типов настроек. |
| [ClickGuiRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiRenderer.java) | 218 строк | Основная отрисовка ClickGUI: поиск, категории, темы, модули. |
| [ClickGuiSettingRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiSettingRenderer.java) | 298 строк | Отрисовка 6 типов настроек; Color/Button/ItemSelect не реализованы. |
| [ClickGuiState.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiState.java) | 236 строк | Состояние GUI, поиск, привязки, прокрутка, анимации; для ключей Module использует IdentityHashMap. |
| [ClickGuiThemeSelector.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/screens/menu/wonderful/ClickGuiThemeSelector.java) | 115 строк | Отдельный виджет выбора темы и обработки кликов. |

### `src/main/java/wtf/wyvern/utility/component/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [FreeLookComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/component/FreeLookComponent.java) | 70 строк | Отделяет свободный взгляд от поворота игрока через EventLook/EventRotation. |
| [RotationComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/component/RotationComponent.java) | 268 строк | Общее состояние AIM/RESET/IDLE, приоритеты, таймаут и изменение yaw/pitch. |

### `src/main/java/wtf/wyvern/utility/crypt/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CryptUtility.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/crypt/CryptUtility.java) | 70 строк | PBKDF2-HMAC-SHA256, AES-CBC/PKCS5Padding, случайные salt/IV для конфигов. |

### `src/main/java/wtf/wyvern/utility/game/combat/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CrystalDamageCalculator.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/combat/CrystalDamageCalculator.java) | 114 строк | Расчёт урона взрыва с учётом экспозиции, защиты и эффектов. |

### `src/main/java/wtf/wyvern/utility/game/other/` — 6

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [InventoryUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/InventoryUtil.java) | 143 строк | Поиск предметов/слотов и переключение/перенос; отдельный набор от PlayerInventoryUtil. |
| [MessageUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/MessageUtil.java) | 86 строк | Форматирование и вывод клиентских сообщений в чат. |
| [MouseButton.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/MouseButton.java) | 45 строк | Имена/индексы кнопок мыши. |
| [NetworkUtils.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/NetworkUtils.java) | 29 строк | Отправка пакетов и список silentPackets для обхода собственного event bus. |
| [ReplaceUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/ReplaceUtil.java) | 342 строк | Замены в тексте/именах с сохранением стилей, нормализация символов и раскладки. |
| [TextUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/TextUtil.java) | 154 строк | Форматирование чисел, обрезка и замены в Minecraft Text. |

### `src/main/java/wtf/wyvern/utility/game/other/render/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CustomScreen.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/other/render/CustomScreen.java) | 54 строк | Обёртка Screen с UIContext и делегированием ввода; потребителей не найдено. |

### `src/main/java/wtf/wyvern/utility/game/player/` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [MovingUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/MovingUtil.java) | 183 строк | Направление, strafe и коррекция forward/strafe при изменении ротации. |
| [PlayerIntersectionUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/PlayerIntersectionUtil.java) | 245 строк | Проверки окружения/пересечений, здоровье, взаимодействия и sequenced packets. |
| [PlayerInventoryComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/PlayerInventoryComponent.java) | 159 строк | Последовательности инвентарных действий с временным отключением клавиш движения. |
| [PlayerInventoryUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/PlayerInventoryUtil.java) | 508 строк | Слоты, swap/offhand, перенос предметов и последовательности использования инвентаря. |
| [PointFinder.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/PointFinder.java) | 227 строк | Выбор видимой подходящей точки в bounding box цели. |
| [RaytracingUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/RaytracingUtil.java) | 75 строк | Raycast мира/сущностей и проверки попадания луча в box. |
| [SimulatedPlayer.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/SimulatedPlayer.java) | 790 строк | Локальная симуляция физики игрока, жидкости, столкновения, прыжок; используется для предсказаний. |
| [TargetSelector.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/TargetSelector.java) | 158 строк | Общий поиск/фильтр/удержание цели; текущая Aura имеет собственный поиск, прямых потребителей TargetSelector нет. |

### `src/main/java/wtf/wyvern/utility/game/player/rotation/` — 4

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AuraRotations.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/rotation/AuraRotations.java) | 201 строк | Старые статические алгоритмы ротации; прямых внешних вызовов не найдено. |
| [Rotation.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/rotation/Rotation.java) | 138 строк | Yaw/pitch, операции с углами, преобразование в вектор и квантование чувствительности. |
| [RotationDelta.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/rotation/RotationDelta.java) | 37 строк | Разность двух углов и её длина/Vec2f. |
| [RotationUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/player/rotation/RotationUtil.java) | 25 строк | Преобразование направления/точки в углы. |

### `src/main/java/wtf/wyvern/utility/game/server/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [AutoBuyUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/server/AutoBuyUtil.java) | 146 строк | Разбор цены/серверных признаков предметов, проверка зачарований для аукционных помощников. |
| [ServerHandler.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/server/ServerHandler.java) | 264 строк | Определение сервера/режима/PvP, оценка TPS и состояние sprint; также неиспользуемый HTTP date helper. |

### `src/main/java/wtf/wyvern/utility/interfaces/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [IClient.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/interfaces/IClient.java) | 7 строк | Объединённый интерфейс доступа к Minecraft/окну для клиентских классов. |
| [IMinecraft.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/interfaces/IMinecraft.java) | 7 строк | Общий доступ к MinecraftClient. |
| [IWindow.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/interfaces/IWindow.java) | 7 строк | Общий доступ к окну Minecraft. |

### `src/main/java/wtf/wyvern/utility/math/` — 7

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [BoostUtils.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/BoostUtils.java) | 266 строк | Нормализация yaw и ограничение pitch для расчётов движения/элитры. |
| [IntRange.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/IntRange.java) | 37 строк | Целочисленный диапазон и случайный выбор; прямых потребителей не найдено. |
| [MathUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/MathUtil.java) | 166 строк | Интерполяция, углы, округление, случайные значения, расстояние строк и вспомогательная математика. |
| [MultipointUtils.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/MultipointUtils.java) | 121 строк | Ближайшие/подходящие точки хитбокса цели. |
| [ProjectionUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/ProjectionUtil.java) | 117 строк | Проекция мира на экран, frustum/видимость и экранные координаты. |
| [StopWatch.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/StopWatch.java) | 38 строк | Измерение интервалов и повторяющиеся проверки времени. |
| [Timer.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/math/Timer.java) | 37 строк | Миллисекундный таймер/reset/finished. |

### `src/main/java/wtf/wyvern/utility/mixin/accessors/` — 6

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CameraAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/CameraAccessor.java) | 14 строк | Mixin → `Camera`. Хуки: Invoker. |
| [DrawContextAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/DrawContextAccessor.java) | 20 строк | Mixin → `DrawContext`. Хуки: Accessor, Invoker. |
| [HandledScreenAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/HandledScreenAccessor.java) | 14 строк | Mixin → `HandledScreen`. Хуки: Accessor. |
| [InGameHudAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/InGameHudAccessor.java) | 16 строк | Mixin → `InGameHud`. Хуки: Invoker. |
| [ItemStackAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/ItemStackAccessor.java) | 12 строк | Mixin → `ItemStack`. Хуки: Accessor. |
| [ShaderProgramAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/ShaderProgramAccessor.java) | 13 строк | Mixin → `ShaderProgram`. Хуки: Accessor. |

### `src/main/java/wtf/wyvern/utility/mixin/client/` — 17

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [BackGroundRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/BackGroundRendererMixin.java) | 73 строк | Mixin → `BackgroundRenderer`. Хуки: Inject. |
| [CameraMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/CameraMixin.java) | 104 строк | Mixin → `Camera`. Хуки: Inject, Redirect. **Остались intermediary-имена; M-01.** |
| [ChatInputSuggestorMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ChatInputSuggestorMixin.java) | 69 строк | Mixin → `ChatInputSuggestor`. Хуки: Inject. **Остались intermediary-имена; M-01.** |
| [ClientPlayerEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java) | 214 строк | Mixin → `ClientPlayerEntity`. Хуки: Inject, Redirect, Overwrite. **Остались intermediary-имена; M-01.** |
| [ClientPlayerInteractionManagerMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerInteractionManagerMixin.java) | 95 строк | Mixin → `ClientPlayerInteractionManager`. Хуки: Inject. **Остались intermediary-имена; M-01.** |
| [ClientWorldMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientWorldMixin.java) | 22 строк | Mixin → `ClientWorld`. Хуки: Inject. |
| [EntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/EntityMixin.java) | 49 строк | Mixin → `Entity`. Хуки: ModifyExpressionValue, Inject. |
| [HandledScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/HandledScreenMixin.java) | 33 строк | Mixin → `HandledScreen`. Хуки: Inject. **Остались intermediary-имена; M-01.** |
| [HeldItemRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/HeldItemRendererMixin.java) | 159 строк | Mixin → `HeldItemRenderer`. Хуки: Inject, Redirect, Overwrite. **Остались intermediary-имена; M-01.** |
| [KeyboardInputMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/KeyboardInputMixin.java) | 74 строк | Mixin → `KeyboardInput`. Хуки: Inject. |
| [KeyboardMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/KeyboardMixin.java) | 22 строк | Mixin → `Keyboard`. Хуки: Inject. |
| [LightmapTextureManagerMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/LightmapTextureManagerMixin.java) | 22 строк | Mixin → `LightmapTextureManager`. Хуки: ModifyExpressionValue. |
| [MinecraftClientMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java) | 75 строк | Mixin → `MinecraftClient`. Хуки: Inject, ModifyVariable. |
| [MouseMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java) | 152 строк | Mixin → `Mouse`. Хуки: Inject, Redirect, WrapWithCondition. **Остались intermediary-имена; M-01.** |
| [PlayerEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/PlayerEntityMixin.java) | 24 строк | Mixin → `LivingEntity`. Хуки: Inject. |
| [ScoreboarMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ScoreboarMixin.java) | 29 строк | Mixin → `Scoreboard`. Хуки: Inject. **Остались intermediary-имена; M-01.** |
| [WorldRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/WorldRendererMixin.java) | 48 строк | Mixin → `WorldRenderer`. Хуки: Redirect, Inject. |

### `src/main/java/wtf/wyvern/utility/mixin/client/render/` — 4

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [LivingEntityRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/LivingEntityRendererMixin.java) | 75 строк | Mixin → `LivingEntityRenderer`. Хуки: Redirect. **Остались intermediary-имена; M-01.** |
| [RenderSystemMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/RenderSystemMixin.java) | 27 строк | Mixin → `RenderSystem`. Хуки: ModifyVariable. |
| [ScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/ScreenMixin.java) | 8 строк | Mixin → `Screen`. Пустой зарегистрированный класс, без хуков. |
| [WindowMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/WindowMixin.java) | 20 строк | Mixin → `Window`. Хуки: Inject. |

### `src/main/java/wtf/wyvern/utility/mixin/client/render/gui/hud/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [GameOverlayRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/hud/GameOverlayRendererMixin.java) | 25 строк | Mixin → `InGameOverlayRenderer`. Хуки: Inject. |
| [InGameHudMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/hud/InGameHudMixin.java) | 159 строк | Mixin → `InGameHud`. Хуки: Inject, ModifyVariable. |

### `src/main/java/wtf/wyvern/utility/mixin/client/render/gui/screen/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ChatScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/screen/ChatScreenMixin.java) | 25 строк | Mixin → `ChatScreen`. Хуки: Inject. |
| [HandledScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/screen/HandledScreenMixin.java) | 171 строк | Mixin → `HandledScreen`. Хуки: Inject. **Остались intermediary-имена; M-01.** |

### `src/main/java/wtf/wyvern/utility/mixin/client/sound/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [SoundSystemMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/sound/SoundSystemMixin.java) | 19 строк | Mixin → `SoundSystem`. Хуки: Inject. |

### `src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/` — 4

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [FireworkRocketEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/FireworkRocketEntityMixin.java) | 106 строк | Mixin → `FireworkRocketEntity`. Хуки: ModifyExpressionValue, Redirect. **Остались intermediary-имена; M-01.** |
| [LimbAnimatorMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/LimbAnimatorMixin.java) | 21 строк | Mixin → `LimbAnimator`. Хуки: Accessor. |
| [LivingEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/LivingEntityMixin.java) | 9 строк | Mixin → `LivingEntity`. Пустой зарегистрированный класс, без хуков. |
| [PlayerEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/PlayerEntityMixin.java) | 21 строк | Mixin → `PlayerEntity`. Хуки: Inject. |

### `src/main/java/wtf/wyvern/utility/mixin/minecraft/network/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ClientConnectionMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientConnectionMixin.java) | 62 строк | Mixin → `ClientConnection`. Хуки: Inject. |
| [ClientPlayNetworkHandlerMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientPlayNetworkHandlerMixin.java) | 100 строк | Mixin → `ClientPlayNetworkHandler`. Хуки: Inject. |

### `src/main/java/wtf/wyvern/utility/mixin/minecraft/render/` — 5

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ClientWorldPropertiesMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/ClientWorldPropertiesMixin.java) | 28 строк | Mixin → `Properties`. Хуки: Inject. **Остались intermediary-имена; M-01.** |
| [FeatureRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/FeatureRendererMixin.java) | 8 строк | Mixin → `FeatureRenderer`. Пустой зарегистрированный класс, без хуков. |
| [HeldItemFeatureRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/HeldItemFeatureRendererMixin.java) | 26 строк | Mixin → `HeldItemFeatureRenderer`. Хуки: Inject. |
| [MixinGameRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java) | 164 строк | Mixin → `GameRenderer`. Хуки: Inject, ModifyExpressionValue. **Остались intermediary-имена; M-01.** |
| [PlayerEntityRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/PlayerEntityRendererMixin.java) | 28 строк | Mixin → `PlayerEntityRenderer`. Хуки: Inject. |

### `src/main/java/wtf/wyvern/utility/mixin/minecraft/team/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [TeamMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/team/TeamMixin.java) | 32 строк | Mixin → `Team`. Хуки: ModifyArg. |

### `src/main/java/wtf/wyvern/utility/mixin/minecraft/text/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [TextVisitFactoryMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/text/TextVisitFactoryMixin.java) | 29 строк | Mixin → `TextVisitFactory`. Хуки: ModifyArg. |

### `src/main/java/wtf/wyvern/utility/other/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [BooleanSettable.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/other/BooleanSettable.java) | 17 строк | Изменяемая boolean-обёртка; прямых потребителей не найдено. |
| [FieldStorage.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/other/FieldStorage.java) | 24 строк | Набор статических boolean/float полей без найденных потребителей. |

### `src/main/java/wtf/wyvern/utility/predict/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [PredictUtils.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/predict/PredictUtils.java) | 57 строк | Предсказание положения сущности по её движению; не загрузчик DJL-моделей. |

### `src/main/java/wtf/wyvern/utility/render/display/` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [BufferUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/BufferUtil.java) | 42 строк | Регистрация динамической текстуры; прямых потребителей не найдено. |
| [GaussianFilter.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/GaussianFilter.java) | 158 строк | CPU Gaussian blur для BufferedImage. |
| [Keyboard.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/Keyboard.java) | 166 строк | Преобразование имён и кодов клавиш/кнопок. |
| [Render2DUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/Render2DUtil.java) | 606 строк | 2D-геометрия, тени, текстуры, scissor, градиенты и цветовые эффекты. |
| [ScrollHandler.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/ScrollHandler.java) | 66 строк | Анимированное состояние прокрутки; в текущем GUI применяется другая реализация. |
| [StencilUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/StencilUtil.java) | 41 строк | Управление stencil-масками OpenGL. |
| [TextBox.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/TextBox.java) | 554 строк | Самостоятельный текстовый редактор UI; текущий ClickGUI хранит ввод в ClickGuiState. |
| [Texture.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/Texture.java) | 39 строк | Данные/обёртка текстуры для рендера. |

### `src/main/java/wtf/wyvern/utility/render/display/base/` — 9

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [BorderRadius.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/BorderRadius.java) | 71 строк | Радиусы углов прямоугольника и фабричные методы. |
| [ChangeRect.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/ChangeRect.java) | 106 строк | Изменяемая геометрия прямоугольника и hit-test; прямых потребителей не найдено. |
| [CustomComponent.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/CustomComponent.java) | 116 строк | Общая база UI-компонентов с render/input/position; прямых наследников в базе не найдено. |
| [CustomDrawContext.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/CustomDrawContext.java) | 106 строк | Обёртка DrawContext с рисованием текста, фигур, изображений и матриц. |
| [CustomSprite.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/CustomSprite.java) | 25 строк | Описание текстурного спрайта/UV. |
| [Gradient.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/Gradient.java) | 55 строк | Четырёхугольный градиент, поворот и прозрачность. |
| [GuiUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/GuiUtil.java) | 28 строк | Координаты мыши и UI-вспомогательные вычисления. |
| [Rect.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/Rect.java) | 32 строк | Геометрия прямоугольника и hit-test; прямых потребителей не найдено. |
| [UIContext.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/UIContext.java) | 36 строк | Контекст UI, объединяющий рисование и параметры ввода. |

### `src/main/java/wtf/wyvern/utility/render/display/base/color/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ColorRGBA.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/color/ColorRGBA.java) | 263 строк | Цветовой тип, преобразования RGBA/HSB, смешивание и прозрачность. |
| [ColorUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/base/color/ColorUtil.java) | 125 строк | Статические преобразования цвета, градиенты, fading и formatting. |

### `src/main/java/wtf/wyvern/utility/render/display/shader/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [CustomRenderTarget.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/CustomRenderTarget.java) | 64 строк | Framebuffer для постобработки, resize и переключение render target. |
| [DrawUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/DrawUtil.java) | 640 строк | Основной shader-based 2D renderer: rounded shapes, blur/glow, текстуры и головы игроков. |
| [GlProgram.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/GlProgram.java) | 66 строк | Регистрация ShaderProgramKey, загрузка при reload, доступ к uniform; ошибки загрузки скрываются. |

### `src/main/java/wtf/wyvern/utility/render/display/shader/impl/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [KawaseBlurProgram.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/impl/KawaseBlurProgram.java) | 36 строк | Специализация GlProgram для Kawase blur; прямых потребителей не найдено. |

### `src/main/java/wtf/wyvern/utility/render/level/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Render3DUtil.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/level/Render3DUtil.java) | 605 строк | Очереди/рисование 3D линий, box, quad, текстур и форм. |

### `src/main/java/wtf/wyvern/utility/render/particles/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ParticleEngine.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/particles/ParticleEngine.java) | 76 строк | Общая коллекция частиц, update и 3D-render. |

### `src/main/java/wtf/wyvern/utility/render/shader/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [ShaderBlockRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/shader/ShaderBlockRenderer.java) | 307 строк | Framebuffer-проходы, mask/blur/overlay для подсветки блока. |
| [ShaderHandsRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/shader/ShaderHandsRenderer.java) | 316 строк | Framebuffer-проходы и uniform для glow/wave рук и предметов. |

### `src/main/java/wtf/wyvern/utility/render/shaders/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [Shader.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/shaders/Shader.java) | 116 строк | Отдельный прямой OpenGL-компилятор шейдеров, не GlProgram. |

### `src/main/java/wtf/wyvern/utility/render/shaders/impl/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [PlasmaSkyShader.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/shaders/impl/PlasmaSkyShader.java) | 300 строк | Старый встроенный GLSL неба на прямом Shader; явного подключения в активный CustomSky нет. |
| [RealSkyShader.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/render/shaders/impl/RealSkyShader.java) | 88 строк | Другая старая реализация неба на прямом Shader; явного подключения в активный CustomSky нет. |

### `src/main/resources/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [fabric.mod.json](../wyvern-dlc/src/main/resources/fabric.mod.json) | 29 строк | Fabric metadata: client-only Wyvern, enum entrypoint, mixins, dependencies; указан отсутствующий avatar.png. |
| [wyvern.accesswidener](../wyvern-dlc/src/main/resources/wyvern.accesswidener) | 70 строк | Доступ к закрытым полям/методам Minecraft и mutable yaw/pitch пакета; named namespace. |
| [wyvern.mixins.json](../wyvern-dlc/src/main/resources/wyvern.mixins.json) | 62 строк | 45 зарегистрированных mixin-классов; JAVA_21, required, defaultRequire=1, refmap. |

### `src/main/resources/assets/win32-x86/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [discord-rpc.dll](../wyvern-dlc/src/main/resources/assets/win32-x86/discord-rpc.dll) | 299 008 байт | Старая Discord RPC DLL: PE x86 (32-bit); не используется активным DiscordManager, без исполнения/дизассемблирования. |

### `src/main/resources/assets/wyvern/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [sounds.json](../wyvern-dlc/src/main/resources/assets/wyvern/sounds.json) | 12 строк | События enable/disable и пути к двум OGG; оба файла присутствуют. |

### `src/main/resources/assets/wyvern/fonts/msdf/` — 32

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [bold.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/bold.json) | 1 строк | Метрики атласа `bold`: 160 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [bold.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/bold.png) | 318 993 байт | MSDF-атлас `bold`, 660×660; PNG CRC корректен, метрики в парном JSON. |
| [comfortaa_light.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/comfortaa_light.json) | 1 строк | Метрики атласа `comfortaa_light`: 153 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [comfortaa_light.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/comfortaa_light.png) | 290 278 байт | MSDF-атлас `comfortaa_light`, 664×664; PNG CRC корректен, метрики в парном JSON. |
| [comfortaa_regular.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/comfortaa_regular.json) | 1 строк | Метрики атласа `comfortaa_regular`: 153 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [comfortaa_regular.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/comfortaa_regular.png) | 300 546 байт | MSDF-атлас `comfortaa_regular`, 664×664; PNG CRC корректен, метрики в парном JSON. |
| [energy.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/energy.json) | 1 строк | Метрики атласа `energy`: 8 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [energy.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/energy.png) | 22 187 байт | MSDF-атлас `energy`, 180×180; PNG CRC корректен, метрики в парном JSON. |
| [font.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/font.json) | 1 строк | Метрики атласа `font`: 39 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [font.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/font.png) | 112 185 байт | MSDF-атлас `font`, 436×436; PNG CRC корректен, метрики в парном JSON. |
| [hud_icons.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/hud_icons.json) | 1 строк | Метрики атласа `hud_icons`: 18 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [hud_icons.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/hud_icons.png) | 67 151 байт | MSDF-атлас `hud_icons`, 328×328; PNG CRC корректен, метрики в парном JSON. |
| [icons.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/icons.json) | 1 строк | Метрики атласа `icons`: 34 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [icons.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/icons.png) | 101 038 байт | MSDF-атлас `icons`, 436×436; PNG CRC корректен, метрики в парном JSON. |
| [icons5.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/icons5.json) | 1 строк | Метрики атласа `icons5`: 24 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [icons5.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/icons5.png) | 51 671 байт | MSDF-атлас `icons5`, 192×192; PNG CRC корректен, метрики в парном JSON. |
| [logo.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/logo.json) | 1 строк | Метрики атласа `logo`: 3 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [logo.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/logo.png) | 2 208 байт | MSDF-атлас `logo`, 72×72; PNG CRC корректен, метрики в парном JSON. |
| [lupa.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/lupa.json) | 1 строк | Метрики атласа `lupa`: 1 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [lupa.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/lupa.png) | 4 119 байт | MSDF-атлас `lupa`, 76×76; PNG CRC корректен, метрики в парном JSON. |
| [medium.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/medium.json) | 1 строк | Метрики атласа `medium`: 183 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [medium.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/medium.png) | 370 977 байт | MSDF-атлас `medium`, 676×676; PNG CRC корректен, метрики в парном JSON. |
| [nuriki.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/nuriki.json) | 1 строк | Метрики атласа `nuriki`: 31 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [nuriki.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/nuriki.png) | 140 101 байт | MSDF-атлас `nuriki`, 449×449; PNG CRC корректен, метрики в парном JSON. |
| [nursultanik.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/nursultanik.json) | 1 строк | Метрики атласа `nursultanik`: 27 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [nursultanik.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/nursultanik.png) | 113 373 байт | MSDF-атлас `nursultanik`, 418×418; PNG CRC корректен, метрики в парном JSON. |
| [regular.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/regular.json) | 1 строк | Метрики атласа `regular`: 183 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [regular.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/regular.png) | 372 225 байт | MSDF-атлас `regular`, 668×668; PNG CRC корректен, метрики в парном JSON. |
| [roundbold.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/roundbold.json) | 1 строк | Метрики атласа `roundbold`: 160 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [roundbold.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/roundbold.png) | 272 669 байт | MSDF-атлас `roundbold`, 648×648; PNG CRC корректен, метрики в парном JSON. |
| [semibold.json](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/semibold.json) | 1 строк | Метрики атласа `semibold`: 183 глифов, kerning; размеры совпали с PNG, дубликатов Unicode нет. |
| [semibold.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/semibold.png) | 358 535 байт | MSDF-атлас `semibold`, 684×684; PNG CRC корректен, метрики в парном JSON. |

### `src/main/resources/assets/wyvern/icons/` — 16

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [arrow.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/arrow.png) | 246 317 байт | Текстура/спрайт `arrow`, 1024×1024; PNG CRC корректен. |
| [bloom.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/bloom.png) | 27 407 байт | Текстура/спрайт `bloom`, 256×256; PNG CRC корректен. |
| [circle.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/circle.png) | 858 966 байт | Текстура/спрайт `circle`, 1424×1424; PNG CRC корректен. |
| [cross.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/cross.png) | 40 038 байт | Текстура/спрайт `cross`, 500×500; PNG CRC корректен. |
| [dollar.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/dollar.png) | 33 130 байт | Текстура/спрайт `dollar`, 512×512; PNG CRC корректен. |
| [glow.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/glow.png) | 27 945 байт | Текстура/спрайт `glow`, 180×180; PNG CRC корректен. |
| [marker.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/marker.png) | 301 447 байт | Текстура/спрайт `marker`, 1024×1024; PNG CRC корректен. |
| [separator.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/separator.png) | 313 байт | Текстура/спрайт `separator`, 42×42; PNG CRC корректен. |
| [sliderhue.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/sliderhue.png) | 7 381 байт | Текстура/спрайт `sliderhue`, 468×19; PNG CRC корректен. |
| [slidertransparent.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/slidertransparent.png) | 815 байт | Текстура/спрайт `slidertransparent`, 468×19; PNG CRC корректен. |
| [snow.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/snow.png) | 73 685 байт | Текстура/спрайт `snow`, 512×512; PNG CRC корректен. После IEND — 22 798 дополнительных байтов, назначение не установлено. |
| [spark_1.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/spark_1.png) | 30 178 байт | Текстура/спрайт `spark_1`, 592×592; PNG CRC корректен. |
| [spark_2.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/spark_2.png) | 39 083 байт | Текстура/спрайт `spark_2`, 612×612; PNG CRC корректен. |
| [spark_3.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/spark_3.png) | 48 059 байт | Текстура/спрайт `spark_3`, 672×672; PNG CRC корректен. |
| [sparkle.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/sparkle.png) | 65 197 байт | Текстура/спрайт `sparkle`, 1000×1000; PNG CRC корректен. |
| [star.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/star.png) | 26 492 байт | Текстура/спрайт `star`, 512×512; PNG CRC корректен. |

### `src/main/resources/assets/wyvern/models/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [model.params](../wyvern-dlc/src/main/resources/assets/wyvern/models/model.params) | 49 764 байт | Бинарные параметры с сигнатурой DJL@; загрузчиков в Java-коде не найдено, десериализация не выполнялась. |
| [slow.params](../wyvern-dlc/src/main/resources/assets/wyvern/models/slow.params) | 49 763 байт | Бинарные параметры с сигнатурой DJL@; загрузчиков в Java-коде не найдено, десериализация не выполнялась. |
| [tf-0100.params](../wyvern-dlc/src/main/resources/assets/wyvern/models/tf-0100.params) | 51 812 байт | Бинарные параметры с сигнатурой DJL@; загрузчиков в Java-коде не найдено, десериализация не выполнялась. |

### `src/main/resources/assets/wyvern/shaders/core/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [position_color.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/position_color.vsh) | 19 строк | Общий vertex shader координат/цвета. |
| [position_texture_color.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/position_texture_color.vsh) | 22 строк | Общий vertex shader координат/цвета/UV. |

### `src/main/resources/assets/wyvern/shaders/core/blur/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/blur/data.json) | 15 строк | Дескриптор программы и uniform/attribute. Размытие UI. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/blur/fragment.fsh) | 39 строк | Fragment shader. Размытие UI. |
| [vertex.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/blur/vertex.vsh) | 21 строк | Vertex shader. Размытие UI. |

### `src/main/resources/assets/wyvern/shaders/core/border/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/border/data.json) | 14 строк | Дескриптор программы и uniform/attribute. Скруглённая обводка. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/border/fragment.fsh) | 31 строк | Fragment shader. Скруглённая обводка. |

### `src/main/resources/assets/wyvern/shaders/core/corner/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/corner/data.json) | 15 строк | Дескриптор программы и uniform/attribute. Углы/частичная рамка. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/corner/fragment.fsh) | 43 строк | Fragment shader. Углы/частичная рамка. |

### `src/main/resources/assets/wyvern/shaders/core/gradient_rectangle/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/gradient_rectangle/data.json) | 17 строк | Дескриптор программы и uniform/attribute. Прямоугольник с интерполяцией градиента. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/gradient_rectangle/fragment.fsh) | 44 строк | Fragment shader. Прямоугольник с интерполяцией градиента. |

### `src/main/resources/assets/wyvern/shaders/core/hand_glow/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [hand_glow.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hand_glow/hand_glow.fsh) | 43 строк | Fragment shader. Свечение рук/предметов. |
| [hand_glow.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hand_glow/hand_glow.json) | 21 строк | Дескриптор программы и uniform/attribute. Свечение рук/предметов. |
| [hand_glow.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hand_glow/hand_glow.vsh) | 36 строк | Vertex shader. Свечение рук/предметов. |

### `src/main/resources/assets/wyvern/shaders/core/hand_wave/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [hand_wave.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hand_wave/hand_wave.fsh) | 90 строк | Fragment shader. Волновой/noise-эффект рук. |
| [hand_wave.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hand_wave/hand_wave.json) | 23 строк | Дескриптор программы и uniform/attribute. Волновой/noise-эффект рук. |
| [hand_wave.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hand_wave/hand_wave.vsh) | 36 строк | Vertex shader. Волновой/noise-эффект рук. |

### `src/main/resources/assets/wyvern/shaders/core/hands/` — 10

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [hands_glow.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_glow.fsh) | 21 строк | Fragment shader. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_glow.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_glow.json) | 15 строк | Дескриптор программы и uniform/attribute. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_kawase_down.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_kawase_down.fsh) | 22 строк | Fragment shader. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_kawase_down.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_kawase_down.json) | 14 строк | Дескриптор программы и uniform/attribute. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_kawase_up.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_kawase_up.fsh) | 27 строк | Fragment shader. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_kawase_up.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_kawase_up.json) | 15 строк | Дескриптор программы и uniform/attribute. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_mask_diff.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_mask_diff.fsh) | 18 строк | Fragment shader. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_mask_diff.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_mask_diff.json) | 14 строк | Дескриптор программы и uniform/attribute. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_overlay.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_overlay.fsh) | 19 строк | Fragment shader. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |
| [hands_overlay.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/hands/hands_overlay.json) | 14 строк | Дескриптор программы и uniform/attribute. Постобработка рук/блока: glow, mask difference, overlay и Kawase. |

### `src/main/resources/assets/wyvern/shaders/core/kawase_down/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/kawase_down/data.json) | 18 строк | Дескриптор программы и uniform/attribute. Downsample-проход Kawase blur. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/kawase_down/fragment.fsh) | 38 строк | Fragment shader. Downsample-проход Kawase blur. |
| [vertex.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/kawase_down/vertex.vsh) | 21 строк | Vertex shader. Downsample-проход Kawase blur. |

### `src/main/resources/assets/wyvern/shaders/core/kawase_up/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/kawase_up/data.json) | 18 строк | Дескриптор программы и uniform/attribute. Upsample-проход Kawase blur. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/kawase_up/fragment.fsh) | 41 строк | Fragment shader. Upsample-проход Kawase blur. |
| [vertex.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/kawase_up/vertex.vsh) | 21 строк | Vertex shader. Upsample-проход Kawase blur. |

### `src/main/resources/assets/wyvern/shaders/core/loading/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/loading/data.json) | 16 строк | Дескриптор программы и uniform/attribute. Индикатор загрузки. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/loading/fragment.fsh) | 36 строк | Fragment shader. Индикатор загрузки. |

### `src/main/resources/assets/wyvern/shaders/core/metanoise/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/metanoise/data.json) | 71 строк | Дескриптор программы и uniform/attribute. Анимированный шум/метаэффект GUI. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/metanoise/fragment.fsh) | 90 строк | Fragment shader. Анимированный шум/метаэффект GUI. |

### `src/main/resources/assets/wyvern/shaders/core/msdf_font/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/msdf_font/data.json) | 23 строк | Дескриптор программы и uniform/attribute. MSDF-отрисовка шрифта. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/msdf_font/fragment.fsh) | 53 строк | Fragment shader. MSDF-отрисовка шрифта. |
| [vertex.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/msdf_font/vertex.vsh) | 20 строк | Vertex shader. MSDF-отрисовка шрифта. |

### `src/main/resources/assets/wyvern/shaders/core/rectangle/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/rectangle/data.json) | 13 строк | Дескриптор программы и uniform/attribute. Скруглённый прямоугольник. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/rectangle/fragment.fsh) | 27 строк | Fragment shader. Скруглённый прямоугольник. |

### `src/main/resources/assets/wyvern/shaders/core/sky/` — 3

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [sky_shader.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/sky/sky_shader.fsh) | 255 строк | Fragment shader. Старый многорежимный шейдер неба; JSON содержит неверный namespace javelin. |
| [sky_shader.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/sky/sky_shader.json) | 13 строк | Дескриптор программы и uniform/attribute. Старый многорежимный шейдер неба; JSON содержит неверный namespace javelin. |
| [sky_shader.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/sky/sky_shader.vsh) | 22 строк | Vertex shader. Старый многорежимный шейдер неба; JSON содержит неверный namespace javelin. |

### `src/main/resources/assets/wyvern/shaders/core/skyshader/` — 8

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [caustic.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/caustic.fsh) | 65 строк | Fragment shader. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [caustic.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/caustic.json) | 18 строк | Дескриптор программы и uniform/attribute. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [position.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/position.vsh) | 10 строк | Vertex shader. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [sky_fullscreen.vsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/sky_fullscreen.vsh) | 10 строк | Vertex shader. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [sky_plasma.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/sky_plasma.fsh) | 60 строк | Fragment shader. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [sky_plasma.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/sky_plasma.json) | 16 строк | Дескриптор программы и uniform/attribute. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [water.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/water.fsh) | 65 строк | Fragment shader. Текущие fullscreen-варианты неба: plasma/water/caustic. |
| [water.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/skyshader/water.json) | 18 строк | Дескриптор программы и uniform/attribute. Текущие fullscreen-варианты неба: plasma/water/caustic. |

### `src/main/resources/assets/wyvern/shaders/core/squircle/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/squircle/data.json) | 14 строк | Дескриптор программы и uniform/attribute. Суперэллипс/скруглённая фигура. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/squircle/fragment.fsh) | 45 строк | Fragment shader. Суперэллипс/скруглённая фигура. |

### `src/main/resources/assets/wyvern/shaders/core/squircle_texture/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/squircle_texture/data.json) | 16 строк | Дескриптор программы и uniform/attribute. Текстура с маской скруглённой фигуры. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/squircle_texture/fragment.fsh) | 42 строк | Fragment shader. Текстура с маской скруглённой фигуры. |

### `src/main/resources/assets/wyvern/shaders/core/texture/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [data.json](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/texture/data.json) | 15 строк | Дескриптор программы и uniform/attribute. Текстура с маской/скруглением. |
| [fragment.fsh](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/core/texture/fragment.fsh) | 31 строк | Fragment shader. Текстура с маской/скруглением. |

### `src/main/resources/assets/wyvern/shaders/include/` — 1

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [common.glsl](../wyvern-dlc/src/main/resources/assets/wyvern/shaders/include/common.glsl) | 37 строк | Общие GLSL-функции SDF скруглённой формы и alpha; include для UI-шейдеров. |

### `src/main/resources/assets/wyvern/sounds/` — 2

| Файл | Объём | Назначение / замечание |
|---|---:|---|
| [disable.ogg](../wyvern-dlc/src/main/resources/assets/wyvern/sounds/disable.ogg) | 12 594 байт | Ogg/Vorbis звук выключения модуля; указан в sounds.json, не воспроизводился. |
| [enable.ogg](../wyvern-dlc/src/main/resources/assets/wyvern/sounds/enable.ogg) | 12 795 байт | Ogg/Vorbis звук включения модуля; указан в sounds.json, не воспроизводился. |

<a id="modules"></a>
## Все 76 модулей

72 зарегистрированы. Таблица учитывает **полное имя класса**, поэтому две реализации NoFall не смешиваются. События ниже — объявленные обработчики; наличие обработчика не гарантирует подписку при нарушенном lifecycle (Blink).

| Класс / путь внутри impl | Имя GUI | Категория | В ModuleManager | Объявленные события |
|---|---|---|---|---|
| [combat/AimBow.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AimBow.java) | AimBow | COMBAT | [L72](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L72) | EventGameUpdate, EventHudRender |
| [combat/AntiBot.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AntiBot.java) | AntiBot | COMBAT | [L62](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L62) | EventUpdate |
| [combat/Aura.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java) | AttackAura | COMBAT | [L63](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L63) | EventGameUpdate, EventMoveInput, EventRender3D, EventRotation, EventTick, EventTickMovement |
| [combat/AutoExplosion.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoExplosion.java) | AutoExplosion | COMBAT | [L64](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L64) | EventPacket, EventUpdate |
| [combat/AutoSwap.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoSwap.java) | AutoSwap | COMBAT | [L70](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L70) | EventKey, EventUpdate |
| [combat/AutoTotem.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoTotem.java) | AutoTotem | COMBAT | [L65](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L65) | EventMoveInput, EventUpdate |
| [combat/ClickPearl.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/ClickPearl.java) | ClickPearl | COMBAT | [L66](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L66) | wtf.wyvern.base.events.impl.input.EventKey |
| [combat/CrystalAura.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/CrystalAura.java) | CrystallAura | COMBAT | [L71](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L71) | EventRender3D, EventTick |
| [combat/PacketCriticals.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/PacketCriticals.java) | PacketCriticals | COMBAT | [L68](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L68) | EventAttack |
| [combat/PearlTarget.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/PearlTarget.java) | PearlTarget | COMBAT | [L67](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L67) | EventPacket |
| [combat/TpsSync.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/TpsSync.java) | TpsSync | COMBAT | [L69](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L69) | Нет; проверить внешние хуки/вызовы |
| [combat/Velocity.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Velocity.java) | Velocity | COMBAT | **Нет** | EventPacket, EventUpdate |
| [misc/AHHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AHHelper.java) | AH Helper | MISC | **Нет** | Нет; проверить внешние хуки/вызовы |
| [misc/AutoAccept.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AutoAccept.java) | AutoAccept | MISC | [L139](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L139) | EventPacket |
| [misc/AutoRespawn.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AutoRespawn.java) | AutoRespawn | MISC | [L140](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L140) | EventUpdate |
| [misc/ChatHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ChatHelper.java) | ChatHelper | MISC | [L145](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L145) | EventChatSend, EventPacket |
| [misc/ClickAction.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ClickAction.java) | ClickFriend | MISC | [L136](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L136) | EventKey |
| [misc/CrystalOptimizer.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/CrystalOptimizer.java) | CrystalOptimizer | MISC | [L143](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L143) | EventRender3D, EventTick |
| [misc/ElytraHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ElytraHelper.java) | ElytraHelper | MISC | [L134](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L134) | EventKey, EventTick, EventTickMovement |
| [misc/FakePlayer.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FakePlayer.java) | FakePlayer | MISC | [L144](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L144) | Нет; проверить внешние хуки/вызовы |
| [misc/FreeCam.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java) | FreeCam | MISC | [L137](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L137) | EventGameUpdate, EventMove, EventMoveInput, EventPacket, EventRender3D |
| [misc/ItemScroller.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ItemScroller.java) | ItemScroller | MISC | [L135](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L135) | EventMouse |
| [misc/NameProtect.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/NameProtect.java) | NameProtect | MISC | [L141](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L141) | Нет; проверить внешние хуки/вызовы |
| [misc/NoInteract.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/NoInteract.java) | NoInteract | MISC | [L138](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L138) | Нет; проверить внешние хуки/вызовы |
| [misc/ScoreboardHealth.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ScoreboardHealth.java) | ScoreboardHealth | MISC | [L142](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L142) | Нет; проверить внешние хуки/вызовы |
| [misc/ServerHelper.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ServerHelper.java) | ServerHelper | MISC | [L133](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L133) | EventKey, EventTickMovement |
| [movement/AirStuck.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java) | AirStuck | MOVEMENT | [L83](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L83) | EventAttack, EventGameUpdate, EventPacket, EventRender3D, EventTick |
| [movement/AutoSprint.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AutoSprint.java) | AutoSprint | MOVEMENT | [L76](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L76) | EventTick |
| [movement/ElytraBooster.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraBooster.java) | ElytraBooster | MOVEMENT | [L77](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L77) | Нет; проверить внешние хуки/вызовы |
| [movement/ElytraMotion.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraMotion.java) | ElytraMotion | MOVEMENT | [L84](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L84) | EventMove, EventUpdate |
| [movement/ElytraRecast.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraRecast.java) | ElytraRecast | MOVEMENT | [L78](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L78) | EventMoveInput |
| [movement/GrimGlide.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GrimGlide.java) | GrimGlide | MOVEMENT | [L79](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L79) | EventMoveInput |
| [movement/GuiWalk.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GuiWalk.java) | GuiMove | MOVEMENT | [L80](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L80) | EventPacket, EventTick |
| [movement/NoFall.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoFall.java) | NoFall | MOVEMENT | **Нет** | EventUpdate |
| [movement/NoSlow.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoSlow.java) | NoSlow | MOVEMENT | [L81](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L81) | EventMove, EventSlowWalking, EventUpdate |
| [movement/NoWeb.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoWeb.java) | NoWeb | MOVEMENT | [L85](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L85) | EventUpdate |
| [movement/Speed.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/Speed.java) | Speed | MOVEMENT | [L82](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L82) | EventUpdate |
| [player/AutoArmor.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/AutoArmor.java) | AutoArmor | PLAYER | [L123](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L123) | EventUpdate |
| [player/AutoTool.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/AutoTool.java) | AutoTool | PLAYER | [L122](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L122) | EventUpdate |
| [player/Blink.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/Blink.java) | Blink | PLAYER | [L124](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L124) | EventUpdate |
| [player/FastBreak.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/FastBreak.java) | FastBreak | PLAYER | [L126](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L126) | EventUpdate |
| [player/FastUse.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/FastUse.java) | FastUse | PLAYER | [L128](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L128) | EventGameUpdate |
| [player/LevitationControl.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/LevitationControl.java) | LevitationControl | PLAYER | [L129](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L129) | EventMoveInput, EventUpdate |
| [player/NoDelay.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoDelay.java) | NoJumpDelay | PLAYER | [L125](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L125) | EventUpdate |
| [player/NoFall.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoFall.java) | NoFall | MOVEMENT | [L86](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L86) | EventUpdate |
| [player/NoPush.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoPush.java) | NoPush | PLAYER | [L127](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L127) | Нет; проверить внешние хуки/вызовы |
| [render/Ambience.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Ambience.java) | Ambience | RENDER | [L97](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L97) | EventFog |
| [render/AntiInvisible.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/AntiInvisible.java) | AntiInvis | RENDER | [L91](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L91) | EventEntityColor |
| [render/Arrows.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Arrows.java) | Arrows | RENDER | [L111](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L111) | EventHudRender |
| [render/AspectRatio.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/AspectRatio.java) | AspectRatio | RENDER | [L116](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L116) | EventAspectRatio |
| [render/BloomBlock.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/BloomBlock.java) | BlockOverlay | RENDER | [L108](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L108) | EventRender3D |
| [render/ClientBow.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ClientBow.java) | ClientBow | RENDER | [L114](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L114) | EventRender3D |
| [render/ClientSounds.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ClientSounds.java) | ClientSounds | RENDER | [L115](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L115) | EventModuleToggle |
| [render/Cosmetics.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cosmetics.java) | Cosmetics | RENDER | [L101](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L101) | EventRender3D |
| [render/Crosshair.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Crosshair.java) | Crosshair | RENDER | [L95](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L95) | EventHudRender |
| [render/Cubes.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cubes.java) | Cubes | RENDER | [L112](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L112) | EventAttack, EventRender3D |
| [render/CustomSky.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/CustomSky.java) | CustomSky | RENDER | [L118](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L118) | Нет; проверить внешние хуки/вызовы |
| [render/EntityESP.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/EntityESP.java) | NameTags | RENDER | [L104](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L104) | EventRender2D, EventRender3D |
| [render/FireworkESP.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/FireworkESP.java) | FireworkESP | RENDER | [L99](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L99) | EventRender2D, EventRender3D |
| [render/FullBright.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/FullBright.java) | FullBright | RENDER | [L102](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L102) | Нет; проверить внешние хуки/вызовы |
| [render/HitMarker.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/HitMarker.java) | HitMarker | RENDER | [L113](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L113) | EventAttack, EventRender3D |
| [render/Interface.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java) | HUD | RENDER | [L90](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L90) | EventHudRender, EventMouse, EventSetScreen, EventUpdate, EventWindowResize |
| [render/JumpCircle.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/JumpCircle.java) | JumpCircle | RENDER | [L100](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L100) | EventRender3D, EventUpdate |
| [render/KillEffect.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/KillEffect.java) | KillEffect | RENDER | [L107](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L107) | EventAttack, EventRender3D, EventTick |
| [render/LineGlyphes.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/LineGlyphes.java) | LineGlyphes | RENDER | [L110](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L110) | EventRender3D, EventUpdate |
| [render/Menu.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Menu.java) | ClickGUI | RENDER | [L103](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L103) | Нет; проверить внешние хуки/вызовы |
| [render/NameTags.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NameTags.java) | NameTags | RENDER | **Нет** | EventRender2D, EventRender3D, EventRenderName |
| [render/NoRender.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NoRender.java) | NoRender | RENDER | [L92](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L92) | EventCamera |
| [render/Particles.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Particles.java) | Particles | RENDER | [L105](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L105) | EventAttack, EventPacket, EventRender3D, EventUpdate |
| [render/Predictions.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Predictions.java) | Predictions | RENDER | [L93](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L93) | EventRender2D, EventRender3D |
| [render/ShaderHands.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ShaderHands.java) | ShaderHands | RENDER | [L117](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L117) | Нет; проверить внешние хуки/вызовы |
| [render/ShulkerPreview.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ShulkerPreview.java) | ShulkerPreview | RENDER | [L98](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L98) | Нет; проверить внешние хуки/вызовы |
| [render/SwingAnimation.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/SwingAnimation.java) | SwingAnimation | RENDER | [L94](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L94) | EventAttack |
| [render/TargetESP.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TargetESP.java) | TargetESP | RENDER | [L106](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L106) | EventRender3D |
| [render/TotemPop.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TotemPop.java) | TotemPop | RENDER | [L109](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L109) | EventPacket, EventRender3D |
| [render/ViewModel.java](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ViewModel.java) | ViewModel | RENDER | [L96](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L96) | Нет; проверить внешние хуки/вызовы |

<a id="events"></a>
## Все 44 события

Источники — найденные места создания объекта; для переиспользуемого EventMotion это объявление поля. Обработчики перечислены независимо от текущей регистрации/включения модулей. Помимо этих 44 классов есть две обёртки `base/events/callables` и библиотечные типы EventAPI.

| Событие | Места создания | Обработчики @EventTarget |
|---|---|---|
| [EventEntityColor](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/entity/EventEntityColor.java) | [utility/mixin/client/render/LivingEntityRendererMixin:42](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/LivingEntityRendererMixin.java#L42)<br>[utility/mixin/client/render/LivingEntityRendererMixin:68](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/LivingEntityRendererMixin.java#L68) | [AntiInvisible.onEntityColor](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/AntiInvisible.java#L25) |
| [EventChatSend](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventChatSend.java) | [utility/mixin/minecraft/network/ClientPlayNetworkHandlerMixin:34](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientPlayNetworkHandlerMixin.java#L34) | [ChatHelper.onChatSend](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ChatHelper.java#L30) |
| [EventHotBarScroll](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventHotBarScroll.java) | [utility/mixin/client/MouseMixin:62](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java#L62) | Нет |
| [EventKey](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventKey.java) | [utility/mixin/client/KeyboardMixin:19](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/KeyboardMixin.java#L19)<br>[utility/mixin/client/MouseMixin:47](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java#L47) | [ModuleManager.onKey](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L169)<br>[AutoSwap.onKey](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoSwap.java#L35)<br>[ClickPearl.onKey](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/ClickPearl.java#L29)<br>[ClickAction.onKey](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ClickAction.java#L25)<br>[ElytraHelper.onKey](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ElytraHelper.java#L46)<br>[ServerHelper.onKey](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ServerHelper.java#L36) |
| [EventMouse](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventMouse.java) | [utility/mixin/client/MouseMixin:48](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java#L48) | [ItemScroller.onMouse](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ItemScroller.java#L18)<br>[Interface.onMouse](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java#L178) |
| [EventMouseRotation](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventMouseRotation.java) | [utility/mixin/client/MouseMixin:91](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java#L91) | Нет |
| [EventSetScreen](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/input/EventSetScreen.java) | [utility/mixin/client/MinecraftClientMixin:46](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java#L46) | [Interface.screenEvent](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java#L336) |
| [EventClickSlot](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventClickSlot.java) | [utility/mixin/client/ClientPlayerInteractionManagerMixin:57](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerInteractionManagerMixin.java#L57) | Нет |
| [EventCloseScreen](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventCloseScreen.java) | [utility/mixin/client/ClientPlayerEntityMixin:140](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L140) | Нет |
| [EventGameUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventGameUpdate.java) | [utility/mixin/client/MinecraftClientMixin:62](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java#L62) | [ModuleManager.onGameUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L248)<br>[AimBow.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AimBow.java#L70)<br>[Aura.eventRotate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java#L284)<br>[FreeCam.onGameUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java#L51)<br>[AirStuck.onGameUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java#L87)<br>[FastUse.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/FastUse.java#L34) |
| [EventModuleToggle](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventModuleToggle.java) | [client/modules/api/Module:56](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Module.java#L56)<br>[client/modules/api/Module:61](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/api/Module.java#L61) | [NotifyManager.onModuleToggle](../wyvern-dlc/src/main/java/wtf/wyvern/base/notify/NotifyManager.java#L49)<br>[ToggleNotify.onToggle](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/ToggleNotify.java#L28)<br>[ClientSounds.onToggle](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ClientSounds.java#L28) |
| [EventSpawnEntity](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventSpawnEntity.java) | [utility/mixin/client/ClientWorldMixin:19](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientWorldMixin.java#L19) | Нет |
| [EventTick](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventTick.java) | [utility/mixin/client/MinecraftClientMixin:72](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java#L72) | [Aura.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java#L233)<br>[CrystalAura.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/CrystalAura.java#L85)<br>[CrystalOptimizer.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/CrystalOptimizer.java#L56)<br>[ElytraHelper.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ElytraHelper.java#L56)<br>[AirStuck.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java#L75)<br>[AutoSprint.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AutoSprint.java#L47)<br>[GuiWalk.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GuiWalk.java#L40)<br>[KillEffect.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/KillEffect.java#L67) |
| [EventTickMovement](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventTickMovement.java) | [utility/mixin/minecraft/entity/PlayerEntityMixin:18](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/PlayerEntityMixin.java#L18) | [Aura.onTickMovement](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java#L273)<br>[ElytraHelper.onTickMovement](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ElytraHelper.java#L154)<br>[ServerHelper.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ServerHelper.java#L48) |
| [EventWindowResize](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/other/EventWindowResize.java) | [utility/mixin/client/render/WindowMixin:18](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/WindowMixin.java#L18) | [Interface.resize](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java#L301) |
| [EventAttack](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventAttack.java) | [utility/mixin/client/ClientPlayerInteractionManagerMixin:42](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerInteractionManagerMixin.java#L42) | [PacketCriticals.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/PacketCriticals.java#L29)<br>[AirStuck.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java#L124)<br>[Cubes.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cubes.java#L97)<br>[HitMarker.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/HitMarker.java#L60)<br>[KillEffect.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/KillEffect.java#L51)<br>[Particles.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Particles.java#L125)<br>[SwingAnimation.onAttack](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/SwingAnimation.java#L37) |
| [EventDirection](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventDirection.java) | **Не найдены** | Нет |
| [EventEntityHitBox](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventEntityHitBox.java) | **Не найдены** | Нет |
| [EventJump](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventJump.java) | **Не найдены** | Нет |
| [EventLook](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventLook.java) | [utility/mixin/client/MouseMixin:138](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java#L138) | [FreeLookComponent.onLook](../wyvern-dlc/src/main/java/wtf/wyvern/utility/component/FreeLookComponent.java#L20) |
| [EventMotion](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventMotion.java) | [utility/mixin/client/ClientPlayerEntityMixin:62](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L62) | Нет |
| [EventMove](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventMove.java) | [utility/mixin/client/ClientPlayerEntityMixin:157](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L157) | [FreeCam.onMove](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java#L78)<br>[ElytraMotion.onMove](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraMotion.java#L40)<br>[NoSlow.onMove](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoSlow.java#L64) |
| [EventMoveInput](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventMoveInput.java) | [utility/mixin/client/KeyboardInputMixin:65](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/KeyboardInputMixin.java#L65) | [Aura.onMoveInput](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java#L628)<br>[AutoTotem.onInput](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoTotem.java#L62)<br>[FreeCam.onMoveInput](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java#L85)<br>[ElytraRecast.update](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraRecast.java#L27)<br>[GrimGlide.onEvent](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GrimGlide.java#L27)<br>[LevitationControl.onMoveInput](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/LevitationControl.java#L60)<br>[RotationComponent.onInput](../wyvern-dlc/src/main/java/wtf/wyvern/utility/component/RotationComponent.java#L59) |
| [EventPickupItem](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventPickupItem.java) | [utility/mixin/minecraft/network/ClientPlayNetworkHandlerMixin:95](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientPlayNetworkHandlerMixin.java#L95) | Нет |
| [EventRotate](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventRotate.java) | **Не найдены** | [ScriptManager.rotateTick](../wyvern-dlc/src/main/java/wtf/wyvern/base/request/ScriptManager.java#L28) |
| [EventRotation](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventRotation.java) | [utility/mixin/client/CameraMixin:93](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/CameraMixin.java#L93) | [Aura.onCameraRotation](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java#L474)<br>[FreeLookComponent.onRotation](../wyvern-dlc/src/main/java/wtf/wyvern/utility/component/FreeLookComponent.java#L29) |
| [EventSlowWalking](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventSlowWalking.java) | [utility/mixin/client/ClientPlayerEntityMixin:126](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L126) | [NoSlow.onItemUse](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoSlow.java#L41) |
| [EventSprintUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventSprintUpdate.java) | [utility/mixin/client/ClientPlayerEntityMixin:96](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L96) | Нет |
| [EventUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/player/EventUpdate.java) | [utility/mixin/client/ClientPlayerEntityMixin:84](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java#L84) | [RCTRepository.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/base/repository/RCTRepository.java#L57)<br>[ScriptManager.updateTick](../wyvern-dlc/src/main/java/wtf/wyvern/base/request/ScriptManager.java#L33)<br>[AntiBot.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AntiBot.java#L31)<br>[AutoExplosion.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoExplosion.java#L80)<br>[AutoSwap.onTick](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoSwap.java#L47)<br>[AutoTotem.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoTotem.java#L72)<br>[Velocity.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Velocity.java#L50)<br>[AutoRespawn.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AutoRespawn.java#L23)<br>[ElytraMotion.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/ElytraMotion.java#L29)<br>[NoFall.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoFall.java#L24)<br>[NoSlow.update](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoSlow.java#L72)<br>[NoWeb.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/NoWeb.java#L27)<br>[Speed.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/Speed.java#L29)<br>[AutoArmor.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/AutoArmor.java#L28)<br>[AutoTool.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/AutoTool.java#L41)<br>[Blink.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/Blink.java#L35)<br>[FastBreak.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/FastBreak.java#L25)<br>[LevitationControl.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/LevitationControl.java#L69)<br>[NoDelay.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoDelay.java#L17)<br>[NoFall.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/NoFall.java#L22)<br>[Interface.update](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java#L314)<br>[JumpCircle.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/JumpCircle.java#L75)<br>[LineGlyphes.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/LineGlyphes.java#L50)<br>[Particles.onUpdate](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Particles.java#L191)<br>[RotationComponent.onEventTick](../wyvern-dlc/src/main/java/wtf/wyvern/utility/component/RotationComponent.java#L75)<br>[ServerHandler.tick](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/server/ServerHandler.java#L79) |
| [EventAspectRatio](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventAspectRatio.java) | [utility/mixin/minecraft/render/MixinGameRenderer:56](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java#L56) | [AspectRatio.onAspectRatio](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/AspectRatio.java#L23) |
| [EventCamera](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventCamera.java) | [utility/mixin/client/CameraMixin:55](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/CameraMixin.java#L55) | [NoRender.onCamera](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NoRender.java#L51) |
| [EventCameraPosition](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventCameraPosition.java) | [utility/mixin/client/CameraMixin:78](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/CameraMixin.java#L78) | Нет |
| [EventFog](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventFog.java) | [utility/mixin/client/BackGroundRendererMixin:41](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/BackGroundRendererMixin.java#L41)<br>[utility/mixin/client/BackGroundRendererMixin:58](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/BackGroundRendererMixin.java#L58) | [Ambience.onFog](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Ambience.java#L34) |
| [EventFov](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventFov.java) | [utility/mixin/minecraft/render/MixinGameRenderer:80](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java#L80) | Нет |
| [EventHandledScreen](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventHandledScreen.java) | [utility/mixin/client/HandledScreenMixin:31](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/HandledScreenMixin.java#L31) | Нет |
| [EventHudRender](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventHudRender.java) | [utility/mixin/minecraft/render/MixinGameRenderer:145](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java#L145) | [ModuleManager.onRender](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L204)<br>[WaypointManager.onHUD](../wyvern-dlc/src/main/java/wtf/wyvern/base/waypoint/WaypointManager.java#L67)<br>[ToggleNotify.onRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/hud/elements/ToggleNotify.java#L37)<br>[AimBow.onRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AimBow.java#L225)<br>[Arrows.onRenderHud](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Arrows.java#L37)<br>[Crosshair.onRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Crosshair.java#L32)<br>[Interface.onRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Interface.java#L126) |
| [EventRender2D](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRender2D.java) | [utility/mixin/client/render/gui/hud/InGameHudMixin:54](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/hud/InGameHudMixin.java#L54) | [EntityESP.onRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/EntityESP.java#L59)<br>[FireworkESP.onRender2D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/FireworkESP.java#L92)<br>[NameTags.onRender2D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NameTags.java#L108)<br>[Predictions.onDraw](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Predictions.java#L52) |
| [EventRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRender3D.java) | [utility/mixin/minecraft/render/MixinGameRenderer:100](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java#L100) | [Aura.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Aura.java#L614)<br>[CrystalAura.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/CrystalAura.java#L197)<br>[CrystalOptimizer.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/CrystalOptimizer.java#L138)<br>[FreeCam.onWorldRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java#L71)<br>[AirStuck.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java#L139)<br>[BloomBlock.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/BloomBlock.java#L52)<br>[ClientBow.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/ClientBow.java#L41)<br>[Cosmetics.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cosmetics.java#L94)<br>[Cubes.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Cubes.java#L83)<br>[EntityESP.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/EntityESP.java#L68)<br>[FireworkESP.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/FireworkESP.java#L59)<br>[HitMarker.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/HitMarker.java#L100)<br>[JumpCircle.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/JumpCircle.java#L104)<br>[KillEffect.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/KillEffect.java#L98)<br>[LineGlyphes.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/LineGlyphes.java#L68)<br>[NameTags.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NameTags.java#L68)<br>[Particles.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Particles.java#L321)<br>[Predictions.onWorldRender](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Predictions.java#L87)<br>[TargetESP.onRenderWorldLast](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TargetESP.java#L129)<br>[TotemPop.onRender3D](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TotemPop.java#L60) |
| [EventRenderName](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRenderName.java) | **Не найдены** | [NameTags.onRenderName](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/NameTags.java#L61) |
| [EventRenderScreen](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRenderScreen.java) | [utility/mixin/minecraft/render/MixinGameRenderer:119](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java#L119) | Нет |
| [EventRenderSky](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/render/EventRenderSky.java) | [utility/mixin/client/WorldRendererMixin:39](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/WorldRendererMixin.java#L39) | Нет |
| [EventChatReceive](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/server/EventChatReceive.java) | **Не найдены** | Нет |
| [EventPacket](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/server/EventPacket.java) | [utility/mixin/minecraft/network/ClientConnectionMixin:27](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientConnectionMixin.java#L27)<br>[utility/mixin/minecraft/network/ClientConnectionMixin:46](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientConnectionMixin.java#L46) | [ModuleManager.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java#L241)<br>[RCTRepository.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/base/repository/RCTRepository.java#L36)<br>[AutoExplosion.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoExplosion.java#L66)<br>[PearlTarget.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/PearlTarget.java#L36)<br>[Velocity.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/Velocity.java#L76)<br>[AutoAccept.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/AutoAccept.java#L28)<br>[ChatHelper.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/ChatHelper.java#L39)<br>[FreeCam.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FreeCam.java#L58)<br>[AirStuck.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/AirStuck.java#L109)<br>[GuiWalk.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/movement/GuiWalk.java#L78)<br>[Particles.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/Particles.java#L153)<br>[TotemPop.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/render/TotemPop.java#L45)<br>[ServerHandler.packet](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/server/ServerHandler.java#L90)<br>[ServerHandler.onPacket](../wyvern-dlc/src/main/java/wtf/wyvern/utility/game/server/ServerHandler.java#L102) |
| [EventPacketPost](../wyvern-dlc/src/main/java/wtf/wyvern/base/events/impl/server/EventPacketPost.java) | **Не найдены** | Нет |

<a id="mixins"></a>
## Все 45 миксинов

Каждый файл ниже присутствует в wyvern.mixins.json. Указаны объявленный target, типы хуков и места с intermediary-именами; успешное применение на runtime не проверено.

| Файл внутри utility/mixin | Target | Хуки | Intermediary-имена |
|---|---|---|---|
| [accessors/CameraAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/CameraAccessor.java) | `Camera` | Invoker L9, Invoker L12 | — |
| [accessors/DrawContextAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/DrawContextAccessor.java) | `DrawContext` | Accessor L12, Invoker L15, Invoker L18 | — |
| [accessors/HandledScreenAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/HandledScreenAccessor.java) | `HandledScreen` | Accessor L9, Accessor L12 | — |
| [accessors/InGameHudAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/InGameHudAccessor.java) | `InGameHud` | Invoker L11, Invoker L14 | — |
| [accessors/ItemStackAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/ItemStackAccessor.java) | `ItemStack` | Accessor L10 | — |
| [accessors/ShaderProgramAccessor.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/accessors/ShaderProgramAccessor.java) | `ShaderProgram` | Accessor L11 | — |
| [client/BackGroundRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/BackGroundRendererMixin.java) | `BackgroundRenderer` | Inject L22, Inject L35, Inject L52 | — |
| [client/CameraMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/CameraMixin.java) | `Camera` | Inject L45, Inject L72, Redirect L85 | `field_18712`, `field_18713`, `field_18717`, `field_18718`, `method_19318`, `method_19324`, `method_19325` |
| [client/ChatInputSuggestorMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ChatInputSuggestorMixin.java) | `ChatInputSuggestor` | Inject L37 | `field_21599`, `field_21610`, `field_21611`, `field_21612`, `field_21614`, `method_23937` |
| [client/ClientPlayerEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerEntityMixin.java) | `ClientPlayerEntity` | Inject L79, Redirect L88, Inject L104, Redirect L116, Inject L134, Inject L148, Overwrite L166 | `field_3920`, `field_3923`, `field_3924`, `field_3925`, `field_3926`, `field_3927`, `field_3937`, `field_3940`, `field_3941`, `field_3944`, `field_53040`, `method_3134`, `method_3136`, `method_3148`, `method_46742` |
| [client/ClientPlayerInteractionManagerMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientPlayerInteractionManagerMixin.java) | `ClientPlayerInteractionManager` | Inject L35, Inject L51, Inject L65, Inject L83 | `method_2905` |
| [client/ClientWorldMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ClientWorldMixin.java) | `ClientWorld` | Inject L14 | — |
| [client/EntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/EntityMixin.java) | `Entity` | ModifyExpressionValue L15, Inject L26, Inject L38 | — |
| [client/HandledScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/HandledScreenMixin.java) | `HandledScreen` | Inject L26 | `field_2779`, `field_2787`, `field_2792` |
| [client/HeldItemRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/HeldItemRendererMixin.java) | `HeldItemRenderer` | Inject L48, Inject L66, Inject L84, Redirect L103, Overwrite L125 | `field_4043`, `field_4047`, `field_4048`, `field_4051`, `field_4052`, `field_4053`, `method_22976`, `method_3228`, `method_65816` |
| [client/KeyboardInputMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/KeyboardInputMixin.java) | `KeyboardInput` | Inject L37 | — |
| [client/KeyboardMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/KeyboardMixin.java) | `Keyboard` | Inject L13 | — |
| [client/LightmapTextureManagerMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/LightmapTextureManagerMixin.java) | `LightmapTextureManager` | ModifyExpressionValue L11 | — |
| [client/MinecraftClientMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MinecraftClientMixin.java) | `MinecraftClient` | Inject L29, ModifyVariable L40, Inject L51, Inject L67 | — |
| [client/MouseMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/MouseMixin.java) | `Mouse` | Inject L41, Inject L53, Redirect L70, WrapWithCondition L81, Inject L107 | `field_1779`, `field_1780`, `field_1782`, `field_1787`, `field_1789`, `field_1793` |
| [client/PlayerEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/PlayerEntityMixin.java) | `LivingEntity` | Inject L12 | — |
| [client/ScoreboarMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/ScoreboarMixin.java) | `Scoreboard` | Inject L18 | `method_1164` |
| [client/WorldRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/WorldRendererMixin.java) | `WorldRenderer` | Redirect L20, Inject L37, Inject L42 | — |
| [client/render/LivingEntityRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/LivingEntityRendererMixin.java) | `LivingEntityRenderer` | Redirect L29, Redirect L52 | `method_24302` |
| [client/render/RenderSystemMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/RenderSystemMixin.java) | `RenderSystem` | ModifyVariable L13 | — |
| [client/render/ScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/ScreenMixin.java) | `Screen` | Нет (пустой класс) | — |
| [client/render/WindowMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/WindowMixin.java) | `Window` | Inject L13 | — |
| [client/render/gui/hud/GameOverlayRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/hud/GameOverlayRendererMixin.java) | `InGameOverlayRenderer` | Inject L14 | — |
| [client/render/gui/hud/InGameHudMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/hud/InGameHudMixin.java) | `InGameHud` | Inject L23, Inject L34, Inject L45, Inject L57, Inject L73, Inject L88, Inject L103, Inject L116, Inject L131, ModifyVariable L144 | — |
| [client/render/gui/screen/ChatScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/screen/ChatScreenMixin.java) | `ChatScreen` | Inject L18 | — |
| [client/render/gui/screen/HandledScreenMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/render/gui/screen/HandledScreenMixin.java) | `HandledScreen` | Inject L45, Inject L77, Inject L113, Inject L125, Inject L154 | `field_2797`, `method_17577`, `method_2383`, `method_2387` |
| [client/sound/SoundSystemMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/client/sound/SoundSystemMixin.java) | `SoundSystem` | Inject L13 | — |
| [minecraft/entity/FireworkRocketEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/FireworkRocketEntityMixin.java) | `FireworkRocketEntity` | ModifyExpressionValue L31, Redirect L43 | `field_7616` |
| [minecraft/entity/LimbAnimatorMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/LimbAnimatorMixin.java) | `LimbAnimator` | Accessor L10, Accessor L14, Accessor L18 | — |
| [minecraft/entity/LivingEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/LivingEntityMixin.java) | `LivingEntity` | Нет (пустой класс) | — |
| [minecraft/entity/PlayerEntityMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/entity/PlayerEntityMixin.java) | `PlayerEntity` | Inject L13 | — |
| [minecraft/network/ClientConnectionMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientConnectionMixin.java) | `ClientConnection` | Inject L21, Inject L37 | — |
| [minecraft/network/ClientPlayNetworkHandlerMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/network/ClientPlayNetworkHandlerMixin.java) | `ClientPlayNetworkHandler` | Inject L27, Inject L66, Inject L78 | — |
| [minecraft/render/ClientWorldPropertiesMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/ClientWorldPropertiesMixin.java) | `Properties` | Inject L16 | `field_24439` |
| [minecraft/render/FeatureRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/FeatureRendererMixin.java) | `FeatureRenderer` | Нет (пустой класс) | — |
| [minecraft/render/HeldItemFeatureRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/HeldItemFeatureRendererMixin.java) | `HeldItemFeatureRenderer` | Inject L15 | — |
| [minecraft/render/MixinGameRenderer.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/MixinGameRenderer.java) | `GameRenderer` | Inject L50, ModifyExpressionValue L71, Inject L85, Inject L108, Inject L122 | `field_3988`, `field_4004`, `field_4005`, `method_32796` |
| [minecraft/render/PlayerEntityRendererMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/render/PlayerEntityRendererMixin.java) | `PlayerEntityRenderer` | Inject L17 | — |
| [minecraft/team/TeamMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/team/TeamMixin.java) | `Team` | ModifyArg L14 | — |
| [minecraft/text/TextVisitFactoryMixin.java](../wyvern-dlc/src/main/java/wtf/wyvern/utility/mixin/minecraft/text/TextVisitFactoryMixin.java) | `TextVisitFactory` | ModifyArg L12 | — |

<a id="binaries"></a>
## Бинарники: SHA-256

39 файлов. Хеш удостоверяет конкретное содержимое, а не безопасность. Wrapper дополнительно сопоставлен с официальным Gradle v8.14.1. Полный reverse engineering DLL/моделей не проводился.

| Файл | SHA-256 |
|---|---|
| [gradle/wrapper/gradle-wrapper.jar](../wyvern-dlc/gradle/wrapper/gradle-wrapper.jar) | `7d3a4ac4de1c32b59bc6a4eb8ecb8e612ccd0cf1ae1e99f66902da64df296172` |
| [src/main/resources/assets/win32-x86/discord-rpc.dll](../wyvern-dlc/src/main/resources/assets/win32-x86/discord-rpc.dll) | `585743ed291ed1008ad071a37ab0a188354e6467e8bb3f71b33f8688c49f6dd0` |
| [src/main/resources/assets/wyvern/fonts/msdf/bold.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/bold.png) | `56a3c95b8acc7365968c27c462981256fefef85c52e774359e5ab04c2d9bd944` |
| [src/main/resources/assets/wyvern/fonts/msdf/comfortaa_light.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/comfortaa_light.png) | `e3ab09477b42a08414a1984bf80eb7166e55293f5ea9c65fa46f61173382475c` |
| [src/main/resources/assets/wyvern/fonts/msdf/comfortaa_regular.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/comfortaa_regular.png) | `70523a9be54c136d494380ce48f56cea8ff2b79bf9d397be01060290be8c1456` |
| [src/main/resources/assets/wyvern/fonts/msdf/energy.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/energy.png) | `3bfe7c33d2b150c789ba463bd41a063a80f18bf305012c684fb93be88392d32f` |
| [src/main/resources/assets/wyvern/fonts/msdf/font.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/font.png) | `26bd895b27c7277f94ee40ddf613cb23ba138b42d99b88e24500f87716d8df28` |
| [src/main/resources/assets/wyvern/fonts/msdf/hud_icons.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/hud_icons.png) | `a25c4b068014a63802045817d0e11120b5b00e877b70131025477394d7a2cbd2` |
| [src/main/resources/assets/wyvern/fonts/msdf/icons.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/icons.png) | `635240a02386a51bb30b59c69a919862010b8f4f36abdcdaf6ecb181b8c87c08` |
| [src/main/resources/assets/wyvern/fonts/msdf/icons5.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/icons5.png) | `f904efe976044357ae646eea2eded9756cba527734de21885127f3f3980bacc3` |
| [src/main/resources/assets/wyvern/fonts/msdf/logo.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/logo.png) | `fba16b6a98916abb05231c2791ea16c2e148a03f60980939af1f5b882019a696` |
| [src/main/resources/assets/wyvern/fonts/msdf/lupa.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/lupa.png) | `846d1c7003bfae96f0c731ff3903a0e467bf45b37fda230044fa7dba10e4ada7` |
| [src/main/resources/assets/wyvern/fonts/msdf/medium.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/medium.png) | `f3d2caa08353068fb35cd5676dfdb087b28c3302d2f8d6952236ce9973d66c83` |
| [src/main/resources/assets/wyvern/fonts/msdf/nuriki.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/nuriki.png) | `f0f3740ccbb3576fcf11f864532e4d6f776d4fd2c2ca2613929fe73279a39175` |
| [src/main/resources/assets/wyvern/fonts/msdf/nursultanik.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/nursultanik.png) | `1785fab2a7858c4be677a1f5b6eaaa648b9e129a2dea6f1fd9ba189b293cd015` |
| [src/main/resources/assets/wyvern/fonts/msdf/regular.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/regular.png) | `761fe58301a58e91e7328d626a4d674fc7efecf31be7d9104f44c8d4e0b7decc` |
| [src/main/resources/assets/wyvern/fonts/msdf/roundbold.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/roundbold.png) | `a387ed80c8d91fe152034a409a8596edbc7991ef3c00de8814236de7ca535a5c` |
| [src/main/resources/assets/wyvern/fonts/msdf/semibold.png](../wyvern-dlc/src/main/resources/assets/wyvern/fonts/msdf/semibold.png) | `fb07e65b79d21523897b1b89f2366aa3fc30dbd8a45edd7d071d4380daaf1467` |
| [src/main/resources/assets/wyvern/icons/arrow.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/arrow.png) | `1ccec98cf30da66cc8eb74f4a843cf4fac8bc40b0b677629a6d5e285f6b86f73` |
| [src/main/resources/assets/wyvern/icons/bloom.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/bloom.png) | `5469f554e07590aca5a89ffec1d8f88fd02eacf7d2edc6d6b09a8f7a0bdd5a01` |
| [src/main/resources/assets/wyvern/icons/circle.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/circle.png) | `dd4d30ed0a753217759b41eebc3e524ac31efdfe20866a62d810e596d31f7d33` |
| [src/main/resources/assets/wyvern/icons/cross.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/cross.png) | `affe7fed446825631a4f909c49e7aa9ee1d3890e7c11dcf0e6ae85e12618500d` |
| [src/main/resources/assets/wyvern/icons/dollar.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/dollar.png) | `29c0f8e4c95bd2fb800cd88c7f18630a0a1dd2290019cb9c3e555a947b378bb0` |
| [src/main/resources/assets/wyvern/icons/glow.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/glow.png) | `677c6878e4c9c83bb783e680be411542d325cd302816c2a8e6e64176410e759a` |
| [src/main/resources/assets/wyvern/icons/marker.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/marker.png) | `c7f6a2972ca26adcca8612dd8dec0613efa436d1af0328e2a33dd093cf4cf486` |
| [src/main/resources/assets/wyvern/icons/separator.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/separator.png) | `d0f12b1cff50b593b23f485810238d2d29efff554b09d73bb2c8f82d731535e0` |
| [src/main/resources/assets/wyvern/icons/sliderhue.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/sliderhue.png) | `55dad80bbbdfa6dc735acf1816be671844ae50ad995db38ac2eada6986492a38` |
| [src/main/resources/assets/wyvern/icons/slidertransparent.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/slidertransparent.png) | `861e06762c4eb579444ade568a0a51b5db94cb2b0c62d53ff0cfe8b2809dde3f` |
| [src/main/resources/assets/wyvern/icons/snow.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/snow.png) | `b7273ce326955f338bff960a13608365938850c70bf1d1d7d15a042b2a3e605d` |
| [src/main/resources/assets/wyvern/icons/spark_1.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/spark_1.png) | `c09545515b7f5938355f1fa6f0a2f275104da7f834625b07f6d5879d1b78d690` |
| [src/main/resources/assets/wyvern/icons/spark_2.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/spark_2.png) | `2264ff512dae1cfd6b019abf346cd809ed6e003915109933b2db4f5947a0e5a7` |
| [src/main/resources/assets/wyvern/icons/spark_3.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/spark_3.png) | `030601bfc3eab5785b281faa269653126f9f726855c19eb327c84160c060de76` |
| [src/main/resources/assets/wyvern/icons/sparkle.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/sparkle.png) | `239fd301ae682d31f14548d241f44fd72af9755f05417fa99e6360d71a7c7fa4` |
| [src/main/resources/assets/wyvern/icons/star.png](../wyvern-dlc/src/main/resources/assets/wyvern/icons/star.png) | `1e8824d5723bb8f80c4f5dc66a4ab08dfeb6596573f9bddc99b1f95fd9751330` |
| [src/main/resources/assets/wyvern/models/model.params](../wyvern-dlc/src/main/resources/assets/wyvern/models/model.params) | `5b7ffa6febb1a4106ff41cf1f9a093d7a256ccb422d87401ce374b3411df561d` |
| [src/main/resources/assets/wyvern/models/slow.params](../wyvern-dlc/src/main/resources/assets/wyvern/models/slow.params) | `537b93deb5e320409e03a75c17a368287a8ff947d08a222ea1d3e913c6093cee` |
| [src/main/resources/assets/wyvern/models/tf-0100.params](../wyvern-dlc/src/main/resources/assets/wyvern/models/tf-0100.params) | `7d48221f367086e7f0485721eb0e0ff3fc0780e4ac5167ba23afa375d6b3827d` |
| [src/main/resources/assets/wyvern/sounds/disable.ogg](../wyvern-dlc/src/main/resources/assets/wyvern/sounds/disable.ogg) | `cfbd424103942643c4f5985b808f25cfa64bb60d5a346dbd3d28862062e8a2ac` |
| [src/main/resources/assets/wyvern/sounds/enable.ogg](../wyvern-dlc/src/main/resources/assets/wyvern/sounds/enable.ogg) | `76f53cb67547707d27b0cac5e3d87e5f60254804392bd7674c46e65ea34eab3f` |

## Контроль полноты

- Файлов в инвентаре и пофайловой таблице: **516**.
- Исходные данные: **7 302 343 байта**.
- Текстовых файлов: **477**; бинарных: **39**.
- Java: **370**; ресурсы: **118**; IDEA: **17**; прочие служебные: **11**.
- Все исходные файлы сверены по SHA-256 после анализа; содержимое не изменено.
- Дополнительно корневой `README.md`: название Anthem, 1 строка; он не входил в архив.
