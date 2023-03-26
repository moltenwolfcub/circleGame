package com.moltenwolfcub.circles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.moltenwolfcub.circles.level.CircleManager;
import com.moltenwolfcub.circles.util.CircularClickable;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.texture.BooleanStatedTexture;

public class CircleTile extends CircularClickable {
    protected final CircleManager manager;
    protected final Integer id;

    protected Boolean isFilled;


    public CircleTile(CircleManager circleManager, Integer id) {
        super(
                Constants.CIRCLE_DIAMETER,
                new BooleanStatedTexture(
                    CircleGame.spriteTextureAtlas.findRegion("filledCircle"),
                    CircleGame.spriteTextureAtlas.findRegion("emptyCircle")
                ),
                circleManager.view
        );

        this.manager = circleManager;
        this.isFilled = false;
        this.id = id;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.sprite.setRegion(((BooleanStatedTexture)this.texture).getTexture(this.isFilled));

        super.draw(batch, parentAlpha);
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
        if (this.manager.isValidMove(this) && !this.isFilled) {
            this.manager.makeMove(this);
        }
    }

    public void fillCircle() {
        this.isFilled = true;
    }

    public Integer getId() {
        return id;
    }

    public void reset() {
        this.isFilled = false;
    }

    public boolean isEmpty() {
        return !isFilled;
    }
}
