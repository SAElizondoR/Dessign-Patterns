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
public class ChouxALaCremeBuilder extends GateauBuilder {
    
    private final String typeCreme;
    private final ArrayList<Ingredient> ingredients;
    
    public ChouxALaCremeBuilder(String typeCreme,
            ArrayList<Ingredient> ingredients) {
        this.typeCreme = typeCreme;
        this.ingredients = ingredients;
    }
    
    @Override
    public void createNewGateau()  {
        gateau = new IngredientsDecorator(new Gateau("Choux à la crème"));
    }

    @Override
    public void buildPate() {
        System.out.println("Mélanger la farine avec la beurre jusqu'à ce "
                + "qu'il forme une pâte...");
        gateau.setPate("choux");
    }
    
    @Override
    public void remplir() {
        System.out.println("Ajouter la garniture à la crème " + typeCreme
                + "...");
        gateau.setRemplissage(typeCreme);
    }

    @Override
    public void cuire() {
        System.out.println("Cuire 12 minutes...");
        gateau.cuire();
    }

    @Override
    public void decorer() {
        for (Ingredient ingredient: ingredients) {
            System.out.println("Ajouter " + ingredient +
                    " en décoration...");
            ((IngredientsDecorator)gateau).addIngredient(ingredient);
        }
    }

}
