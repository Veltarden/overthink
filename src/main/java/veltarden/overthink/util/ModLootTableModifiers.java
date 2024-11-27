package veltarden.overthink.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import veltarden.overthink.item.ModItems;

public class ModLootTableModifiers {

    private static Identifier JUNGLE_TEMPLE_ID =
            Identifier.of("minecraft","chests/jungle_temple");
    private static Identifier DESERT_PYRAMID_ID =
            Identifier.of("minecraft","chests/desert_pyramid");
    private static Identifier SIMPLE_DUNGEON_ID =
            Identifier.of("minecraft", "chests/simple_dungeon");
    private static Identifier ANCIENT_CITY_ID =
            Identifier.of("minecraft", "chests/ancient_city");
    private static Identifier BURIED_TREASURE_ID =
            Identifier.of("minecraft", "chests/buried_treasure");
    private static Identifier WOODLAND_MANSION_ID =
            Identifier.of("minecraft", "chests/woodland_mansion");
    private static Identifier ABANDONED_MINESHAFT_ID =
            Identifier.of("minecraft", "chests/abandoned_mineshaft");

    //
// modifyLootTable(RegistryKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, RegistryWrapper.WrapperLookup registries)
    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((RegistryKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, RegistryWrapper.WrapperLookup registries) -> {
            if (LootTables.JUNGLE_TEMPLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.DESERT_PYRAMID_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.SIMPLE_DUNGEON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f)) // Drops 33% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.ANCIENT_CITY_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.BURIED_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops 33% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.WOODLAND_MANSION_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.ABANDONED_MINESHAFT_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 8.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f)) // Drops 90% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 8.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.BASTION_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.0f)) // Drops 90% of the time
                        .with(ItemEntry.builder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 0.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
