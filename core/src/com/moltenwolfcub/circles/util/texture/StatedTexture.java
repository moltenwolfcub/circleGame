package com.moltenwolfcub.circles.util.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface StatedTexture<T> {

    TextureRegion getTexture(T state);
}
