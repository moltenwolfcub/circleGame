package com.moltenwolfcub.circles.util;

import java.util.ArrayList;
import java.util.List;

public class MoveRuleSet {
    public final Integer defaultJumpMax;
    public final Integer defaultJumpMin;
    protected Integer maxJumpSize;
    protected Integer minJumpSize;

    public MoveRuleSet(Integer min, Integer max) {
        this.defaultJumpMax = max;
        this.defaultJumpMin = min;
        this.maxJumpSize = this.defaultJumpMax;
        this.minJumpSize = this.defaultJumpMin;
    }

    public List<Integer> getValidMoves(Integer origin) {
        if (origin<0) {
            throw new IllegalArgumentException("Can't have a negative tile id");
        }

        List<Integer> valid = new ArrayList<>();
        for (int i = origin+this.minJumpSize; i <= origin+this.maxJumpSize; i++) {
            if (i > -1) {
                valid.add(i);
            }
        }
        for (int i = origin-this.minJumpSize; i >= origin-this.maxJumpSize; i--) {
            if (i > -1) {
                valid.add(i);
            }
        }
        return valid;
    }
}
