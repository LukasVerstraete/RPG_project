package com.rpgproject.view.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.rpgproject.resources.Resources;

/**
 * Created by lukas on 21-12-2015.
 */
public class GameLabel extends Label {
    public GameLabel(CharSequence text) {
        super(text, new Skin(Gdx.files.internal(Resources.getSkinPath("label"))));
        getStyle().background = new NinePatchDrawable(new NinePatch(new Texture(Resources.getImagePath("label")), 10, 10, 10, 10));
        setVisible(false);
    }
}
