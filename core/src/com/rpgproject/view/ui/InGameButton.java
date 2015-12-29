package com.rpgproject.view.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.rpgproject.view.skins.MenuSkin;
import com.rpgproject.view.skins.MovementButtonStyle;

/**
 * Created by Lukas on 18-12-2015.
 */
public class InGameButton extends ImageButton {

    public InGameButton(MovementButtonStyle.Direction direction) {
        super(new MovementButtonStyle(direction));
    }
}
