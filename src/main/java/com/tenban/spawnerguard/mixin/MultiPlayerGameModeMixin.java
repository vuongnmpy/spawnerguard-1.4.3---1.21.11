package com.tenban.spawnerguard.mixin;

import com.tenban.spawnerguard.SpawnerGuard;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {
	/** Khi mod dang dao spawner, khong cho game reset tien do dao moi tick. */
	@Inject(method = "stopDestroyBlock", at = @At("HEAD"), cancellable = true)
	private void sg$keepDigging(CallbackInfo ci) {
		if (SpawnerGuard.digging) ci.cancel();
	}
}
