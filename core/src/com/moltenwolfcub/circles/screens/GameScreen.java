package com.moltenwolfcub.circles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.util.Button;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.util.CircleManager;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.RestartButton;

public class GameScreen implements Screen {
    private final CircleGame game;
    private OrthographicCamera camera;
    public Viewport view;
    private Stage stage;

    public CircleManager circleManager;

    public GameScreen(CircleGame game) {
        this.game = game;

        setup();

        circleManager = new CircleManager(5, this.game, this.view);
        circleManager.getCircles().forEach(c -> this.stage.addActor(c));

        this.stage.addActor(new RestartButton(circleManager));
    }

    private void setup() {

		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false);
		this.view = new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT, this.camera);
        this.stage = new Stage(view, this.game.spriteBatch);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        tick(delta);
        draw();
    }
    private void draw() {
        ScreenUtils.clear(0, 0, 0, 0);
        this.stage.draw();
    }
    private void tick(float delta) {
        this.stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        this.view.update(width, height);
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }


    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void show() {

    }
    @Override
    public void hide() {

    }
}
