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

package boulangerie.patissier;

import boulangerie.boulangerie.Boulangerie;
import boulangerie.builders.ChouxALaCremeBuilder;
import boulangerie.gateaux.Gateau;
import boulangerie.builders.GateauBuilder;
import boulangerie.builders.PanDeMuertoBuilder;
import boulangerie.builders.TarteBuilder;
import boulangerie.dao.GateauxDao;
import boulangerie.gestion.GateauObserver;
import boulangerie.ingredients.Ingredient;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author selizondorod
 */
public class Patissier implements GateauObserver {
    
    private GateauBuilder gateauBuilder;
    private final GateauxDao gateauxDao;
    private final BufferedReader buff;
    
    public Patissier(BufferedReader buff, GateauxDao gateauxDao) {
        this.buff = buff;
        this.gateauxDao = gateauxDao;
    }
    
    public void setGateauBuilder(GateauBuilder gateauBuilder) {
        this.gateauBuilder = gateauBuilder;
    }
    
    public Gateau getGateau() {
        return gateauBuilder.getGateau();
    }
    
    public void preparerGateau() {
        System.out.println("");
        System.out.println("PRÉPARATION");
        System.out.println("");
        gateauBuilder.createNewGateau();
        gateauBuilder.buildPate();
        gateauBuilder.remplir();
        gateauBuilder.cuire();
        gateauBuilder.decorer();
        
        System.out.println("C'est fait!");
    }

    @Override
    public void update(int gateauSize) {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        
        System.out.println();
        System.out.println("UN GÂTEAU VENDU. AJOUTER UN AUTRE: ");
        
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
                gateauBuilder = new ChouxALaCremeBuilder(
                        typeCreme, ingredients);
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
                gateauBuilder = new TarteBuilder(typeTarte, ingredients);
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
                gateauBuilder = new PanDeMuertoBuilder(
                        typeRemplissage, ingredients);
                break;
        }
        
        setGateauBuilder(gateauBuilder);
        preparerGateau();
        gateauxDao.save(getGateau());
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
