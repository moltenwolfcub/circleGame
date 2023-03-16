package com.moltenwolfcub.circles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.moltenwolfcub.circles.screens.GameScreen;

public class CircleGame extends Game {
    public static TextureAtlas spriteTextureAtlas;
	public SpriteBatch spriteBatch;
	
	@Override
	public void create() {
		spriteTextureAtlas = new TextureAtlas("main/atlases/spriteTextureMap.atlas");
		spriteBatch = new SpriteBatch();

		setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		spriteBatch.dispose();
	}
}
