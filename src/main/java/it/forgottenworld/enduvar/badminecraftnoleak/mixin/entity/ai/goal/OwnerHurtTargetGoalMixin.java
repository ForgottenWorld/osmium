package it.forgottenworld.enduvar.badminecraftnoleak.mixin.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(OwnerHurtTargetGoal.class)
public abstract class OwnerHurtTargetGoalMixin extends TargetGoalMixin {

    @Shadow private LivingEntity attacker;

    @Override
    public void resetTask() {
        super.resetTask();
        this.attacker = null;
    }
}
