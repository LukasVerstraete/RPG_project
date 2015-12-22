package com.rpgproject.model.world.actions;

import com.rpgproject.controller.newControllers.GameController;

/**
 * Created by lukas on 21-12-2015.
 */
public class DialogAction extends Action {

    private String text;

    public DialogAction(String text)
    {
        this.text = text;
    }

    @Override
    public void perform(GameController controller) {
        controller.addMessage(text);
    }
}
