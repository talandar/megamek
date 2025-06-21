/*
 * MegaMek - Copyright (C) 2000-2004 Ben Mazur (bmazur@sev.org)
 * Copyright © 2013 Edward Cullen (eddy@obsessedcomputers.co.uk)
 * Copyright © 2013 Nicholas Walczak (walczak@cs.umn.edu)
 * Copyright (c) 2024 - The MegaMek Team. All Rights Reserved.
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
package megamek.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import megamek.codeUtilities.StringUtility;
import megamek.common.*;
import megamek.common.annotations.Nullable;
import megamek.common.equipment.ArmorType;
import megamek.common.templates.TROView;
import megamek.logging.MMLogger;

/**
 * This class provides a utility to read in all the /data/mekfiles and print
 * that data out into a CSV format.
 *
 * @author arlith
 * @author Simon (Juliez)
 */
public final class SimplifiedCSVExportTool {
    private static final MMLogger logger = MMLogger.create(MekCacheCSVTool.class);

    // Excel import works better with the .txt extension instead of .csv
    private static final String FILE_NAME = "Units.txt";
    private static final String DELIM = "|";
    private static boolean includeGunEmplacement = false; // Variable to control inclusion of Gun Emplacement units

    private static final String NOT_APPLICABLE = "Not Applicable";

    private static final List<String> HEADERS = List.of("Chassis", "Model", "MUL ID", "Combined", "Clan",
            "Weight", "Intro Date", "Unit Type", "BV", "Rules", "Equipment", "Armor", "Structure", "Movement");

    public static void main(String... args) {
        if (args.length > 0) {
            includeGunEmplacement = Boolean.parseBoolean(args[0]);
        }

        try (PrintWriter pw = new PrintWriter(FILE_NAME);
                BufferedWriter bw = new BufferedWriter(pw)) {
            MekSummaryCache cache = MekSummaryCache.getInstance(true);
            MekSummary[] units = cache.getAllMeks();

            StringBuilder csvLine = new StringBuilder();
            csvLine.append(String.join(DELIM, HEADERS)).append("\n");
            bw.write(csvLine.toString());

            for (MekSummary unit : units) {
                if (!includeGunEmplacement && unit.getUnitType().equals("Gun Emplacement")) {
                    continue;
                }

                csvLine = new StringBuilder();
                csvLine.append(unit.getChassis()).append(DELIM);
                csvLine.append(unit.getModel()).append(DELIM);
                csvLine.append(unit.getMulId()).append(DELIM);
                csvLine.append(unit.getChassis()).append(" ").append(unit.getModel()).append(DELIM);

                csvLine.append(!unit.getTechBase().equals("Inner Sphere")).append(DELIM);

                csvLine.append(unit.getTons()).append(DELIM);
                csvLine.append(unit.getYear()).append(DELIM);

                // Unit Type.
                csvLine.append(unit.getUnitType()).append(DELIM);

                // Unit BV
                csvLine.append(unit.getBV()).append(DELIM);
                // Unit Tech Level
                csvLine.append(unit.getLevel()).append(DELIM);


                // Equipment Names
                List<String> equipmentNames = new ArrayList<>();
                for (String name : unit.getEquipmentNames()) {
                    // Ignore armor critical
                    if (ArmorType.allArmorNames().contains(name)) {
                        continue;
                    }

                    // Ignore internal structure critical
                    if (Stream.of(EquipmentType.structureNames).anyMatch(name::contains)) {
                        continue;
                    }

                    if (Stream.of("Bay", "Ammo", "Infantry Auto Rifle", "Heat Sink", "HeatSink", "Ferro-Fibrous", Infantry.LEG_ATTACK,
                                Infantry.SWARM_MEK, Infantry.SWARM_WEAPON_MEK, Infantry.STOP_SWARM)
                              .anyMatch(name::contains)) {
                        continue;
                    }
                    equipmentNames.add(name);
                }
                csvLine.append(String.join(",", equipmentNames)).append(DELIM);

                //ARMOR
                csvLine.append(unit.getTotalArmor()).append(DELIM);
                //STRUCTURE
                csvLine.append(unit.getTotalInternal()).append(DELIM);

                String movement = unit.getWalkMp()+"/"+unit.getRunMp()+"/"+(unit.getJumpMp()<=0? "-": unit.getJumpMp());
                csvLine.append(movement).append(DELIM);



                csvLine.append("\n");
                bw.write(csvLine.toString());
            }
        } catch (FileNotFoundException e) {
            logger.error(e, "Could not open file for output!");
        } catch (IOException e) {
            logger.error(e, "IO Exception");
        }
    }

    public static @Nullable Entity loadEntity(File f, String entityName) {
        try {
            return new MekFileParser(f, entityName).getEntity();
        } catch (megamek.common.loaders.EntityLoadingException e) {
            return null;
        }
    }

    private SimplifiedCSVExportTool() {
    }
}
