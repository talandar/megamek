/*
 * MegaMek - Copyright (C) 2004, 2005 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package megamek.common.weapons.flamers;

import megamek.common.AmmoType;
import megamek.common.SimpleTechLevel;
import megamek.common.WeaponType;
import megamek.common.alphaStrike.AlphaStrikeElement;

/**
 * @author Andrew Hunter
 * @since Sep 24, 2004
 */
public class ISHeavyFlamer extends VehicleFlamerWeapon {
    private static final long serialVersionUID = -3957472644909347725L;

    public ISHeavyFlamer() {
        super();

        name = "Heavy Flamer";
        setInternalName(name);
        addLookupName("IS Heavy Flamer");
        addLookupName("ISHeavyFlamer");
        sortingName = "Flamer D";
        heat = 5;
        damage = 4;
        infDamageClass = WeaponType.WEAPON_BURST_6D6;
        rackSize = 2;
        ammoType = AmmoType.AmmoTypeEnum.HEAVY_FLAMER;
        shortRange = 2;
        mediumRange = 3;
        longRange = 4;
        extremeRange = 6;
        tonnage = 1.5;
        criticals = 1;
        bv = 15;
        cost = 11250;
        shortAV = 4;
        maxRange = RANGE_SHORT;
        atClass = CLASS_POINT_DEFENSE;
        flags = flags.or(WeaponType.F_AERO_WEAPON).or(WeaponType.F_MEK_WEAPON)
                .or(WeaponType.F_TANK_WEAPON);
        rulesRefs = "312, TO";
        // Tech Progression tweaked to combine IntOps with TRO Prototypes/3145 NTNU RS
        techAdvancement.setTechBase(TechBase.IS)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(TechRating.C)
                .setAvailability(AvailabilityValue.X, AvailabilityValue.X, AvailabilityValue.E, AvailabilityValue.D)
                .setISAdvancement(DATE_NONE, 3068, 3079, DATE_NONE, DATE_NONE)
                .setISApproximate(false, false, true, false, false)
                .setPrototypeFactions(Faction.LC)
                .setProductionFactions(Faction.LC)
                .setStaticTechLevel(SimpleTechLevel.STANDARD);
    }

    @Override
    public int getAlphaStrikeHeatDamage(int rangeband) {
        return (rangeband == AlphaStrikeElement.RANGE_BAND_SHORT) ? 4 : 0;
    }
}
