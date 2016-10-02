package de.robindev.easymcapi.builder.item;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.robindev.easymcapi.Main;
import de.robindev.easymcapi.builder.Builder;

/**
 * @author RobinDEV (16.09.2016, 21:40:01)
 */
public class ItemBuilder implements Builder<ItemStack> {

	private ItemStack item;
	private ItemMeta meta;
	
	private ItemBuilder() {
	}
	
	public ItemBuilder(Material mat) {
		item = new ItemStack(mat);
		meta = item.getItemMeta();
	}

	public ItemBuilder(Material mat, int amount) {
		item = new ItemStack(mat, amount);
		meta = item.getItemMeta();
	}

	public ItemBuilder(Material mat, int amount, byte data) {
		item = new ItemStack(mat, amount, data);
		meta = item.getItemMeta();
	}
	
	public static ItemBuilder fromBukkitItemStack(ItemStack item) {
		ItemBuilder builder = new ItemBuilder();
		builder.item = item;
		builder.meta = item.getItemMeta();
		return builder;
	}

	public ItemBuilder setDisplayName(String displayName) {
		meta.setDisplayName(displayName);
		return this;
	}

	public ItemBuilder addAllItemFlags() {
		meta.addItemFlags(ItemFlag.values());
		return this;
	}

	public ItemBuilder removeAllItemFlags() {
		meta.removeItemFlags(ItemFlag.values());
		return this;
	}

	public ItemBuilder addItemFlags(ItemFlag... flags) {
		meta.addItemFlags(flags);
		return this;
	}

	public ItemBuilder removeItemFlags(ItemFlag... flags) {
		meta.removeItemFlags(flags);
		return this;
	}

	public ItemBuilder setColor(Color color) {
		((LeatherArmorMeta) meta).setColor(color);
		return this;
	}

	public ItemBuilder setAuthor(String author) {
		((BookMeta) meta).setAuthor(author);
		return this;
	}

	public ItemBuilder setTitle(String title) {
		((BookMeta) meta).setTitle(title);
		return this;
	}

	public ItemBuilder setPages(String... pages) {
		((BookMeta) meta).setPages(Arrays.asList(pages));
		return this;
	}

	public ItemBuilder addPages(String... pages) {
		((BookMeta) meta).addPage(pages);
		return this;
	}

	public ItemBuilder addEffect(PotionEffect effect) {
		((PotionMeta) meta).addCustomEffect(effect, true);
		return this;
	}
	
	public ItemBuilder removeEffect(PotionEffectType effect) {
		((PotionMeta) meta).removeCustomEffect(effect);
		return this;
	}
	
	public ItemBuilder setOwner(String owner) {
		((SkullMeta) meta).setOwner(owner);
		return this;
	}
	
	public ItemBuilder addEnchantent(Enchantment ench, int level) {
		meta.addEnchant(ench, level, true);
		return this;
	}
	
	public ItemBuilder setDurability(short durability) {
		item.setDurability(durability);
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		meta.setLore(Arrays.asList(lore));
		return this;
	}
	
	public ItemBuilder setClickListener(ClickListener listener) {
		Main.CLICK_LISTENERS.put(build(), listener);
		return this;
	}

	@Override
	public ItemStack build() {
		item.setItemMeta(meta);
		return item;
	}
}
