package com.chengzi.art.school.framework.util;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

/**
 * 字符串工具类
 *
 */
public class StringUtil {

	public static boolean isBlank(String str) {
		if (null == str || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNotBlank(String str) {
		if (null != str && !str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String str) {
		if (null == str || str.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmtpy(String str) {
		if (null != str && !str.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 将一个字符串数据使用一个字符相连
	 * @param infos
	 * @param str
	 * @return
	 */
	public static String implode(List<String> infos, String str){
		if (CollectionUtils.isEmpty(infos)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String info : infos){
			if (sb.length() > 0){
				sb.append(str);
			}
			sb.append(info);
		}
		return sb.toString();
	}

	/**
	 * 将一个字符串数据使用一个字符相连
	 * @param infos
	 * @param str
	 * @return
	 */
	public static String implode(String[] infos, String str){
		if (infos == null || infos.length == 0){
			return "";
		}
		return implode(Lists.newArrayList(infos),str);
	}

	/**
	 * 切割一个字符串为list
	 * @param infos
	 * @param str
	 * @return
	 */
	public static String[] splitString(String infos, String str){
		if (null == infos) {
			return new String[]{};
		}
		String[] infosArray = infos.split(str);
		return infosArray;
	}

	/**
	 * 切割一个字符串为List
	 * @param infos
	 * @param str
	 * @return
	 */
	public static List<String> splitStringList(String infos, String str){
		String[] result = splitString(infos, str);
		return Lists.newArrayList(result);
	}
}
