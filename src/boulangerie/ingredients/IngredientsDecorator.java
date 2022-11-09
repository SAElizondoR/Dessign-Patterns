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
package boulangerie.ingredients;

import boulangerie.gateaux.Gateau;
import boulangerie.gateaux.GateauDecorator;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class IngredientsDecorator extends GateauDecorator {
    protected final ArrayList<Ingredient> ingredients;
    
    public IngredientsDecorator(Gateau decoratedGateau,
            ArrayList<Ingredient> ingredients) {
        super(decoratedGateau);
        this.ingredients = ingredients;
    }
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    @Override
    public String toString() {
        String str = decoratedGateau.toString();
        str += "\nIngredients:";
        for (Ingredient ingredient: ingredients) {
            str += "\n" + ingredient;
        }
        return str;
    }

    @Override
    public void preparer() {
        decoratedGateau.preparer();
        for (Ingredient ingredient: ingredients) {
            System.out.println("Ajouter " + ingredient +
                    " en décoration...");
        }
    }
    
}
