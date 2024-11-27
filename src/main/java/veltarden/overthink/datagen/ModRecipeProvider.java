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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import veltarden.overthink.Overthink;
import veltarden.overthink.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static List<ItemConvertible> rottenFleshSmeltable = List.of(Items.ROTTEN_FLESH);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
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
                .input('C', Items.IRON_BLOCK)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, Identifier.of(Overthink.MOD_ID, getRecipeName(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', ModItems.NETHERITE_UPGRADE_SHARD)
                .input('B', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(ModItems.NETHERITE_UPGRADE_SHARD), conditionsFromItem(ModItems.NETHERITE_UPGRADE_SHARD))
                .offerTo(exporter, Identifier.of("netherite_upgrade_smithing_template_from_pieces"));

        //alt:
        //.offerTo(exporter, Identifier.of("portal_caster_from_gem"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEATHER_COVER, 1)
                .pattern(" B ")
                .pattern("BAB")
                .pattern(" B ")
                .input('A', ModItems.DEAD_LEATHER)
                .input('B', Items.STRING)
                .criterion(hasItem(ModItems.DEAD_LEATHER), conditionsFromItem(ModItems.DEAD_LEATHER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, Identifier.of(Overthink.MOD_ID, getRecipeName(ModItems.LEATHER_COVER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STONE_SHARD, 2)
                .pattern("BAB")
                .input('A', Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS))
                .input('B', Items.FLINT)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter, Identifier.of(Overthink.MOD_ID, getRecipeName(ModItems.STONE_SHARD)));

        //thanks to .luviana on symphony discord for this pillow recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PILLOW, 1)
                .pattern("AAA")
                .pattern("BBB")
                .pattern("AAA")
                .input('A', ModItems.DEAD_LEATHER)
                .input('B', Items.PHANTOM_MEMBRANE)
                .criterion(hasItem(ModItems.DEAD_LEATHER), conditionsFromItem(ModItems.DEAD_LEATHER))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, Identifier.of(Overthink.MOD_ID, getRecipeName(ModItems.PILLOW)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STRONG_TOOL_HANDLE, 1)
                .pattern("  B")
                .pattern(" A ")
                .pattern("B  ")
                .input('A', Items.HONEYCOMB)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(Overthink.MOD_ID, getRecipeName(ModItems.STRONG_TOOL_HANDLE)));


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
                .offerTo(exporter, Identifier.of(getRecipeName(Items.WHITE_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RED_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.RED_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.RED_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLUE_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.BLUE_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.BLUE_BED)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.YELLOW_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.YELLOW_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GREEN_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.GREEN_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.GREEN_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BLACK_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.BLACK_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.BLACK_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LIGHT_BLUE_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.LIGHT_BLUE_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.LIGHT_BLUE_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BROWN_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.BROWN_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.BROWN_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CYAN_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.CYAN_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.CYAN_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LIGHT_GRAY_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.LIGHT_GRAY_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.LIGHT_GRAY_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LIME_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.LIME_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.LIME_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ORANGE_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.ORANGE_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.ORANGE_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.MAGENTA_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.MAGENTA_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PINK_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.PINK_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.PINK_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_BED, 1)
                .pattern("CAA")
                .pattern("BBB")
                .input('A', Items.PURPLE_WOOL)
                .input('B', Ingredient.fromTag(ItemTags.PLANKS))
                .input('C', ModItems.PILLOW)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(ModItems.PILLOW), conditionsFromItem(ModItems.PILLOW))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.PURPLE_BED)));

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
                .offerTo(exporter, Identifier.of(getRecipeName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_CHESTPLATE, 1)
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_BOOTS, 1)
                .pattern("B B")
                .pattern("A A")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_LEGGINGS, 1)
                .pattern("ABA")
                .pattern("A A")
                .pattern("A A")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_HELMET, 1)
                .pattern("AAA")
                .pattern("ABA")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.LEATHER_COVER)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.LEATHER_COVER), conditionsFromItem(ModItems.LEATHER_COVER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_HELMET)));

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
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.IRON_SWORD, 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ") //???
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_HOE, 1)
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.IRON_INGOT)
                .input('B', ModItems.STRONG_TOOL_HANDLE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.STRONG_TOOL_HANDLE), conditionsFromItem(ModItems.STRONG_TOOL_HANDLE))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.IRON_HOE)));


        //stone tools and arrow

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.STONE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_AXE, 1)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.STONE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.STONE_SWORD, 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.STONE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.STONE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_HOE, 1)
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.STONE_HOE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ARROW, 4)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .input('A', ModItems.STONE_SHARD)
                .input('B', Items.STICK)
                .input('C', Items.FEATHER)
                .criterion(hasItem(ModItems.STONE_SHARD), conditionsFromItem(ModItems.STONE_SHARD))
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.ARROW)));

        //Diamond removal

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_AXE, 1)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL, 1)
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_SWORD, 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_HOE, 1)
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', Items.BARRIER)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_HELMET, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_CHESTPLATE, 1)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_LEGGINGS, 1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.DIAMOND_BOOTS, 1)
                .pattern("A A")
                .pattern("A A")
                .pattern("   ")
                .input('A', Items.BARRIER)
                .criterion(hasItem(Items.BARRIER), conditionsFromItem(Items.BARRIER))
                .offerTo(exporter, Identifier.of(getRecipeName(Items.DIAMOND_BOOTS)));


        //Addition of diamond trough smithing


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_CHESTPLATE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_CHESTPLATE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_chestplate_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HELMET),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_HELMET)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_helmet_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_LEGGINGS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_LEGGINGS)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_leggings_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_BOOTS),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_BOOTS)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_boots_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_PICKAXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_PICKAXE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_pickaxe_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_AXE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_AXE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_axe_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_SWORD),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_SWORD)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_sword_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HOE),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_HOE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_hoe_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_SHOVEL),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_SHOVEL)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_shovel_from_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.IRON_HORSE_ARMOR),
                        Ingredient.ofItems(Items.DIAMOND),
                        RecipeCategory.MISC,
                        Items.DIAMOND_HORSE_ARMOR)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(exporter, Identifier.of("diamond_horse_armor_from_upgrade"));
    }


    @Override //thanks to supersaiyansubtlety on fabric discord for providing a way to replace iron and diamond recipes
    protected Identifier getRecipeIdentifier(Identifier id) {
        return id;
    }

}
