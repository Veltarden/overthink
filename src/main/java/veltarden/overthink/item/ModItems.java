package veltarden.overthink.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import veltarden.overthink.Overthink;

public class ModItems {
    //Que no se note el copia y pega ayyy



     //public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = registerItem("diamond_upgrade_smithing_template", new Item(new Item.Settings()));
     //public static final Item BROKEN_DIAMOND_UPGRADE = registerItem("broken_diamond_upgrade", new Item(new Item.Settings()));

    public static final Item LEATHER_COVER = registerItem("leather_cover", new Item(new Item.Settings()));
    public static final Item STRONG_TOOL_HANDLE = registerItem("strong_tool_handle", new Item(new Item.Settings()));
    public static final Item PILLOW = registerItem("pillow", new Item(new Item.Settings()));
    public static final Item STONE_SHARD = registerItem("stone_shard", new Item(new Item.Settings()));
    public static final Item DEAD_LEATHER = registerItem("dead_leather", new Item(new Item.Settings()));
    public static final Item NETHERITE_UPGRADE_SHARD = registerItem("netherite_upgrade_shard", new Item(new Item.Settings()));
    public static final Item SACRED_MANGO = registerItem("sacred_mango", new Item(new Item.Settings()));

    //ESTO DE ACA GENERA TEMPLATES, NO COPIAR Y PEGAR
    public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = registerItem("diamond_upgrade_smithing_template", ModSmithingTemplateItem.createDiamondUpgrade());
    //ESTO DE ACA GENERA TEMPLATES, NO COPIAR Y PEGAR

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(DIAMOND_UPGRADE_SMITHING_TEMPLATE);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Overthink.MOD_ID, name), item);
    }

    public static void registerModItems () {
        Overthink.LOGGER.info("metiendo items para: " + Overthink.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }

}
