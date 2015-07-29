/*
 ** 2013 October 24
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.riphtix.mem.server.entity.breeds;

import com.riphtix.mem.server.entity.EntityTameableDragon;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.BiomeGenBase;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonBreedFire extends DragonBreed {

    public DragonBreedFire() {
        super("fire", "fire", 0x960b0f);
        
        addImmunity(DamageSource.inFire);
        addImmunity(DamageSource.onFire);
        addImmunity(DamageSource.lava);
        
        addHabitatBlock(Blocks.lava);
        addHabitatBlock(Blocks.flowing_lava);
        addHabitatBlock(Blocks.fire);
        addHabitatBlock(Blocks.lit_furnace);
        
        addHabitatBiome(BiomeGenBase.desert);
        addHabitatBiome(BiomeGenBase.desertHills);
    }

    @Override
    public void onEnable(EntityTameableDragon dragon) {
      dragon.setDragonAvoidWater(true);
    }

    @Override
    public void onDisable(EntityTameableDragon dragon) {
      dragon.setDragonAvoidWater(false);
    }
}
