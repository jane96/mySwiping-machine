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
	// ȫ�ֵ�λ�ñ��������ڱ�ʾ����ڴ����ϵ�λ��
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
		
		System.out.println("ͼƬ����");
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
					//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					//String time=df.format(new Date());
					//label3.setText(time);
					//Ϊʲô������ͼƬ��ӡ�����
					
			
					try{
						System.out.println("ͼƬ����1");
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
		// ���£�mousePressed ���ǵ����������걻����û��̧��
		public void mousePressed(MouseEvent e) {
			// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
			origin.x = e.getX();
			origin.y = e.getY();
		}
	});
	addMouseMotionListener(new MouseMotionAdapter() {
		// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
		public void mouseDragged(MouseEvent e) {
			// ������϶�ʱ��ȡ���ڵ�ǰλ��
			Point p = getLocation();
			// ���ô��ڵ�λ��
			// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
			setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
		}
	});
}
}

