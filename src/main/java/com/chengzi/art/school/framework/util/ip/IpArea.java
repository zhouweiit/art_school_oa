package com.chengzi.art.school.framework.util.ip;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class IpArea {

	private int state=0;
	private int provice=0;
	private int city=0;
	//运营商
	private int operator=0;

}
