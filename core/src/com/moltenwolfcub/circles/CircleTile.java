package com.moltenwolfcub.circles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.util.CircleManager;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.texture.BooleanStatedTexture;

public class CircleTile extends Actor implements Disposable {
    protected final CircleManager manager;
    protected final Sprite sprite;
    protected final BooleanStatedTexture texture;
    protected final Integer id;
    protected final Circle hitbox;

    protected boolean isFilled;


    public CircleTile(CircleManager circleManager, Integer id) {
        this.manager = circleManager;
        this.isFilled = false;
        this.hitbox = new Circle(0, 0, Constants.CIRCLE_DIAMETER/2.0f);
        this.id = id;

        this.texture = new BooleanStatedTexture(
            CircleGame.spriteTextureAtlas.findRegion("filledCircle"),
            CircleGame.spriteTextureAtlas.findRegion("emptyCircle")
        );

        this.sprite = new Sprite(this.texture.getTexture());
        this.sprite.setBounds(0, 0, Constants.CIRCLE_DIAMETER, Constants.CIRCLE_DIAMETER);

        float paddingSize = Constants.VIEWPORT_WIDTH/(float)Constants.CIRCLES_PADDING;
        float usableWidth = Constants.VIEWPORT_WIDTH-paddingSize*2;
        float x = usableWidth/5.0f*(this.id+0.5f) + paddingSize;
        this.positionSprite(x, Constants.VIEWPORT_HEIGHT/2.0f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.sprite.setRegion(this.texture.getTexture(this.isFilled));

        this.sprite.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        handleInput();
    }

    @Override
    public void dispose() {
    }

    public void positionSprite(float x, float y) {
        this.sprite.setCenter(x, y);
        this.hitbox.setPosition(x, y);
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 mousePos = this.manager.view.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (this.hitbox.contains(mousePos.x, mousePos.y)) {
                this.handleClick();
            }
        }
    }

    private void handleClick() {
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
}
