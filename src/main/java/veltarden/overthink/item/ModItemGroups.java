package veltarden.overthink.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import veltarden.overthink.Overthink;

public class ModItemGroups {

    public static final ItemGroup OVERTHINK_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Overthink.MOD_ID, "nether_gem"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.overthink"))
                    .icon(() -> new ItemStack(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.LEATHER_COVER);
                        entries.add(ModItems.STRONG_TOOL_HANDLE);
                        entries.add(ModItems.PILLOW);
                        entries.add(ModItems.STONE_SHARD);
                        entries.add(ModItems.DEAD_LEATHER);
                        entries.add(ModItems.NETHERITE_UPGRADE_SHARD);
                    }).build());
    public static void registerModItemGroups () {
        Overthink.LOGGER.info("metiendo grupos de items para: " + Overthink.MOD_ID);
    }
}
