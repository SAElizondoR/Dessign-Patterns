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
    
    private String typeFarine;
    private String typeBeurre;
    private String typeRemplissage;
    
    /* public Gateau(String typeFarine, String typeBeurre,
            String typeRemplissage) {
        this.typeFarine = typeFarine;
        this.typeBeurre = typeBeurre;
        this.typeRemplissage = typeRemplissage;
    } */
    
    public void setFarine(String typeFarine) {
        this.typeFarine = typeFarine;
    }
    
    public void setBeurre(String typeBeurre) {
        this.typeBeurre = typeBeurre;
    }
    
    public void setRemplissage(String typeRemplissage) {
        this.typeRemplissage = typeRemplissage;
    }
    
    public String getFarine() {
        return typeFarine;
    }
    
    public String getBeurre() {
        return typeBeurre;
    }
    
    public String getRemplissage() {
        return typeRemplissage;
    }
    
    public int preparer() {
        System.out.println("PREPARATION");
        System.out.println("Mélanger la farine (" + typeFarine +
                ") avec la beurre (" + typeBeurre + ")...");
        System.out.println("Mettre du remplissage (" + typeRemplissage
                + ")...");
        System.out.println("Cuire...");
        
        return 0;
    }
}
