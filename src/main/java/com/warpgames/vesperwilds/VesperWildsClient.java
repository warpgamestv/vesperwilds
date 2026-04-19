package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.particle.VelvetFallingLeafParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;

public class VesperWildsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(ModParticles.VELVET_FALLING_LEAF,
                VelvetFallingLeafParticle.Provider::new);

        net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.registerGlobalReceiver(
                com.warpgames.vesperwilds.network.packet.VelvetEclipseSyncS2CPacket.ID,
                (payload, context) -> {
                    context.client().execute(() -> {
                        com.warpgames.vesperwilds.event.VelvetEclipseClientManager.setEclipseActive(payload.active());
                    });
                });

        net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.DISCONNECT
                .register((handler, client) -> {
                    com.warpgames.vesperwilds.event.VelvetEclipseClientManager.setEclipseActive(false);
                });
    }
}