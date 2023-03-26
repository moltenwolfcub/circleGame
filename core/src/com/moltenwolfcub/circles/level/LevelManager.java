package com.moltenwolfcub.circles.level;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.moltenwolfcub.circles.CircleTile;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private final Stage stage;

    private final List<Level> levels;
    private Integer currentLvl = 0;

    public LevelManager(Stage stage) {
        this.stage = stage;
        this.levels = new ArrayList<>();
    }

    public void addLevel(Level lvl) {
        this.levels.add(lvl);
    }

    public Level getCurrent() {
        return this.levels.get(this.currentLvl);
    }

    public void load() {
        this.load(this.currentLvl);
    }

    public void loadNext() {
        this.load(++this.currentLvl);
    }

    public void load(Integer lvlId) {
        boolean levelLoaded = false;
        for (Actor actor : this.stage.getActors().items) {
            if (actor instanceof CircleTile) {
                levelLoaded = true;
                break;
            }
        }

        if (lvlId.equals(currentLvl) && levelLoaded) {
            this.getCurrent().reset();
        } else {
            this.getCurrent().unLoad();
            this.currentLvl = lvlId;
            Level next = this.getCurrent();
            next.load(this.stage);
        }
    }
}