package it.forgottenworld.enduvar.osmium.mixin.entity.ai.goal;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RangedAttackGoal.class)
public abstract class RangedAttackGoalMixin extends GoalMixin {

    @Shadow @Final private MobEntity entityHost;

    @Inject(method = "resetTask", at = @At(value = "HEAD"))
    private void onResetTask(CallbackInfo ci) {
        this.entityHost.setAttackTarget(null);
    }
}
