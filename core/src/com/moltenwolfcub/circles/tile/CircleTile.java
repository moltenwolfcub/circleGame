package com.moltenwolfcub.circles.tile;

import com.moltenwolfcub.circles.level.CircleManager;
import com.moltenwolfcub.circles.util.CircularClickable;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.texture.StatedTextureImpl;

public abstract class CircleTile<T> extends CircularClickable<T> {
    protected final CircleManager manager;
    protected final Integer id;



    public CircleTile(CircleManager circleManager, StatedTextureImpl<T> texture, Integer id) {
        super(Constants.CIRCLE_DIAMETER, texture, circleManager.view);

        this.manager = circleManager;
        this.id = id;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float paddingSize = Constants.VIEWPORT_WIDTH/(float)Constants.CIRCLES_PADDING;
        float usableWidth = Constants.VIEWPORT_WIDTH-paddingSize*2;
        float x = usableWidth/this.manager.size()*(this.id+0.5f) + paddingSize;
        this.positionSprite(x, Constants.VIEWPORT_HEIGHT/2.0f);
    }

    protected void handleClick() {
        if (this.manager.isValidMove(this) && this.isIncomplete()) {
            this.manager.makeMove(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public abstract void fillCircle();
    public abstract void reset();
    public abstract boolean isIncomplete();
}
