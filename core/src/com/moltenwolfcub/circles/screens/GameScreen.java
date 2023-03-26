package com.moltenwolfcub.circles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.moltenwolfcub.circles.CircleGame;
import com.moltenwolfcub.circles.level.Level;
import com.moltenwolfcub.circles.level.LevelManager;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.RestartButton;

public class GameScreen implements Screen {
    private final CircleGame game;
    public Viewport view;
    private Stage stage;

    public GameScreen(CircleGame game) {
        this.game = game;

        setup();

        LevelManager lvlManage = new LevelManager(this.stage);
        lvlManage.addLevel(new Level(this.view));
        lvlManage.load();

        this.stage.addActor(new RestartButton(lvlManage, this.view));
    }

    private void setup() {

        OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false);
		this.view = new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT, camera);
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
