/*
 * Copyright (c) 2004-2005 - Ben Mazur (bmazur@sev.org)
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
package megamek.common.weapons.infantry;

import megamek.common.AmmoType;

/**
 * @author Ben Grills
 * @since Sep 7, 2005
 */
public class InfantryRifleMauser960LaserWeapon extends InfantryWeapon {
    private static final long serialVersionUID = -3164871600230559641L;

    public InfantryRifleMauser960LaserWeapon() {
        super();

        name = "Laser Rifle (Mauser 960)";
        setInternalName(name);
        addLookupName("InfantryMauser960");
        addLookupName("Mauser 960 Assault System");
        ammoType = AmmoType.AmmoTypeEnum.NA;
        cost = 8000;
        bv = 4.75;
        tonnage = .0108;
        flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_LASER).or(F_ENERGY).or(F_INF_BURST);
        infantryDamage = 0.93;
        ammoWeight = 0.0003;
        shots = 15;
        bursts = 2;
        infantryRange = 2;
        rulesRefs = "273, TM";
        techAdvancement.setTechBase(TechBase.ALL).setISAdvancement(2698, 2700, 2710, DATE_NONE, DATE_NONE)
                .setISApproximate(true, false, false, false, false)
                .setClanAdvancement(2698, 2700, 2710, DATE_NONE, DATE_NONE)
                .setClanApproximate(true, false, false, false, false).setPrototypeFactions(Faction.TH)
                .setProductionFactions(Faction.TH).setTechRating(TechRating.E)
                .setAvailability(AvailabilityValue.C, AvailabilityValue.F, AvailabilityValue.D, AvailabilityValue.E);
    }
}
