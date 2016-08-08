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
		//����������
		String[] columnNames={"A","B"};
		//������������
		String[][] tableValues={{"A1","B1"},{"A2","B2"},{"A3","B3"}};
		//�������
		JTable table=new JTable(tableValues,columnNames);
		//������ʾ���Ĺ������
		JScrollPane pane=new JScrollPane(table);
		//���������ӵ��߽粼�ֵ�����
		getContentPane().add(pane,BorderLayout.CENTER);
		
	}
}
