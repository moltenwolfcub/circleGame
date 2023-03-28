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
import com.moltenwolfcub.circles.data.LevelSerialization;
import com.moltenwolfcub.circles.util.Constants;
import com.moltenwolfcub.circles.util.RestartButton;

public class GameScreen implements Screen {
    private final CircleGame game;
    private LevelManager levelManager;
    public Viewport view;
    private Stage stage;

    public GameScreen(CircleGame game) {
        this.game = game;

        this.setup();
        this.initializeLevel();


        this.stage.addActor(new RestartButton(levelManager, this.view));
    }
    private void setup() {

        OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false);
		this.view = new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT, camera);
        this.stage = new Stage(view, this.game.spriteBatch);
        Gdx.input.setInputProcessor(stage);
    }
    private void initializeLevel() {
        this.levelManager = new LevelManager(this.stage);
        LevelSerialization.readAll(this.view).forEach(this.levelManager::addLevel);
        this.levelManager.load();

        LevelSerialization.clearData();
        for (int id = 0; id < this.levelManager.getLevels().size(); id++) {
            LevelSerialization.write(this.levelManager.getLevels().get(id), id);
        }
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
        this.levelManager.update();
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
