package com.moltenwolfcub.circles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.moltenwolfcub.circles.screens.GameScreen;

public class CircleGame extends Game {
    public static TextureAtlas spriteTextureAtlas;
	public SpriteBatch spriteBatch;
	
	@Override
	public void create() {
		try {
			spriteTextureAtlas = new TextureAtlas("main/atlases/spriteTextureMap.atlas");
		} catch (GdxRuntimeException exception) {
			System.out.println("""
				[WARNING] Something went wrong when loading the spriteTextureAtlas. \
				Continuing Silently as it is presumed that the texture atlas is empty.
				""");
			boolean debugInfo = false;
			if (debugInfo) {
				exception.printStackTrace();
			}
		}
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
