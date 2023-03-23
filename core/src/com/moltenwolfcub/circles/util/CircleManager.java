package com.moltenwolfcub.circles.util;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.CircleTile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleManager {
    public Map<Integer, CircleTile> circles;

    public CircleManager(Integer circleCount, CircleGame game, Viewport view) {
        this.circles = new HashMap<>();

        for (int i = 0; i < circleCount; i++) {
            CircleTile c = new CircleTile(game, view, i);
            this.circles.put(i, c);
        }
    }

    public List<CircleTile> getCircles() {
        return circles.values().stream().toList();
    }
}
