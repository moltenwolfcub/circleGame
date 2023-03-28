package com.moltenwolfcub.circles.level;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.moltenwolfcub.circles.tile.CircleTile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelManager {
    private final Stage stage;

    private final List<Level> levels;
    private Integer currentLvl = 0;

    public LevelManager(Stage stage) {
        this.stage = stage;
        this.levels = new ArrayList<>();
    }
//
    public void update() {
        if (this.getCurrent().isComplete()) {
            this.loadNext();
        }
    }

    public void addLevel(Level lvl) {
        this.levels.add(lvl);
    }

    public Level getCurrent() {
        return this.levels.get(this.currentLvl);
    }

    public List<Level> getLevels() {
        return List.copyOf(levels);
    }

    public void load() {
        this.load(this.currentLvl);
    }

    public void loadNext() {
        this.load(this.currentLvl+1);
    }

    public void load(Integer lvlId) {
        if (lvlId >= levels.size()) {
            lvlId = 0;
        }

        boolean levelLoaded = Arrays.stream(this.stage.getActors().items).anyMatch(c -> c instanceof CircleTile);

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
