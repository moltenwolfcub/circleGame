package com.moltenwolfcub.circles.data.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.moltenwolfcub.circles.level.CircleManager;
import com.moltenwolfcub.circles.level.Level;

import java.lang.reflect.Type;

public class LevelSerializer implements JsonSerializer<Level> {
    @Override
    public JsonElement serialize(Level lvl, Type type, JsonSerializationContext context) {
        CircleManager manager = lvl.getManager();

        JsonObject serializedLvl = new JsonObject();
        TypeToken.get(type);

        JsonElement rules = new MoveRuleSetSerializer().serialize(manager.getRules(), manager.getRules().getClass(), context);
        serializedLvl.add("move_rules", rules);

        serializedLvl.addProperty("size", manager.size());

        return serializedLvl;
    }
}
