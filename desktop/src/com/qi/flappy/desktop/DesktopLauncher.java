package com.qi.flappy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.qi.flappy.MyFlappy;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = MyFlappy.WIDTH;
		config.height = MyFlappy.HEIGHT;
		config.title = MyFlappy.TITLE;

		new LwjglApplication(new MyFlappy(), config);
	}
}
