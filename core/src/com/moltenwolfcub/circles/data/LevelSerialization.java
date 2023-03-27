package com.moltenwolfcub.circles.data;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moltenwolfcub.circles.data.serializers.LevelSerializer;
import com.moltenwolfcub.circles.level.Level;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LevelSerialization {

    public static void write(Level lvl) throws IOException {
        String fileName = "data/level/level_01.json";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Level.class, new LevelSerializer())
                .create();
        String output = gson.toJson(lvl);

        File file = new File(fileName);
        file.getParentFile().mkdirs();
        file.createNewFile();

        FileWriter writer = new FileWriter(Gdx.files.internal(fileName).file());
        writer.write(output);
        writer.close();
    }
}
