package com.moltenwolfcub.circles;

import java.util.Arrays;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.moltenwolfcub.circles.util.Constants;

public class DesktopLauncher {
	public static void main (String[] args) {
		if(Arrays.stream(args).anyMatch("pack"::equals)) {
			packTextures();
		}

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		config.setTitle("Circle Game");
		new Lwjgl3Application(new CircleGame(), config);
	}

	private static void packTextures() {
		TexturePacker.process("main/textures", "main/atlases", "spriteTextureMap.atlas");
	}
}
