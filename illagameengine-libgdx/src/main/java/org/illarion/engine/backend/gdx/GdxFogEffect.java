/*
 * This file is part of the Illarion project.
 *
 * Copyright © 2014 - Illarion e.V.
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
package org.illarion.engine.backend.gdx;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import org.illarion.engine.graphic.effects.FogEffect;

import javax.annotation.Nonnull;

/**
 * The libGDX implementation of the fog effect.
 *
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
class GdxFogEffect implements FogEffect, GdxSceneEffect {
    /**
     * The pixel shader that is required for this effect.
     */
    @Nonnull
    private final ShaderProgram shader;

    /**
     * The density that was applied last.
     */
    private float density;

    GdxFogEffect(@Nonnull final Files files) {
        //noinspection SpellCheckingInspection
        shader = new ShaderProgram(files.internal("org/illarion/engine/backend/gdx/shaders/generic.vert"),
                                   files.internal("org/illarion/engine/backend/gdx/shaders/fog.frag"));
    }

    @Override
    public void setDensity(final float density) {
        this.density = density;
    }

    @Override
    public void update(final int delta) {
        // nothing to do
    }

    @Override
    public void activateEffect(
            @Nonnull final SpriteBatch batch,
            final int screenWidth,
            final int screenHeight,
            final int textureWidth,
            final int textureHeight) {
        batch.setShader(shader);
        shader.setUniformf("u_density", density);
        shader.setUniformf("u_center", (float) screenWidth / 2.f / (float) textureWidth,
                           (float) screenHeight / 2.f / (float) textureHeight);
    }

    @Override
    public void disableEffect(@Nonnull final SpriteBatch batch) {
        batch.setShader(null);
    }
}
