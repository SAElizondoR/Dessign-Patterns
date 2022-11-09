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
import boulangerie.gateaux.Gateau;
import boulangerie.ingredients.Ingredient;
import boulangerie.patissier.Patissier;
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
        GateauxDao gateauxDAO = new GateauxDao();
        Patissier patissier = new Patissier();
        String typeGateau = null;
        String complementGateau = null;
        int choix = choisirOption(buff, "Choux à la crème", "Tarte",
                "Pan de muerto");
        switch (choix) {
            case 1:
                typeGateau = "choux";
                choix = choisirOption(buff, "Crème vanille", "Crème chocolat");
                switch (choix) {
                    case 1:
                        complementGateau = "vanille";
                        break;
                    case 2:
                        complementGateau = "chocolat";
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
                break;
            case 2:
                typeGateau = "tarte";
                choix = choisirOption(buff, "Aux pommes", "Aux abricots");
                switch (choix) {
                    case 1:
                        complementGateau = "pommes";
                        break;
                    case 2:
                        complementGateau = "abricots";
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
                break;
            case 3:
                typeGateau = "pan de muerto";
                choix = choisirOption(buff, "Chocolat", "Massepain");
                switch (choix) {
                    case 1:
                        complementGateau = "chocolat";
                        break;
                    case 2:
                        complementGateau = "massepain";
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
                break;
        }
        
        Gateau g = patissier.preparerGateau(typeGateau,
                complementGateau, ingredients);
        gateauxDAO.save(g);
        System.out.println();
        gateauxDAO.afficherGateaux();
        
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
