package it.forgottenworld.enduvar.badminecraftnoleak.mixin.network.play;

import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.tileentity.SignTileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetHandler.class)
public abstract class ServerPlayNetHandlerMixin {

    @Redirect(
            method = "processUpdateSign",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/tileentity/SignTileEntity;markDirty()V")
    )
    private void onMarkDirty(SignTileEntity tileEntity) {
        tileEntity.markDirty();
        tileEntity.setPlayer(null);
    }
}
