package net.mrdeadlydonut.magic8ball.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.mrdeadlydonut.magic8ball.Magic8Ball;


import java.util.function.Function;

public class ModItems {
    public static final Item MAGIC_8_BALL = registerItem("Magic_8_Ball", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Magic8Ball.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Magic8Ball.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Magic8Ball.LOGGER.info("Registering Mod Items for " + Magic8Ball.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(MAGIC_8_BALL);
        });
    }
}
