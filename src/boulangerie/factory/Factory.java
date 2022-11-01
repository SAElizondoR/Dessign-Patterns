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
package boulangerie.factory;

import boulangerie.gateaux.ChouxALaCreme;
import boulangerie.gateaux.PanDeMuerto;
import boulangerie.gateaux.Tarte;
import boulangerie.gateaux.Gateau;
import boulangerie.ingredients.Ingredient;
import boulangerie.ingredients.IngredientsDecorator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sergio
 */
public class Factory {
    private static final Map<String, Gateau> prototypes = 
            new HashMap<>();
    
    static {
        prototypes.put("Choux à la crème", new ChouxALaCreme());
        prototypes.put("Tarte", new Tarte());
        prototypes.put("Pan de muerto", new PanDeMuerto());
    }
    
    public static IngredientsDecorator getPrototype(String type,
            ArrayList<Ingredient> ingredients) {
        try {
            return new IngredientsDecorator(prototypes.get(type).clone(),
                    ingredients);
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type +
                    ", doesn't exist.");
            return null;
        }
    }
}
