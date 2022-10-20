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
package boulangerie.gateaux;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
abstract class Gateau implements Aliment {
    
    protected final ArrayList<Aliment> ingredients = new ArrayList<>();
    
    public void add(Aliment aliment) {
        ingredients.add(aliment);
    }
    
    @Override
    public int preparer() {
        System.out.println();
        System.out.println();
        System.out.println("PREPARATION");
        
        for (Aliment aliment : ingredients)
            aliment.preparer();
        
        return 0;
    }
    
}
