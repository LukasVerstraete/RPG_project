package com.rpgproject.view.skins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.rpgproject.resources.Resources;

/**
 * Created by lukas on 21-12-2015.
 */
public class InGameLabelStyle extends Label.LabelStyle {

    public InGameLabelStyle()
    {
        NinePatch patch = new NinePatch(new Texture(Resources.getImagePath("label")), 10, 10, 10, 10);
        Skin skin = new Skin(Gdx.files.internal(Resources.getSkinPath("label")));
        skin.add("background", patch);
        background = skin.getDrawable("background");
        font = skin.getFont("default-font");
    }

}
