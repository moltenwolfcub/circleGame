package com.moltenwolfcub.circles.tile;

import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.level.CircleManager;
import com.moltenwolfcub.circles.util.texture.BooleanStatedTextureImpl;

public class BasicCircleTile extends CircleTile<Boolean> {

    public BasicCircleTile(CircleManager circleManager, Integer id) {
        super(circleManager,
        new BooleanStatedTextureImpl(
                false,
                CircleGame.spriteTextureAtlas.findRegion("filledCircle"),
                CircleGame.spriteTextureAtlas.findRegion("emptyCircle")
        ), id);
    }

    @Override
    public void fillCircle() {
        this.texture.setState(true);
    }

    @Override
    public void reset() {
        this.texture.setState(false);
    }

    @Override
    public boolean isIncomplete() {
        return !this.texture.getCurrentState();
    }
}
