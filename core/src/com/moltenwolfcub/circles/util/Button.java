package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.util.texture.ConstantStatedTexture;

public abstract class Button extends Actor implements Disposable {
    protected static final Integer diameter = 48;
    protected static final Integer padding = 10;

    protected final Viewport view;

    protected final ConstantStatedTexture texture;
    protected final Sprite sprite;
    protected final Circle hitbox;


    public Button(Viewport view) {
        this.view = view;

        this.texture = new ConstantStatedTexture(CircleGame.spriteTextureAtlas.findRegion("filledCircle"));
        this.sprite = new Sprite(this.texture.getTexture());
        this.hitbox = new Circle(0, 0, diameter/2.0f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.sprite.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.sprite.setBounds(0, 0, diameter, diameter);
        this.sprite.setPosition(Constants.VIEWPORT_WIDTH-(diameter+padding), Constants.VIEWPORT_HEIGHT-(diameter+padding));
        this.hitbox.setPosition(this.sprite.getWidth()/2+this.sprite.getX(), this.sprite.getHeight()/2+this.sprite.getY());

        if (Gdx.input.justTouched()) {
            Vector3 mousePos = this.view.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (this.hitbox.contains(mousePos.x, mousePos.y)) {
                this.handleClick();
            }
        }
    }

    public abstract void handleClick();

    @Override
    public void dispose() {

    }
}
