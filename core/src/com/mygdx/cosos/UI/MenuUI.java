package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.cosos.CoSOS;

public class MenuUI {
    private Stage stage;
    private TextButton buttonSpustit;
    private TextButton konecButton;
    private TextButton.TextButtonStyle buttonStyle;
    private BitmapFont font;
    private Skin skin;

    public MenuUI(Stage stage) {
        this.stage = stage;
        this.skin = new Skin();
        font = ManagerUI.setFont(font);
        createMenuUI();
    }

    private void createMenuUI() {
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;


        buttonSpustit = new TextButton("Spustit", buttonStyle);
        buttonSpustit.setPosition(Gdx.graphics.getWidth() / 2 - buttonSpustit.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 + 50 - buttonSpustit.getHeight() / 2);

        buttonSpustit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Button clicked!");
                CoSOS.StavHry = CoSOS.GameState.SETTINGS;
            }
        });
        stage.addActor(buttonSpustit);


        konecButton = new TextButton("Konec", buttonStyle);
        konecButton.setPosition(Gdx.graphics.getWidth() / 2 - konecButton.getWidth() / 2,
                (Gdx.graphics.getHeight() / 2 - konecButton.getHeight() / 2)-200);

        konecButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        stage.addActor(konecButton);

    }
}
