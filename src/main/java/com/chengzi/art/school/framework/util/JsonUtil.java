package com.chengzi.art.school.framework.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T json2object(String _json, Class cls) {
        try {
            if (_json == null || _json.equals(""))
            	if(java.util.List.class.isAssignableFrom(cls)){
            		_json = "[]";
            	}else{
            		_json = "{}";
            	}
            return (T) objectMapper.readValue(_json, cls);
        } catch (Exception e) {
            log.warn("json2object error", e);
        }
        return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T json2object(String _json, JavaType javaType) {
        try {
            if (_json == null || _json.equals(""))
            	if(java.util.List.class.isAssignableFrom(javaType.getRawClass())){
            		_json = "[]";
            	}else{
            		_json = "{}";
            	}
            return (T) objectMapper.readValue(_json, javaType);
        } catch (Exception e) {
            log.warn("json2object error", e);
        }
        return null;
    }

    public static String object2json(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("object2json error", e);
        }
        return null;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
         return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
    }   
}
