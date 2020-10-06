package it.forgottenworld.enduvar.badminecraftnoleak;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("badminecraftnoleak")
public class BadMinecraftNoLeak {

    private static final Logger LOGGER = LogManager.getLogger();

    public BadMinecraftNoLeak() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("Enduvar lives");
    }
}
