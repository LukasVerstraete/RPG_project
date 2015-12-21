package com.rpgproject.model.world.triggers;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.World;
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
        MapObjects triggerObjects = map.getMap().getLayers().get("triggers").getObjects();
        createTriggers(triggers, triggerObjects);
        return triggers;
    }

    private void createTriggers(ArrayList<Trigger> triggers, MapObjects triggerObjects)
    {
        for(MapObject object : triggerObjects)
        {
            RectangleMapObject rect = (RectangleMapObject) object;
            String[] triggerFormat = rect.getName().split("_");
            triggers.add(interpreteTrigger(triggerFormat, rect.getRectangle()));
        }
    }

    private Trigger interpreteTrigger(String[] triggerFormat, Rectangle actionField)
    {
        Trigger trigger = null;
        String type = triggerFormat[0];
        if(type.equals("00"))
        {
            String target = triggerFormat[1];
            String targetLocation = triggerFormat[2];
            trigger = new ChangeMapTrigger(actionField, target, targetLocation);
        }
        return trigger;
    }
}
