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

package boulangerie.recettes;

/**
 *
 * @author selizondorod
 */
public class TarteRecette extends Recette {
    String type;
    
    public TarteRecette(String type) {
        this.type = type;
    }
    
    @Override
    public void buildFarine() {
        gateau.setFarine("Blé");
        System.out.println("Mélanger la farine de "
                + gateau.getFarine() + "...");
    }

    @Override
    public void buildBeurre() {
        gateau.setBeurre("Margarine");
        System.out.println("Ajouter les morceaux de "
                + gateau.getBeurre() + "...");
    }

    @Override
    public void buildRemplissage() {
        gateau.setRemplissage(type);
        System.out.println("Remplir avec " + gateau.getRemplissage());
    }
}
