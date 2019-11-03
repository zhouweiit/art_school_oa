package com.chengzi.art.school.framework.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.lang.reflect.Field;

/**
 * Created by zhouwei on 2019/10/16
 **/
@Slf4j
public class BeanPropertyUtil {

    public static void copyPropery(Object src, Object des){
        if(null == src){
            return;
        }
        try {
            Assert.notNull(des, "des object can't be null.");
            Class<? extends Object> srcClass = src.getClass();
            Class<? extends Object> descClass = des.getClass();
            Field[] srcFields = srcClass.getDeclaredFields();
            Field[] desFields = descClass.getDeclaredFields();
            for(int i=0; i<srcFields.length; i++){
                Field tmpSrcFiled = srcFields[i];
                tmpSrcFiled.setAccessible(true);
                String srcPropertyname = tmpSrcFiled.getName();
                Object value = tmpSrcFiled.get(src);
                for(int j=0; j<desFields.length; j++){
                    Field tmpDesFiled = desFields[j];
                    tmpDesFiled.setAccessible(true);
                    String desPropertyName = tmpDesFiled.getName();
                    if(desPropertyName.equals(srcPropertyname)){
                        tmpDesFiled.set(des, value);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
