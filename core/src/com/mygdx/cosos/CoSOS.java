	package com.mygdx.cosos;

	import com.badlogic.gdx.ApplicationAdapter;
	import com.badlogic.gdx.Game;
	import com.badlogic.gdx.Gdx;
	import com.badlogic.gdx.audio.Sound;
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
	import com.mygdx.cosos.Tym.Tym;
	import com.mygdx.cosos.UI.GameUI;
	import com.mygdx.cosos.UI.MenuUI;
	import com.mygdx.cosos.UI.SettingsUI;

	public class CoSOS extends ApplicationAdapter {
		SpriteBatch batch;
		private Texture img;
		private Stage stage;
		private Stage stageSet;
		private Stage stageGame;//da
		private TextButton buttonSpustit;
		private TextButton.TextButtonStyle buttonStyle;
		private BitmapFont font;
		private MenuUI menuUI;

		private GameUI gameUI;

		public static int pocetTymu = 4;

		private static Sound IntroMusic;

		public static boolean reset = false;

		public static Tym[] Tymy = new Tym[4];
		private SettingsUI settingsUI;
		public static boolean IntroAnim = false;
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
			stageGame = new Stage();
			StavHry = CoSOS.GameState.MENU;
			Gdx.input.setInputProcessor(stage);
			font = new BitmapFont();
			menuUI = new MenuUI(stage);
			gameUI = new GameUI(stageGame, batch);
			settingsUI = new SettingsUI(stageSet);
			IntroMusic = Gdx.audio.newSound(Gdx.files.internal("Audio/CoSOSIntro.mp3"));
			pocetTymu = 4;

		}
		public static void SetGame(String tym1, String tym2, String tym3, String tym4){
			switch (pocetTymu){
				case 2:
					Tymy[0] = new Tym(tym1,0);
					Tymy[1] = new Tym(tym2,0);
					break;
				case 3:
					Tymy[0] = new Tym(tym1,0);
					Tymy[1] = new Tym(tym2,0);
					Tymy[2] = new Tym(tym3,0);
					break;
				case 4:
					Tymy[0] = new Tym(tym1,0);
					Tymy[1] = new Tym(tym2,0);
					Tymy[2] = new Tym(tym3,0);
					Tymy[3] = new Tym(tym4,0);
					break;
			}
			IntroMusic.play(0.5f);

		}
		public static void stopMusic(){
			IntroMusic.stop();
		}
		@Override
		public void render () {
			Gdx.gl.glClearColor(0f, 0f, 42f / 255f, 0.9f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
			if(reset == true){
				gameUI.resetAnimation();
				reset = false;
			}
			switch(StavHry){
				case MENU:
					stage.draw();
					Gdx.input.setInputProcessor(stage);
					break;
				case SETTINGS:
					stageSet.draw();
					Gdx.input.setInputProcessor(stageSet);
					break;
				case GAME:

					stageGame.draw();
					Gdx.input.setInputProcessor(stageGame);
					gameUI.update(Gdx.graphics.getDeltaTime());
					break;
			}

		}

		@Override
		public void dispose () {
			batch.dispose();
			stage.dispose();
			IntroMusic.dispose();
			stageSet.dispose();
			font.dispose();
		}
	}
