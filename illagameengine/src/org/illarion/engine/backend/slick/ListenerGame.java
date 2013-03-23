/*
 * This file is part of the Illarion Game Engine.
 *
 * Copyright © 2013 - Illarion e.V.
 *
 * The Illarion Game Engine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Illarion Game Engine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the Illarion Game Engine.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.illarion.engine.backend.slick;

import org.illarion.engine.GameListener;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import javax.annotation.Nonnull;

/**
 * This is the game implementation for Slick2D that is reporting to a default game listener.
 *
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
class ListenerGame implements Game {
    /**
     * The listener that this game implementation reports to.
     */
    @Nonnull
    private final GameListener listener;

    @Nonnull
    private org.illarion.engine.GameContainer engineContainer;

    /**
     * Create a new implementation of this game and set the listener that receives the game lifecycle.
     *
     * @param gameListener the game listener that receives the updates
     */
    ListenerGame(@Nonnull final GameListener gameListener) {
        listener = gameListener;
    }

    public void setEngineContainer(@Nonnull final org.illarion.engine.GameContainer engineContainer) {
        this.engineContainer = engineContainer;
    }

    @Override
    public void init(final GameContainer gameContainer) throws SlickException {
        listener.create(engineContainer);
    }

    @Override
    public void update(final GameContainer gameContainer, final int delta) throws SlickException {
        listener.update(engineContainer, delta);
    }

    @Override
    public void render(final GameContainer gameContainer, final Graphics graphics) throws SlickException {
        final SlickGraphics slickGraphics = (SlickGraphics) engineContainer.getEngine().getGraphics();
        slickGraphics.setSlickGraphicsImpl(graphics);
        listener.render(engineContainer);
        slickGraphics.clearSlickGraphicsImpl();
    }

    @Override
    public boolean closeRequested() {
        return listener.isClosingGame();
    }

    @Override
    public String getTitle() {
        return engineContainer.getTitle();
    }
}
