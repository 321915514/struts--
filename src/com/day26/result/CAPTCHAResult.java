package com.day26.result;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.StrutsResultSupport;
import com.opensymphony.xwork2.ActionInvocation;

import util.ImageUtil;

public class CAPTCHAResult extends StrutsResultSupport{
	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception{
		// TODO Auto-generated method stub
		ImageUtil imageUtil=new ImageUtil();
		BufferedImage image=imageUtil.getImage();
		HttpServletResponse response=ServletActionContext.getResponse();
		ImageUtil.output(image,response.getOutputStream());
	}


}
