package it.forgottenworld.enduvar.badminecraftnoleak.mixin.entity.ai.goal;

import net.minecraft.entity.ai.goal.CreeperSwellGoal;
import net.minecraft.entity.monster.CreeperEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperSwellGoal.class)
public abstract class CreeperSwellGoalMixin {

    @Shadow @Final private CreeperEntity swellingCreeper;

    @Inject(method = "resetTask", at = @At(value = "HEAD"))
    private void hasRaidersNearby(CallbackInfo ci) {
        this.swellingCreeper.setAttackTarget(null);
    }
}
