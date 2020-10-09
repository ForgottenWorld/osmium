package it.forgottenworld.enduvar.badminecraftnoleak.mixin.entity.ai.goal;

import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RangedBowAttackGoal.class)
public abstract class RangedBowAttackGoalMixin<T extends MonsterEntity & IRangedAttackMob> extends GoalMixin {

    @Shadow @Final private T entity;

    @Inject(method = "resetTask", at = @At(value = "HEAD"))
    private void onResetTask(CallbackInfo ci) {
        this.entity.setAttackTarget(null);
    }
}
