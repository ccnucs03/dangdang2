package com.ccnu.dang.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

/**
 * 验证码
 * @author Christy
 *
 */
public class ImageVerityUtils {
	static Map<String,BufferedImage> map;
	public static Map<String,BufferedImage> getImage(){
		map=new HashMap<String,BufferedImage>();
		//画图片
		BufferedImage image=new BufferedImage(60,
				20,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g=image.getGraphics();
		//设置背景色
		g.setColor(Color.white);
		g.fillRect(0, 0, 60, 20);
		//画个边框
		g.setColor(Color.black);
		g.drawRect(0, 0, 59, 19);
		g.setColor(Color.blue);
		//随机数字
		Random r=new Random();
		//所有数字
		StringBuffer str=new StringBuffer();
		for(int i=0;i<4;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.setFont(new Font("宋体",Font.BOLD,20));
			String code=r.nextInt(10)+"";//[0-9]
			g.drawString(code, (i+1)*10, 15);
			str.append(code);
			g.drawLine(i,i*3,60-i, i*2);
		}
		//画一点干扰线		
		map.put(str.toString(), image);
		return map;
	}
	
	//封装一个图片流
	public static ByteArrayInputStream getArrayStream(Map<String,BufferedImage> map) throws ImageFormatException, IOException{
		Set<Entry<String, BufferedImage>> entry=map.entrySet();
		Iterator<Entry<String, BufferedImage>> it=entry.iterator();
		Entry<String,BufferedImage> e=it.next();
		BufferedImage image=e.getValue();
		ByteOutputStream os=new ByteOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
		byte[] bs=os.toByteArray();
		ByteArrayInputStream in=new ByteArrayInputStream(bs);
		return in;
		
	}
	//封装一个code
	public static String getCode(Map<String,BufferedImage> map){
		Set<Entry<String, BufferedImage>> entry=map.entrySet();
		Iterator<Entry<String, BufferedImage>> it=entry.iterator();
		Entry<String,BufferedImage> e=it.next();
		return e.getKey();
	}
}
