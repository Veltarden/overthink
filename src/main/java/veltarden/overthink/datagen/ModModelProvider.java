package veltarden.overthink.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import veltarden.overthink.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Ejemplo);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEATHER_COVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRONG_TOOL_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PILLOW, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEAD_LEATHER, Models.GENERATED);
    }

}

