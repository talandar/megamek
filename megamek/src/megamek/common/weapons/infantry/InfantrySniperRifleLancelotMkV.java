/**
 * MegaMek - Copyright (C) 2004,2005, 2022 MegaMekTeam
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
 * Created on March 20, 2022
 * @author Hammer
 */

package megamek.common.weapons.infantry;

import megamek.common.AmmoType;


public class InfantrySniperRifleLancelotMkV extends InfantryWeapon {

    /**
    *
    */
   private static final long serialVersionUID = -3164871600230559641L;

   public InfantrySniperRifleLancelotMkV() {
       super();

       name = "Sniper Rifle (Lancelot Mk V)";
       setInternalName(name);
       addLookupName("Lancelot Mk V");
       ammoType = AmmoType.AmmoTypeEnum.INFANTRY;
       bv = .28;
       tonnage =  0.006;
       infantryDamage =  0.28;
       infantryRange =  4;
       ammoWeight =  0.006;
       cost = 400;
       ammoCost =  4;
       shots =  10;
       bursts =  1;
       flags = flags.or(F_NO_FIRES).or(F_DIRECT_FIRE).or(F_BALLISTIC);
       rulesRefs = "Shrapnel #1";
       techAdvancement
       .setTechBase(TechBase.IS)
       .setTechRating(TechRating.C)
       .setAvailability(AvailabilityValue.C,AvailabilityValue.C,AvailabilityValue.C,AvailabilityValue.C)
       .setISAdvancement(DATE_NONE, DATE_NONE,DATE_ES,DATE_NONE,DATE_NONE)
       .setISApproximate(false, false, true, false, false)
       .setProductionFactions(Faction.FS);

   }
}