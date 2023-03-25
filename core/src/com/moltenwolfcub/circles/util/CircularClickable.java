package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.util.texture.StatedTexture;

public abstract class CircularClickable extends Actor {
    protected final Viewport view;

    protected final Sprite sprite;
    protected final StatedTexture<?> texture;

    protected final Circle hitbox;
    protected final Integer diameter;

    public CircularClickable(Integer diameter, StatedTexture<?> texture, Viewport viewport) {
        this.view = viewport;

        this.texture = texture;
        this.sprite = new Sprite(this.texture.getTexture());
        this.sprite.setBounds(0, 0, diameter, diameter);

        this.diameter = diameter;
        this.hitbox = new Circle(0, 0, this.diameter/2.0f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.sprite.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        this.clickListener();
    }

    private void clickListener() {
        if (Gdx.input.justTouched()) {
            Vector3 mousePos = this.view.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (this.hitbox.contains(mousePos.x, mousePos.y)) {
                this.handleClick();
            }
        }
    }

    public abstract void handleClick();

    public void positionSprite(float x, float y) {
        this.sprite.setCenter(x, y);
        this.hitbox.setPosition(x, y);
    }
}
