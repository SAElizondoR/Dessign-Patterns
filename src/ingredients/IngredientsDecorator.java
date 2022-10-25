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
package ingredients;

import boulangerie.gateaux.Gateau;
import boulangerie.gateaux.GateauDecorator;

/**
 *
 * @author sergio
 */
public class IngredientsDecorator extends GateauDecorator {
    private final Ingredients ingredients;
    
    public IngredientsDecorator(Gateau decoratedGateau,
            Ingredients ingredients) {
        super(decoratedGateau);
        this.ingredients = ingredients;
    }

    @Override
    public int preparer() {
        decoratedGateau.preparer();
        for (String ingredient: ingredients)
            System.out.println("Ajouter " + ingredient + "...");
        return 0;
    }
    
}
