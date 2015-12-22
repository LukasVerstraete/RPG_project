package com.rpgproject.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.HashMap;

/**
 * Created by Lukas on 8-12-2015.
 */
public class Resources {

    private static HashMap<String, String> strings = new HashMap<String, String>();
    private static HashMap<String, String> images = new HashMap<String, String>();
    private static HashMap<String, String> maps = new HashMap<String, String>();
    private static HashMap<String, String> skins = new HashMap<String, String>();
    private static HashMap<String, String> atlasses = new HashMap<String, String>();
    private static HashMap<String, FileHandle> files = new HashMap<String, FileHandle>();

    public static void addString(String key, String string)
    {
        if(string != null && key != null)
            strings.put(key, string);
    }

    public static void addImage(String key, String imagePath)
    {
        if(imagePath != null && key != null)
            images.put(key, "sprites/" + imagePath);
    }

    public static void addMap(String key, String mapPath)
    {
        if(mapPath != null && key != null)
            maps.put(key, "maps/" + mapPath);
    }

    public static void addSkin(String key, String skinPath)
    {
        if(skinPath != null && key != null)
            skins.put(key, "skins/" + skinPath);
    }

    public static void addAtlas(String key, String atlasPath)
    {
        if(atlasPath != null && key != null)
            atlasses.put(key, atlasPath);
    }

    public static void addFile(String key, String filePath)
    {
        if(key != null && filePath != null)
            files.put(key, Gdx.files.internal(filePath));
    }

    public static String getString(String key)
    {
        return strings.get(key);
    }

    public static String getImagePath(String key)
    {
        return images.get(key);
    }

    public static String getMapPath(String key)
    {
        return maps.get(key);
    }

    public static String getSkinPath(String key)
    {
        return skins.get(key);
    }

    public static String getAtlasPath(String key)
    {
        return atlasses.get(key);
    }

    public static FileHandle getFile (String key)
    {
        return files.get(key);
    }
}
