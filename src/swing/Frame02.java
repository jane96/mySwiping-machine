package swing;

import com.sun.awt.AWTUtilities; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.SaharaSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

public class Frame02 extends JFrame {
	String[] columnNames={"刷卡时间","员工工号","员工姓名","班次","编排"};
	String[][] tableValues = null;
	DefaultTableModel tableModel=new DefaultTableModel(tableValues,columnNames);
	JPanel jp;
	JTextField aTextField;
	JButton addButton;
	int cardId;
	JScrollPane js;
	JPanel jp4;
	JPanel jp3=new JPanel();
	int count=0;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Frame02 frame02=new Frame02();
		frame02.setVisible(true);
		//设置皮肤
		//换肤
		try {  
             
			//JFrame.setDefaultLookAndFeelDecorated(true);  
            //JDialog.setDefaultLookAndFeelDecorated(true);  
           // SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());  
            SubstanceLookAndFeel.setSkin(new SaharaSkin());  
           // SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());  
            //SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());  
            //SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());  
            //SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());  
            //SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());  
        } catch (Exception e) {  
            System.err.println("出错了");  
        }
		
		
	}
	@SuppressWarnings("restriction")
	public Frame02(){
		super();
		setTitle("厂车刷卡模拟系统");
		java.net.URL url=getClass().getResource("/img/busoo1.jpg");
        Image img=Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(img);
		setSize(520,440);
		setEnabled(true);
		setUndecorated(true);//设置无边框标题
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(780,150);
		js=new JScrollPane();
		//AWTUtilities.setWindowOpaque(this, false);
		setVisible(true);
		//加入容器
		getContentPane().add(js,BorderLayout.CENTER);
		JLabel label3=new JLabel();
	    card();
	}
	public void card(){
				//1.创建数据表名
				//2.创建指定表格列名和表格数据的表格模型
				//3.创建指定表格模型的表格
				JTable jTable=new JTable(tableModel);
				jTable.setRowHeight(26);
				jTable.setRowSorter(new TableRowSorter<>(tableModel));//指定表格的排序器
				//可视化
				js.setViewportView(jTable);
				jp=new JPanel();
				//jp.setLayout();
				getContentPane().add(jp,BorderLayout.NORTH);
				Font font1=new Font("宋体",Font.BOLD,20);
				JLabel label1=new JLabel("刷卡信息表");
				JLabel label=new JLabel("                                              ");
				JLabel label2=new JLabel("                         ");
				label1.setFont(font1);
				label1.setBounds(new Rectangle(100, 2, 100, 30));
				jp.add(label);
				jp.add(label1);
				jp.add(label2);
				//getContentPane().add(jp3,BorderLayout.SOUTH);
				//清空模拟数据按钮
				final JPanel jp2=new JPanel();
				//getContentPane().add(jp2,BorderLayout.EAST);
				JButton  clearButton=new JButton("清空");
				clearButton.setBounds(new Rectangle(200, 10, 100, 30));
				 clearButton.setIcon(new ImageIcon(Frame02.class
			                .getResource("/img/delete_16.jpg")));
			     
				clearButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						while(count>0){
							tableModel.removeRow(0);
							count--;
						}
						
					}
					
				});
				Font font2=new Font("宋体",Font.BOLD,15);
				clearButton.setBackground(new Color(175,216,246));
				clearButton.setFont(font2);
				jp.add(clearButton,BorderLayout.EAST);
			
	}
	public User findUser(String id){
		System.out.println(id);
		boolean flag=false;
		User user=new User();
		Data data=new Data();
		List<User> list=data.userInfo();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				user=list.get(i);
				flag=true;
				break;
				
			}
		}
		if(flag){
		return user;
		}else{
			JOptionPane.showMessageDialog(null, "无效卡");
			return null;
		}
	}
	//找到班次中对应的车
	public String findCar(String id){
		
		String car=null;
		Data data=new Data();
		List<User> list=data.userInfo();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				car=list.get(i).getClass1().getCar();
				break;
			}
		}
		return car;
	}
	//增加一行数据
	public  void  addRow1(String date,String id,String name,String class1,String part){
		
		count++;
		Object[] rowValues={date,id,name,class1,part};
		try{
			tableModel.addRow(rowValues);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
