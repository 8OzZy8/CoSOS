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

	public class CoSOS extends ApplicationAdapter {
		SpriteBatch batch;
		private Texture img;
		private Stage stage;
		private Stage AdminStage;
		private TextButton buttonSpustit;
		private TextButton.TextButtonStyle buttonStyle;
		private BitmapFont font;
		private MenuUI menuUI;

		public enum GameState {
			MENU,
			ADMIN,
			GAME,
		}
		public static GameState StavHry;

		@Override
		public void create () {
			batch = new SpriteBatch();
			stage = new Stage();
			AdminStage = new Stage();
			StavHry = CoSOS.GameState.MENU;
			Gdx.input.setInputProcessor(stage);
			font = new BitmapFont();
			menuUI = new MenuUI(stage);

		}

		@Override
		public void render () {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
			if(StavHry == GameState.MENU) {
				stage.draw();
			}else if(StavHry == GameState.ADMIN) {
				AdminStage.draw();
			}

		}

		@Override
		public void dispose () {
			batch.dispose();
			stage.dispose();
			AdminStage.dispose();
			font.dispose();
		}
	}
