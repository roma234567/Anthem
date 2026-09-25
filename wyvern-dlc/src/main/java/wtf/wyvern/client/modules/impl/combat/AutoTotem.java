package wtf.wyvern.client.modules.impl.combat;

import com.darkmagician6.eventapi.EventTarget;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;
import wtf.wyvern.base.events.impl.other.EventTick;
import wtf.wyvern.client.modules.api.Category;
import wtf.wyvern.client.modules.api.Module;
import wtf.wyvern.client.modules.api.ModuleAnnotation;
import wtf.wyvern.client.modules.api.setting.impl.BooleanSetting;
import wtf.wyvern.client.modules.api.setting.impl.NumberSetting;
import wtf.wyvern.utility.game.combat.CrystalDamageCalculator;
import wtf.wyvern.utility.game.other.InventoryUtil;

import java.util.Comparator;
import java.util.List;

@ModuleAnnotation(name = "AutoTotem", category = Category.COMBAT, description = "Предиктивно берет тотем в левую руку при риске ваншота")
public class AutoTotem extends Module {
    public static final AutoTotem INSTANCE = new AutoTotem();

    private final NumberSetting healthThreshold = new NumberSetting("Health Threshold", 10.0f, 1.0f, 20.0f, 0.5f);
    private final BooleanSetting predictCrystals = new BooleanSetting("Predict Crystals", true);
    
    public AutoTotem() {}

    @EventTarget
    public void onTick(EventTick event) {
        if (mc.player == null || mc.currentScreen != null) return;

        boolean needTotem = mc.player.getHealth() + mc.player.getAbsorptionAmount() <= healthThreshold.getCurrent();

        if (!needTotem && predictCrystals.isEnabled()) {
            needTotem = checkLethalCrystals();
        }

        if (needTotem && mc.player.getOffHandStack().getItem() != Items.TOTEM_OF_UNDYING && mc.player.getMainHandStack().getItem() != Items.TOTEM_OF_UNDYING) {
            int totemSlot = InventoryUtil.findItem(Items.TOTEM_OF_UNDYING);
            if (totemSlot != -1) {
                // Легитный свап: клик по слоту, затем клик по оффхэнду (слот 45)
                mc.interactionManager.clickSlot(mc.player.playerScreenHandler.syncId, totemSlot, 0, SlotActionType.PICKUP, mc.player);
                mc.interactionManager.clickSlot(mc.player.playerScreenHandler.syncId, 45, 0, SlotActionType.PICKUP, mc.player);
                // Если в оффхэнде что-то было, вернем это в инвентарь
                mc.interactionManager.clickSlot(mc.player.playerScreenHandler.syncId, totemSlot, 0, SlotActionType.PICKUP, mc.player);
            }
        }
    }

    private boolean checkLethalCrystals() {
        if (mc.world == null) return false;
        List<EndCrystalEntity> crystals = mc.world.getEntitiesByClass(EndCrystalEntity.class, mc.player.getBoundingBox().expand(12.0), entity -> true);
        if (crystals.isEmpty()) return false;

        float currentHp = mc.player.getHealth() + mc.player.getAbsorptionAmount();

        EndCrystalEntity dangerous = crystals.stream().max(Comparator.comparingDouble(c -> CrystalDamageCalculator.calculateDamage(c.getPos(), mc.player, mc.world))).orElse(null);
        if (dangerous != null) {
            double damage = CrystalDamageCalculator.calculateDamage(dangerous.getPos(), mc.player, mc.world);
            return (currentHp - damage) <= 2.0; // Берем тотем, если после взрыва останется меньше 1 сердечка
        }
        return false;
    }
}
