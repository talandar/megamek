/*
 * Copyright (c) 2005 - Ben Mazur (bmazur@sev.org)
 * Copyright (c) 2022 - The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MegaMek.
 *
 * MegaMek is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MegaMek is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MegaMek. If not, see <http://www.gnu.org/licenses/>.
 */
package megamek.common.weapons.battlearmor;

import megamek.common.AmmoType;
import megamek.common.weapons.srms.SRMWeapon;


/**
 * @author Sebastian Brocks
 */
public class CLBASRM4 extends SRMWeapon {

    /**
     *
     */
    private static final long serialVersionUID = -6776541552712952370L;

    /**
     *
     */
    public CLBASRM4() {
        super();
        name = "SRM 4";
        setInternalName("CLBASRM4");
        addLookupName("Clan BA SRM-4");
        addLookupName("Clan BA SRM 4");
        ammoType = AmmoType.AmmoTypeEnum.SRM;
        heat = 3;
        rackSize = 4;
        shortRange = 3;
        mediumRange = 6;
        longRange = 9;
        extremeRange = 12;
        tonnage = .140;
        criticals = 2;
        bv = 39;
        flags = flags.or(F_NO_FIRES).or(F_BA_WEAPON).andNot(F_MEK_WEAPON).andNot(F_TANK_WEAPON).andNot(F_AERO_WEAPON).andNot(F_PROTO_WEAPON);
        cost = 20000;
        shortAV = 4;
        maxRange = RANGE_SHORT;
		rulesRefs = "261, TM";
		techAdvancement.setTechBase(TechBase.CLAN)
		.setIntroLevel(false)
		.setUnofficial(false)
	    .setTechRating(TechRating.F)
	    .setAvailability(AvailabilityValue.X, AvailabilityValue.D, AvailabilityValue.C, AvailabilityValue.B)
	    .setClanAdvancement(2865, 2868, 2870, DATE_NONE, DATE_NONE)
	    .setClanApproximate(true, false, false, false, false)
	    .setPrototypeFactions(Faction.CWF)
	    .setProductionFactions(Faction.CWF);
    }
}
