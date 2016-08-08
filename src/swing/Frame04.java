package swing;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.BusinessSkin;
import org.jvnet.substance.skin.MistAquaSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;



import java.awt.*; 
import java.awt.event.*;

import javax.swing.JFrame; 
public class Frame04 extends JFrame 
{ 	
	static Frame03 f3;//ÿ�����ʹ��ͬһ��Frame03
	JPanel c1=new JPanel();
	Container c2=getContentPane();
	Container c3=getContentPane(); 
	JLabel label11;
	JTextField textField1;
	JLabel label12;
	JButton backButton1;
	JButton submitButton1;
	JLabel label21;
	JTextField textField2;
	JLabel label22;
	JButton backButton2;
	JButton submitButton2;
	JLabel label31;
	JTextField textField3;
	JLabel label32;
	JButton backButton3;
	JButton submitButton3;
	boolean flag;
	int id;
	int position;	//��ʶ���
	Point position1;
	
	// ȫ�ֵ�λ�ñ��������ڱ�ʾ����ڴ����ϵ�λ��
	static Point origin = new Point();
public Frame04(){ 	
	//��ȡͼ��ͼ��
	 java.net.URL url=getClass().getResource("/img/busoo1.jpg");
	 Image img1=Toolkit.getDefaultToolkit().getImage(url);
	
	//��������
	setLocation(0,280); 
	setSize(300, 180);
	setUndecorated(true);
	setTitle("Ա����2");
	setIconImage(img1);
	
	//���в���ʱ�޷�����ͼƬ
	//setLayout(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//��������
	Font font1=new Font("����",Font.BOLD,20); 
	Font font2=new Font("����",Font.BOLD,15);
	
	//��־��ʼ��
	flag=true;
	
	//��ʾ��ǩ
	label22 =new JLabel("Ա����2");
	label22.setVisible(true);
	label22.setBounds(70, 60, 200, 30);
	label22.setFont(font2);
	
	//��������
	//add(label22);
	//���ӻ�����Ӧ
	CanvasPanel2 canvas=new CanvasPanel2();
	canvas.addMouseListener(new MouseAdapter() {
		// ���£�mousePressed ���ǵ����������걻����û��̧��
		public void mousePressed(MouseEvent e) {
			// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
			origin.x = e.getX();
			origin.y = e.getY();
		}
	});
	
	canvas.addMouseMotionListener(new MouseMotionAdapter() {
		// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
		public void mouseDragged(MouseEvent e) {
			// ������϶�ʱ��ȡ���ڵ�ǰλ��
			Point p = getLocation();
			
			// ���ô��ڵ�λ��
			// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
			setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
		}
	});
	add(canvas);
	position=2;
	//�ж����λ��
	Thread threadD=new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				
				//Ϊʲôһ��Ҫִ����仰�Ż��ȡλ����Ϣ��
				
				getLocation().toString();
				if(getLocation().getX()>400&&getLocation().getX()<800){
					if(getLocation().getY()>300&getLocation().getY()<650){
						System.out.println("--------����ˢ������--------");
						try {
							Thread.sleep(500);
							mousePosition();
							Thread.sleep(1000);
							Thread.yield();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
			}
		}
	
	});
	//�����߳�
	threadD.start();		
			
 } 
