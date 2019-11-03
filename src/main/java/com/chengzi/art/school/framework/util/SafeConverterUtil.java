package com.chengzi.art.school.framework.util;

public class SafeConverterUtil {

    public static Boolean toBoolean(Object obj) {
        try {
            return (Boolean) obj;
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean toBoolean(Object obj, Boolean defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return (Boolean) obj;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Integer toInteger(Object obj) {
        try {
            return (Integer) obj;
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer toInteger(Object obj, Integer defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return (Integer) obj;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Float toFloat(Object obj) {
        try {
            return (Float) obj;
        } catch (Exception e) {
            return null;
        }
    }

    public static Float toFloat(Object obj, Float defaultValue) {
        try {
            if (null == obj) {
                return defaultValue;
            }
            return (Float) obj;
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
