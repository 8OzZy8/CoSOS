	package com.mygdx.cosos;

	import com.badlogic.gdx.ApplicationAdapter;
	import com.badlogic.gdx.Gdx;
	import com.badlogic.gdx.graphics.GL20;
	import com.badlogic.gdx.graphics.Texture;
	import com.badlogic.gdx.graphics.g2d.BitmapFont;
	import com.badlogic.gdx.graphics.g2d.SpriteBatch;
	import com.badlogic.gdx.scenes.scene2d.InputEvent;
	import com.badlogic.gdx.scenes.scene2d.Stage;
	import com.badlogic.gdx.scenes.scene2d.ui.Skin;
	import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
	import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
	import com.badlogic.gdx.utils.ScreenUtils;
	import com.mygdx.cosos.UI.MenuUI;
	import com.mygdx.cosos.UI.SettingsUI;

	public class CoSOS extends ApplicationAdapter {
		SpriteBatch batch;
		private Texture img;
		private Stage stage;
		private Stage stageSet;
		private TextButton buttonSpustit;
		private TextButton.TextButtonStyle buttonStyle;
		private BitmapFont font;
		private MenuUI menuUI;

		private SettingsUI settingsUI;
		public enum GameState {
			MENU,
			SETTINGS,
			GAME,
		}
		public static GameState StavHry;

		@Override
		public void create () {
			batch = new SpriteBatch();
			stage = new Stage();
			stageSet = new Stage();
			StavHry = CoSOS.GameState.MENU;
			Gdx.input.setInputProcessor(stage);
			font = new BitmapFont();
			menuUI = new MenuUI(stage);
			settingsUI = new SettingsUI(stageSet);

		}

		@Override
		public void render () {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
			switch(StavHry){
				case MENU:
					stage.draw();
					break;
				case SETTINGS:

					stageSet.draw();
					break;
			}

		}

		@Override
		public void dispose () {
			batch.dispose();
			stage.dispose();
			stageSet.dispose();
			font.dispose();
		}
	}
