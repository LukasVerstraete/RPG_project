package com.rpgproject.view.skins;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 18-12-2015.
 */
public class InGameSkin extends Skin {

    public InGameSkin()
    {
        super(new TextureAtlas(Resources.getAtlasPath("in-gameUI")));
    }

}
