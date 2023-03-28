package com.moltenwolfcub.circles.data.serializers;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.moltenwolfcub.circles.level.CircleManager;
import com.moltenwolfcub.circles.level.Level;
import com.moltenwolfcub.circles.util.MoveRuleSet;

import java.lang.reflect.Type;

public class LevelDeserializer implements JsonDeserializer<Level> {
    private final Viewport view;

    public LevelDeserializer(Viewport view) {
        this.view = view;
    }

    @Override
    public Level deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        int lvlSize = obj.get("size").getAsInt();

        MoveRuleSet rules = new MoveRuleSetDeserializer().deserialize(obj.get("move_rules"), MoveRuleSet.class, context);

        return new Level(this.view, lvlSize, rules);
    }
}
