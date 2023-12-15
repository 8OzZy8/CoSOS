package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.cosos.CoSOS;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.cosos.Sada.Odpoved;

import java.awt.*;
import java.io.IOException;

public class GameUI {
    private Stage stageGame;
    private TextButton menu;
    private TextButton nextTeamButton;
    private TextButton hledatSlovoButton;
    private TextButton ShowAll;
    private TextButton NextOtazka;
    private TextButton ButtonCasovac;
    private TextButton.TextButtonStyle buttonStyle;
    private TextButton.TextButtonStyle buttonStyleBig;
    private Skin skin;
    private BitmapFont font;

    private static BitmapFont fontBig;
    private BitmapFont fontBigTlac;
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
    private static Texture TeamBackgroundText;
    private static Texture TeamBackgroundTextActive;
    private Texture Napoveda1Textura;
    private Texture Napoveda2Textura;
    private Texture Napoveda3Textura;
    private Texture Napoveda1TexturaNe;
    private Texture Napoveda2TexturaNe;
    private Texture Napoveda3TexturaNe;

    private static Label otazkaLabel;
    private Sprite bodyBack1;
    private Sprite bodyBack2;
    private Sprite bodyBack3;
    private Sprite bodyBack4;
    private Sprite bodyBack5;
    private Sprite bodyBack6;
    private Sprite bodyBack7;

    private static Sprite team1Back;
    private static Sprite team2Back;
    private static Sprite team3Back;
    private static Sprite team4Back;

    private Sprite team1BackActive;
    private Sprite team2BackActive;
    private Sprite team3BackActive;
    private Sprite team4BackActive;

    private ImageButton team1Napoveda1;
    private ImageButton team1Napoveda2;
    private ImageButton team1Napoveda3;

    private ImageButton team2Napoveda1;
    private ImageButton team2Napoveda2;
    private ImageButton team2Napoveda3;

    private ImageButton team3Napoveda1;
    private ImageButton team3Napoveda2;
    private ImageButton team3Napoveda3;
    private ImageButton team4Napoveda1;
    private ImageButton team4Napoveda2;
    private ImageButton team4Napoveda3;

    private Texture napoveda1TexturaNepouzity;
    private Texture napoveda2TexturaNepouzity;
    private Texture napoveda3TexturaNepouzity;
    private Texture napoveda1TexturaPouzity;
    private Texture napoveda2TexturaPouzity;
    private Texture napoveda3TexturaPouzity;
    private Drawable napoveda1DrawableNe;
    private Drawable napoveda1DrawablePo;

    private Drawable napoveda2DrawableNe;
    private Drawable napoveda2DrawablePo;

    private Drawable napoveda3DrawableNe;
    private Drawable napoveda3DrawablePo;

    private Label Team1Name;
    private static Label Team1Body;
    private Label Team2Name;
    private static Label Team2Body;
    private Label Team3Name;
    private static Label Team3Body;
    private Label Team4Name;
    private static Label Team4Body;

    private static Label odpoved1;
    private Label odmena1;
    private static Label odpoved2;
    private Label odmena2;
    private static Label odpoved3;
    private Label odmena3;
    private static Label odpoved4;
    private Label odmena4;
    private static Label odpoved5;
    private Label odmena5;
    private static Label odpoved6;
    private Label odmena6;
    private static Label odpoved7;
    private Label odmena7;

