package com.chengzi.art.school.framework.task;

import com.chengzi.art.school.framework.util.JsonUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个property需要传给task，继承该类的新属性必须都要实现Cloneable
 * 
 * @author zhouwei
 */
@Slf4j
@Data
public class Property implements Cloneable{
	
	public static final String MONITOR_PROPERTY_GROUP_KEYNAME = "phone_group";

	public static final String MONITOR_PROPERTY_GROUP_ONEPIECE_KEYNAME = "onepiece_group";

	public static final String MONITOR_PROPERTY_PHONE_KEYNAME = "phone";

	public Integer msgType;

	public String taskName;
	
	private Map<String,List> monitorConfig = new HashMap<String,List>();

	/**
	 * config信息
	 */
	private Map<String,Object> config = new HashMap<String,Object>();
	
	/**
	 * 配置的json串
	 */
	private String propertyJson;
	
	/**
	 * 监控的json串
	 */
	private String monitorConfigJson;
	
	public Property(){
	}
	
	public Property(String property,String monitorProperty) throws TaskException{
		this.propertyJson = property;
		if (property != null && !property.trim().isEmpty()){
			try {
				config = JsonUtil.json2object(this.propertyJson, Map.class);
			} catch (Exception e) {
				throw new TaskException("init property failed , the property is not json type , json:{}" + property);
			}
		}
		this.monitorConfigJson = monitorProperty;
		if (monitorProperty != null && !monitorProperty.trim().isEmpty()){
			try {
				monitorConfig = JsonUtil.json2object(this.monitorConfigJson, Map.class);
			} catch (Exception e) {
				throw new TaskException("init property failed , the monitor property is not json type , json:{}" + monitorProperty);
			}
		}
	}
	
	/**
	 * 获取监控需要发送的电话号码
	 * @return
	 * @author ZHOUWEI4
	 */
	public List<Integer> getPhone(){
		return monitorConfig.get(MONITOR_PROPERTY_PHONE_KEYNAME) == null ? new ArrayList<Integer>() : monitorConfig.get(MONITOR_PROPERTY_PHONE_KEYNAME);
	}
	
	/**
	 * 获取监控需要发送的电话号码分组
	 * @return
	 * @author ZHOUWEI4
	 */
	public List<Integer> getPhoneGroup(){
		return monitorConfig.get(MONITOR_PROPERTY_GROUP_KEYNAME) == null ? new ArrayList<Integer>() : monitorConfig.get(MONITOR_PROPERTY_GROUP_KEYNAME);
	}

	/**
	 * 获取监控需要发送的onepiece报警组
	 * @return
	 * @author ZHOUWEI4
	 */
	public List<Map> getOnePieceGroup(){
		return monitorConfig.get(MONITOR_PROPERTY_GROUP_ONEPIECE_KEYNAME) == null ? new ArrayList<Map>() : monitorConfig.get(MONITOR_PROPERTY_GROUP_ONEPIECE_KEYNAME);
	}
	
	/**
	 * 获取配置信息
	 * @param key
	 * @return
	 */
	public Object getProperty(String key){
		return this.config.get(key);
	}
	
	/**
	 * 设置配置信息
	 * @param key
	 * @param value
	 */
	public void setProperty(String key,Object value){
		this.config.put(key, value);
	}
	
	@Override
	public Property clone(){
		Property property = null;
		try {
			property = (Property) super.clone();
		} catch (CloneNotSupportedException e) {
			log.error("property fail",e);
		}
		return property;
	}
	
}
