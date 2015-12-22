package com.rpgproject.view.skins;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 19-12-2015.
 */
public class MovementButtonStyle extends ImageButton.ImageButtonStyle {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT, ACTION
    }

    public MovementButtonStyle(Direction direction)
    {
        super();
        init(direction);
    }

    private void init(Direction type)
    {
        TextureAtlas atlas = new TextureAtlas(Resources.getFile("navigationUI"));
        Skin skin = new Skin(atlas);
        switch (type)
        {
            case UP:
                up = skin.getDrawable("buttonUp");
                break;
            case DOWN:
                up = skin.getDrawable("buttonDown");
                break;
            case LEFT:
                up = skin.getDrawable("buttonLeft");
                break;
            case RIGHT:
                up = skin.getDrawable("buttonRight");
                break;
            case ACTION:
                up = skin.getDrawable("buttonAction");
                break;
        }
    }
}
