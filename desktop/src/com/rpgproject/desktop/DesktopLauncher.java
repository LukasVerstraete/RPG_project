package com.rpgproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rpgproject.RPGGame;

public class DesktopLauncher {

	private static int width = 800;
	private static int height = 450;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DesktopLauncher.width;
		config.height = DesktopLauncher.height;
		new LwjglApplication(new RPGGame(), config);
	}
}
