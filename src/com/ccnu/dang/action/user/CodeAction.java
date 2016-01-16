package com.ccnu.dang.action.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ccnu.dang.util.ImageVerityUtils;
import com.sun.image.codec.jpeg.ImageFormatException;


public class CodeAction {
	
	private ByteArrayInputStream inputStream;
	public String execute() throws ImageFormatException, IOException{
		//System.out.println("======");
		Map<String,BufferedImage> map=ImageVerityUtils.getImage();
		//System.out.println(map);
		String code=ImageVerityUtils.getCode(map);	
		HttpServletRequest request=
			ServletActionContext.getRequest();
		request.getSession().setAttribute("code", code);
		
		inputStream=ImageVerityUtils.getArrayStream(map);
		return "success";
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
}