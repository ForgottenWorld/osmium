package it.forgottenworld.enduvar.osmium.mixin.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NearestAttackableTargetGoal.class)
public abstract class NearestAttackableTargetGoalMixin extends TargetGoalMixin {

    @Shadow protected LivingEntity nearestTarget;

    @Override
    public void resetTask() {
        super.resetTask();
        this.nearestTarget = null;
    }
}
