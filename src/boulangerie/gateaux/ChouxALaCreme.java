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

import boulangerie.gateaux.Gateau;
import boulangerie.ingredients.Ingredient;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ChouxALaCreme extends Gateau {
    
    String typeCreme;
    ArrayList<Ingredient> ingredients;
    
    public ChouxALaCreme() {
        
    }
    
    public ChouxALaCreme(String typeCreme,
            ArrayList<Ingredient> ingredients) {
        this.typeCreme = typeCreme;
        this.ingredients = ingredients;
    }
    
    public void setTypeCreme(String typeCreme) {
        this.typeCreme = typeCreme;
    }
    
    @Override
    public Gateau clone() {
        return new ChouxALaCreme();
    }

}
