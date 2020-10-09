package it.forgottenworld.enduvar.osmium.mixin.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LeapAtTargetGoal.class)
public abstract class LeapAtTargetGoalMixin extends GoalMixin {

    @Shadow private LivingEntity leapTarget;

    @Override
    public void resetTask() {
        super.resetTask();
        this.leapTarget = null;
    }
}
