package stevekung.mods.moreplanets.utils.items.tools;

import micdoodle8.mods.galacticraft.api.item.GCRarity;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.core.MorePlanetsMod;
import stevekung.mods.moreplanets.integration.jei.MPJEIRecipes;
import stevekung.mods.moreplanets.utils.client.renderer.IItemModelRender;
import stevekung.mods.moreplanets.utils.items.EnumSortCategoryItem;
import stevekung.mods.moreplanets.utils.items.ISortableItem;
import stevekung.mods.stevekunglib.utils.enums.EnumToolSpeed;

public class ItemAxeMP extends ItemAxe implements ISortableItem, IItemModelRender, GCRarity
{
    private Item repairItem;
    private String name;

    public ItemAxeMP(String name, ToolMaterial material, Block block, EnumToolSpeed speed)
    {
        this(name, material, Item.getItemFromBlock(block), speed);
    }

    public ItemAxeMP(String name, ToolMaterial material, Item item, EnumToolSpeed speed)
    {
        super(material, material.getAttackDamage(), speed.getSpeed());
        this.repairItem = item;
        this.setTranslationKey(name);
        MPJEIRecipes.collectAnvilList(name, this, item);
    }

    @Override
    public Item setTranslationKey(String name)
    {
        this.name = name;
        return super.setTranslationKey(name);
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return MorePlanetsMod.ITEM_TAB;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        if (repair.getItem() == this.repairItem)
        {
            return true;
        }
        return false;
    }

    @Override
    public EnumSortCategoryItem getItemCategory()
    {
        return EnumSortCategoryItem.AXE;
    }

    @Override
    public String getName()
    {
        return this.name;
    }
}