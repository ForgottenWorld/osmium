package it.forgottenworld.enduvar.badminecraftnoleak.mixin.entity.ai.goal;

import net.minecraft.entity.ai.goal.Goal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Goal.class)
public abstract class GoalMixin {

    @Shadow public void resetTask() { throw new IllegalStateException("unreachable"); }

}
