package swing;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.AutumnSkin;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;
import org.jvnet.substance.skin.BusinessSkin;
import org.jvnet.substance.skin.ChallengerDeepSkin;
import org.jvnet.substance.skin.CremeSkin;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.skin.MistAquaSkin;
import org.jvnet.substance.skin.MistSilverSkin;
import org.jvnet.substance.skin.NebulaBrickWallSkin;
import org.jvnet.substance.skin.NebulaSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.skin.OfficeSilver2007Skin;
import org.jvnet.substance.skin.RavenSkin;
import org.jvnet.substance.skin.SaharaSkin;
import org.jvnet.substance.skin.SubstanceSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;
public class Frame03 extends JFrame {
	
	JPanel panel;
	JLabel label2;
	JLabel label3=new JLabel();
	JLabel label4=new JLabel();
	Image img;
	Image img1;
	Icon img2;
	Canvas canvas;
	Toolkit toolkit;
	static Frame02 f2;
	Thread threadA;
	int count=0;
	JProgressBar jp1;
	Thread threadB = new Thread();
	
	public static void main(String[] args) throws Exception
    {
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//设置皮肤
        //皮肤特效
		new Frame03().setVisible(true);
        try {  
            //UIManager.setLookAndFeel(new SubstanceLookAndFeel());  
            //JFrame.setDefaultLookAndFeelDecorated(true);  
            //JDialog.setDefaultLookAndFeelDecorated(true);  
            //SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
            SubstanceLookAndFeel.setSkin(new BusinessSkin());  
            //SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
            //SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
            // SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
            //SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
            //SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());  
        } catch (Exception e) {  
            System.err.println("出错了");  
        } 
        
        
    }
    public Frame03()
    {	
    	//调用Frame02
    	f2=new Frame02();
    	f2.setVisible(true);
    	
    	//设置容器
    	setTitle("刷卡器");
    	setSize(380,440);
    	this.setUndecorated(true);
        setVisible(true);
        Color color=new Color(27,168,248);
         
        getContentPane().setBackground(color);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 150);
        
        //设置字体
        Font font1=new Font("宋体",Font.BOLD,20); 
        Font font2=new Font("宋体",Font.BOLD,15);
        
        //设置标题
        JLabel label=new JLabel("Busoo刷卡器");
        label.setBounds(150,10,150,20);
        label.setFont(font1);
        //this.add(label);
       
        
        //设置读取标签
        label2=new JLabel("正在读取中：");
        label2.setFont(font1);
        label2.setVisible(false);
        label2.setBounds(100,80,150,50);
        this.add(label2);
        
        //设置进度条不可见
        jp1=new JProgressBar();
        jp1.setStringPainted(true);
        
        this.jp1.setBackground(Color.red);
        
        jp1.setVisible(false);
       
        jp1.setBounds(125,120,160,30);
        this.add(jp1);
        
        //设置时间显示标签
        label3.setText("");
        label3.setBounds(125,120,160,30);
        Font font3=new Font("宋体",Font.BOLD,13);
        label3.setFont(font3);
        
        this.add(label3);
       
        //获取图标以及显示图片
        java.net.URL url=getClass().getResource("/img/Busoo.jpg");
        java.net.URL url1=getClass().getResource("/img/busoo1.jpg");
        java.net.URL url2=getClass().getResource("/img/delete.jpg");
        img=Toolkit.getDefaultToolkit().getImage(url);
        img1=Toolkit.getDefaultToolkit().getImage(url1);
        //img2=(Icon) Toolkit.getDefaultToolkit().getImage(url2);
        setIconImage(img1);		//设置标题图标
        
