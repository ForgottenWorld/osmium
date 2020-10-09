package it.forgottenworld.enduvar.osmium.mixin.entity.ai.goal;

import net.minecraft.entity.ai.goal.LandOnOwnersShoulderGoal;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LandOnOwnersShoulderGoal.class)
public abstract class LandOnOwnersShoulderGoalMixin extends GoalMixin {

    @Shadow private ServerPlayerEntity owner;

    @Override
    public void resetTask() {
        super.resetTask();
        this.owner = null;
    }
}
