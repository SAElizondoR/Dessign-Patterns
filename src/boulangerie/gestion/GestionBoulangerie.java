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
package boulangerie.gestion;

import boulangerie.builders.ChouxALaCremeBuilder;
import boulangerie.builders.GateauBuilder;
import boulangerie.builders.PanDeMuertoBuilder;
import boulangerie.builders.TarteBuilder;
import boulangerie.dao.GateauxDao;
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
 * @author sergio
 */
public class GestionBoulangerie implements GateauObserver {
    private final BufferedReader buff = new BufferedReader(
                new InputStreamReader(System.in));
    private final GateauxDao gateauxDao = new GateauxDao();
    private final Patissier patissier = new Patissier();
    
    public void run() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        
        ingredients.add(new Ingredient("chantilly"));
        
        System.out.println("On va préparer 4 gâteaux");
        GateauBuilder gateauBuilder = new ChouxALaCremeBuilder(
                        "vanille", ingredients);
        buildGateau(gateauBuilder);
        gateauBuilder = new TarteBuilder(
                        "pommes", ingredients);
        buildGateau(gateauBuilder);
        gateauBuilder = new PanDeMuertoBuilder(
                        "massepain", ingredients);
        buildGateau(gateauBuilder);
        ingredients.add(new Ingredient("sucre"));
        gateauBuilder = new PanDeMuertoBuilder(
                        "massepain", ingredients);
        buildGateau(gateauBuilder);
        gateauxDao.show();
        
        Vendeur vendeur =
                new Vendeur(gateauxDao.size());
        vendeur.addObserver(this);
        int choix;
        do {
            choix = choisirOption("Vendre", "Quitter");
            switch(choix) {
                case 1:
                    vendre(vendeur);
                    break;
            }
        } while (choix != 2);
        
        try {
            buff.close();
        } catch (IOException ex) {
            Logger.getLogger(GestionBoulangerie.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    private void buildGateau(GateauBuilder gateauBuilder) {
        patissier.setGateauBuilder(gateauBuilder);
        patissier.preparerGateau();
        gateauxDao.save(patissier.getGateau());
    }
    
    private void vendre(Vendeur vendeur) {
        String[] types = gateauxDao.getTypes();
        int choix = choisirOption(types);
        gateauxDao.delete(gateauxDao.getGateaux(choix));
        vendeur.vendre();
    }
    
    private int choisirOption(String... options) {
        System.out.println("Quel est votre choix ?");
        int cont = 0;
        for (String option : options) {
            cont++;
            System.out.printf("%d: %s\n", cont, option);
        }
        System.out.print("Votre choix: ");
        return Integer.parseInt(lireChaine());
    }
    
    private String lireChaine() {
        try {
            return buff.readLine();
        } catch (IOException ex) {
            Logger.getLogger(GestionBoulangerie.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void update(int gateauSize) {
        if (gateauSize >= 4)
            return;
        
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        
        System.out.println();
        System.out.println("UN GÂTEAU VENDU. AJOUTER UN AUTRE: ");
        GateauBuilder gateauBuilder = null;
        int choix = choisirOption("Choux à la crème", "Tarte",
                "Pan de muerto");
        switch (choix) {
            case 1:
                String typeCreme = "";
                choix = choisirOption("Crème vanille", "Crème chocolat");
                switch (choix) {
                    case 1:
                        typeCreme = "vanille";
                        break;
                    case 2:
                        typeCreme = "chocolat";
                        break;
                }
                choix = choisirOption("Avec chantilly", "Sans chantilly");
                if (choix == 1)
                    ingredients.add(new Ingredient("chantilly"));
                choix = choisirOption("Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add(new Ingredient("noisettes"));
                choix = choisirOption("Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add(new Ingredient("amandes grillées"));
                gateauBuilder = new ChouxALaCremeBuilder(
                        typeCreme, ingredients);
                break;
            case 2:
                String typeTarte = "";
                choix = choisirOption("Aux pommes", "Aux abricots");
                switch (choix) {
                    case 1:
                        typeTarte = "pommes";
                        break;
                    case 2:
                        typeTarte = "abricots";
                        break;
                }
                choix = choisirOption("Avec meringue sur les fruits",
                    "Sans meringue sur les fruits");
                if (choix == 1)
                    ingredients.add(new Ingredient("meringue"));
                choix = choisirOption("Avec noisettes", "Sans noisettes");
                if (choix == 1)
                    ingredients.add(new Ingredient("noisettes"));
                choix = choisirOption("Avec amandes grillées",
                    "Sans amandes grillées");
                if (choix == 1)
                    ingredients.add(new Ingredient("amandes grillées"));
                gateauBuilder = new TarteBuilder(typeTarte, ingredients);
                break;
            case 3:
                String typeRemplissage = "";
                choix = choisirOption("Chocolat", "Massepain");
                switch (choix) {
                    case 1:
                        typeRemplissage = "chocolat";
                        break;
                    case 2:
                        typeRemplissage = "massepain";
                        break;
                }
                choix = choisirOption("Avec canelle", "Sans canelle");
                if (choix == 1)
                    ingredients.add(new Ingredient("canelle"));
                choix = choisirOption("Avec pain de vesou",
                        "Sans pain de vesou");
                if (choix == 1)
                    ingredients.add(new Ingredient("pain de vesou"));
                choix = choisirOption("Avec sucre",
                    "Sans sucre");
                if (choix == 1)
                    ingredients.add(new Ingredient("sucre"));
                gateauBuilder = new PanDeMuertoBuilder(
                        typeRemplissage, ingredients);
                break;
        }
        
        patissier.setGateauBuilder(gateauBuilder);
        patissier.preparerGateau();
        gateauxDao.save(patissier.getGateau());
    }
    
}