        canvas =new CanvasPanel();
        
        
        //换肤按钮
        JButton skinButton=new JButton("换肤");
        skinButton.setBounds(10, 430, 50, 20);
        skinButton.addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				try {  
		              SubstanceSkin[] skin={new AutumnSkin(),new BusinessSkin(),new BusinessBlackSteelSkin(),
		            		  new ChallengerDeepSkin(),new CremeSkin(),new EmeraldDuskSkin(),
		            		  new MistAquaSkin(),new MistSilverSkin(),
		            		  new NebulaSkin(),new NebulaBrickWallSkin(),new OfficeBlue2007Skin(),
		            		  new OfficeSilver2007Skin(),new RavenSkin(),new SaharaSkin()};
		              int temp=count%skin.length;
		              count++;
		              
		            SubstanceLookAndFeel.setSkin(skin[temp]);  
		              
		        } catch (Exception e1) {  
		            System.err.println("出错了");  
		        } 
				
			}
        	
        });
        //add(skinButton);
        add(canvas);//加载图片绘制类
    }
    public void drag(String id)//定义的拖拽方法
    	{
         	try
         		{
         			//调用进度条
         			
                	Thread threadC=new Thread(new Runnable(){
                		int count=0;
						@Override
						public void run() {
							// TODO Auto-generated method stub
							while(count<100){
								//设置精度条可见
								label3.setVisible(false);
								label2.setVisible(true);
								jp1.setBackground(Color.red);
								jp1.setVisible(true);
								jp1.setValue(count+=8);
								try{
									Thread.sleep(30);
								}catch(Exception e){
									e.printStackTrace();
								}
								jp1.setVisible(false);
								label2.setVisible(false);
								label3.setVisible(true);
								jp1.setValue(0);
							}
						}
                	});
                	Data data=new Data();
                    User user = null;
                    
                    //先设定账号不存在
                    boolean flag1=false;
                    List<User> list1=data.userInfo();
                    for(int i=0;i<list1.size();i++){
                        if(list1.get(i).getId()==id){	//账号存在
                        	user=list1.get(i);
                        	flag1=true;
                        	break;
                        }
                       }
                       //如果没有对应的卡 则提示无效卡
                    	threadC.setPriority(4);
                        threadC.start();
                        if(!flag1){
                        	JOptionPane.showMessageDialog(panel, "无效卡");
                        }else{
                        	if(id=="6"){
                        		JOptionPane.showMessageDialog(panel, "儿童卡！请下车！");
                        		
                        	}
                        	//获取时间
                        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    						String time=df.format(new Date());
    						//获取姓名
    						String name=user.getName();
    						//获取班次
    						String class1=user.getClass1().getOoc();
    						//获取车间
    						String part="";
    						if(id=="201310311221")
    							part="5车间7班";
    						else if(id=="201410421107")
    							part="8车间5班";
    						else 
    							part="4车间1班";
    						 f2.addRow1(time,id,name,class1,part);
                       }
         		}finally{
         			
         		}
    }
    //定义画图类
    class CanvasPanel extends Canvas{
    	public void paint(final Graphics g){
    		super.paint(g);
    		final Graphics2D g2=(Graphics2D)g;
    		//g2.drawImage(img,100,100,200,300,this);
    		Shape rect=new Rectangle2D.Double(92,58,200,100);
    		
    		
    		//画图
    		java.net.URL url2=getClass().getResource("/img/machine1.jpg");
    	    Image img3=Toolkit.getDefaultToolkit().getImage(url2);
    	    g2.drawImage(img3,0,0,380,440,this);
    	    g2.setColor(new Color(27,168,248));
    	    g2.fill(rect);
    	    
    		g2.setColor(Color.black);
    		
    		Date date=new Date();
    		Font font2=new Font("宋体",Font.BOLD,14);
    		g2.setFont(font2);
    		g2.drawString("现在时间是：",100,100);
    		threadB=new Thread(new Runnable(){
    			@Override
				public void run() {
					while(true){
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						String time=df.format(new Date());
						label3.setText(time);
						//为什么不能用图片打印输出？
						
						try{
							Thread.sleep(1000);
							Thread.yield();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					
				}
    			
    		});
    		threadB.setPriority(4);
    		threadB.start();
    		
    	
    	}
    }
   

}
    

