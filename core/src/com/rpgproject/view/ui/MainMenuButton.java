package com.rpgproject.view.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.rpgproject.view.skins.MenuSkin;

/**
 * Created by lukas on 3-12-2015.
 */
public class MainMenuButton extends TextButton{

    public MainMenuButton(String text)
    {
        super(text, new MenuSkin());
    }


}
