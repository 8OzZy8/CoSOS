package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.cosos.CoSOS;

public class MenuUI {
    private Stage stage;
    private TextButton buttonSpustit;
    private TextButton buttonAdmin;
    private TextButton konecButton;
    private TextButton.TextButtonStyle buttonStyle;
    private BitmapFont font;

    public MenuUI(Stage stage) {
        this.stage = stage;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/BebasNeue-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        parameter.characters =  parameter.characters  + "ěščřžýáíéĚŠČŘŽÝÁÍÉ"; // přidejte všechny znaky, které chcete zahrnout
        font = generator.generateFont(parameter);
        generator.dispose();


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
            }
        });
        stage.addActor(buttonSpustit);

        buttonAdmin = new TextButton("Admin", buttonStyle);
        buttonAdmin.setPosition(Gdx.graphics.getWidth() / 2 - buttonAdmin.getWidth() / 2,
                (Gdx.graphics.getHeight() / 2 - buttonAdmin.getHeight() / 2)-50);

        buttonAdmin.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CoSOS.StavHry = CoSOS.GameState.ADMIN;
            }
        });
        stage.addActor(buttonAdmin);

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
    public void adminPage(Stage AdminStage){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/BebasNeue-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        parameter.characters =  parameter.characters  + "ěščřžýáíéĚŠČŘŽÝÁÍÉ"; // přidejte všechny znaky, které chcete zahrnout
        font = generator.generateFont(parameter);
        konecButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        AdminStage.addActor(konecButton);

    }
}
