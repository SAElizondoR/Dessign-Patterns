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
package boulangerie.gateaux;

/**
 *
 * @author sergio
 */
public class Gateau {
    protected final String nom;
    private String typePate;
    private String typeRemplissage;
    private boolean isCuit;
    
    public Gateau(String nom) {
        this.nom = nom;
    }
    
    public void setPate(String typePate) {
        this.typePate = typePate;
    }
    
    public void setRemplissage(String typeRemplissage) {
        this.typeRemplissage = typeRemplissage;
    }
    
    public void cuire() {
        this.isCuit = true;
    }
    
    @Override
    public String toString() {
        return "Nom: " + this.nom + "\nPâte: " + this.typePate +
                "\nRemplissage: " + this.typeRemplissage +
                (isCuit ? "\nCuit" : "\nEn cours de cuisson...");
    }
    
}
