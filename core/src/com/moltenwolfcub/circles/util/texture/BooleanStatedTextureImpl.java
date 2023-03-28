package com.moltenwolfcub.circles.util.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BooleanStatedTextureImpl implements StatedTextureImpl<Boolean> {
    private final BooleanStatedTexture texture;
    private boolean state;

    public BooleanStatedTextureImpl(boolean state, TextureRegion whenTrue, TextureRegion whenFalse) {
        this.state = state;
        this.texture = new BooleanStatedTexture(whenTrue, whenFalse);
    }

    @Override
    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public Boolean getCurrentState() {
        return state;
    }

    @Override
    public TextureRegion getTexture() {
        return texture.getTexture(this.state);
    }
}
