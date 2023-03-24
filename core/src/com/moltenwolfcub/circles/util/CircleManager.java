package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.CircleTile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleManager {
    protected Map<Integer, CircleTile> circles;
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
        return circles.values().stream().toList();
    }

    public void reset() {
        this.moveRules = new MoveRuleSet(2, 4);
        this.lastSelected = 0;
        this.circles.values().forEach(CircleTile::reset);
        this.circles.get(0).fillCircle();
    }

    public List<CircleTile> getValidMoves() {
        return moveRules.getValidMoves(lastSelected).stream().map(x -> this.circles.get(x)).toList();
    }

    public boolean isValidMove(CircleTile tile) {
        return this.getValidMoves().contains(tile);
    }

    public void makeMove(CircleTile tile) {
        tile.fillCircle();
        this.lastSelected = tile.getId();
    }
}
