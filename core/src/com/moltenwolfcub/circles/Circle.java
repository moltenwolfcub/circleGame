package com.moltenwolfcub.circles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.texture.BooleanStatedTexture;

public class Circle extends Actor implements Disposable {
    protected final CircleGame game;
    protected final Sprite sprite;
    protected final BooleanStatedTexture texture;

    protected boolean isFilled;


    public Circle(CircleGame game) {
        this.game = game;
        this.isFilled = false;

        this.texture = new BooleanStatedTexture(
            CircleGame.spriteTextureAtlas.findRegion("filledCircle"),
            CircleGame.spriteTextureAtlas.findRegion("emptyCircle")
        );

        this.sprite = new Sprite(this.texture.getTexture(this.isFilled));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.sprite.setBounds(0, 0, Constants.CIRCLE_DIAMETER, Constants.CIRCLE_DIAMETER);
        this.sprite.setCenter(Constants.VIEWPORT_WIDTH/2.0f, Constants.VIEWPORT_HEIGHT/2.0f);
        this.sprite.setRegion(this.texture.getTexture(this.isFilled));
        this.sprite.draw(this.game.spriteBatch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Gdx.input.justTouched()) {
            this.isFilled = !this.isFilled;
        }
    }

    @Override
    public void dispose() {
    }
}