    private  float logoScale = 0.5f;  // Původní velikost loga
    private float logoTargetScale = 0.2f;  // Cílová velikost loga
    private Vector2 logoPosition = new Vector2(Gdx.graphics.getWidth() / 2, (Gdx.graphics.getHeight() / 2));  // Původní pozice loga
    private Timer.Task countdownTask;
    private LabelStyle textLabelStyle;
    private SpriteBatch batch;
    public GameUI(Stage stageGame, SpriteBatch batch){
        this.stageGame = stageGame;
        this.batch = batch;
        this.skin = new Skin();
        font = ManagerUI.setFont(font);
        fontBig = ManagerUI.setFontBig(font);
        fontBigTlac = ManagerUI.setFontBigTlac(fontBigTlac);
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;

        Label.LabelStyle textLabelStyle = new Label.LabelStyle();
        textLabelStyle.font = font;
        textLabelStyle.fontColor = Color.WHITE;

        logoTexture = new Texture(Gdx.files.internal("Logo/CoSOSLogo1920.png"));
        logoSprite = new Sprite(logoTexture);

        ZakryteSlovoTextura = new Texture(Gdx.files.internal("policka/prazdne.png"));
        bodyTextura = new Texture(Gdx.files.internal("policka/bodyne.png"));

        TeamBackgroundText = new Texture(Gdx.files.internal("Teamy/teambackground.png"));
        team1Back = new Sprite(TeamBackgroundText);
        team2Back = new Sprite(TeamBackgroundText);
        team3Back = new Sprite(TeamBackgroundText);
        team4Back = new Sprite(TeamBackgroundText);
        TeamBackgroundTextActive = new Texture(Gdx.files.internal("Teamy/teambackgroundActive.png"));


        napoveda1TexturaNepouzity = new Texture(Gdx.files.internal("Teamy/napoveda_50_ne.png"));
        napoveda1TexturaPouzity = new Texture(Gdx.files.internal("Teamy/napoveda_50_po.png"));

        napoveda2TexturaNepouzity = new Texture(Gdx.files.internal("Teamy/napoveda_osoba_ne.png"));
        napoveda2TexturaPouzity = new Texture(Gdx.files.internal("Teamy/napoveda_osoba_po.png"));

        napoveda3TexturaNepouzity = new Texture(Gdx.files.internal("Teamy/napoveda_otaznik_ne.png"));
        napoveda3TexturaPouzity = new Texture(Gdx.files.internal("Teamy/napoveda_otaznik_po.png"));

        napoveda1DrawableNe = new TextureRegionDrawable(new TextureRegion(napoveda1TexturaNepouzity));
        napoveda1DrawablePo = new TextureRegionDrawable(new TextureRegion(napoveda1TexturaPouzity));

        napoveda2DrawableNe = new TextureRegionDrawable(new TextureRegion(napoveda2TexturaNepouzity));
        napoveda2DrawablePo = new TextureRegionDrawable(new TextureRegion(napoveda2TexturaPouzity));

        napoveda3DrawableNe = new TextureRegionDrawable(new TextureRegion(napoveda3TexturaNepouzity));
        napoveda3DrawablePo = new TextureRegionDrawable(new TextureRegion(napoveda3TexturaPouzity));


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

        buttonStyleBig = new TextButton.TextButtonStyle();
        buttonStyleBig.font = fontBig;
        menu = new TextButton("Menu", buttonStyle);
        menu.setPosition(25, Gdx.graphics.getHeight() - 50);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CoSOS.StavHry = CoSOS.GameState.MENU;
                CoSOS.stopMusic();
                CoSOS.StopTimerMusic();
                resetGameUI();
            }
        });
        stageGame.addActor(menu);

        float logoX = Gdx.graphics.getWidth() / 2 - logoSprite.getWidth() / 2 + 10;
        float logoY = 200;
        logoSprite.setScale(0.5f);
        logoSprite.setPosition(logoX, logoY);
        stageGame.addActor(new LogoActor(logoSprite));
    }
    public void drawAfterAnim(){
        hledatSLovo = new TextField("", skin);
        hledatSLovo.setSize(200, 50);
        hledatSLovo.setPosition(Gdx.graphics.getWidth()/2-hledatSLovo.getPrefWidth()/2 - 27, 100);
        hledatSLovo.getStyle().background.setLeftWidth(5);
        hledatSLovo.getStyle().background.setRightWidth(5);
        hledatSLovo.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                // Zkontrolujte, zda byla stisknuta klávesa Enter
                if (keycode == Input.Keys.ENTER) {
                    String hledane = hledatSLovo.getText();
                    CoSOS.hledatOdpoved(hledane);
                    resetCountdown();
                    CoSOS.StopTimerMusic();

                    return true;
                }
                return false;
            }
        });
        stageGame.addActor(hledatSLovo);

        float polickaY = 700;
        float polickaX = 50;

        Label.LabelStyle textLabelStyle = new Label.LabelStyle();
        textLabelStyle.font = fontBig;
        textLabelStyle.fontColor = Color.WHITE;


        Zakryte1.setScale(0.7f);
        Zakryte1.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte1));

        float odpovedX = 110;
        float odpovedY = Zakryte1.getY()+15;
        float bodyX = odpovedX + 300;
        odpoved1 = new Label("Odpověď 1", textLabelStyle);
        odpoved1.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved1);

        float polickaBodyX = Zakryte1.getX() + 300;
        bodyBack1.setScale(0.7f);
        bodyBack1.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack1));

        odmena1 = new Label("1000", textLabelStyle);
        odmena1.setPosition(bodyX, odpovedY);
        stageGame.addActor(odmena1);

        polickaY = polickaY - 100;
        Zakryte2.setScale(0.7f);
        Zakryte2.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte2));

        odpovedY = Zakryte2.getY()+15;
        odpoved2 = new Label("Odpověď 2", textLabelStyle);
        odpoved2.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved2);

        bodyBack2.setScale(0.7f);
        bodyBack2.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack2));

        odmena2 = new Label("900", textLabelStyle);
        odmena2.setPosition(bodyX+10, odpovedY);
        stageGame.addActor(odmena2);

        polickaY = polickaY - 100;
        Zakryte3.setScale(0.7f);
        Zakryte3.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte3));

        odpovedY = Zakryte3.getY()+15;
        odpoved3 = new Label("Odpověď 3", textLabelStyle);
        odpoved3.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved3);

        bodyBack3.setScale(0.7f);
        bodyBack3.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack3));

        odmena3 = new Label("800", textLabelStyle);
        odmena3.setPosition(bodyX+10, odpovedY);
        stageGame.addActor(odmena3);

        polickaY = polickaY - 100;
        Zakryte4.setScale(0.7f);
        Zakryte4.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte4));

        odpovedY = Zakryte4.getY()+15;
        odpoved4 = new Label("Odpověď 4", textLabelStyle);
        odpoved4.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved4);

        bodyBack4.setScale(0.7f);
        bodyBack4.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack4));

        odmena4 = new Label("700", textLabelStyle);
        odmena4.setPosition(bodyX+10, odpovedY);
        stageGame.addActor(odmena4);

        polickaY = polickaY - 100;
        Zakryte5.setScale(0.7f);
        Zakryte5.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte5));

        odpovedY = Zakryte5.getY()+15;
        odpoved5 = new Label("Odpověď 5", textLabelStyle);
        odpoved5.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved5);

        bodyBack5.setScale(0.7f);
        bodyBack5.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack5));

        odmena5 = new Label("600", textLabelStyle);
        odmena5.setPosition(bodyX+10, odpovedY);
        stageGame.addActor(odmena5);

        polickaY = polickaY - 100;
        Zakryte6.setScale(0.7f);
        Zakryte6.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte6));

        odpovedY = Zakryte6.getY()+15;
        odpoved6 = new Label("Odpověď 6", textLabelStyle);
        odpoved6.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved6);

        bodyBack6.setScale(0.7f);
        bodyBack6.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack6));

        odmena6 = new Label("500", textLabelStyle);
        odmena6.setPosition(bodyX+10, odpovedY);
        stageGame.addActor(odmena6);

        polickaY = polickaY - 100;
        Zakryte7.setScale(0.7f);
        Zakryte7.setPosition(polickaX, polickaY);
        stageGame.addActor(new CoveredWordActor(Zakryte7));

        odpovedY = Zakryte7.getY()+15;
        odpoved7 = new Label("Odpověď 7", textLabelStyle);
        odpoved7.setPosition(odpovedX, odpovedY);
        stageGame.addActor(odpoved7);

        bodyBack7.setScale(0.7f);
        bodyBack7.setPosition(polickaBodyX,polickaY);
        stageGame.addActor(new CoveredWordActor(bodyBack7));

        odmena7 = new Label("400", textLabelStyle);
        odmena7.setPosition(bodyX+10, odpovedY);
        stageGame.addActor(odmena7);

        ButtonCasovac = new TextButton("Časomíra", buttonStyleBig);
        ButtonCasovac.setPosition(Gdx.graphics.getWidth()/2 - ButtonCasovac.getWidth()/2, 200);

        ButtonCasovac.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (countdownTask != null) {
                    ButtonCasovac.getLabel().setColor(Color.WHITE);
                    resetCountdown();
                    CoSOS.StopTimerMusic();
                } else {
                    ButtonCasovac.getLabel().setColor(Color.WHITE);
                    startCountdown();
                    CoSOS.StartTimerMusic();
                }
            }
        });
        stageGame.addActor(ButtonCasovac);

        nextTeamButton = new TextButton("Další tým", buttonStyle);
        nextTeamButton.setPosition(Gdx.graphics.getWidth()- 600, 60);
        nextTeamButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               CoSOS.ActiveTeam++;
               if(CoSOS.ActiveTeam > CoSOS.pocetTymu){
                   CoSOS.ActiveTeam = 1;
               }
            }
        });
        stageGame.addActor(nextTeamButton);
        LabelStyle textLabelStyleB = textLabelStyle;
        textLabelStyleB.font = fontBigTlac;
        otazkaLabel = new Label("otázka", textLabelStyleB);
        otazkaLabel.setColor(Color.ORANGE);
        otazkaLabel.setScale(1f);
        otazkaLabel.setWrap(true);
        otazkaLabel.setWidth(500f);
        otazkaLabel.setAlignment(Align.center);
        otazkaLabel.setPosition(Gdx.graphics.getWidth()/2 - otazkaLabel.getWidth()/2, Gdx.graphics.getHeight()/2);
        stageGame.addActor(otazkaLabel);

        NextOtazka = new TextButton("Další otázka", buttonStyle);
        NextOtazka.setPosition(385, nextTeamButton.getY());
        NextOtazka.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    CoSOS.NovaOtazka();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                aktulizaceOtazek();
            }
        });
        stageGame.addActor(NextOtazka);

        ShowAll = new TextButton("Odhalit vše", buttonStyle);
        ShowAll.setPosition(105, nextTeamButton.getY());
        ShowAll.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CoSOS.odpoved1uhodnuto = true;
                CoSOS.odpoved2uhodnuto = true;
                CoSOS.odpoved3uhodnuto = true;
                CoSOS.odpoved4uhodnuto = true;
                CoSOS.odpoved5uhodnuto = true;
                CoSOS.odpoved6uhodnuto = true;
                CoSOS.odpoved7uhodnuto = true;

            }
        });
        stageGame.addActor(ShowAll);

        hledatSlovoButton = new TextButton("Hledat", buttonStyle);
        hledatSlovoButton.setPosition(Gdx.graphics.getWidth()/2 - hledatSlovoButton.getPrefWidth()/2, 20);
        hledatSlovoButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String hledane = hledatSLovo.getText();
                CoSOS.hledatOdpoved(hledane);
                resetCountdown();
                CoSOS.StopTimerMusic();
            }
        });
        stageGame.addActor(hledatSlovoButton);

        drawTeams();
    }
    private void startCountdown() {
        final int countdownSeconds = 29;
        final TextButton countdownButton = ButtonCasovac;

        countdownButton.setDisabled(true);

        countdownTask = new Timer.Task() {
            int secondsLeft = countdownSeconds;

            @Override
            public void run() {
                countdownButton.setText("" + secondsLeft);
                if (secondsLeft <= 5 && secondsLeft >= 0) {
                    countdownButton.getLabel().setColor(Color.RED);
                }
                if (secondsLeft == 0) {
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            countdownButton.getLabel().setColor(Color.WHITE);
                            resetCountdown();
                        }
                    }, 5);
                } else if (secondsLeft < 0) {
                    countdownButton.setDisabled(false);
                    countdownButton.getLabel().setColor(Color.WHITE);
                    countdownButton.setText("Časomíra");
                    countdownTask = null;
                    this.cancel();
                }


                secondsLeft--;
            }
        };

        Timer.schedule(countdownTask, 1, 1, countdownSeconds);
    }
    public static void aktulizaceOtazek(){

        otazkaLabel.setText(CoSOS.Otazka.getText());
        int i = 0;
        String[] odpovedi = new String[7];
        for (Odpoved odpoved : CoSOS.Otazka.getOdpovedi()) {
            if( i < odpovedi.length) {
                if (odpoved != null) {
                    odpovedi[i] = odpoved.getText();
                } else {
                    odpovedi[i] = "";
                }
            i++;
            }
        }
        odpoved1.setText(odpovedi[0]);
        odpoved2.setText(odpovedi[1]);
        odpoved3.setText(odpovedi[2]);
        odpoved4.setText(odpovedi[3]);
        odpoved5.setText(odpovedi[4]);
        odpoved6.setText(odpovedi[5]);
        odpoved7.setText(odpovedi[6]);


    }
    public static void AktulizaceShowOdpovedi(){
        if(CoSOS.odpoved1uhodnuto){
            odpoved1.setVisible(true);
        }else {
            odpoved1.setVisible(false);
        }

        if(CoSOS.odpoved2uhodnuto){
            odpoved2.setVisible(true);
        }else {
            odpoved2.setVisible(false);
        }
        if(CoSOS.odpoved3uhodnuto){
            odpoved3.setVisible(true);
        }else {
            odpoved3.setVisible(false);
        }
        if(CoSOS.odpoved4uhodnuto){
            odpoved4.setVisible(true);
        }else {
            odpoved4.setVisible(false);
        }
        if(CoSOS.odpoved5uhodnuto){
            odpoved5.setVisible(true);
        }else {
            odpoved5.setVisible(false);
        }
        if(CoSOS.odpoved6uhodnuto){
            odpoved6.setVisible(true);
        }else {
            odpoved6.setVisible(false);
        }
        if(CoSOS.odpoved7uhodnuto){
            odpoved7.setVisible(true);
        }else {
            odpoved7.setVisible(false);
        }
    }

    // Add a new method to reset the countdown
    private void resetCountdown() {
        if (countdownTask != null) {

            countdownTask.cancel(); // Cancel the current countdown task
            countdownTask = null; // Reset the countdown task
            ButtonCasovac.setText("Časomíra"); // Reset the button text
            ButtonCasovac.setDisabled(false); // Enable the button
        }
    }
    public void drawTeams(){
        float teamyX = Gdx.graphics.getWidth()-500;
        float teamyY = Gdx.graphics.getHeight()-250;
        if(CoSOS.fullscreen){
            teamyY = Gdx.graphics.getHeight()-425;
        }
        float buttonY = teamyY + 134;
        float buttonX = teamyX + 307;
        float textX = teamyX + 30;
        float textY = teamyY + 100;
        float size = 0.9f;

        Label.LabelStyle textLabelStyle = new Label.LabelStyle();
        textLabelStyle.font = fontBig;
        textLabelStyle.fontColor = Color.WHITE;

        team1Back.setScale(size);
        team1Back.setPosition(teamyX, teamyY);
        stageGame.addActor(new CoveredWordActor(team1Back));
        if(CoSOS.Tymy[0].getNazev() != null) {
            Team1Name = new Label(CoSOS.Tymy[0].getNazev(), textLabelStyle);
            Team1Name.setPosition(textX, textY);
            stageGame.addActor(Team1Name);
            textY = textY - 80;
            Team1Body = new Label(String.valueOf(CoSOS.Tymy[0].getBody()), textLabelStyle);
            Team1Body.setPosition(textX + 10, textY);
            stageGame.addActor(Team1Body);
        }

        ImageButton.ImageButtonStyle Team1napoveda1ButtonStyle = new ImageButton.ImageButtonStyle();
        Team1napoveda1ButtonStyle.imageUp = napoveda1DrawableNe;
        team1Napoveda1 = new ImageButton(Team1napoveda1ButtonStyle);
        team1Napoveda1.setPosition(buttonX, buttonY);
        team1Napoveda1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CoSOS.Tymy[0].isNapoveda1() == false){
                    CoSOS.Tymy[0].setNapoveda1(true);
                    team1Napoveda1.getStyle().imageUp = napoveda1DrawablePo;
                }
            }
        });
        stageGame.addActor(team1Napoveda1);

        buttonY = buttonY - 60;
        ImageButton.ImageButtonStyle Team1napoveda2ButtonStyle = new ImageButton.ImageButtonStyle();
        Team1napoveda2ButtonStyle.imageUp = napoveda2DrawableNe;
        team1Napoveda2 = new ImageButton(Team1napoveda2ButtonStyle);
        team1Napoveda2.setPosition(buttonX, buttonY);
        team1Napoveda2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CoSOS.Tymy[0].isNapoveda2() == false){
                    CoSOS.Tymy[0].setNapoveda2(true);
                    team1Napoveda2.getStyle().imageUp = napoveda2DrawablePo;
                }
            }
        });
        stageGame.addActor(team1Napoveda2);

        buttonY = buttonY - 60;
        ImageButton.ImageButtonStyle Team1napoveda3ButtonStyle = new ImageButton.ImageButtonStyle();
        Team1napoveda3ButtonStyle.imageUp = napoveda3DrawableNe;
        team1Napoveda3 = new ImageButton(Team1napoveda3ButtonStyle);
        team1Napoveda3.setPosition(buttonX, buttonY);
        team1Napoveda3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CoSOS.Tymy[0].isNapoveda3() == false){
                    CoSOS.Tymy[0].setNapoveda3(true);
                    team1Napoveda3.getStyle().imageUp = napoveda3DrawablePo;
                }
            }
        });
        stageGame.addActor(team1Napoveda3);


        teamyY = teamyY - 200;
        team2Back.setScale(size);
        team2Back.setPosition(teamyX, teamyY);
        stageGame.addActor(new CoveredWordActor(team2Back));

        textY = teamyY + 100;
        if(CoSOS.Tymy[1].getNazev() != null) {
            Team2Name = new Label(CoSOS.Tymy[1].getNazev(), textLabelStyle);
            Team2Name.setPosition(textX, textY);
            stageGame.addActor(Team2Name);
            textY = textY - 80;
            Team2Body = new Label(String.valueOf(CoSOS.Tymy[1].getBody()), textLabelStyle);
            Team2Body.setPosition(textX + 10, textY);
            stageGame.addActor(Team2Body);
        }

        buttonY = teamyY + 134;

        //TEAM2 NAPVOEDY
        ImageButton.ImageButtonStyle Team2napoveda1ButtonStyle = new ImageButton.ImageButtonStyle();
        Team2napoveda1ButtonStyle.imageUp = napoveda1DrawableNe;
        team2Napoveda1 = new ImageButton(Team2napoveda1ButtonStyle);
        team2Napoveda1.setPosition(buttonX, buttonY);
        team2Napoveda1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CoSOS.Tymy[1].isNapoveda1() == false){
                    CoSOS.Tymy[1].setNapoveda1(true);
                    team2Napoveda1.getStyle().imageUp = napoveda1DrawablePo;
                }
            }
        });
        stageGame.addActor(team2Napoveda1);

        buttonY = buttonY - 60;
        ImageButton.ImageButtonStyle Team2napoveda2ButtonStyle = new ImageButton.ImageButtonStyle();
        Team2napoveda2ButtonStyle.imageUp = napoveda2DrawableNe;
        team2Napoveda2 = new ImageButton(Team2napoveda2ButtonStyle);
        team2Napoveda2.setPosition(buttonX, buttonY);
        team2Napoveda2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CoSOS.Tymy[1].isNapoveda2() == false){
                    CoSOS.Tymy[1].setNapoveda2(true);
                    team2Napoveda2.getStyle().imageUp = napoveda2DrawablePo;
                }
            }
        });
        stageGame.addActor(team2Napoveda2);

        buttonY = buttonY - 60;
        ImageButton.ImageButtonStyle Team2napoveda3ButtonStyle = new ImageButton.ImageButtonStyle();
        Team2napoveda3ButtonStyle.imageUp = napoveda3DrawableNe;
        team2Napoveda3 = new ImageButton(Team2napoveda3ButtonStyle);
        team2Napoveda3.setPosition(buttonX, buttonY);
        team2Napoveda3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CoSOS.Tymy[1].isNapoveda3() == false){
                    CoSOS.Tymy[1].setNapoveda3(true);
                    team2Napoveda3.getStyle().imageUp = napoveda3DrawablePo;
                }
            }
        });
        stageGame.addActor(team2Napoveda3);

        if(CoSOS.pocetTymu > 2) {
            teamyY = teamyY - 200;
            team3Back.setScale(size);
            team3Back.setPosition(teamyX, teamyY);
            stageGame.addActor(new CoveredWordActor(team3Back));
            textY = teamyY + 100;
            if(CoSOS.Tymy[2].getNazev() != null) {
                Team3Name = new Label(CoSOS.Tymy[2].getNazev(), textLabelStyle);
                Team3Name.setPosition(textX, textY);
                stageGame.addActor(Team3Name);
                textY = textY - 80;
                Team3Body = new Label(String.valueOf(CoSOS.Tymy[2].getBody()), textLabelStyle);
                Team3Body.setPosition(textX + 10, textY);
                stageGame.addActor(Team3Body);
            }

            buttonY = teamyY + 134;
            //TEAM3 NAPVOEDY
            ImageButton.ImageButtonStyle Team3napoveda1ButtonStyle = new ImageButton.ImageButtonStyle();
            Team3napoveda1ButtonStyle.imageUp = napoveda1DrawableNe;
            team3Napoveda1 = new ImageButton(Team3napoveda1ButtonStyle);
            team3Napoveda1.setPosition(buttonX, buttonY);
            team3Napoveda1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(CoSOS.Tymy[2].isNapoveda1() == false){
                        CoSOS.Tymy[2].setNapoveda1(true);
                        team3Napoveda1.getStyle().imageUp = napoveda1DrawablePo;
                    }
                }
            });
            stageGame.addActor(team3Napoveda1);

            buttonY = buttonY - 60;
            ImageButton.ImageButtonStyle Team3napoveda2ButtonStyle = new ImageButton.ImageButtonStyle();
            Team3napoveda2ButtonStyle.imageUp = napoveda2DrawableNe;
            team3Napoveda2 = new ImageButton(Team3napoveda2ButtonStyle);
            team3Napoveda2.setPosition(buttonX, buttonY);
            team3Napoveda2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(CoSOS.Tymy[2].isNapoveda2() == false){
                        CoSOS.Tymy[2].setNapoveda2(true);
                        team3Napoveda2.getStyle().imageUp = napoveda2DrawablePo;
                    }
                }
            });
            stageGame.addActor(team3Napoveda2);

            buttonY = buttonY - 60;
            ImageButton.ImageButtonStyle Team3napoveda3ButtonStyle = new ImageButton.ImageButtonStyle();
            Team3napoveda3ButtonStyle.imageUp = napoveda3DrawableNe;
            team3Napoveda3 = new ImageButton(Team3napoveda3ButtonStyle);
            team3Napoveda3.setPosition(buttonX, buttonY);
            team3Napoveda3.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(CoSOS.Tymy[2].isNapoveda3() == false){
                        CoSOS.Tymy[2].setNapoveda3(true);
                        team3Napoveda3.getStyle().imageUp = napoveda3DrawablePo;
                    }
                }
            });
            stageGame.addActor(team3Napoveda3);


            if(CoSOS.pocetTymu > 3) {
                teamyY = teamyY - 200;
                team4Back.setScale(size);
                team4Back.setPosition(teamyX, teamyY);
                stageGame.addActor(new CoveredWordActor(team4Back));
                textY = teamyY + 100;
                if(CoSOS.Tymy[3].getNazev() != null) {
                    Team4Name = new Label(CoSOS.Tymy[3].getNazev(), textLabelStyle);
                    Team4Name.setPosition(textX, textY);
                    stageGame.addActor(Team4Name);
                    textY = textY - 80;
                    Team4Body = new Label(String.valueOf(CoSOS.Tymy[3].getBody()), textLabelStyle);
                    Team4Body.setPosition(textX + 10, textY);
                    stageGame.addActor(Team4Body);
                }

                buttonY = teamyY + 134;
                //TEAM3 NAPVOEDY
                ImageButton.ImageButtonStyle Team4napoveda1ButtonStyle = new ImageButton.ImageButtonStyle();
                Team4napoveda1ButtonStyle.imageUp = napoveda1DrawableNe;
                team4Napoveda1 = new ImageButton(Team4napoveda1ButtonStyle);
                team4Napoveda1.setPosition(buttonX, buttonY);
                team4Napoveda1.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if(CoSOS.Tymy[3].isNapoveda1() == false){
                            CoSOS.Tymy[3].setNapoveda1(true);
                            team4Napoveda1.getStyle().imageUp = napoveda1DrawablePo;
                        }
                    }
                });
                stageGame.addActor(team4Napoveda1);

                buttonY = buttonY - 60;
                ImageButton.ImageButtonStyle Team4napoveda2ButtonStyle = new ImageButton.ImageButtonStyle();
                Team4napoveda2ButtonStyle.imageUp = napoveda2DrawableNe;
                team4Napoveda2 = new ImageButton(Team4napoveda2ButtonStyle);
                team4Napoveda2.setPosition(buttonX, buttonY);
                team4Napoveda2.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if(CoSOS.Tymy[3].isNapoveda2() == false){
                            CoSOS.Tymy[3].setNapoveda2(true);
                            team4Napoveda2.getStyle().imageUp = napoveda2DrawablePo;
                        }
                    }
                });
                stageGame.addActor(team4Napoveda2);

                buttonY = buttonY - 60;
                ImageButton.ImageButtonStyle Team4napoveda3ButtonStyle = new ImageButton.ImageButtonStyle();
                Team4napoveda3ButtonStyle.imageUp = napoveda3DrawableNe;
                team4Napoveda3 = new ImageButton(Team4napoveda3ButtonStyle);
                team4Napoveda3.setPosition(buttonX, buttonY);
                team4Napoveda3.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if(CoSOS.Tymy[3].isNapoveda3() == false){
                            CoSOS.Tymy[3].setNapoveda3(true);
                            team4Napoveda3.getStyle().imageUp = napoveda3DrawablePo;
                        }
                    }
                });
                stageGame.addActor(team4Napoveda3);

            }
        }

    }
    public static void aktulizovatBody(){
        Team1Body.setText(String.valueOf(CoSOS.Tymy[0].getBody()));
        Team2Body.setText(String.valueOf(CoSOS.Tymy[1].getBody()));
        if(CoSOS.pocetTymu > 2) {
            Team3Body.setText(String.valueOf(CoSOS.Tymy[2].getBody()));
            if(CoSOS.pocetTymu > 3) {
                Team4Body.setText(String.valueOf(CoSOS.Tymy[3].getBody()));
            }
        }
        switch (CoSOS.ActiveTeam){
            case 1:
                team1Back.setTexture(TeamBackgroundTextActive);
                team2Back.setTexture(TeamBackgroundText);
                team3Back.setTexture(TeamBackgroundText);
                team4Back.setTexture(TeamBackgroundText);
                break;
            case 2:
                team1Back.setTexture(TeamBackgroundText);
                team2Back.setTexture(TeamBackgroundTextActive);
                team3Back.setTexture(TeamBackgroundText);
                team4Back.setTexture(TeamBackgroundText);
                break;
            case 3:
                team1Back.setTexture(TeamBackgroundText);
                team2Back.setTexture(TeamBackgroundText);
                team3Back.setTexture(TeamBackgroundTextActive);
                team4Back.setTexture(TeamBackgroundText);
                break;
            case 4:
                team1Back.setTexture(TeamBackgroundText);
                team2Back.setTexture(TeamBackgroundText);
                team3Back.setTexture(TeamBackgroundText);
                team4Back.setTexture(TeamBackgroundTextActive);
                break;
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

        Team1Name.setVisible(false);
        Team1Body.setVisible(false);
        Team2Name.setVisible(false);
        Team2Body.setVisible(false);
        Team3Name.setVisible(false);
        Team3Body.setVisible(false);
        Team4Name.setVisible(false);
        Team4Body.setVisible(false);

        team1Napoveda1.setVisible(false);
        team1Napoveda2.setVisible(false);
        team1Napoveda3.setVisible(false);

        team2Napoveda1.setVisible(false);
        team2Napoveda2.setVisible(false);
        team2Napoveda3.setVisible(false);

        team3Napoveda1.setVisible(false);
        team3Napoveda2.setVisible(false);
        team3Napoveda3.setVisible(false);

        team4Napoveda1.setVisible(false);
        team4Napoveda2.setVisible(false);
        team4Napoveda3.setVisible(false);

        odpoved1.setVisible(false);
        odpoved2.setVisible(false);
        odpoved3.setVisible(false);
        odpoved4.setVisible(false);
        odpoved5.setVisible(false);
        odpoved6.setVisible(false);
        odpoved7.setVisible(false);

        odmena1.setVisible(false);
        odmena2.setVisible(false);
        odmena3.setVisible(false);
        odmena4.setVisible(false);
        odmena5.setVisible(false);
        odmena6.setVisible(false);
        odmena7.setVisible(false);

        otazkaLabel.setVisible(false);
        hledatSlovoButton.setVisible(false);
        NextOtazka.setVisible(false);
        ShowAll.setVisible(false);
        hledatSLovo.setVisible(false);
        ButtonCasovac.setVisible(false);
        nextTeamButton.setVisible(false);
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

        int cilpos =Gdx.graphics.getHeight() - 150;

        if(CoSOS.skipIntro == true){
            logoScale = logoTargetScale;
            logoPosition.y = cilpos;
            CoSOS.stopMusic();
        }

        if (logoScale > logoTargetScale) {
            logoScale -= delta * 0.07f;  // Úprava rychlosti změny velikosti
        }
        if(logoScale<= logoTargetScale) {
            if (logoPosition.y < cilpos) {
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
