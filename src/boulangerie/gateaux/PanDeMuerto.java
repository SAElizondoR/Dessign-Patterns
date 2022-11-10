/*
 * Copyright (C) 2022 selizondorod
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

package boulangerie.gateaux;

/**
 *
 * @author selizondorod
 */
public class PanDeMuerto extends Gateau {
    
    public PanDeMuerto(String type) {
        super(type);
    }
    
    @Override
    public void preparer() {
        System.out.println();
        System.out.println("PREPARATION");
        System.out.println("Mélanger la farine, la levure et le sucre...");
        setPate("duveteux");
        System.out.println("Ajouter la garniture au " + complement
                + "...");
        setRemplissage(complement);
        System.out.println("Cuire 15 minutes...");
        cuire();
    }
    
    @Override
    public String toString() {
        return "Type: Pan de muerto\nType remplissage: " + complement + "\n" +
                super.toString();
    }
}