package com.chengzi.art.school.framework.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 *
 * ApiController的通用Result接口
 *
 * @author zhouwei
 *
 */
@Data
public class ApiResultDto<T>{
	
	@JsonProperty("resultCode")
	private Integer resultCode;
	
	@JsonProperty("resultMessage")
	private String resultMessage;
	
	@JsonProperty("result")
	@JsonInclude(Include.NON_NULL) 
	private T result;
	
	public static <E> ApiResultDto<E> getInstance200(){
		ApiResultDto<E> dto = new ApiResultDto<>();
		dto.setResultCode(200);
		dto.setResultMessage("请求成功");
		return dto;
	}
	
	public static <E> ApiResultDto<E> getInstanceError400(String message){
		ApiResultDto<E> dto = new ApiResultDto<>();
		dto.setResultCode(400);
		dto.setResultMessage(message);
		return dto;
	}

	public static <E> ApiResultDto<E> getInstanceError500(String message){
		ApiResultDto<E> dto = new ApiResultDto<>();
		dto.setResultCode(500);
		dto.setResultMessage("内部错误，请联系管理员");
		return dto;
	}

	public static <E> ApiResultDto<E> getInstanceError(int code, String message){
		ApiResultDto<E> dto = new ApiResultDto<>();
		dto.setResultCode(code);
		dto.setResultMessage(message);
		return dto;
	}

}
