package com.wechat.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @项目名称：wechat-server
 * @类名称：Result
 */
@XmlRootElement(name="result")
public class RequestResult implements Serializable {

	private static final long serialVersionUID = 4514399597330417533L;

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + "]";
	}

}
