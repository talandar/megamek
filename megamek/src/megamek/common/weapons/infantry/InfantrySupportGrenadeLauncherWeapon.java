/**
 * MegaMek - Copyright (C) 2004,2005 Ben Mazur (bmazur@sev.org)
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
/*
 * Created on Sep 7, 2005
 *
 */
package megamek.common.weapons.infantry;

import megamek.common.AmmoType;

/**
 * @author Ben Grills
 */
public class InfantrySupportGrenadeLauncherWeapon extends InfantryWeapon {

	/**
	 *
	 */
	private static final long serialVersionUID = -3164871600230559641L;

	public InfantrySupportGrenadeLauncherWeapon() {
		super();

		name = "Grenade Launcher";
		setInternalName(name);
		addLookupName("InfantryGrenadeLauncher");
		addLookupName("Infantry Grenade Launcher");
		ammoType = AmmoType.AmmoTypeEnum.INFANTRY;
		cost = 465;
		bv = 2.48;
		tonnage = .005;
		flags = flags.or(F_NO_FIRES).or(F_BALLISTIC).or(F_INF_SUPPORT);
		infantryDamage = 0.81;
		infantryRange = 1;
		crew = 1;
		ammoWeight = 0.0045;
		ammoCost = 80;
		shots = 10;
		rulesRefs = " 273, TM";
		techAdvancement.setTechBase(TechBase.ALL).setISAdvancement(1950, 1950, 1950, DATE_NONE, DATE_NONE)
				.setISApproximate(false, false, false, false, false)
				.setClanAdvancement(1950, 1950, 1950, DATE_NONE, DATE_NONE)
				.setClanApproximate(false, false, false, false, false).setTechRating(TechRating.C)
				.setAvailability(AvailabilityValue.A, AvailabilityValue.B, AvailabilityValue.B, AvailabilityValue.A);

	}
}
