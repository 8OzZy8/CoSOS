package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;  // Add this import statement
import com.mygdx.cosos.CoSOS;

import java.io.IOException;

public class SettingsUI  {
    private Stage stageSet;
    private BitmapFont font;
    private Skin skin;
    private TextButton menu;
    private TextButton.TextButtonStyle buttonStyle;
    private Label pocetTymuLabel;
    private TextField teamNameField1;
    private Label teamLabel1;
    private TextField teamNameField2;
    private Label teamLabel2;
    private TextField teamNameField3;
    private Label teamLabel3;
    private TextField teamNameField4;
    private Label teamLabel4;

    private TextButton pokracovat;

    public SettingsUI(Stage stageSet) {
        this.stageSet = stageSet;
        this.skin = new Skin();
        font = ManagerUI.setFont(font);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;

        Texture textFieldBackgroundTexture = new Texture(Gdx.files.internal("textfield_background.png"));
        Drawable textFieldBackground = new TextureRegionDrawable(new TextureRegion(textFieldBackgroundTexture));
        textFieldStyle.background = textFieldBackground;

        // Apply the style to the skin
        skin.add("default", textFieldStyle);
        drawSettings();
    }

    private void drawSettings() {
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;


        menu = new TextButton("Menu", buttonStyle);
        menu.setPosition(25, Gdx.graphics.getHeight() - 50);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CoSOS.StavHry = CoSOS.GameState.MENU;
            }
        });
        stageSet.addActor(menu);

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;

        // Create the label with the text "Počet týmů"
        Label labelPocteTymu = new Label("Počet týmů:", labelStyle);
        labelPocteTymu.setPosition(Gdx.graphics.getWidth()/2 - labelPocteTymu.getPrefWidth(), Gdx.graphics.getHeight() - 200); // Adjust the position as needed
        stageSet.addActor(labelPocteTymu);

        TextButton SnizitHraceButton;
        SnizitHraceButton = new TextButton("<", buttonStyle);
        SnizitHraceButton.setPosition(labelPocteTymu.getX()+labelPocteTymu.getPrefWidth()+50, labelPocteTymu.getY());
        SnizitHraceButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               CoSOS.pocetTymu--;
                if(CoSOS.pocetTymu < 2){
                    CoSOS.pocetTymu = 4;
                }
                updatePocetTymuLabel();
            }
        });
        stageSet.addActor(SnizitHraceButton);

        pocetTymuLabel = new Label(String.valueOf(CoSOS.pocetTymu), labelStyle);
        pocetTymuLabel.setPosition(SnizitHraceButton.getX()+SnizitHraceButton.getPrefWidth() + 50, labelPocteTymu.getY());
        stageSet.addActor(pocetTymuLabel);

        TextButton ZvysitHraceButton;
        ZvysitHraceButton = new TextButton(">", buttonStyle);
        ZvysitHraceButton.setPosition(pocetTymuLabel.getX()+pocetTymuLabel.getPrefWidth()+50, pocetTymuLabel.getY());
        ZvysitHraceButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CoSOS.pocetTymu++;
                if(CoSOS.pocetTymu > 4){
                    CoSOS.pocetTymu = 2;
                }
                updatePocetTymuLabel();
            }
        });
        stageSet.addActor(ZvysitHraceButton);

        teamLabel1 = new Label("Název týmu 1:", labelStyle);
        teamLabel1.setPosition(Gdx.graphics.getWidth() / 2 - teamLabel1.getPrefWidth(), Gdx.graphics.getHeight() - 300);
        stageSet.addActor(teamLabel1);

        teamNameField1 = new TextField(" Tým 1", skin);
        teamNameField1.setSize(200, 50);
        float offset = 10; // Změňte hodnotu podle potřeby
        float frameWidth = 6; // Šířka bílého rámečku na stranách
        teamNameField1.setPosition(teamLabel1.getX() + teamLabel1.getPrefWidth() + offset + frameWidth, teamLabel1.getY() - frameWidth);
        teamNameField1.getStyle().background.setLeftWidth(5);
        teamNameField1.getStyle().background.setRightWidth(5);
        stageSet.addActor(teamNameField1);

        teamLabel2 = new Label("Název týmu 2:", labelStyle);
        teamLabel2.setPosition(teamLabel1.getX(), teamLabel1.getY() - 100);
        stageSet.addActor(teamLabel2);

        teamNameField2 = new TextField(" Tým 2", skin);
        teamNameField2.setSize(200, 50);
        teamNameField2.setPosition(teamLabel2.getX() + teamLabel2.getPrefWidth() + offset + frameWidth, teamLabel2.getY() - frameWidth);
        stageSet.addActor(teamNameField2);

        teamLabel3 = new Label("Název týmu 3:", labelStyle);
        teamLabel3.setPosition(teamLabel2.getX(), teamLabel2.getY() - 100);
        stageSet.addActor(teamLabel3);

        teamNameField3 = new TextField(" Tým 3", skin);
        teamNameField3.setSize(200, 50);
        teamNameField3.setPosition(teamLabel3.getX() + teamLabel3.getPrefWidth() + offset + frameWidth, teamLabel3.getY() - frameWidth);
        stageSet.addActor(teamNameField3);

        teamLabel4 = new Label("Název týmu 4:", labelStyle);
        teamLabel4.setPosition(teamLabel3.getX(), teamLabel3.getY() - 100);
        stageSet.addActor(teamLabel4);

        teamNameField4 = new TextField(" Tým 4", skin);
        teamNameField4.setSize(200, 50);
        teamNameField4.setPosition(teamLabel4.getX() + teamLabel4.getPrefWidth() + offset + frameWidth, teamLabel4.getY() - frameWidth);
        stageSet.addActor(teamNameField4);

        pokracovat = new TextButton("Pokračovat", buttonStyle);
        pokracovat.setPosition(Gdx.graphics.getWidth()/2 - pokracovat.getPrefWidth()/2, 100);
        pokracovat.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String tym1 = "Tym 1";
                String tym2 = "Tym 2";
                String tym3 = "Tym 3";
                String tym4 = "Tym 4";

                switch(CoSOS.pocetTymu){
                    case 2:
                        tym1 = teamNameField1.getText();
                        tym2 = teamNameField2.getText();
                        break;
                    case 3:
                        tym1 = teamNameField1.getText();
                        tym2 = teamNameField2.getText();
                        tym3 = teamNameField3.getText();
                        break;
                    case 4:
                        tym1 = teamNameField1.getText();
                        tym2 = teamNameField2.getText();
                        tym3 = teamNameField3.getText();
                        tym4 = teamNameField4.getText();
                        break;
                }
                CoSOS.reset = true;
                CoSOS.SetGame(tym1,tym2,tym3,tym4);
                try {
                    CoSOS.NovaOtazka();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                CoSOS.StavHry = CoSOS.GameState.GAME;
            }
        });
        stageSet.addActor(pokracovat);
    }
    void updatePocetTymuLabel() {
        pocetTymuLabel.setText(String.valueOf(CoSOS.pocetTymu));

        switch(CoSOS.pocetTymu){
            case 2:
                teamLabel1.setVisible(true);
                teamLabel2.setVisible(true);
                teamLabel3.setVisible(false);
                teamLabel4.setVisible(false);

                teamNameField1.setVisible(true);
                teamNameField2.setVisible(true);
                teamNameField3.setVisible(false);
                teamNameField4.setVisible(false);
                break;
            case 3:
                teamLabel1.setVisible(true);
                teamLabel2.setVisible(true);
                teamLabel3.setVisible(true);
                teamLabel4.setVisible(false);

                teamNameField1.setVisible(true);
                teamNameField2.setVisible(true);
                teamNameField3.setVisible(true);
                teamNameField4.setVisible(false);
                break;
            case 4:
                teamLabel1.setVisible(true);
                teamLabel2.setVisible(true);
                teamLabel3.setVisible(true);
                teamLabel4.setVisible(true);

                teamNameField1.setVisible(true);
                teamNameField2.setVisible(true);
                teamNameField3.setVisible(true);
                teamNameField4.setVisible(true);
                break;
        }
    }

}
