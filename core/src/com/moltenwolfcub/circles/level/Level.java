package com.moltenwolfcub.circles.level;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleTile;
import com.moltenwolfcub.circles.util.MoveRuleSet;

public class Level {
    private final CircleManager manager;

    public Level(Viewport view, int size, MoveRuleSet initialRules) {
        this.manager = new CircleManager(size, view, initialRules);
    }

    public void load(Stage stage) {
        this.manager.getCircles().forEach(stage::addActor);
    }

    public void reset() {
        this.manager.reset();
    }

    public void unLoad() {
        this.manager.reset();
        this.manager.getCircles().forEach(Actor::remove);
    }

    public boolean isComplete() {
        return this.manager.getCircles().stream().noneMatch(CircleTile::isEmpty);
    }
    public boolean isStuck() {
        return this.manager.getValidMoves().isEmpty();
    }

    public CircleManager getManager() {
        return manager;
    }
}