public Frame04(int bianhao){
		
		//��������
		setLocation(0,50); 
		setSize(300, 180);
		setUndecorated(true);//�����ޱ߿����
		setVisible(true);
		setTitle("Ա����1");
		//setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��������
		Font font1=new Font("����",Font.BOLD,20); 
		Font font2=new Font("����",Font.CENTER_BASELINE,15);
		
		//��ȡͼ��ͼ��
		 java.net.URL url=getClass().getResource("/img/busoo1.jpg");
		 Image img1=Toolkit.getDefaultToolkit().getImage(url);
		
		 //��־��ʼ��
		flag=true;
		
		//���ý���
		setIconImage(img1);
		
		//�����ǩ
		label12 =new JLabel("Ա����1");
		label12.setVisible(true);
		label12.setBounds(70, 60, 200, 30);
		label12.setFont(font2);
		
		//�������������
		//add(label12);
		
		position=1;
		CanvasPanel1 canvas = new CanvasPanel1();
		
		//���ӻ�����Ӧ
		canvas.addMouseListener(new MouseAdapter() {
			// ���£�mousePressed ���ǵ����������걻����û��̧��
			public void mousePressed(MouseEvent e) {
				// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
				
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
			public void mouseDragged(MouseEvent e) {
				// ������϶�ʱ��ȡ���ڵ�ǰλ��
				Point p = getLocation();
				
				// ���ô��ڵ�λ��
				// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
		add(canvas);
		//�ж����λ��
				Thread threadB=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true){
							getLocation().toString();
							if(getLocation().getX()>400&&getLocation().getX()<800){
								if(getLocation().getY()>300&getLocation().getY()<650){
									System.out.println("--------����ˢ������--------");
									try {
										Thread.sleep(500);
										mousePosition();
										Thread.sleep(1000);
										Thread.yield();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									}
								}
						}
					}
				
				});
				threadB.start();
	}
public Frame04(String id1){ 	
	//��ȡͼ��ͼ��
	 java.net.URL url=getClass().getResource("/img/busoo1.jpg");
	 Image img1=Toolkit.getDefaultToolkit().getImage(url);
	
	//��������
	setLocation(0,510); 
	setSize(300, 180);
	setTitle("Ա����3");
	setUndecorated(true);//�����ޱ߿����
	setVisible(true);
	setIconImage(img1);
	//setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//��������
	Font font1=new Font("����",Font.BOLD,20); 
	Font font2=new Font("����",Font.CENTER_BASELINE,15);
	
	//��־��ʼ��
	flag=true;
	
	//�����ǩ
	label32 =new JLabel("Ա����3");
	label32.setVisible(true);
	label32.setBounds(70, 60, 200, 30);
	label32.setFont(font2);
	
	//��������
	//add(label32);
	//���ӻ�����Ӧ
	CanvasPanel3 canvas = new CanvasPanel3();
	canvas.addMouseListener(new MouseAdapter() {
		// ���£�mousePressed ���ǵ����������걻����û��̧��
		public void mousePressed(MouseEvent e) {
			// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
			
			origin.x = e.getX();
			origin.y = e.getY();
		}
	});
	
	canvas.addMouseMotionListener(new MouseMotionAdapter() {
		// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
		public void mouseDragged(MouseEvent e) {
			// ������϶�ʱ��ȡ���ڵ�ǰλ��
			Point p = getLocation();
			
			// ���ô��ڵ�λ��
			// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
			setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
		}
	});
	add(canvas);		
	
	position=3;
	Thread threadC=new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				
				getLocation().toString();
				//�趨ˢ������
				if(getLocation().getX()>400&&getLocation().getX()<800){
					if(getLocation().getY()>300&getLocation().getY()<650){
							System.out.println("--------����ˢ������--------");
						try {
							Thread.sleep(800);
							mousePosition();
							Thread.sleep(1000);
							Thread.yield();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
			}
		}
	
	});
	threadC.setPriority(4);
	threadC.start();
	
 } 
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
	
	f3=new Frame03();
	new Frame04();
	new Frame04(1);
	new Frame04("1");
    //Ƥ����Ч
    try {  
        //UIManager.setLookAndFeel(new SubstanceLookAndFeel());  
        JFrame.setDefaultLookAndFeelDecorated(true);  
        JDialog.setDefaultLookAndFeelDecorated(true);  
     // SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
        SubstanceLookAndFeel.setSkin(new OfficeBlue2007Skin());  
     // SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
      //SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
      //SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
     // SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
       // SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());  
    } catch (Exception e) {  
        System.err.println("������");  
    } 
	
}
//����¼�
public void mousePosition(){
				if(flag){	//position���ж��ĸ�����ı�־
						if(position==1)
							f3.drag("201410411105");
						if(position==2)
							f3.drag("201410421107");
						if(position==3)
							f3.drag("201310311221");
						//�ж����ĸ����
						if(position==1){
							setLocation(0,50);
						}else if(position==2){
							setLocation(0,280);
						}else{
							setLocation(0,510);
						}
						
					}
				}
//����1
class CanvasPanel1 extends Canvas{
	public void paint(final Graphics g){
		
		super.paint(g);
		final Graphics2D g2=(Graphics2D)g;
		Image img;
		java.net.URL url1=getClass().getResource("/img/card3.jpg");
		img=Toolkit.getDefaultToolkit().getImage(url1);
		g2.drawImage(img,0,0,305,185,this);
		
	}
}
//����2
class CanvasPanel2 extends Canvas{
	public void paint(final Graphics g){
	
		super.paint(g);
		final Graphics2D g2=(Graphics2D)g;
		Image img;
		java.net.URL url2=getClass().getResource("/img/card2.jpg");
		img=Toolkit.getDefaultToolkit().getImage(url2);
		g2.drawImage(img,0,0,305,185,this);
		
	}
}
//����3
class CanvasPanel3 extends Canvas{
	public void paint(final Graphics g){
		
		super.paint(g);
		final Graphics2D g2=(Graphics2D)g;
		Image img;
		java.net.URL url3=getClass().getResource("/img/card1.jpg");
		img=Toolkit.getDefaultToolkit().getImage(url3);
		g2.drawImage(img,0,0,305,185,this);
		
	}
}
public void directDrag(){
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

			




