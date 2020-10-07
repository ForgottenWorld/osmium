package it.forgottenworld.enduvar.badminecraftnoleak.mixin.entity.ai.goal;

import net.minecraft.entity.ai.goal.TargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TargetGoal.class)
public abstract class TargetGoalMixin {

    @Shadow public void resetTask() { throw new IllegalStateException("unreachable"); }

}
