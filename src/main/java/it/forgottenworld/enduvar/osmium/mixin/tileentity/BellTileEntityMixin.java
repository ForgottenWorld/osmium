package it.forgottenworld.enduvar.osmium.mixin.tileentity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.BellTileEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BellTileEntity.class)
public abstract class BellTileEntityMixin {

    @Shadow private List<LivingEntity> entitiesAtRing;

    @Shadow private boolean shouldReveal;

    @Inject(method = "tick",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/tileentity/BellTileEntity;isRinging:Z",
                    opcode = Opcodes.PUTFIELD
            ),
            allow = 1
    )
    private void onStopRinging(CallbackInfo ci) {
        if (!this.shouldReveal) {
            this.entitiesAtRing.clear();
        }
    }

    @Inject(method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/tileentity/BellTileEntity;addRaiderParticles(Lnet/minecraft/world/World;)V",
                    shift = At.Shift.AFTER
            )
    )
    private void onAddRaiderParticles(CallbackInfo ci) {
        this.entitiesAtRing.clear();
    }

    @Inject(method = "func_213941_c", at = @At(value = "RETURN"))
    private void onBlockEvent(CallbackInfo ci) {
        this.entitiesAtRing.removeIf(e -> !e.isAlive());
    }
}
