package com.rpgproject.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.StringBuilder;

import org.w3c.dom.Document;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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

    public static XmlReader.Element parseXmlFile(FileHandle file)
    {
        XmlReader xml = new XmlReader();
        XmlReader.Element root = null;
        try{
            System.out.println(file.exists());
            root = xml.parse(file);
            //System.out.println(root);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return root;
    }
}
