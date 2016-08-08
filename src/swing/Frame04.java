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
	static Frame03 f3;//每个组件使用同一个Frame03
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
	int position;	//标识组件
	Point position1;
	
	// 全局的位置变量，用于表示鼠标在窗口上的位置
	static Point origin = new Point();
public Frame04(){ 	
	//获取图标图标
	 java.net.URL url=getClass().getResource("/img/busoo1.jpg");
	 Image img1=Toolkit.getDefaultToolkit().getImage(url);
	
	//设置容器
	setLocation(0,280); 
	setSize(300, 180);
	setUndecorated(true);
	setTitle("员工卡2");
	setIconImage(img1);
	
	//当有布局时无法加载图片
	//setLayout(null);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//设置字体
	Font font1=new Font("宋体",Font.BOLD,20); 
	Font font2=new Font("宋体",Font.BOLD,15);
	
	//标志初始化
	flag=true;
	
	//显示标签
	label22 =new JLabel("员工卡2");
	label22.setVisible(true);
	label22.setBounds(70, 60, 200, 30);
	label22.setFont(font2);
	
	//加入容器
	//add(label22);
	//增加画布响应
	CanvasPanel2 canvas=new CanvasPanel2();
	canvas.addMouseListener(new MouseAdapter() {
		// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
		public void mousePressed(MouseEvent e) {
			// 当鼠标按下的时候获得窗口当前的位置
			origin.x = e.getX();
			origin.y = e.getY();
		}
	});
	
	canvas.addMouseMotionListener(new MouseMotionAdapter() {
		// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
		public void mouseDragged(MouseEvent e) {
			// 当鼠标拖动时获取窗口当前位置
			Point p = getLocation();
			
			// 设置窗口的位置
			// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
			setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
		}
	});
	add(canvas);
	position=2;
	//判断鼠标位置
	Thread threadD=new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				
				//为什么一定要执行这句话才会获取位置信息？
				
				getLocation().toString();
				if(getLocation().getX()>400&&getLocation().getX()<800){
					if(getLocation().getY()>300&getLocation().getY()<650){
						System.out.println("--------进入刷卡区域--------");
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
	//启动线程
	threadD.start();		
			
 } 
public Frame04(int bianhao){
		
		//设置容器
		setLocation(0,50); 
		setSize(300, 180);
		setUndecorated(true);//设置无边框标题
		setVisible(true);
		setTitle("员工卡1");
		//setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置字体
		Font font1=new Font("宋体",Font.BOLD,20); 
		Font font2=new Font("宋体",Font.CENTER_BASELINE,15);
		
		//获取图标图标
		 java.net.URL url=getClass().getResource("/img/busoo1.jpg");
		 Image img1=Toolkit.getDefaultToolkit().getImage(url);
		
		 //标志初始化
		flag=true;
		
		//设置界面
		setIconImage(img1);
		
		//加入标签
		label12 =new JLabel("员工卡1");
		label12.setVisible(true);
		label12.setBounds(70, 60, 200, 30);
		label12.setFont(font2);
		
		//将组件加入容器
		//add(label12);
		
		position=1;
		CanvasPanel1 canvas = new CanvasPanel1();
		
		//增加画布响应
		canvas.addMouseListener(new MouseAdapter() {
			// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = getLocation();
				
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
		add(canvas);
		//判断鼠标位置
				Thread threadB=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true){
							getLocation().toString();
							if(getLocation().getX()>400&&getLocation().getX()<800){
								if(getLocation().getY()>300&getLocation().getY()<650){
									System.out.println("--------进入刷卡区域--------");
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
	//获取图标图标
	 java.net.URL url=getClass().getResource("/img/busoo1.jpg");
	 Image img1=Toolkit.getDefaultToolkit().getImage(url);
	
	//设置容器
	setLocation(0,510); 
	setSize(300, 180);
	setTitle("员工卡3");
	setUndecorated(true);//设置无边框标题
	setVisible(true);
	setIconImage(img1);
	//setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//设置字体
	Font font1=new Font("宋体",Font.BOLD,20); 
	Font font2=new Font("宋体",Font.CENTER_BASELINE,15);
	
	//标志初始化
	flag=true;
	
	//加入标签
	label32 =new JLabel("员工卡3");
	label32.setVisible(true);
	label32.setBounds(70, 60, 200, 30);
	label32.setFont(font2);
	
	//加入容器
	//add(label32);
	//增加画布响应
	CanvasPanel3 canvas = new CanvasPanel3();
	canvas.addMouseListener(new MouseAdapter() {
		// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
		public void mousePressed(MouseEvent e) {
			// 当鼠标按下的时候获得窗口当前的位置
			
			origin.x = e.getX();
			origin.y = e.getY();
		}
	});
	
	canvas.addMouseMotionListener(new MouseMotionAdapter() {
		// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
		public void mouseDragged(MouseEvent e) {
			// 当鼠标拖动时获取窗口当前位置
			Point p = getLocation();
			
			// 设置窗口的位置
			// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
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
				//设定刷卡区域
				if(getLocation().getX()>400&&getLocation().getX()<800){
					if(getLocation().getY()>300&getLocation().getY()<650){
							System.out.println("--------进入刷卡区域--------");
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
    //皮肤特效
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
        System.err.println("出错了");  
    } 
	
}
//鼠标事件
public void mousePosition(){
				if(flag){	//position是判断哪个组件的标志
						if(position==1)
							f3.drag("201410411105");
						if(position==2)
							f3.drag("201410421107");
						if(position==3)
							f3.drag("201310311221");
						//判断是哪个组件
						if(position==1){
							setLocation(0,50);
						}else if(position==2){
							setLocation(0,280);
						}else{
							setLocation(0,510);
						}
						
					}
				}
//画布1
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
//画布2
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
//画布3
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

			




