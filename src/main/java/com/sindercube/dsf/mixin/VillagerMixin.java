package com.sindercube.dsf.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(VillagerEntity.class)
public abstract class VillagerMixin {

	@ModifyArg(
			method = "onInteractionWith(Lnet/minecraft/entity/EntityInteraction;Lnet/minecraft/entity/Entity;)V",
			index = 2,
			at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerGossips;startGossip(Ljava/util/UUID;Lnet/minecraft/village/VillageGossipType;I)V"),
			slice = @Slice(
					from = @At(value = "CONSTANT", args = "intValue=20"),
					to = @At(value = "CONSTANT", args = "intValue=25")
			)
	)
	private int majorReputation(int target) {
		return 0;
	}

	@ModifyArg(
			method = "onInteractionWith(Lnet/minecraft/entity/EntityInteraction;Lnet/minecraft/entity/Entity;)V",
			index = 2,
			at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerGossips;startGossip(Ljava/util/UUID;Lnet/minecraft/village/VillageGossipType;I)V"),
			slice = @Slice(
					from = @At(value = "CONSTANT", args = "intValue=25"),
					to = @At(value = "CONSTANT", args = "intValue=2")
			)
	)
	private int minorReputation(int target) {
		return 0;
	}

	/*

	private Boolean hasBeenCured = false;

	@Inject(
		method = "writeCustomDataToNbt(Lnet/minecraft/nbt/NbtCompound;)V",
		at = @At(value = "TAIL")
	)
	public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
		nbt.putBoolean("HasBeenCured", this.hasBeenCured);
	}

	@Inject(
		method = "readCustomDataFromNbt(Lnet/minecraft/nbt/NbtCompound;)V",
		at = @At(value = "TAIL")
	)
	public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
		if (nbt.contains("HasBeenCured")) {
			this.hasBeenCured = nbt.getBoolean("HasBeenCured");
		}
	}

	@Inject(
		method = "onInteractionWith(Lnet/minecraft/entity/EntityInteraction;Lnet/minecraft/entity/Entity;)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerGossips;startGossip(Ljava/util/UUID;Lnet/minecraft/village/VillageGossipType;I)V"),
		slice = @Slice(
			from = @At(value = "CONSTANT", args = "intValue=20"),
			to = @At(value = "CONSTANT", args = "intValue=25")
		)
	)
	public void onInteractionWith(EntityInteraction interaction, Entity entity, CallbackInfo ci) {
		if (this.hasBeenCured == true) {
			return;
		} else {
			this.hasBeenCured = true;
		}
	}

	*/

}
