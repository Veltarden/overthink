package veltarden.overthink.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import veltarden.overthink.Overthink;
import veltarden.overthink.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static List<ItemConvertible> rottenFleshSmeltable = List.of(Items.ROTTEN_FLESH);


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(exporter, rottenFleshSmeltable, RecipeCategory.MISC, ModItems.DEAD_LEATHER, 0.1f, 200, "nethergem");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("DAD")
                .pattern("BCB")
                .pattern("DBD")
                .input('A', ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE)
                .input('B', Items.IRON_INGOT)
                .input('C', Items.DEEPSLATE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(Overthink.MOD_ID, getRecipeName(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE)));
                //alt:
                //.offerTo(exporter, new Identifier("portal_caster_from_gem"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEATHER_COVER, 1)
                .pattern(" B ")
                .pattern("BAB")
                .pattern(" B ")
                .input('A', ModItems.DEAD_LEATHER)
                .input('B', Items.STRING)
                .criterion(hasItem(ModItems.DEAD_LEATHER), conditionsFromItem(ModItems.DEAD_LEATHER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(Overthink.MOD_ID, getRecipeName(ModItems.LEATHER_COVER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STONE_SHARD, 2)
                .pattern("BAB")
                .input('A', Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS))
                .input('B', Items.FLINT)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter, new Identifier(Overthink.MOD_ID, getRecipeName(ModItems.STONE_SHARD)));

        //thanks to .luviana on symphony discord for this pillow recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PILLOW, 1)
                .pattern("AAA")
                .pattern("BBB")
                .pattern("AAA")
                .input('A', ModItems.DEAD_LEATHER)
                .input('B', Items.PHANTOM_MEMBRANE)
                .criterion(hasItem(ModItems.DEAD_LEATHER), conditionsFromItem(ModItems.DEAD_LEATHER))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, new Identifier(Overthink.MOD_ID, getRecipeName(ModItems.PILLOW)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STRONG_TOOL_HANDLE, 1)
                .pattern("  B")
                .pattern(" A ")
                .pattern("B  ")
                .input('A', Items.HONEYCOMB)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(Overthink.MOD_ID, getRecipeName(ModItems.STRONG_TOOL_HANDLE)));


        //bed changes

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.WHITE_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, new Identifier(getRecipeName(Items.WHITE_BED)));


        //changes to armor and gear

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("DAD")
                .pattern("BCB")
                .pattern("DBD")
                .input('A', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .input('B', Items.DIAMOND)
                .input('C', Items.NETHERRACK)
                .input('D', Items.NETHERITE_SCRAP)
                .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_CHESTPLATE, 1)
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_BOOTS, 1)
                .pattern("B B")
                .pattern("A A")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_LEGGINGS, 1)
                .pattern("ABA")
                .pattern("A A")
                .pattern("A A")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_HELMET, 1)
                .pattern("AAA")
                .pattern("ABA")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_HELMET)));

        //tools
        //recomendacion: hacer los stronger sticks/ tool handle

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_AXE, 1)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_SWORD, 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ") //???
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_HOE, 1)
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.IRON_HOE)));


        //stone tools and arrow

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_AXE, 1)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.STONE_SWORD, 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_HOE, 1)
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STONE_HOE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ARROW, 4)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .input('C', Items.FEATHER)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.ARROW)));

        //Diamond removal

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_AXE, 1)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_SWORD, 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_HOE, 1)
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_HELMET, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_CHESTPLATE, 1)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_LEGGINGS, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_BOOTS, 1)
                .pattern("A A")
                .pattern("A A")
                .pattern("   ")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DIAMOND_BOOTS)));


        //Addition of diamond trough smithing


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.IRON_CHESTPLATE),
                Ingredient.ofItems(Items.DIAMOND),
                RecipeCategory.MISC,
                Items.DIAMOND_CHESTPLATE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_chestplate_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HELMET),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_HELMET)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_helmet_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_LEGGINGS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_LEGGINGS)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_leggings_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_BOOTS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_BOOTS)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_boots_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.IRON_PICKAXE),
                Ingredient.ofItems(Items.DIAMOND),
                RecipeCategory.MISC,
                Items.DIAMOND_PICKAXE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_pickaxe_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_AXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_AXE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_axe_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_SWORD),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_SWORD)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_sword_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HOE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_HOE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_hoe_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_SHOVEL),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_SHOVEL)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_shovel_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HORSE_ARMOR),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_HORSE_ARMOR)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, new Identifier("diamond_horse_armor_from_upgrade"));
    }


    @Override //thanks to supersaiyansubtlety on fabric discord for providing a way to replace iron and diamond recipes
    protected Identifier getRecipeIdentifier(Identifier id) {
        return id;
    }

}
