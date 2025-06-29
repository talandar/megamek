/*
 * MegaMek - Copyright (C) 2004, 2005 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package megamek.common.weapons.capitalweapons;

import megamek.common.AmmoType;
import megamek.common.Game;
import megamek.common.Mounted;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.weapons.AmmoWeapon;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.ScreenLauncherHandler;
import megamek.server.totalwarfare.TWGameManager;

/**
 * @author Jay Lawson
 * @since Sep 25, 2004
 */
public class ScreenLauncherWeapon extends AmmoWeapon {
    private static final long serialVersionUID = 8756042527483383101L;

    public ScreenLauncherWeapon() {
        this.name = "Screen Launcher";
        this.setInternalName(this.name);
        this.addLookupName("ScreenLauncher");
        this.heat = 10;
        this.damage = 15;
        this.ammoType = AmmoType.AmmoTypeEnum.SCREEN_LAUNCHER;
        this.shortRange = 3;
        this.mediumRange = 6;
        this.longRange = 9;
        this.extremeRange = 12;
        this.tonnage = 40.0;
        this.bv = 160;
        this.cost = 250000;
        this.shortAV = 15;
        this.maxRange = RANGE_SHORT;
        this.capital = true;
        this.atClass = CLASS_SCREEN;
        rulesRefs = "237, TM";
        techAdvancement.setTechBase(TechBase.IS)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(TechRating.F)
                .setAvailability(AvailabilityValue.X, AvailabilityValue.X, AvailabilityValue.E, AvailabilityValue.D)
                .setISAdvancement(3053, 3055, 3057, DATE_NONE, DATE_NONE)
                .setISApproximate(false, false, false, false, false)
                .setPrototypeFactions(Faction.DC)
                .setProductionFactions(Faction.DC);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * megamek.common.weapons.Weapon#getCorrectHandler(megamek.common.ToHitData,
     * megamek.common.actions.WeaponAttackAction, megamek.common.Game,
     * megamek.server.Server)
     */
    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit, WeaponAttackAction waa, Game game,
            TWGameManager manager) {
        return new ScreenLauncherHandler(toHit, waa, game, manager);
    }

    @Override
    public double getBattleForceDamage(int range, Mounted<?> fcs) {
        return 0;
    }
}
