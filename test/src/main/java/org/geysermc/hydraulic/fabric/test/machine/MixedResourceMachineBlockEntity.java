package org.geysermc.hydraulic.fabric.test.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.geysermc.hydraulic.compat.ir.CompiledCompatibilityPlan;
import org.geysermc.hydraulic.compat.runtime.MachineBridgeFactory;
import org.geysermc.hydraulic.compat.runtime.MixedResourceMachineProcessingBridge;
import org.geysermc.hydraulic.compat.runtime.TransferBridgeFactory;
import org.geysermc.hydraulic.fabric.test.ModBlockEntities;
import org.jetbrains.annotations.NotNull;

public final class MixedResourceMachineBlockEntity extends ReflectiveResourceStorageBlockEntity {
    private MixedResourceMachineProcessingBridge processing;

    public MixedResourceMachineBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModBlockEntities.MIXED_RESOURCE_MACHINE, pos, state, 2);
    }

    public MixedResourceMachineProcessingBridge processing(@NotNull CompiledCompatibilityPlan plan) {
        if (this.processing == null || this.processing.plan() != plan) {
            TransferBridgeFactory.ItemTransferBridge items = TransferBridgeFactory.createItemTransfer(plan, this);
            TransferBridgeFactory.FluidTransferBridge fluids = TransferBridgeFactory.createFluidTransfer(plan, this);
            TransferBridgeFactory.EnergyTransferBridge energy = TransferBridgeFactory.createEnergyTransfer(plan, this);
            this.processing = MachineBridgeFactory.createMixedProcessing(plan, items, fluids, energy);
        }
        return this.processing;
    }
}