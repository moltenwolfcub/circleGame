package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.CircleTile;
import com.moltenwolfcub.circles.util.texture.StatedTexture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CircleManager {
    protected final Map<Integer, CircleTile> circles;
    protected MoveRuleSet moveRules;
    protected Integer lastSelected;

    public final CircleGame game;
    public final Viewport view;

    public CircleManager(Integer circleCount, CircleGame game, Viewport view) {
        this.game = game;
        this.view = view;

        this.circles = new HashMap<>();

        for (int i = 0; i < circleCount; i++) {
            CircleTile c = new CircleTile(this, i);
            this.circles.put(i, c);
        }
        this.reset();
    }

    public List<CircleTile> getCircles() {
        return new ArrayList<>(circles.values());
    }

    public void reset() {
        this.moveRules = new MoveRuleSet(2, 4);
        this.lastSelected = 0;
        this.circles.values().forEach(CircleTile::reset);
        this.circles.get(0).fillCircle();
    }

    public List<CircleTile> getValidMoves() {
        return moveRules.getValidMoves(lastSelected).stream().map(this.circles::get).collect(Collectors.toList());
    }

    public boolean isValidMove(CircleTile tile) {
        return this.getValidMoves().contains(tile);
    }

    public void makeMove(CircleTile tile) {
        tile.fillCircle();
        this.lastSelected = tile.getId();
    }
}
