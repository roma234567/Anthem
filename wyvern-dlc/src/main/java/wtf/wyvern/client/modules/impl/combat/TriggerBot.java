package wtf.wyvern.client.modules.impl.combat;

import com.darkmagician6.eventapi.EventTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import wtf.wyvern.base.events.impl.other.EventTick;
import wtf.wyvern.client.modules.api.Category;
import wtf.wyvern.client.modules.api.Module;
import wtf.wyvern.client.modules.api.ModuleAnnotation;
import wtf.wyvern.client.modules.api.setting.impl.BooleanSetting;
import wtf.wyvern.client.modules.api.setting.impl.ModeSetting;
import wtf.wyvern.client.modules.api.setting.impl.NumberSetting;
import wtf.wyvern.base.player.AttackUtil;
import wtf.wyvern.utility.game.player.RaytracingUtil;
import wtf.wyvern.utility.game.player.rotation.RotationUtil;
import wtf.wyvern.utility.math.Timer;

import java.util.Random;

@ModuleAnnotation(name = "TriggerBot", category = Category.COMBAT, description = "Автоматически бьет, когда вы смотрите на сущность")
public class TriggerBot extends Module {
    public static final TriggerBot INSTANCE = new TriggerBot();

    private final ModeSetting mode = new ModeSetting("Mode", "Default", "Custom");
    
    private final NumberSetting minCooldown = new NumberSetting("Min Cooldown", 0.95f, 0.5f, 1.0f, 0.01f);
    private final NumberSetting maxCooldown = new NumberSetting("Max Cooldown", 1.0f, 0.5f, 1.2f, 0.01f);
    
    private final NumberSetting minDelay = new NumberSetting("Min Delay (ms)", 50f, 0f, 300f, 5f);
    private final NumberSetting maxDelay = new NumberSetting("Max Delay (ms)", 150f, 0f, 300f, 5f);

    private final BooleanSetting fakeMisses = new BooleanSetting("Fake Misses", true);
    private final BooleanSetting strictRaycast = new BooleanSetting("Strict Raycast", true);
    
    private final Timer delayTimer = new Timer();
    private final Random random = new Random();
    
    private long currentDelay = 0;
    private float currentCooldownTarget = 1.0f;
    private Entity targetEntity = null;

    public TriggerBot() {
        setRandomTargets();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        setRandomTargets();
    }

    @EventTarget
    public void onTick(EventTick event) {
        if (mc.player == null || mc.world == null || mc.currentScreen != null) return;
        if (mc.player.isUsingItem()) return;

        Entity entity = getTarget();

        if (entity != null && entity instanceof LivingEntity) {
            if (targetEntity != entity) {
                targetEntity = entity;
                setRandomTargets();
                delayTimer.reset();
            }

            if (mode.is("Custom") && !delayTimer.finished(currentDelay)) {
                return;
            }

            float progress = mc.player.getAttackCooldownProgress(0.5f);
            
            boolean ready = mode.is("Default") ? (progress >= 1.0f) : (progress >= currentCooldownTarget);
            
            if (ready) {
                if (strictRaycast.isEnabled() && !isStrictlyVisible(entity)) {
                    return;
                }
                
                if (fakeMisses.isEnabled() && random.nextInt(10) == 0) { // 10% chance to miss
                    mc.getNetworkHandler().sendPacket(new HandSwingC2SPacket(Hand.MAIN_HAND));
                    mc.player.swingHand(Hand.MAIN_HAND);
                } else {
                    AttackUtil.attackEntity(entity);
                }
                
                setRandomTargets();
                delayTimer.reset();
                targetEntity = null; // reset for next attack
            }
        } else {
            targetEntity = null;
        }
    }

    private Entity getTarget() {
        HitResult hit = mc.crosshairTarget;
        if (hit != null && hit.getType() == HitResult.Type.ENTITY) {
            return ((EntityHitResult) hit).getEntity();
        }
        return null;
    }

    private void setRandomTargets() {
        if (minDelay.getCurrent() >= maxDelay.getCurrent()) {
            currentDelay = (long) minDelay.getCurrent();
        } else {
            currentDelay = (long) (minDelay.getCurrent() + random.nextFloat() * (maxDelay.getCurrent() - minDelay.getCurrent()));
        }
        
        if (minCooldown.getCurrent() >= maxCooldown.getCurrent()) {
            currentCooldownTarget = minCooldown.getCurrent();
        } else {
            currentCooldownTarget = minCooldown.getCurrent() + random.nextFloat() * (maxCooldown.getCurrent() - minCooldown.getCurrent());
        }
    }
    
    private boolean isStrictlyVisible(Entity entity) {
        if (mc.player == null || mc.world == null) return false;
        Vec3d eyePos = mc.player.getEyePos();
        Vec3d targetPos = entity.getBoundingBox().getCenter();
        net.minecraft.world.RaycastContext context = new net.minecraft.world.RaycastContext(
                eyePos, targetPos, 
                net.minecraft.world.RaycastContext.ShapeType.COLLIDER, 
                net.minecraft.world.RaycastContext.FluidHandling.NONE, 
                mc.player
        );
        net.minecraft.util.hit.BlockHitResult result = mc.world.raycast(context);
        return result.getType() == net.minecraft.util.hit.HitResult.Type.MISS;
    }
}
