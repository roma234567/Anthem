# ANTITHESIS KNOWLEDGE BASE
*Файл для синхронизации контекста будущих агентов при работе с базой Wyvern (Minecraft 1.21.4).*

## 1. Среда и маппинги
- **Minecraft:** 1.21.4
- **Yarn / Маппинги:** `1.21.4+build.8` (Named).
- **Сборка:** Fabric Loader `0.16.10`, API `0.119.3+1.21.4`, Java 21, Gradle 8.14.1.
- **Особенности 1.21.4:** 
  - Пакеты движения (`PlayerMoveC2SPacket`) требуют **5 аргументов**, включая флаг `horizontalCollision` последним параметром.
  - Избегать `EntityDamageS2CPacket` (частые конфликты обфускации), использовать `EntityStatusS2CPacket` (status 2 = HURT).
  - Свап слотов: `InventoryUtil.indexToSlot(int)` для перевода индексов в сетевые слоты. Свап в левую руку — кнопка `40`, `SlotActionType.SWAP`.

## 2. Архитектура клиента (Wyvern)
- **Менеджер модулей:** Ручная регистрация модулей в `wtf.wyvern.base.modules.ModuleManager.java` (вызовом `registerModule(Модуль.INSTANCE);`). Категории: `COMBAT`, `MOVEMENT`, `RENDER`, `PLAYER`, `MISC`.
- **Event Bus:** `com.darkmagician6.eventapi`. Аннотация `@EventTarget`. Синхронный вызов по строгому классу события.
- **Настройки:** Используется Reflection. Поля типа `ModeSetting`, `NumberSetting`, `BooleanSetting` автоматически регистрируются в GUI.
- **Жизненный цикл:** Модули обязаны вызывать `super.onEnable()` и `super.onDisable()` при переопределении, иначе ломается подписка на события и бинды.

## 3. Интегрированные обходы и модули (уже в коде)
- **TriggerBot:** 
  - *Fake Misses:* 10% шанс отправки только анимации (`HandSwingC2SPacket`) без пакета атаки (обход 100% accuracy).
  - *Strict Raycast:* Серверная симуляция видимости (raycastBlock) из глаз в центр хитбокса, игнор атак сквозь невидимые стены.
- **AutoTotem (Predictive):**
  - Не ждет урона. Сканирует `EndCrystalEntity` в радиусе 12 блоков. Если `currentHp - explosionDamage <= 2.0`, свапает тотем за 1 тик до взрыва пакетом `PICKUP` / `SWAP`.
- **TargetStrafe:**
  - Не трогает `player.setVelocity()`. Подменяет `forward/strafe` в `EventMoveInput`.
  - Зависит от `MovingUtil.fixMovementFocus(event, yaw)` для корректного перерасчета векторов WASD относительно цели, а не направления взгляда.
- **PearlPhase:**
  - *Anti-Suffocation:* Внутри блока (noclip) шлет пакеты `PositionAndOnGround` со сдвигом Y `+0.0001` (1E-4), чтобы сломать серверный вектор выталкивания.
- **HitboxDesync:**
  - *Micro:* Дрожит координатами ±0.03 в пакетах движения.
  - *MagicPitch:* Отправляет pitch = 180.0F на сервер, ломая чужие ESP и Aura raycasts.
- **FakeLag:**
  - Накапливает пакеты `PlayerMoveC2SPacket` и отменяет их отправку (`event.setCancelled(true)`).
  - Имеет Jitter (±8% разброс времени задержки) и хард-лимит в **40 пакетов**, чтобы сервер не кикнул за переполнение буфера.

## 4. Критические проблемы базы (Исправлено)
- **Discord IPC:** Крашил клиент на Android (FCL / PojavLauncher) из-за отсутствия x86/Win библиотек. Отключен в `DiscordManager.java`.
- **Рендер (VirGL/OpenGL ES):** Мобильные лаунчеры намертво крашились или лагали от FBO шейдеров (`KawaseBlurProgram`, `drawBlur`) и AWT буферов (`Render2DUtil.drawGradientBlurredShadow`). Шейдеры отключены, заменены на обычную заливку.
- **NotifyManager:** Оригинальный код Wyvern.java создавал пустой второй инстанс вместо использования оригинального. Поправлено на `getInstance()`.
- **Yarn Intermediary:** В 13 миксинах остались старые обфусцированные имена (field_... / method_...). *Требует дальнейшего рефакторинга.*

## 5. Правила работы Агента
1. **Никакого Python внутри bash.** Для редактирования использовать только `default_api:edit_file` или `write_file`.
2. **Проверка перед коммитом.** Перед пушем делать статический анализ зависимостей пакетов и проверку маппингов (например, через `grep` старых классов).
3. **Легитность пакетов.** Модули не должны отправлять невалидные параметры. Если модифицируется `PlayerMoveC2SPacket`, флаг `horizontalCollision` обязателен.
4. **Краткость.** Писать код без лишних комментариев, отвечать без воды. Токены экономить.