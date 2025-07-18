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
package megamek.common.weapons.artillery;

import megamek.common.AmmoType;
import megamek.common.SimpleTechLevel;

/**
 * @author Sebastian Brocks
 * @since Oct 20, 2004
 */
public class ISCruiseMissile70 extends ArtilleryWeapon {
    private static final long serialVersionUID = 5323886711682442495L;

    public ISCruiseMissile70() {
        super();
        name = "Cruise Missile/70";
        setInternalName("ISCruiseMissile70");
        sortingName = "Cruise Missile/070";
        heat = 70;
        rackSize = 70;
        ammoType = AmmoType.AmmoTypeEnum.CRUISE_MISSILE;
        shortRange = 1;
        mediumRange = 2;
        longRange = 90;
        extremeRange = 90; // No extreme range.
        tonnage = 80;
        criticals = 80;
        svslots = 35;
        flags = flags.or(F_CRUISE_MISSILE);
        bv = 1031;
        cost = 1250000;
        rulesRefs = "284, TO";
        // Tech Progression tweaked to combine IntOps with TRO Prototypes/3145 NTNU RS
        techAdvancement.setTechBase(TechBase.IS)
                .setTechRating(TechRating.E)
                .setAvailability(AvailabilityValue.X, AvailabilityValue.X, AvailabilityValue.F, AvailabilityValue.E)
                .setISAdvancement(3065, 3095, DATE_NONE, DATE_NONE, DATE_NONE)
                .setISApproximate(false, true, false, false, false)
                .setPrototypeFactions(Faction.FS)
                .setProductionFactions(Faction.FS)
                .setStaticTechLevel(SimpleTechLevel.ADVANCED);
    }
}
