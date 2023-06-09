package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.level.LevelManager;

public class RestartButton extends Button {
    protected static final Integer padding = 10;

    protected final LevelManager manager;

    public RestartButton(LevelManager manager, Viewport view) {
        super(view);
        this.manager = manager;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        this.positionSprite(
                Constants.VIEWPORT_WIDTH-(diameter+padding)+this.sprite.getWidth()/2,
                Constants.VIEWPORT_HEIGHT-(diameter+padding)+this.sprite.getHeight()/2
        );
    }

    @Override
    public void handleClick() {
        this.manager.load();
    }
}
