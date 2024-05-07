package name.magmabucket;

import name.magmabucket.item.ItemMagmaBucket;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagmaBucket implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("magma-bucket");

	public static final Item MAGMA_BUCKET = Registry.register(Registries.ITEM, new Identifier("magma-bucket", "magma_bucket"),
			new ItemMagmaBucket(Fluids.EMPTY, new Item.Settings().rarity(Rarity.RARE)));
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.addAfter(Items.LAVA_BUCKET, MAGMA_BUCKET);
		});
	}
}