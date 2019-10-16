package com.chengzi.study.validate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashMap;
import java.util.Map;


public class MapMessage extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = -5410799397055048515L;

    private static final String __duplicatedOperation = "__duplicatedOperation";

    // ========================================================================
    // success
    // ========================================================================

    public MapMessage setSuccess(Boolean v) {
        put("success", v);
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        Object value = get("success");
        return Boolean.parseBoolean(value.toString());
    }

    /**
     * 仅用于兼容之前的 Message 对象的代码
     *
     * @return {@link #isSuccess()}
     */
    @JsonIgnore
    @Deprecated
    public boolean getSuccess() {
        return isSuccess();
    }

    // ========================================================================
    // info
    // ========================================================================

    @JsonIgnore
    public MapMessage setInfo(String s) {
        put("info", s);
        return this;
    }

    @JsonIgnore
    public String getInfo() {
        Object value = get("info");
        if (value == null) {
            return "";
        }
        if (!(value instanceof String)) {
            return "";
        }
        return (String) value;
    }

    // ========================================================================
    // errorUrl and errorCode
    // ========================================================================

    public MapMessage setErrorUrl(String s) {
        put("errorUrl", s);
        return this;
    }

    @JsonIgnore
    public String getErrorUrl() {
        Object value = get("errorUrl");
        if (value == null) {
            return "";
        }
        if (!(value instanceof String)) {
            return "";
        }
        return (String) value;
    }

    public void clearErrorUrl() {
        remove("errorUrl");
    }

    public MapMessage setErrorCode(String s) {
        put("errorCode", s);
        return this;
    }

    @JsonIgnore
    public String getErrorCode() {
        Object value = get("errorCode");
        if (value == null) {
            return "";
        }
        if (!(value instanceof String)) {
            return "";
        }
        return (String) value;
    }

    public void clearErrorCode() {
        remove("errorCode");
    }


    public MapMessage withDuplicatedException() {
        return add(__duplicatedOperation, Boolean.TRUE);
    }

    @JsonIgnore
    public boolean hasDuplicatedException() {
        return containsKey(__duplicatedOperation);
    }


    // ========================================================================
    // add & set
    // ========================================================================

    public MapMessage add(String k, Object v) {
        Object last = super.put(k, v);
        if (last != null) {
            throw new IllegalArgumentException("key " + k + " already exists in map, overwritten by new value");
        }
        return this;
    }

    public MapMessage set(String k, Object v) {
        super.put(k, v);
        return this;
    }

    public static MapMessage successMessage() {
        return null;
    }

    public static MapMessage successMessage(String info) {
        return null;
    }

    public static MapMessage errorMessage() {
        return null;
    }

    public static MapMessage errorMessage(String info) {
        return null;
    }
}