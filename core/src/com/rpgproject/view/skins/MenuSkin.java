package com.rpgproject.view.skins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 4-12-2015.
 */
public class MenuSkin extends Skin {

    public MenuSkin()
    {
        super(Gdx.files.internal(Resources.getSkinPath("default")));
    }

}
