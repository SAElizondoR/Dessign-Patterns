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
public class ChouxALaCreme extends Gateau {
    
    public ChouxALaCreme(String typeCreme) {
        super(typeCreme);
    }

    @Override
    public void preparer() {
        System.out.println("Mélanger la farine avec la beurre jusqu'à ce "
                + "qu'il forme une pâte...");
        setPate("choux");
        System.out.println("Ajouter la garniture à la crème " + complement
                + "...");
        setRemplissage(complement);
        System.out.println("Cuire 12 minutes...");
        cuire();
    }
    
    @Override
    public String toString() {
        return "\nType: Choux à la crème\nType crème: " + complement + "\n" +
                super.toString();
    }
}