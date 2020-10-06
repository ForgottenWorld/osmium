package it.forgottenworld.enduvar.badminecraftnoleak.mixin.tileentity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.BellTileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BellTileEntity.class)
public abstract class BellTileEntityMixin {

    @Shadow private List<LivingEntity> entitiesAtRing;

    @Inject(method = "hasRaidersNearby", at = @At(value = "HEAD"))
    private void hasRaidersNearby(CallbackInfoReturnable<Boolean> ci) {
        this.entitiesAtRing.removeIf(e -> !e.isAlive());
    }
}
