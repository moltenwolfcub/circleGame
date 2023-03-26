package com.moltenwolfcub.circles.level;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Level {
    private final CircleManager circles;

    public Level(Viewport view) {
        this.circles = new CircleManager(5, view);
    }

    public void load(Stage stage) {
        this.circles.getCircles().forEach(stage::addActor);
    }

    public void reset() {
        this.circles.reset();
    }

    public void unLoad() {
        this.circles.getCircles().forEach(Actor::remove);
    }
}
