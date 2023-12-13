package com.mygdx.cosos.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

public class ManagerUI {
    public static BitmapFont setFont(BitmapFont font){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/BebasNeue-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 32;
        parameter.characters =  parameter.characters  + "ěščřžýáíéĚŠČŘŽÝÁÍÉ"; // přidejte všechny znaky, které chcete zahrnout
        font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

}
