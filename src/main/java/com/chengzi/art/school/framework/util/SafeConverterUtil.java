package com.chengzi.art.school.framework.util;

public class SafeConverterUtil {

    public static Boolean toBoolean(Object obj) {
        try {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return Boolean.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean toBoolean(Object obj, Boolean defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return toBoolean(obj);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Integer toInteger(Object obj) {
        try {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return Integer.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer toInteger(Object obj, Integer defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return toInteger(obj);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Float toFloat(Object obj) {
        try {
            if (obj instanceof Float) {
                return (Float) obj;
            }
            return Float.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return null;
        }
    }

    public static Float toFloat(Object obj, Float defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return toFloat(obj);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String toString(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static String toString(Object obj, String defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return String.valueOf(obj);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
