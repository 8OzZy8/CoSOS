package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.cosos.CoSOS;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import java.awt.*;

public class GameUI {
    private Stage stageGame;
    private TextButton menu;
    private TextButton.TextButtonStyle buttonStyle;
    private Skin skin;
    private BitmapFont font;
    private TextField hledatSLovo;

    private Texture logoTexture;
    private Sprite logoSprite;

    private Texture ZakryteSlovoTextura;
    private Sprite Zakryte1;
    private Sprite Zakryte2;
    private Sprite Zakryte3;
    private Sprite Zakryte4;
    private Sprite Zakryte5;
    private Sprite Zakryte6;
    private Sprite Zakryte7;

    private Texture bodyTextura;
    private Texture TeamBackgroundText;
    private Texture Napoveda1Textura;
    private Texture Napoveda2Textura;
    private Texture Napoveda3Textura;
    private Texture Napoveda1TexturaNe;
    private Texture Napoveda2TexturaNe;
    private Texture Napoveda3TexturaNe;
    private Sprite bodyBack1;
    private Sprite bodyBack2;
    private Sprite bodyBack3;
    private Sprite bodyBack4;
    private Sprite bodyBack5;
    private Sprite bodyBack6;
    private Sprite bodyBack7;

    private Sprite team1Back;
    private Sprite team2Back;
    private Sprite team3Back;
    private Sprite team4Back;

    private  float logoScale = 0.5f;  // Původní velikost loga
    private float logoTargetScale = 0.2f;  // Cílová velikost loga
    private Vector2 logoPosition = new Vector2(Gdx.graphics.getWidth() / 2, (Gdx.graphics.getHeight() / 2));  // Původní pozice loga

