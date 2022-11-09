/*
 * Copyright (C) 2022 sergio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package boulangerie.dao;

import boulangerie.gateaux.Gateau;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class GateauxDao {
    private final ArrayList<Gateau> gateaux;
    
    public GateauxDao() {
        gateaux = new ArrayList<>();
    }
    
    public void afficherGateaux() {
        System.out.println("Historique de gâteaux:");
        for (Gateau gateau: gateaux)
            System.out.println(gateau.toString());
        System.out.println();
       }

    public void save(Gateau obj) {
        gateaux.add(obj);
    }

    public void delete(Gateau obj) {
        gateaux.remove(obj);
    }
}