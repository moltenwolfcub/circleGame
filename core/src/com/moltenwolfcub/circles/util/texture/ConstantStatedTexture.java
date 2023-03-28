package com.moltenwolfcub.circles.util.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ConstantStatedTexture implements StatedTexture<Void>, StatedTextureImpl<Void> {
    protected final TextureRegion texture;
    
    public ConstantStatedTexture(TextureRegion texture) {
        this.texture = texture;
    }

    @Override
    public TextureRegion getTexture() {
        return texture;
    }

    @Override
    public TextureRegion getTexture(Void state) {
        throw new UnsupportedOperationException("This method shouldn't be called. Use the one with no parameters");
    }

    
    @Override
    public String toString() {
        return String.format("ConstantStatedTexture of Texture [%s]", this.texture);
    }


    @Override
    public void setState(Void state) {
    }

    @Override
    public Void getCurrentState() {
        return null;
    }
}
