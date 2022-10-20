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

package boulangerie;

import boulangerie.gateaux.ChouxALaCreme;
import boulangerie.gateaux.Gateau;
import boulangerie.gateaux.IngredientsDecorator;
import boulangerie.gateaux.Tarte;
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
        
        Gateau gateau = null;
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        int choix = choisirOption(buff, "Choux à la crème", "Tarte");
        switch (choix) {
            case 1:
                String typeCreme = "";
                choix = choisirOption(buff, "Crème vanille", "Crème chocolat");
                switch (choix) {
                    case 1:
                        typeCreme = "Vanille";
                        break;
                    case 2:
                        typeCreme = "Chocolat";
                        break;
                }
                gateau = new ChouxALaCreme(typeCreme);
                choix = choisirOption(buff, "Avec chantilly", "Sans chantilly");
                if (choix == 1)
                    ingredients.add(new Ingredient("Chantilly"));
                choix = choisirOption(buff, "Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add(new Ingredient("Noisettes"));
                choix = choisirOption(buff, "Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add(new Ingredient("Amandes grillées"));
                break;
            case 2:
                String typeTarte = "";
                choix = choisirOption(buff, "Aux pommes", "Aux abricots");
                switch (choix) {
                    case 1:
                        typeTarte = "Pommes";
                        break;
                    case 2:
                        typeTarte = "Abricots";
                        break;
                }
                gateau= new Tarte(typeTarte);
                choix = choisirOption(buff, "Avec meringue sur les fruits",
                    "Sans meringue sur les fruits");
                if (choix == 1)
                    ingredients.add(new Ingredient("Meringue"));
                choix = choisirOption(buff, "Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add(new Ingredient("Noisettes"));
                choix = choisirOption(buff, "Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add(new Ingredient("Amandes grillées"));
                break;
        }
        Gateau decoratedGateau = new IngredientsDecorator(gateau, ingredients);
        
        if (decoratedGateau.preparer() == 0)
            System.out.println("C'est fait!");
        else
            System.out.println("Erreur lors de la preparation.");
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
