package com.rpgproject.model.world.triggers;

import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.World;
import com.rpgproject.model.world.actions.DialogAction;
import com.rpgproject.resources.Resources;

/**
 * Created by lukas on 21-12-2015.
 */
public class DialogTrigger extends Trigger {

    private String dialog;

    public DialogTrigger(Rectangle actionField, String dialog) {
        super(actionField);
        this.dialog = dialog;
    }

    @Override
    public void act(float delta, World world) {
        world.addAction(new DialogAction(Resources.getString(dialog)));
    }
}
