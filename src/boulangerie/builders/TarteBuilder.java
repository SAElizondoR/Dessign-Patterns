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
package boulangerie.builders;

import boulangerie.gateaux.Gateau;
import boulangerie.ingredients.Ingredient;
import boulangerie.ingredients.IngredientsDecorator;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class TarteBuilder extends GateauBuilder {
    
    private final String type;
    private final ArrayList<Ingredient> ingredients;
    
    public TarteBuilder(String type, ArrayList<Ingredient> ingredients) {
        this.type = type;
        this.ingredients = ingredients;
    }
    
    @Override
    public void createNewGateau()  {
        gateau = new IngredientsDecorator(new Gateau("Tarte"));
    }

    @Override
    public void buildPate() {
        System.out.println("Mélanger la farine, le sucre, les oeufs et le "
                + "beurre...");
        gateau.setPate("sucrée");
    }

    @Override
    public void remplir() {
        System.out.println("Ajouter la garniture aux " + type + "...");
        gateau.setRemplissage(type);
    }

    @Override
    public void cuire() {
        System.out.println("Cuire pendant 20 minutes...");
        gateau.cuire();
    }

    @Override
    public void decorer() {
        for (Ingredient ingredient: ingredients) {
            System.out.println("Ajouter des " + ingredient +
                    " en décoration...");
            ((IngredientsDecorator)gateau).addIngredient(ingredient);
        }
    }
    
}
