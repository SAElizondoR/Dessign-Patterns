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

import boulangerie.builders.ChouxALaCremeBuilder;
import boulangerie.builders.GateauBuilder;
import boulangerie.builders.PanDeMuertoBuilder;
import boulangerie.builders.TarteBuilder;
import boulangerie.dao.GateauxDao;
import boulangerie.gestion.Vendeur;
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
        GateauxDao gateauxDao = new GateauxDao();
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Patissier patissier = new Patissier(buff, gateauxDao);
        ingredients.add(new Ingredient("chantilly"));
        GateauBuilder gateauBuilder = new ChouxALaCremeBuilder(
                        "vanille", ingredients);
        buildGateau(buff, gateauBuilder, gateauxDao, patissier);
        gateauBuilder = new TarteBuilder(
                        "pommes", ingredients);
        buildGateau(buff, gateauBuilder, gateauxDao, patissier);
        gateauBuilder = new PanDeMuertoBuilder(
                        "massepain", ingredients);
        buildGateau(buff, gateauBuilder, gateauxDao, patissier);
        ingredients.add(new Ingredient("sucre"));
        gateauBuilder = new PanDeMuertoBuilder(
                        "massepain", ingredients);
        buildGateau(buff, gateauBuilder, gateauxDao, patissier);
        gateauxDao.show();
        
        Vendeur vendeur =
                new Vendeur(gateauxDao.size());
        vendeur.addObserver(patissier);
        int choix;
        do {
            choix = choisirOption(buff, "Vendre", "Quitter");
            switch(choix) {
                case 1:
                    vendre(buff, gateauxDao, vendeur);
                    break;
            }
        } while (choix != 2);
        
        
        
        
        /*  */
        
        try {
            buff.close();
        } catch (IOException ex) {
            Logger.getLogger(Boulangerie.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public static void buildGateau(BufferedReader buff,
            GateauBuilder builder, GateauxDao gateauxDao, Patissier patissier) {
        GateauBuilder gateauBuilder = builder;
        patissier.setGateauBuilder(gateauBuilder);
        patissier.preparerGateau();
        gateauxDao.save(patissier.getGateau());
    }
    
    public static void vendre(BufferedReader buff, GateauxDao gateauxDao,
            Vendeur vendeur) {
        String[] types = gateauxDao.getTypes();
        int choix = choisirOption(buff, types);
        gateauxDao.delete(gateauxDao.getGateaux(choix));
        vendeur.vendre();
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
