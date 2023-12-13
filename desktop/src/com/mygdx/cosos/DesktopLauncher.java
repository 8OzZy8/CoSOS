package com.mygdx.cosos;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.cosos.CoSOS;

import java.io.*;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) throws IOException {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("coSOS");
		Graphics.DisplayMode dm = Lwjgl3ApplicationConfiguration.getDisplayMode();
		File file = new File("config.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bread = new BufferedReader(fileReader);
		String radek = bread.readLine();
		System.out.println(radek);
		Boolean fullscreen = false;
		if(radek != null){
			String[] hodnoty = radek.split("=");
			hodnoty[1] = hodnoty[1].trim();

			if(hodnoty[1].equals("true")){

				fullscreen = true;
			}
		}
		if(fullscreen == true){
			config.setFullscreenMode(dm);
		}else {
			config.setWindowedMode(dm.width - (dm.width / 6), dm.height - (dm.height / 6));
		}
		new Lwjgl3Application(new CoSOS(), config);
	}
}
