package com.moltenwolfcub.circles.level;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.tile.BasicCircleTile;
import com.moltenwolfcub.circles.tile.CircleTile;
import com.moltenwolfcub.circles.util.MoveRuleSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CircleManager {
    protected final Map<Integer, CircleTile<?>> circles;
    protected final MoveRuleSet moveRules;
    protected Integer lastSelected;

    public final Viewport view;

    public CircleManager(Integer circleCount, Viewport view, MoveRuleSet rules) {
        this.view = view;
        this.moveRules = rules;

        this.circles = new HashMap<>();

        for (int i = 0; i < circleCount; i++) {
            BasicCircleTile c = new BasicCircleTile(this, i);
            this.circles.put(i, c);
        }
        this.reset();
    }

    public List<CircleTile<?>> getCircles() {
        return new ArrayList<>(this.circles.values());
    }

    public int size() {
        return getCircles().size();
    }

    public void reset() {
        this.lastSelected = 0;
        this.circles.values().forEach(CircleTile::reset);
        this.circles.get(0).fillCircle();
    }

    public List<CircleTile<?>> getValidMoves() {
        return this.moveRules.getValidMoves(lastSelected).stream().map(this.circles::get).collect(Collectors.toList());
    }

    public boolean isValidMove(CircleTile<?> tile) {
        return this.getValidMoves().contains(tile);
    }

    public void makeMove(CircleTile<?> tile) {
        tile.fillCircle();
        this.lastSelected = tile.getId();
    }

    public MoveRuleSet getRules() {
        return moveRules;
    }
}
