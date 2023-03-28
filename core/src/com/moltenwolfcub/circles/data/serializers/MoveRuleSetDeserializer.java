package com.moltenwolfcub.circles.data.serializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.moltenwolfcub.circles.util.MoveRuleSet;

import java.lang.reflect.Type;

public class MoveRuleSetDeserializer implements JsonDeserializer<MoveRuleSet> {
    @Override
    public MoveRuleSet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();

        Integer min = obj.get("min_jump").getAsInt();
        Integer max = obj.get("max_jump").getAsInt();

        return new MoveRuleSet(min, max);
    }
}
