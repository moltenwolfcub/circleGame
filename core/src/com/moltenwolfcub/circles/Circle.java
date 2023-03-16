package com.moltenwolfcub.circles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.moltenwolfcub.circles.util.Constants;

public class Circle extends Actor implements Disposable {
    protected final CircleGame game;
    protected final Sprite sprite;
    protected final Texture emptyTexture;
    protected final Texture filledTexture;

    protected boolean isFilled;


    public Circle(CircleGame game) {
        this.game = game;
        this.isFilled = false;


        Pixmap filled = new Pixmap(Constants.CIRCLE_DIAMETER, Constants.CIRCLE_DIAMETER, Pixmap.Format.RGBA8888);
        filled.setColor(Color.WHITE);
        filled.fillCircle(filled.getWidth()/2, filled.getHeight()/2, filled.getWidth()/2-1);
        this.filledTexture = new Texture(filled);
        filled.dispose();

        Pixmap empty = new Pixmap(Constants.CIRCLE_DIAMETER, Constants.CIRCLE_DIAMETER, Pixmap.Format.RGBA8888);
        empty.setColor(Color.WHITE);
        empty.drawCircle(empty.getWidth()/2, empty.getHeight()/2, empty.getWidth()/2-1);
        this.emptyTexture = new Texture(empty);
        empty.dispose();

        this.sprite = new Sprite(this.emptyTexture);
        this.sprite.setCenter(Constants.VIEWPORT_WIDTH/2.0f, Constants.VIEWPORT_HEIGHT/2.0f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.sprite.setTexture(isFilled ? filledTexture : emptyTexture);
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
        this.filledTexture.dispose();
        this.emptyTexture.dispose();
    }
}
