package com.moltenwolfcub.circles.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.moltenwolfcub.circles.data.serializers.LevelDeserializer;
import com.moltenwolfcub.circles.data.serializers.LevelSerializer;
import com.moltenwolfcub.circles.level.Level;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LevelSerialization {

    public static void clearData() {
        Path toDelete = new File("data/level/").toPath();
        try (Stream<Path> pathStream = Files.walk(toDelete)) {
            pathStream.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(Level lvl, int lvlId) {
        String fileName = "data/level/level_"+lvlId+".json";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Level.class, new LevelSerializer())
                .create();
        String output = gson.toJson(lvl);

        try {
            File file = new File(fileName);
            file.getParentFile().mkdirs();
            file.createNewFile();

            FileWriter writer = new FileWriter(Gdx.files.internal(fileName).file());
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Level read(String lvlFile, Viewport view) {

        JsonElement json;
        try {
            File file = new File(lvlFile);
            json = JsonParser.parseReader(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Level.class, new LevelDeserializer(view))
                .create();
        return gson.fromJson(json, Level.class);
    }
    public static Level read(int lvlId, Viewport view) {
        String fileName = "data/level/level_"+lvlId+".json";
        return LevelSerialization.read(fileName, view);
    }

    public static List<Level> readAll(Viewport view) {
        File directoryPath = new File("data/level");
        List<Level> levels = new ArrayList<>();
        for (String dir : Objects.requireNonNull(directoryPath.list())) {
            levels.add(LevelSerialization.read(directoryPath.getPath()+"/"+dir, view));
        }
        return levels;
    }
}
