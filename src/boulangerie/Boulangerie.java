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

import boulangerie.gateaux.Ingredients;
import boulangerie.gateaux.ChouxALaCreme;
import boulangerie.gateaux.Tarte;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Patissier patissier = new Patissier();
        Ingredients ingredients = new Ingredients();
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
                choix = choisirOption(buff, "Avec chantilly", "Sans chantilly");
                if (choix == 1)
                    ingredients.add("Chantilly");
                choix = choisirOption(buff, "Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add("Noisettes");
                choix = choisirOption(buff, "Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add("Amandes grillées");
                
                patissier.preparerGateau(new ChouxALaCreme(typeCreme),
                        ingredients);
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
                choix = choisirOption(buff, "Avec meringue sur les fruits",
                    "Sans meringue sur les fruits");
                if (choix == 1)
                    ingredients.add("Meringue");
                choix = choisirOption(buff, "Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add("Noisettes");
                choix = choisirOption(buff, "Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add("Amandes grillées");
                
                patissier.preparerGateau(new Tarte(typeTarte),
                        ingredients);
                break;
        }
        
        try {
            buff.close();
        } catch (IOException ex) {
            Logger.getLogger(Boulangerie.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public static int choisirOption(BufferedReader buff, String... options) {
        System.out.println();
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
