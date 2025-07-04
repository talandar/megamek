/**
 * MegaMek - Copyright (C) 2005 Ben Mazur (bmazur@sev.org)
 *
 *  This program is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the Free
 *  Software Foundation; either version 2 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 *  for more details.
 */
package megamek.common.weapons.bombs;

import megamek.common.AmmoType;
import megamek.common.BombType;
import megamek.common.BombType.BombTypeEnum;
import megamek.common.weapons.missiles.ThunderBoltWeapon;

/**
 * @author Jay Lawson
 * @author Dave Nawton
 */
public class CLLAAMissileWeapon extends ThunderBoltWeapon {

    /**
     *
     */
    private static final long serialVersionUID = 6262048986109960442L;

    public CLLAAMissileWeapon() {
        super();

        this.name = "Light Air-to-Air (LAA) Missiles";
        this.setInternalName(BombTypeEnum.LAA.getWeaponName());
        this.heat = 0;
        this.damage = 6;
        this.rackSize = 1;
        this.shortRange = 6;
        this.mediumRange = 12;
        this.longRange = 24;
        this.extremeRange = 40;
        this.tonnage = 0.5;
        this.criticals = 0;
        this.hittable = false;
        this.bv = 0;
        this.cost = 6000;
        this.flags = flags.or(F_MISSILE).or(F_LARGEMISSILE).or(F_BOMB_WEAPON).andNot(F_MEK_WEAPON).andNot(F_TANK_WEAPON);
        this.shortAV = 6;
        this.medAV = 6;
        this.maxRange = RANGE_MED;
        this.ammoType = AmmoType.AmmoTypeEnum.LAA_MISSILE;
        this.capital = false;
        this.missileArmor = 6;
        rulesRefs = "359, TO";
        techAdvancement.setTechBase(TechBase.CLAN)
    	.setIntroLevel(false)
    	.setUnofficial(false)
        .setTechRating(TechRating.E)
        .setAvailability(AvailabilityValue.X, AvailabilityValue.X, AvailabilityValue.F, AvailabilityValue.D)
        .setClanAdvancement(DATE_NONE, DATE_NONE, 3074, DATE_NONE, DATE_NONE)
        .setClanApproximate(false, false, false, false, false);
    }
}
