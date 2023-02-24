package com.ioiox.dei.core.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ioiox.dei.core.constant.DeiGlobalConstant;

import java.util.Collections;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper DEI_OBJECT_MAPPER = new ObjectMapper();
    static {
        DEI_OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DEI_OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        DEI_OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    public static <T> T parse(final String jsonStr, final Class<T> clazz) {
        try {
            return DEI_OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> List<T> parseList(final String json, final Class<T> elementType) {
        final JavaType type = DEI_OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, elementType);
        try {
            return DEI_OBJECT_MAPPER.readValue(json, type);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public static <T> T parse(final String jsonStr, final TypeReference<T> typeReference) {
        try {
            return DEI_OBJECT_MAPPER.readValue(jsonStr, typeReference);
        } catch (Exception e) {
            return null;
        }
    }

    public static String toJsonStr(final Object obj) {
        String jsonStr;
        try {
            jsonStr = DEI_OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            jsonStr = DeiGlobalConstant.ZERO_LENGTH_STR;
        }
        return jsonStr;
    }
}
