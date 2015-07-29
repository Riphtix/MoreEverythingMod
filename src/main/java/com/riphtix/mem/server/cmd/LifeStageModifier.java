/*
 ** 2015 Juni 30
 **
 ** The author disclaims copyright to this source code. In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.riphtix.mem.server.cmd;

import com.riphtix.mem.server.entity.EntityTameableDragon;
import com.riphtix.mem.server.entity.helper.DragonLifeStage;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
class LifeStageModifier implements EntityModifier {
    
    private final DragonLifeStage lifeStage;

    LifeStageModifier(DragonLifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }

    @Override
    public void modify(EntityTameableDragon dragon) {
        if (lifeStage == null) {
            dragon.getLifeStageHelper().transformToEgg();
        } else {
            dragon.getLifeStageHelper().setLifeStage(lifeStage);
        }
    }
}
