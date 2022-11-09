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

package boulangerie.factories;

import boulangerie.gateaux.Gateau;

/**
 *
 * @author selizondorod
 */
abstract public class GateauFactory {
    public static GateauFactory getFactory(String typeGateau) {
        if (typeGateau.equals("choux"))
            return new ChouxALaCremeFactory();
        if (typeGateau.equals("tarte"))
            return new TarteFactory();
        if (typeGateau.equals("pan de muerto"))
            return new PanDeMuertoFactory();
        return null;
    }
    
    public abstract Gateau createGateau(String complement);
}
