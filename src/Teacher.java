
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class Teacher extends JFrame  {
	String id;
	JMenuBar menubar;
	JMenu menu1,menu2;
	JMenuItem m3,m4,m5,m6;
	JTextField text,text1, text2,text3,text4,text5,text6,text7,text8,text9,text10,text11;
	public Teacher(String id){
		this.id=id;
		this.setTitle("老师");
		this.setBounds(500,10,600,650);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		setLayout(new FlowLayout());
		
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		Action action=new Action();   //监听
		
		menu1=new JMenu("个人信息");
		m6=new JMenuItem("个人的信息");
		menu1.add(m6);
		menubar.add(menu1);
		m6.addActionListener(action);
		
		menu2=new JMenu("学生信息");
		m3=new JMenuItem("学生个人信息");
		menu2.add(m3);
		m3.addActionListener(action);
		
		m4=new JMenuItem("学生成绩表");
		menu2.add(m4);
		m4.addActionListener(action);
		
		menubar.add(menu2);
		validate();
	}
	
	public void XinXi(){
		getContentPane().removeAll();
		JTable table;
		Object a[][]=new Object[13][7];
		Object name[]={"教师号","姓名","密码","性别 ","院系号","电话","QQ"};
		table=new JTable(a,name);
		JScrollPane jsp=new JScrollPane(table);
		Panel panel=new Panel(new GridLayout(3,1));
		Panel p=new Panel();
		Panel p1=new Panel();
		Panel p2=new Panel();
		
		Action3 action=new Action3();
		JButton button1=new JButton("修改   姓名");
		JButton button2=new JButton("修改   密码");
		JButton button3=new JButton("修改   性别");
		JButton button4=new JButton("修改院系号");
		JButton button5=new JButton("修改   电话");
		JButton button6=new JButton("修改      QQ");
	    text2=new JTextField(10);
	    text3=new JTextField(10);
	    text4=new JTextField(10);
	    text5=new JTextField(10);
	    text6=new JTextField(10);
	    text7=new JTextField(10);
	 
		button1.addActionListener(action);    //监听
		button2.addActionListener(action);   //监听
		button3.addActionListener(action);
		button4.addActionListener(action);
		button5.addActionListener(action);
		button6.addActionListener(action);
		
		p.add(text2);
		p.add(button1);
		
		p.add(text3);
		p.add(button2);
		
		p1.add(text4);
		p1.add(button3);
		
		p1.add(text5);
		p1.add(button4);
		
		p2.add(text6);
		p2.add(button5);
		
		p2.add(text7);
		p2.add(button6);
		
		panel.add(p);
		panel.add(p1);
		panel.add(p2);
		
		getContentPane().add(jsp);
		getContentPane().add(panel);
		getContentPane().repaint();
		getContentPane().validate();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			Statement sql=con.createStatement();
			ResultSet rs=sql.executeQuery("select 教师号,姓名,密码,性别 ,院系号,电话,QQ from teacher WHERE 教师号='"+id+"'" );
			int m=0;
			while(rs.next()){
				for(int n=1;n<=7;n++){
					a[m][n-1]=rs.getString(n);
				}
				m++;
			}
			rs.close();
			con.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	public void XSXX(){
		getContentPane().removeAll();
		JTable table;
		Object a[][]=new Object[24][7];
		Object name[]={"学号","姓名","性别","院系号","班级号","电话","QQ"};
		table=new JTable(a,name);
		
		Action1 action=new Action1();
		JPanel panel=new JPanel(new BorderLayout());
		JPanel panel1=new JPanel(new FlowLayout());
		JLabel label=new JLabel("姓名");
	    text=new JTextField(10);
		JButton button=new JButton("搜索姓名");
		button.addActionListener(action);
		panel1.add(label);
		panel1.add(text);
		panel1.add(button);
		JScrollPane jsp=new JScrollPane(table);
		panel.add(panel1,BorderLayout.NORTH);
		panel.add(jsp,BorderLayout.CENTER);
		getContentPane().add(panel);
		getContentPane().repaint();
		getContentPane().validate();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			Statement sql=con.createStatement();
			ResultSet rs=sql.executeQuery("select  s.学号,s.姓名,s.性别,s.院系号,s.班级号,s.电话,s.QQ from student s,class where s.班级号=class.班级号 and class.教师号='"+id+"'");
			int m=0;
			while(rs.next()){
				for(int n=1;n<8;n++){
					a[m][n-1]=rs.getString(n);
				}
				m++;
			}
			rs.close();
			con.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	public void ChengJi(){
		getContentPane().removeAll();
		JTable table;
		Object b[][]=new Object[100][4];
		Object name[]={"学号","课程号","教师号","分数"};
		table=new JTable(b,name);
		JPanel panel=new JPanel(new BorderLayout());
		JPanel panel1=new JPanel(new FlowLayout());
		JLabel label=new JLabel("学号");
		
	    text1=new JTextField(10);
		JButton button=new JButton("搜索学号");
		Action2 action=new Action2();         //监听
		panel1.add(label);
		panel1.add(text1);
		panel1.add(button);
		button.addActionListener(action);
		
		JScrollPane jsp=new JScrollPane(table);
		Action4 action1=new Action4();        //监听
		JPanel panel2=new JPanel();
		JLabel label1=new JLabel("学号");
		text11=new JTextField(10);
		text9=new JTextField(10);
		JButton button1=new JButton("修改成绩和添加成绩");
		panel2.add(label1);
		panel2.add(text11);
		panel2.add(text9);
		panel2.add(button1);
		button1.addActionListener(action1);
		
		panel.add(panel1,BorderLayout.NORTH);
	    panel.add(jsp,BorderLayout.CENTER);
	    panel.add(panel2,BorderLayout.SOUTH);
	    getContentPane().add(panel);
	    
	    getContentPane().repaint();  
	    getContentPane().validate();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			Statement sql=con.createStatement();
			ResultSet rs=sql.executeQuery("select * from score where 教师号='"+id+"'" );
			int m=0;
			while(rs.next()){
				for(int n=1;n<=4;n++){
					b[m][n-1]=rs.getString(n);
				}
				m++;
			}
			rs.close();
			con.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}  
    public class Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		   if(e.getActionCommand()=="个人的信息"){    
				XinXi();
			}
		   else if(e.getActionCommand()=="学生个人信息"){
			   XSXX();
		   }
		   else if(e.getActionCommand()=="学生成绩表"){
			    ChengJi();
			}
		}
    }
    //搜索功能  个人
    public class Action1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="搜索姓名"){
				getContentPane().removeAll();
				JTable table;
				Object a[][]=new Object[24][8];
				Object name[]={"学号","姓名","性别","院系号","班级号","电话","QQ"};
				table=new JTable(a,name);
				JPanel panel=new JPanel(new BorderLayout());
				JPanel panel1=new JPanel(new FlowLayout());
				JLabel label=new JLabel("姓名");
				JTextField text1=new JTextField(10);
				JButton button=new JButton("搜索姓名");
				panel1.add(label);
				panel1.add(text1);
				panel1.add(button);
				JScrollPane jsp=new JScrollPane(table);
				panel.add(panel1,BorderLayout.NORTH);
				panel.add(jsp,BorderLayout.CENTER);
				getContentPane().add(panel);
				getContentPane().repaint();
				getContentPane().validate();
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					ResultSet rs=sql.executeQuery("select*from student WHERE  姓名 ='"+text.getText()+"' ");
					while(rs.next()){
						for(int n=1;n<9;n++){
							a[0][n-1]=rs.getString(n);
						}
						((AbstractTableModel)table.getModel()).fireTableDataChanged();
					}
					rs.close();
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
		}
    }
    //搜索功能  成绩
    public class Action2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			JTable table;
			Object a[][]=new Object[100][4];
			Object name[]={"学号","课程号","教师号","分数"};
			table=new JTable(a,name);
			JPanel panel=new JPanel(new BorderLayout());
			JPanel panel1=new JPanel(new FlowLayout());
			JLabel label=new JLabel("学号");
			
			JTextField text=new JTextField(10);
			JButton button=new JButton("搜索学号");
			Action2 action=new Action2();
			panel1.add(label);
			panel1.add(text);
			panel1.add(button);
			button.addActionListener(action);
			
			JScrollPane jsp=new JScrollPane(table);
			JPanel panel2=new JPanel();
			JButton button1=new JButton("修改成绩");
			JButton button2=new JButton("添加成绩");
			panel2.add(button1);
			panel2.add(button2);
			panel.add(panel1,BorderLayout.NORTH);
		    panel.add(jsp,BorderLayout.CENTER);
		    panel.add(panel2,BorderLayout.SOUTH);
		    getContentPane().add(panel);
		    
		    getContentPane().repaint();  
		    getContentPane().validate();
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				System.out.println(e);
			}
			try{
				Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
				Statement sql=con.createStatement();
				ResultSet rs=sql.executeQuery("select*from score WHERE 学号 ='"+text1.getText()+"'" );
				while(rs.next()){
					for(int n=1;n<=4;n++){
						a[0][n-1]=rs.getString(n);
					}
					((AbstractTableModel)table.getModel()).fireTableDataChanged();
				}
				rs.close();
				con.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}
    }
    //修改信息
    public class Action3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="修改   姓名"){
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute("UPDATE teacher SET 姓名='"+text2.getText()+"' WHERE 教师号='"+id+"'" );
					
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
			else if(e.getActionCommand()=="修改   密码"){
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute("UPDATE teacher SET 密码='"+text3.getText()+"' WHERE 教师号='"+id+"'" );
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
			else if(e.getActionCommand()=="修改   性别"){
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute("UPDATE teacher SET 性别='"+text4.getText()+"' WHERE 教师号='"+id+"'" );
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
            else if(e.getActionCommand()=="修改院系号"){
            	try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute("UPDATE teacher SET 院系号='"+text5.getText()+"' WHERE 教师号='"+id+"'" );
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
			else if(e.getActionCommand()=="修改   电话"){
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute("UPDATE teacher SET 电话='"+text6.getText()+"' WHERE 教师号='"+id+"'" );
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
            else if(e.getActionCommand()=="修改      QQ"){
            	try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute("UPDATE teacher SET QQ='"+text7.getText()+"' WHERE 教师号='"+id+"'" );
					con.close();
				}catch(SQLException m){
					System.out.println(m);
				}
			}
		}
    }
    public class Action4 implements ActionListener{
    	Object b[][]=new Object[100][4];
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 if(e.getActionCommand()=="修改成绩和添加成绩"){
				String score=text9.getText().trim();
				String number=text11.getText().trim();
				String str="update score set 分数='"+score+"' where 学号='"+number+"'";
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException m){
					System.out.println(m);
				}
				try{
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					Statement sql=con.createStatement();
					sql.execute(str);
					ResultSet rs=sql.executeQuery("select * from score" );
					int m=0;
					while(rs.next()){
						for(int n=1;n<=4;n++){
							b[m][n-1]=rs.getString(n);
						}
						m++;
					}
					
					con.close();
					sql.close();
					rs.close();
				}catch(SQLException m){
					System.out.println(m);
				}
				
				
			}
		}
    }
}
