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

package boulangerie.patissier;

import boulangerie.gateaux.Gateau;
import boulangerie.factories.GateauFactory;
import boulangerie.ingredients.Ingredient;
import boulangerie.ingredients.IngredientsDecorator;
import java.util.ArrayList;

/**
 *
 * @author selizondorod
 */
public class Patissier {
    
    public Gateau preparerGateau(String typeGateau, String complement,
            ArrayList<Ingredient> ingredients) {
        GateauFactory factory = GateauFactory.getFactory(typeGateau);
        Gateau decoratedGateau = new IngredientsDecorator(
                factory.createGateau(complement), ingredients);
        decoratedGateau.preparer();
        System.out.println("C'est fait!");
        
        return decoratedGateau;
    }
    
}
