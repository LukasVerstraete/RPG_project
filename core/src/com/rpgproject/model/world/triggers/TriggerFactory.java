package com.rpgproject.model.world.triggers;

import com.rpgproject.model.world.WorldMap;

import java.util.ArrayList;

/**
 * Created by Lukas on 15-12-2015.
 */
public class TriggerFactory {

    private WorldMap map;

    public TriggerFactory(WorldMap map)
    {
        this.map = map;
    }

    public ArrayList<Trigger> getTriggers()
    {
        ArrayList<Trigger> triggers = new ArrayList<Trigger>();

        return triggers;
    }
}
