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

package boulangerie.boulangerie;

import boulangerie.dao.GateauxDao;
import boulangerie.factory.Factory;
import boulangerie.ingredients.Ingredient;
import boulangerie.ingredients.IngredientsDecorator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author selizondorod
 */
public class Boulangerie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        BufferedReader buff = new BufferedReader(
                new InputStreamReader(System.in));
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        GateauxDao gateauxDao = new GateauxDao();
        IngredientsDecorator gateau = null;
        int choix = choisirOption(buff, "Choux à la crème", "Tarte",
                "Pan de muerto");
        switch (choix) {
            case 1:
                String typeCreme = "";
                choix = choisirOption(buff, "Crème vanille", "Crème chocolat");
                switch (choix) {
                    case 1:
                        typeCreme = "vanille";
                        break;
                    case 2:
                        typeCreme = "chocolat";
                        break;
                }
                choix = choisirOption(buff, "Avec chantilly", "Sans chantilly");
                if (choix == 1)
                    ingredients.add(new Ingredient("chantilly"));
                choix = choisirOption(buff, "Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add(new Ingredient("noisettes"));
                choix = choisirOption(buff, "Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add(new Ingredient("amandes grillées"));
                gateau = Factory.getPrototype("Choux à la crème", ingredients);
                System.out.println("Mélanger la farine avec la beurre jusqu'à "
                        + "ce qu'il forme une pâte...");
                gateau.setPate("choux");
                System.out.println("Ajouter la garniture à la crème " +
                        typeCreme + "...");
                gateau.setRemplissage(typeCreme);
                System.out.println("Cuire 12 minutes...");
                gateau.cuire();
                for (Ingredient ingredient: new ArrayList<>(ingredients)) {
                    System.out.println("Ajouter " + ingredient +
                    " en décoration...");
                    gateau.addIngredient(ingredient);
                }
                break;
            case 2:
                String typeTarte = "";
                choix = choisirOption(buff, "Aux pommes", "Aux abricots");
                switch (choix) {
                    case 1:
                        typeTarte = "pommes";
                        break;
                    case 2:
                        typeTarte = "abricots";
                        break;
                }
                choix = choisirOption(buff, "Avec meringue sur les fruits",
                    "Sans meringue sur les fruits");
                if (choix == 1)
                    ingredients.add(new Ingredient("meringue"));
                choix = choisirOption(buff, "Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add(new Ingredient("noisettes"));
                choix = choisirOption(buff, "Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add(new Ingredient("amandes grillées"));
                gateau = Factory.getPrototype("Tarte",
                        ingredients);
                System.out.println("Mélanger la farine, le sucre, les oeufs et le "
                + "beurre...");
                gateau.setPate("sucrée");
                System.out.println("Ajouter la garniture aux "
                        + typeTarte + "...");
                gateau.setRemplissage(typeTarte);
                System.out.println("Cuire pendant 20 minutes...");
                gateau.cuire();
                for (Ingredient ingredient: new ArrayList<>(ingredients)) {
                    System.out.println("Ajouter des " + ingredient +
                        " en décoration...");
                    gateau.addIngredient(ingredient);
                }
                break;
            case 3:
                String typeRemplissage = "";
                choix = choisirOption(buff, "Chocolat", "Massepain");
                switch (choix) {
                    case 1:
                        typeRemplissage = "chocolat";
                        break;
                    case 2:
                        typeRemplissage = "massepain";
                        break;
                }
                choix = choisirOption(buff, "Avec canelle", "Sans canelle");
                if (choix == 1)
                    ingredients.add(new Ingredient("canelle"));
                choix = choisirOption(buff, "Avec pain de vesou",
                        "Sans pain de vesou");
                if (choix == 1)
                    ingredients.add(new Ingredient("pain de vesou"));
                choix = choisirOption(buff, "Avec sucre",
                    "Sans sucre");
                if (choix == 1)
                    ingredients.add(new Ingredient("sucre"));
                gateau = Factory.getPrototype("Pan de muerto",
                        ingredients);
                System.out.println("Mélanger la farine, la levure et le sucre...");
                gateau.setPate("duveteux");
                System.out.println("Ajouter la garniture au " + typeRemplissage
                + "...");
                gateau.setRemplissage(typeRemplissage);
                System.out.println("Cuire 15 minutes...");
                gateau.cuire();
                for (Ingredient ingredient: new ArrayList<>(ingredients)) {
                    System.out.println("Ajouter " + ingredient +
                            " en décoration...");
                    gateau.addIngredient(ingredient);
                }
                break;
        }
        
        gateauxDao.save(gateau);
        
        /*patissier.setGateauBuilder(gateauBuilder);
        patissier.preparerGateau();
        patissier.getGateau(); */
        
        try {
            buff.close();
        } catch (IOException ex) {
            Logger.getLogger(Boulangerie.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public static int choisirOption(BufferedReader buff, String... options) {
        System.out.println("Quel est votre choix ?");
        int cont = 0;
        for (String option : options) {
            cont++;
            System.out.printf("%d: %s\n", cont, option);
        }
        System.out.print("Votre choix: ");
        return Integer.parseInt(lireChaine(buff));
    }
    
    public static String lireChaine(BufferedReader buff) {
        try {
            return buff.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Boulangerie.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
