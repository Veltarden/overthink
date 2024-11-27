package veltarden.overthink.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //addDrop(ModBlocks.Ejemplo);
        //addDrop(ModBlocks.Ejemplo, copperLikeOreDrops(ModBlocks.Ejemplo, ModItems.NETHER_GEM));

    }

    /*
    public LootTable.Builder copperLikeOreDrops(Block drop) {
        return dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ItemEntry.builder(Items.RAW_COPPER)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(2.0F, 5.0F)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));

    }
     */
}