    private SpriteBatch batch;
    public GameUI(Stage stageGame, SpriteBatch batch){
        this.stageGame = stageGame;
        this.batch = batch;
        this.skin = new Skin();
        font = ManagerUI.setFont(font);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;

        logoTexture = new Texture(Gdx.files.internal("Logo/CoSOSLogo1920.png"));
        logoSprite = new Sprite(logoTexture);

        ZakryteSlovoTextura = new Texture(Gdx.files.internal("policka/prazdne.png"));
        bodyTextura = new Texture(Gdx.files.internal("policka/bodyne.png"));

        TeamBackgroundText = new Texture(Gdx.files.internal("Teamy/teambackground.png"));
        team1Back = new Sprite(TeamBackgroundText);
        team2Back = new Sprite(TeamBackgroundText);
        team3Back = new Sprite(TeamBackgroundText);
        team4Back = new Sprite(TeamBackgroundText);


        Napoveda1TexturaNe = new Texture(Gdx.files.internal("Teamy/napoveda_50_ne.png"));
        Napoveda2TexturaNe = new Texture(Gdx.files.internal("Teamy/napoveda_osoba_ne.png"));
        Napoveda3TexturaNe = new Texture(Gdx.files.internal("Teamy/napoveda_otaznik_ne.png"));

        Napoveda1Textura = new Texture(Gdx.files.internal("Teamy/napoveda_50_po.png"));
        Napoveda2Textura = new Texture(Gdx.files.internal("Teamy/napoveda_osoba_po.png"));
        Napoveda3Textura = new Texture(Gdx.files.internal("Teamy/napoveda_otaznik_po.png"));

        Zakryte1 = new Sprite(ZakryteSlovoTextura);
        Zakryte2 = new Sprite(ZakryteSlovoTextura);
        Zakryte3 = new Sprite(ZakryteSlovoTextura);
        Zakryte4 = new Sprite(ZakryteSlovoTextura);
        Zakryte5 = new Sprite(ZakryteSlovoTextura);
        Zakryte6 = new Sprite(ZakryteSlovoTextura);
        Zakryte7 = new Sprite(ZakryteSlovoTextura);

        bodyBack1 = new Sprite(bodyTextura);
        bodyBack2 = new Sprite(bodyTextura);
        bodyBack3 = new Sprite(bodyTextura);
        bodyBack4 = new Sprite(bodyTextura);
        bodyBack5 = new Sprite(bodyTextura);
        bodyBack6 = new Sprite(bodyTextura);
        bodyBack7 = new Sprite(bodyTextura);

        Texture textFieldBackgroundTexture = new Texture(Gdx.files.internal("textfield_background.png"));
        Drawable textFieldBackground = new TextureRegionDrawable(new TextureRegion(textFieldBackgroundTexture));
        textFieldStyle.background = textFieldBackground;

        // Apply the style to the skin
        skin.add("default", textFieldStyle);

        drawGameUI();
    }
    public void drawGameUI(){
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;

        menu = new TextButton("Menu", buttonStyle);
        menu.setPosition(25, Gdx.graphics.getHeight() - 50);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CoSOS.StavHry = CoSOS.GameState.MENU;
                CoSOS.stopMusic();
                resetGameUI();
            }
        });
        stageGame.addActor(menu);

        float logoX = Gdx.graphics.getWidth() / 2 - logoSprite.getWidth() / 2;
        float logoY = 200;
        logoSprite.setScale(0.5f);
        logoSprite.setPosition(logoX, logoY);
        stageGame.addActor(new LogoActor(logoSprite));

    }
    public void drawAfterAnim(){
        hledatSLovo = new TextField("", skin);
        hledatSLovo.setSize(200, 50);
        hledatSLovo.setPosition(Gdx.graphics.getWidth()/2-hledatSLovo.getPrefWidth()/2 - 35, 100);
        hledatSLovo.getStyle().background.setLeftWidth(5);
        hledatSLovo.getStyle().background.setRightWidth(5);
        stageGame.addActor(hledatSLovo);

        float polickaY = 700;
        float polickaX = 50;

        Zakryte1.setScale(0.7f);
        Zakryte1.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte1));

        float polickaBodyX = Zakryte1.getX() + 300;
        bodyBack1.setScale(0.7f);
        bodyBack1.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack1));

        polickaY = polickaY - 100;
        Zakryte2.setScale(0.7f);
        Zakryte2.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte2));

        bodyBack2.setScale(0.7f);
        bodyBack2.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack2));

        polickaY = polickaY - 100;
        Zakryte3.setScale(0.7f);
        Zakryte3.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte3));

        bodyBack3.setScale(0.7f);
        bodyBack3.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack3));

        polickaY = polickaY - 100;
        Zakryte4.setScale(0.7f);
        Zakryte4.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte4));

        bodyBack4.setScale(0.7f);
        bodyBack4.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack4));

        polickaY = polickaY - 100;
        Zakryte5.setScale(0.7f);
        Zakryte5.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte5));

        bodyBack5.setScale(0.7f);
        bodyBack5.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack5));

        polickaY = polickaY - 100;
        Zakryte6.setScale(0.7f);
        Zakryte6.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte6));

        bodyBack6.setScale(0.7f);
        bodyBack6.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack6));

        polickaY = polickaY - 100;
        Zakryte7.setScale(0.7f);
        Zakryte7.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte7));

        bodyBack7.setScale(0.7f);
        bodyBack7.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack7));

        drawTeams();
    }
    public void drawTeams(){
        float teamyX = Gdx.graphics.getWidth()-500;
        float teamyY = Gdx.graphics.getHeight()-250;
        float size = 0.9f;
        team1Back.setScale(size);
        team1Back.setPosition(teamyX, teamyY);
        stageGame.addActor(new CoveredWordActor(team1Back));

        teamyY = teamyY - 200;
        team2Back.setScale(size);
        team2Back.setPosition(teamyX, teamyY);
        stageGame.addActor(new CoveredWordActor(team2Back));
        if(CoSOS.pocetTymu > 2) {
            teamyY = teamyY - 200;
            team3Back.setScale(size);
            team3Back.setPosition(teamyX, teamyY);
            stageGame.addActor(new CoveredWordActor(team3Back));
            if(CoSOS.pocetTymu > 3) {
                teamyY = teamyY - 200;
                team4Back.setScale(size);
                team4Back.setPosition(teamyX, teamyY);
                stageGame.addActor(new CoveredWordActor(team4Back));
            }
        }

    }
    public void resetAnimation() {
        logoScale = 0.5f;
        logoPosition.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        CoSOS.IntroAnim = false;
    }
    public void resetGameUI(){
        hideSprite(Zakryte1);
        hideSprite(Zakryte2);
        hideSprite(Zakryte3);
        hideSprite(Zakryte4);
        hideSprite(Zakryte5);
        hideSprite(Zakryte6);
        hideSprite(Zakryte7);

        hideSprite(bodyBack1);
        hideSprite(bodyBack2);
        hideSprite(bodyBack3);
        hideSprite(bodyBack4);
        hideSprite(bodyBack5);
        hideSprite(bodyBack6);
        hideSprite(bodyBack7);

        hideSprite(team1Back);
        hideSprite(team2Back);
        hideSprite(team3Back);
        hideSprite(team4Back);


        hledatSLovo.setVisible(false);

    }
    public void startGameAgain(){
        showSprite(Zakryte1);
        showSprite(Zakryte2);
        showSprite(Zakryte3);
        showSprite(Zakryte4);
        showSprite(Zakryte5);
        showSprite(Zakryte6);
        showSprite(Zakryte7);

        showSprite(bodyBack1);
        showSprite(bodyBack2);
        showSprite(bodyBack3);
        showSprite(bodyBack4);
        showSprite(bodyBack5);
        showSprite(bodyBack6);
        showSprite(bodyBack7);

        showSprite(team1Back);
        showSprite(team2Back);
        if(CoSOS.pocetTymu > 2){
            showSprite(team3Back);
            if(CoSOS.pocetTymu > 3){
                showSprite(team4Back);
            }
        }
    }
    private void hideSprite(Sprite sprite) {
        if (sprite != null) {
            sprite.setAlpha(0f); // Set alpha to 0 to make the sprite invisible
        }
    }
    private void showSprite(Sprite sprite) {
        if (sprite != null) {
            sprite.setAlpha(1f); // Set alpha to 0 to make the sprite invisible
        }
    }
    public void update(float delta) {
        if (logoScale > logoTargetScale) {
            logoScale -= delta * 0.07f;  // Úprava rychlosti změny velikosti
        }
        if(logoScale<= logoTargetScale) {
            if (logoPosition.y < Gdx.graphics.getHeight() - 150) {
                logoPosition.y += delta * 50;  // Úprava rychlosti pohybu nahoru
            }else {
                if(CoSOS.IntroAnim == false) {
                    CoSOS.IntroAnim = true;
                    drawAfterAnim();
                    startGameAgain();
                }
            }
        }

        // Update the logoSprite with the new scale and position
        logoSprite.setScale(logoScale);
        logoSprite.setPosition(logoPosition.x - logoSprite.getWidth() / 2, logoPosition.y - logoSprite.getHeight() / 2);
    }
    private static class CoveredWordActor extends com.badlogic.gdx.scenes.scene2d.Actor {
        private final Sprite sprite;
        private boolean isVisible;
        public CoveredWordActor(Sprite sprite) {
            this.sprite = sprite;
            this.isVisible = true;

        }
        @Override
        public void draw(Batch batch, float parentAlpha) {
            if (isVisible) {
                sprite.draw(batch);
            }
        }
        public void setVisible(boolean visible) {
            this.isVisible = visible;
        }
    }
    private static class LogoActor extends com.badlogic.gdx.scenes.scene2d.Actor {
        private final Sprite sprite;
        private boolean isVisible;

        public LogoActor(Sprite sprite) {
            this.sprite = sprite;
            this.isVisible = true;
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            if (isVisible) {
                sprite.draw(batch);
            }
        }
        public void setVisible(boolean visible) {
            this.isVisible = visible;
        }
    }


}
