package com.moltenwolfcub.circles.util.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BooleanStatedTexture implements StatedTexture<Boolean>{
    protected final TextureRegion whenTrue;
    protected final TextureRegion whenFalse;

    public BooleanStatedTexture(TextureRegion textureTrue, TextureRegion textureFalse) {
        this.whenTrue = textureTrue;
        this.whenFalse = textureFalse;
    }

    @Override
    public TextureRegion getTexture(Boolean state) {
        return state ? whenTrue : whenFalse;
    }

    @Override
    public String toString() {
        return String.format("BooleanStatedTexture with Textures[True: %s, False: %s]", this.whenTrue, this.whenFalse);
    }
}
