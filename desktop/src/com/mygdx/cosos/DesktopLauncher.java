package com.mygdx.cosos;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.cosos.CoSOS;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("coSOS");
		Graphics.DisplayMode dm = Lwjgl3ApplicationConfiguration.getDisplayMode();
		config.setWindowedMode(dm.width-(dm.width/6),dm.height-(dm.height/6));
		new Lwjgl3Application(new CoSOS(), config);
	}
}
