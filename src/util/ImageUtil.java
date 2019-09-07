package util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageUtil {
	private int w=70;
	private int h=35;
	private String[] fontname={"宋体","楷体","华文宋体","华文隶书","隶书"};
	private String codes="qwertyupasdfghjkzxcvbnm23456789QWERTYUPASDFGHJKLZXCVBNM";
	private Color color=new Color(255,255,255);
	private Random random=new Random();
	private String text;
	private Color randomColor() {
		int red=random.nextInt(150);
		int green=random.nextInt(150);
		int blue=random.nextInt(150);
		return new Color(green,red,blue);
		
	}
	public Font randomFont() {
		int index=random.nextInt(fontname.length);
		String fontname1=fontname[index];
		int style=random.nextInt(4);
		int size=random.nextInt(5)+24;
		return new Font(fontname1, style, size);
	}
	public BufferedImage getImage(){
		BufferedImage image=createImage();
		Graphics2D g2=(Graphics2D) image.getGraphics();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < 4; i++) {
			String s=randomChar()+"";
			sb.append(s);
			float x=i*1.0F* w/4;
			g2.setFont(randomFont());
			g2.setColor(randomColor());
			g2.drawString(s, x, h-5);
		}
		this.text=sb.toString();
		drawLine(image);
		return image;
	}
	private void drawLine(BufferedImage image) {
		// TODO Auto-generated method stub
		int num=3;
		Graphics2D g2=(Graphics2D) image.getGraphics();
		for (int i = 0; i < num; i++) {
			int x1=random.nextInt(w);
			int y1=random.nextInt(h);
			int x2=random.nextInt(w);
			int y2=random.nextInt(h);
			g2.setStroke(new BasicStroke(1.5F));
			g2.setColor(Color.blue);
			g2.drawLine(x1, y1, x2, y2);
			}
		}
	private char randomChar() {
		// TODO Auto-generated method stub
		int index=random.nextInt(codes.length());
		return codes.charAt(index);
	}
	private BufferedImage createImage() {
		// TODO Auto-generated method stub
		BufferedImage image=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=(Graphics2D) image.getGraphics();
		g2.setColor(this.color);
		g2.fillRect(0, 0, w, h);
		return image;
	}
	public String getText() {
		return text;
	}
	public static void  output(BufferedImage image,OutputStream out) throws Exception {
		ImageIO.write(image, "JPEG", out);
	}
	@Test
	public void fun() throws Exception, Exception {
		ImageUtil image=new ImageUtil();
		BufferedImage image2=image.getImage();
		ImageUtil.output(image2, new FileOutputStream("d:/hahahhaha.jpg"));
	}

}
