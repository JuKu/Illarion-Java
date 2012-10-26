/*
 * This file is part of the Illarion Mapeditor.
 *
 * Copyright © 2012 - Illarion e.V.
 *
 * The Illarion Mapeditor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Illarion Mapeditor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the Illarion Mapeditor.  If not, see <http://www.gnu.org/licenses/>.
 */
package illarion.mapedit.tools;

import illarion.mapedit.data.Map;
import illarion.mapedit.tools.panel.SettingsChangedListener;
import org.apache.log4j.Logger;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;

import javax.swing.*;

/**
 * @author Tim
 */
public abstract class AbstractTool implements SettingsChangedListener {

    protected static final Logger LOGGER = Logger.getLogger(AbstractTool.class);

    private ToolManager manager;

    /**
     * X and Y are tile coordinates.
     *
     * @param x
     * @param y
     */
    public abstract void clickedAt(int x, int y, Map map);

    public abstract String getLocalizedName();

    public abstract ResizableIcon getToolIcon();

    public abstract JPanel getSettingsPanel();

    public final void registerManager(final ToolManager toolManager) {
        manager = toolManager;
    }


    protected final ToolManager getManager() {
        return manager;
    }

    @Override
    public void settingsChanged() {

    }
}
