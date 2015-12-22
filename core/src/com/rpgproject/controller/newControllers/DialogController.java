package com.rpgproject.controller.newControllers;

import com.rpgproject.model.world.World;
import com.rpgproject.model.world.actions.DialogAction;
import com.rpgproject.model.world.actions.NextMessageAction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lukas on 21-12-2015.
 */
public class DialogController {

    private LinkedList<String> messages;

    public DialogController()
    {
        messages = new LinkedList<String>();
    }

    public void pushMessage(String message)
    {
        if(message != null)
            messages.addLast(message);
    }

    public void update(World world)
    {
        world.addAction(new NextMessageAction());
    }

    public void nextMessage(World world, GameController controller)
    {
        if(!messages.isEmpty())
        {
            controller.showDialog(messages.poll());
        }
        else
            controller.hideDialog();
    }
}
