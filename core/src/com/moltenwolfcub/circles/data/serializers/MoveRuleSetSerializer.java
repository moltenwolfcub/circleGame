package com.moltenwolfcub.circles.data.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.moltenwolfcub.circles.util.MoveRuleSet;

import java.lang.reflect.Type;

public class MoveRuleSetSerializer implements JsonSerializer<MoveRuleSet> {
    @Override
    public JsonElement serialize(MoveRuleSet rules, Type type, JsonSerializationContext context) {
        JsonObject serialized = new JsonObject();
        serialized.addProperty("min_jump", rules.defaultJumpMin);
        serialized.addProperty("max_jump", rules.defaultJumpMax);

        return serialized;
    }
}
