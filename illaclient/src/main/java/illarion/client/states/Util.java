/*
 * This file is part of the Illarion project.
 *
 * Copyright © 2015 - Illarion e.V.
 *
 * Illarion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Illarion is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package illarion.client.states;

import de.lessvoid.nifty.Nifty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

/**
 * This utility class is used to load the game state stuff.
 *
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
final class Util {
    /**
     * The logger that is used for the logging output of this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    private Util() {
    }

    /**
     * Load the XML file after validating its contents.
     *
     * @param nifty the instance of Nifty the files are supposed to be applied to
     * @param xmlFile the XML file that is supposed to be load
     */
    public static void loadXML(@Nonnull Nifty nifty, @Nonnull String xmlFile) {
        try {
            nifty.validateXml(xmlFile);
        } catch (Throwable e) {
            LOGGER.error("Validation of the XML file \"{}\" failed.", xmlFile, e);
        }
        nifty.addXml(xmlFile);
    }
}
