package it.forgottenworld.enduvar.osmium.mixin.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.DefendVillageTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DefendVillageTargetGoal.class)
public abstract class DefendVillageTargetGoalMixin extends TargetGoalMixin {

    @Shadow private LivingEntity villageAgressorTarget;

    @Override
    public void resetTask() {
        super.resetTask();
        this.villageAgressorTarget = null;
    }
}
