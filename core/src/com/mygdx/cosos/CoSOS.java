	package com.mygdx.cosos;

	import com.badlogic.gdx.ApplicationAdapter;
	import com.badlogic.gdx.Game;
	import com.badlogic.gdx.Gdx;
	import com.badlogic.gdx.Input;
	import com.badlogic.gdx.audio.Sound;
	import com.badlogic.gdx.graphics.GL20;
	import com.badlogic.gdx.graphics.Texture;
	import com.badlogic.gdx.graphics.g2d.BitmapFont;
	import com.badlogic.gdx.graphics.g2d.SpriteBatch;
	import com.badlogic.gdx.math.Interpolation;
	import com.badlogic.gdx.scenes.scene2d.InputEvent;
	import com.badlogic.gdx.scenes.scene2d.Stage;
	import com.badlogic.gdx.scenes.scene2d.ui.Skin;
	import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
	import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
	import com.badlogic.gdx.utils.ScreenUtils;
	import com.mygdx.cosos.Sada.Odpoved;
	import com.mygdx.cosos.Sada.Otazka;
	import com.mygdx.cosos.Tym.Tym;
	import com.mygdx.cosos.UI.GameUI;
	import com.mygdx.cosos.UI.MenuUI;
	import com.mygdx.cosos.UI.SettingsUI;
	import java.io.*;
	import java.nio.charset.StandardCharsets;
	import java.text.Normalizer;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	import java.util.regex.Pattern;

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
		private static Sound TimerMusic;

		public static boolean reset = false;

		public static Tym[] Tymy = new Tym[4];
		private SettingsUI settingsUI;
		public static boolean IntroAnim = false;

		public static Otazka Otazka;

		public static boolean odpoved1uhodnuto = false;
		public static boolean odpoved2uhodnuto = false;
		public static boolean odpoved3uhodnuto = false;
		public static boolean odpoved4uhodnuto = false;
		public static boolean odpoved5uhodnuto = false;
		public static boolean odpoved6uhodnuto = false;
		public static boolean odpoved7uhodnuto = false;
		public static int ActiveTeam = 1;
		public static boolean fullscreen;
		public static boolean skipIntro;
		private static long startTime;
		private static long duration = 30000; // Délka písničky v milisekundách
		private static long warningTime = 10000;
		public CoSOS(Boolean fullscreen) {
			this.fullscreen = fullscreen;
		}

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
            TimerMusic = Gdx.audio.newSound(Gdx.files.internal("Audio/coSOScas30s.mp3"));
            pocetTymu = 4;

        }
		public static void SetGame(String tym1, String tym2, String tym3, String tym4){
			skipIntro = false;
			ActiveTeam = 1;
			odpoved1uhodnuto = false;
			odpoved2uhodnuto = false;
			odpoved3uhodnuto = false;
			odpoved4uhodnuto = false;
			odpoved5uhodnuto = false;
			odpoved6uhodnuto = false;
			odpoved7uhodnuto = false;
			switch (pocetTymu){
				case 2:
					Tymy[0] = new Tym(tym1,0,false,false,false);
					Tymy[1] = new Tym(tym2,0, false,false,false);
					break;
				case 3:
					Tymy[0] = new Tym(tym1,0, false,false,false);
					Tymy[1] = new Tym(tym2,0, false,false,false);
					Tymy[2] = new Tym(tym3,0, false,false,false);
					break;
				case 4:
					Tymy[0] = new Tym(tym1,0, false,false,false);
					Tymy[1] = new Tym(tym2,0,false,false,false );
					Tymy[2] = new Tym(tym3,0, false,false,false);
					Tymy[3] = new Tym(tym4,0, false,false,false);
					break;
			}
			IntroMusic.play(0.5f);

		}
		public static void StartTimerMusic(){
			TimerMusic.play(0.5f);
		}
		public static void StopTimerMusic(){
			TimerMusic.stop();
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
				Gdx.gl.glClearColor(0f, 0f, 42f / 255f, 0.9f);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

					if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
						if(IntroAnim == false){
						skipIntro = true;
						}
					}
					if(IntroAnim == true){
						GameUI.AktulizaceShowOdpovedi();
						GameUI.aktulizovatBody();
					}
					break;
			}

		}
		public static String removeDiacritics(String input) {
			String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(normalized).replaceAll("");
		}
        public static void hledatOdpoved(String hledane){
            int i = 1;
            int pozice = 0;
            for (Odpoved odpoved : Otazka.getOdpovedi()) {
                hledane = hledane.trim().toLowerCase();
                hledane = removeDiacritics(hledane);

				String vysledek = odpoved.getText().trim().toLowerCase();
				vysledek = orezatKoncovky(vysledek);
				vysledek = removeDiacritics(vysledek);

                // Porovnání s využitím Levenshteinovy vzdálenosti
                int vzdalenost = getLevenshteinDistance(hledane, vysledek);
                if (vzdalenost < 3) { // Přípustný počet odlišností (lze upravit)
                    pozice = i;
                    break;
                }
                i++;
            }
			int aktivni = ActiveTeam - 1;
			switch (pozice){
				case 1:
					if(odpoved1uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 1000);
						odpoved1uhodnuto = true;
						ActiveTeam++;
					}

					break;
				case 2:
					if(odpoved2uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 900);
						odpoved2uhodnuto = true;
						ActiveTeam++;
					}
					break;
				case 3:
					if(odpoved3uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 800);
						odpoved3uhodnuto = true;
						ActiveTeam++;
					}
					break;
				case 4:
					if(odpoved4uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 700);
						odpoved4uhodnuto = true;
						ActiveTeam++;
					}
					break;
				case 5:
					if(odpoved5uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 600);
						odpoved5uhodnuto = true;
						ActiveTeam++;
					}
					break;
				case 6:
					if(odpoved6uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 500);
						odpoved6uhodnuto = true;
						ActiveTeam++;
					}
					break;
				case 7:
					if(odpoved7uhodnuto == false) {
						Tymy[aktivni].setBody(Tymy[aktivni].getBody() + 400);
						odpoved7uhodnuto = true;
						ActiveTeam++;
					}
					break;
				default:
					System.out.println("pozice: " + pozice);
					ActiveTeam++;
					break;
			}
			if(ActiveTeam > pocetTymu){
				ActiveTeam = 1;
			}
		}
		private static String orezatKoncovky(String slovo) {
			String[] koncovky = {"ou", "ami", "ama", "a", "y", "u"};
			for (String koncovka : koncovky) {
				if (slovo.endsWith(koncovka)) {
					slovo = slovo.substring(0, slovo.length() - koncovka.length());
					break;
				}
			}
			return slovo;
		}
        public static int getLevenshteinDistance(String s, String t) {
            int m = s.length();
            int n = t.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else if (j == 0) {
                        dp[i][j] = i;
                    } else {
                        int cost = (s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1;
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                    }
                }
            }

            return dp[m][n];
        }
		public static void NovaOtazka() throws IOException {
			CoSOS.odpoved1uhodnuto = false;
			CoSOS.odpoved2uhodnuto = false;
			CoSOS.odpoved3uhodnuto = false;
			CoSOS.odpoved4uhodnuto = false;
			CoSOS.odpoved5uhodnuto = false;
			CoSOS.odpoved6uhodnuto = false;
			CoSOS.odpoved7uhodnuto = false;
			String cestaKSouboru = "assets/Otazky/tabulka.csv";

			List<String> radky = nactiRadkyZeSouboru(cestaKSouboru);

			if (!radky.isEmpty() && radky.equals(",1,,2,,3,,4,,5,,6,,7,,8,,9,,10,,11,,12,,13,,14,,15,,16,,17,,18,,19,,20")) {
				radky.remove(0);
			}
			String nahodnyRadek = "";
			for(int m = 0; m < 1;) {
				nahodnyRadek = nahodnyVyberRadku(radky);
				if (nahodnyRadek.equals(",1,,2,,3,,4,,5,,6,,7,,8,,9,,10,,11,,12,,13,,14,,15,,16,,17,,18,,19,,20")){
					System.out.println("První řádek");
					nahodnyRadek = nahodnyVyberRadku(radky);
				}else {
					m = 2;
				}
			}
			System.out.println(nahodnyRadek);
			if (nahodnyRadek != null) {
				String[] hodnoty = nahodnyRadek.split(",");

				String otazkaText = hodnoty[0];
				List<Odpoved> odpovedi = new ArrayList<>();
				System.out.println(otazkaText);
				for (int i = 1; i < hodnoty.length; i++) {
					if (!hodnoty[i].isEmpty()) {
						String odpovedText = hodnoty[i];
						System.out.println(odpovedText);
						i++;

						// Ověření, zda další hodnota existuje a není prázdná
						if (i < hodnoty.length && !hodnoty[i].isEmpty()) {
							try {
								int pocetHlasu = Integer.parseInt(hodnoty[i]);
								Odpoved odpoved = new Odpoved(odpovedText, pocetHlasu);
								odpovedi.add(odpoved);
							} catch (NumberFormatException e) {
								System.out.println("Chyba při převodu na číslo pro odpověď: " + odpovedText);
								// Můžete přijmout výchozí hodnotu pro pocetHlasu nebo provést jinou obsluhu chyby
							}
						}
					}
				}

				Otazka = new Otazka(otazkaText,odpovedi);
				/*for (Odpoved odpoved : Otazka.getOdpovedi()) {
					System.out.println(odpoved.getText() + " - Hlasy: " + odpoved.getHlasy());
				}*/

			} else {
				System.out.println("NIC");
			}

		}
		private static List<String> nactiRadkyZeSouboru(String cesta) throws IOException {
			List<String> radky = new ArrayList<>();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("assets/Otazky/tabulka.csv"), StandardCharsets.UTF_8));

			String radek;
			while ((radek = bufferedReader.readLine()) != null) {
				radky.add(radek);
			}

			bufferedReader.close();
			return radky;
		}

		private static String nahodnyVyberRadku(List<String> radky) {
			if (radky.isEmpty()) {
				return null; // Neexistují žádné řádky k výběru
			}

			Random random = new Random();
			int nahodneCislo = random.nextInt(radky.size());

			return radky.get(nahodneCislo);
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
