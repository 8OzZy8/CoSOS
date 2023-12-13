package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Disposable;  // Add this import statement
import com.mygdx.cosos.CoSOS;

public class SettingsUI  {
    private Stage stageSet;
    private BitmapFont font;
    private Table table;
    private Skin skin;
    private TextButton buttonSpustit;
    private TextButton buttonAdmin;
    private TextButton menu;
    private TextButton.TextButtonStyle buttonStyle;

    public SettingsUI(Stage stageSet) {
        this.stageSet = stageSet;
        font = ManagerUI.setFont(font);
        drawSettings();
    }

    private void drawSettings() {
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;


        menu = new TextButton("Menu", buttonStyle);
        menu.setPosition(200, Gdx.graphics.getHeight() - 200);

        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("dad");
                CoSOS.StavHry = CoSOS.GameState.MENU;
            }
        });
        stageSet.addActor(menu);

    }

}
