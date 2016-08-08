package swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Frame01 extends JFrame{
	public static void main(String[] args) {
		Frame01 frame=new Frame01();
		frame.setVisible(true);
	}
	public Frame01(){
		super();
		setTitle("Table");
		setBounds(100,100,240,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//定义表格列名
		String[] columnNames={"A","B"};
		//定义表格数据组
		String[][] tableValues={{"A1","B1"},{"A2","B2"},{"A3","B3"}};
		//创建表格
		JTable table=new JTable(tableValues,columnNames);
		//创建显示表格的滚动面板
		JScrollPane pane=new JScrollPane(table);
		//讲滚动面板加到边界布局的中心
		getContentPane().add(pane,BorderLayout.CENTER);
		
	}
}
