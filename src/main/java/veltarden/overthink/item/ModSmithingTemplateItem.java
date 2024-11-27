package veltarden.overthink.item;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {

    private static final Formatting TITLE_FORMATTING;
    private static final Formatting DESCRIPTION_FORMATTING;
    private static final Text DIAMOND_UPGRADE_TEXT;
    private static final Text DIAMOND_UPGRADE_APPLIES_TO_TEXT;
    private static final Text DIAMOND_UPGRADE_INGREDIENTS_TEXT;
    private static final Text DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE;
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE;
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE;
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE;
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE;

    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    public static SmithingTemplateItem createDiamondUpgrade() {
        return new SmithingTemplateItem(
                DIAMOND_UPGRADE_APPLIES_TO_TEXT,
                DIAMOND_UPGRADE_INGREDIENTS_TEXT,
                DIAMOND_UPGRADE_TEXT,
                DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
                DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                getDiamondUpgradeEmptyBaseSlotTextures(),
                getDiamondUpgradeEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getDiamondUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getDiamondUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_DIAMOND_TEXTURE);
    }

    static {
        TITLE_FORMATTING = Formatting.GRAY;
        DESCRIPTION_FORMATTING = Formatting.BLUE;

        EMPTY_SLOT_DIAMOND_TEXTURE = Identifier.of("item/empty_slot_diamond");

        DIAMOND_UPGRADE_TEXT = Text.translatable("item.overthink.diamond_upgrade_smithing_template.upgradeText").formatted(TITLE_FORMATTING);
        DIAMOND_UPGRADE_APPLIES_TO_TEXT  = Text.translatable("item.overthink.smithing_template.diamond_upgrade.applies_to").formatted(DESCRIPTION_FORMATTING);
        DIAMOND_UPGRADE_INGREDIENTS_TEXT =  Text.translatable("item.overthink.smithing_template.diamond_upgrade.ingredients").formatted(DESCRIPTION_FORMATTING);
        DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable("item.overthink.smithing_template.diamond_upgrade.base_slot_description");
        DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable("item.overthink.smithing_template.diamond_upgrade.additions_slot_description");
        EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.of("item/empty_armor_slot_helmet");
        EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.of("item/empty_armor_slot_chestplate");
        EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.of("item/empty_armor_slot_leggings");
        EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.of("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE_TEXTURE = Identifier.of("item/empty_slot_hoe");
        EMPTY_SLOT_AXE_TEXTURE = Identifier.of("item/empty_slot_axe");
        EMPTY_SLOT_SWORD_TEXTURE = Identifier.of("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.of("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.of("item/empty_slot_pickaxe");
        //bodrio tener que hacerlo, pero no tan bodrio fue hacerlo
    }

}
