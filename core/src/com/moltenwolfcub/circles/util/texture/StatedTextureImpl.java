package com.moltenwolfcub.circles.util.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface StatedTextureImpl<T> {

    void setState(T state);

    T getCurrentState();

    TextureRegion getTexture();
}
