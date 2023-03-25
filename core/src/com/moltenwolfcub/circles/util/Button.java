package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.util.texture.ConstantStatedTexture;

public abstract class Button extends CircularClickable {

    public Button(Viewport view) {
        super(48, new ConstantStatedTexture(CircleGame.spriteTextureAtlas.findRegion("filledCircle")), view);
    }
}
