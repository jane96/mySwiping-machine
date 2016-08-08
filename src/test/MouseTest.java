package test;

import java.awt.*; 

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 
public class MouseTest extends JFrame 
{ 
	JLabel label;
	JTextField text;
	Graphics2D g2;
	Container container=getContentPane();
	private JFrame frame;
	// 全局的位置变量，用于表示鼠标在窗口上的位置
	static Point origin = new Point();
public MouseTest() 
{ 
	
	frame = new JFrame();
	frame.setSize(300,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);
	frame.setUndecorated(true);
	 
	 frame.setBackground(Color.blue);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(new CanvasPanel1());
	initialize();
}


public static void main(String[] args) {
	new MouseTest().setVisible(true);
}
// MouseHandler is an inner class that implements the MouseListener. 
// Each method simply prints out a message to the command line. 

class CanvasPanel1 extends Canvas{
	public void paint( final Graphics g){
		
		System.out.println("图片绘制");
		super.paint(g);
		g2=(Graphics2D)g;
		Image img;
		java.net.URL url3=getClass().getResource("/img/card1.jpg");
		img=Toolkit.getDefaultToolkit().getImage(url3);
		g2.drawImage(img,5,5,200,100,this);
		Date date=new Date();
		
		g2.drawString(String.format("%tr", date), 125, 120);
		Thread threadB=new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					//String time=df.format(new Date());
					//label3.setText(time);
					//为什么不能用图片打印输出？
					
			
					try{
						System.out.println("图片绘制1");
						Thread.sleep(1000);
						
						 repaint(125,110,200,15); 
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}
			
		});
		threadB.start();
		
	}
}
private void initialize() {
	
	

	addMouseListener(new MouseAdapter() {
		// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
		public void mousePressed(MouseEvent e) {
			// 当鼠标按下的时候获得窗口当前的位置
			origin.x = e.getX();
			origin.y = e.getY();
		}
	});
	addMouseMotionListener(new MouseMotionAdapter() {
		// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
		public void mouseDragged(MouseEvent e) {
			// 当鼠标拖动时获取窗口当前位置
			Point p = getLocation();
			// 设置窗口的位置
			// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
			setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
		}
	});
}
}

