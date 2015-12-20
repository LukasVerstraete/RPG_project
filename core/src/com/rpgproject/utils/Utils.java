package com.rpgproject.utils;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by Lukas on 4-12-2015.
 */
public class Utils {

    //returns the amount of pixels relative to the screen
    public static float getRelativeSizeWidth(float percentage)
    {
        return (Gdx.graphics.getWidth()/100) * percentage;
    }

    public static float getRelativeSizeHeight(float percentage)
    {
        return (Gdx.graphics.getHeight()/100) * percentage;
    }

    public static int[] toArray(ArrayList<Integer> integers)
    {
        int[] ints = new int[integers.size()];
        for(int i = 0; i < integers.size(); i++)
        {
            ints[i] = integers.get(i);
        }
        return ints;
    }
}
