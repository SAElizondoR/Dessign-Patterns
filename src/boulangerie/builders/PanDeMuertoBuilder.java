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
public class PanDeMuertoBuilder extends GateauBuilder {
    
    String typeRemplissage;
    ArrayList<Ingredient> ingredients;
    
    public PanDeMuertoBuilder(String typeRemplissage,
            ArrayList<Ingredient> ingredients) {
        this.typeRemplissage = typeRemplissage;
        this.ingredients = ingredients;
    }
    
    @Override
    public void createNewGateau()  {
        gateau = new IngredientsDecorator(new Gateau("Pan de muerto"));
    }

    @Override
    public void buildPate() {
        System.out.println("Mélanger la farine, la levure et le sucre...");
        gateau.setPate("duveteux");
    }
    
    @Override
    public void remplir() {
        System.out.println("Ajouter la garniture au " + typeRemplissage
                + "...");
        gateau.setRemplissage(typeRemplissage);
    }

    @Override
    public void cuire() {
        System.out.println("Cuire 15 minutes...");
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
