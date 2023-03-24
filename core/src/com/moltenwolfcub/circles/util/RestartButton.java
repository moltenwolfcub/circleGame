package com.moltenwolfcub.circles.util;

public class RestartButton extends Button{

    protected final CircleManager manager;

    public RestartButton(CircleManager manager) {
        super(manager.view);
        this.manager = manager;
    }

    @Override
    public void handleClick() {
        this.manager.reset();
    }
}
