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
public class Tarte extends Gateau {
    private final String type;
    
    public Tarte(String type) {
        this.type = type;
    }
    
    @Override
    public int preparer() {
        if (super.preparer() == 0) {
            System.out.println("Ajouter les " + type + "...");
            System.out.println("Préparer la pâte");
            System.out.println("Mélanger les ingrédients...");
            System.out.println("Cuire...");
            return 0;
        }
        return 1;
    }
}
