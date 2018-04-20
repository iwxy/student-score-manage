
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Studentwindows extends JFrame implements MouseListener{
	JMenuBar menubar;   //菜单条
	JMenu menu1;
	JMenu menu2;
	JMenuItem item1,item2;   //子菜单
	JTable table;
	JButton jb,jb1;
	JScrollPane scroll;
	JPanel jp,jp1;
	String id,SQL;   //id为该学生的学号，SQL为sql语句
	String data[][];   //data为table中的数据
	String col[]={"学生","课程","分数"};    //col为table的列名
	Connection con;
	Statement sta;
	ResultSet rs;
	int rows;   //该学生有多少行分数（即：多少个课程）
	JTextField jtf[]=new JTextField[8];
	JPasswordField jpf1,jpf2,jpf3;
	int w=0,x=0,y=0;
	/**
	 * 构造方法
	 * 参数i为该学生的输入的学号
	 * */
	public Studentwindows(String i){
		id=i;
		panel();
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		init();
		setLayout(new FlowLayout());
		setVisible(true);
		setTitle("学生成绩管理");
		setBounds(500,10,600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		if(this.isUndecorated()){          //运行程序就是最大化窗口
//			this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
//		}else{
//			this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//		}
	}
	void init(){
		menubar=new JMenuBar();
		menu1=new JMenu("成绩查询");
		menu1.addMouseListener(this);
		menu2=new JMenu("个人中心");
		item1=new JMenuItem("修改个人信息");
		item1.addMouseListener(this);
		item2=new JMenuItem("修改密码");
		item2.addMouseListener(this);
		menu2.add(item1);
		menu2.add(item2);
		menubar.add(menu1);
		menubar.add(menu2);
		setJMenuBar(menubar);
		rows=getRows();
	}
	
	/**
	 * 修改个人信息和修改密码的两个面板
	 * */
	public void panel(){
		//jp是修改个人信息的面板
		jp=new JPanel();
		jb=new JButton("提交");
		//jp.setBounds(20, 20,1800,900);
		jp.setLayout(new FlowLayout());
		//jp.setBackground(Color.WHITE);
		Box box[]=new Box[7];
		for(int i=0;i<7;i++){
			box[i]=Box.createHorizontalBox();
		}
		Box basebox=Box.createVerticalBox();
		JLabel jl[]=new JLabel[7];
		jl[0]=new JLabel("学号");
		jl[1]=new JLabel("姓名");
		jl[2]=new JLabel("性别");
		jl[3]=new JLabel("院系");
		jl[4]=new JLabel("班级");
		jl[5]=new JLabel("电话");
		jl[6]=new JLabel("QQ");
		jtf[0]=new JTextField(10);
		jtf[1]=new JTextField(10);
		jtf[2]=new JTextField(10);
		jtf[3]=new JTextField(10);
		jtf[4]=new JTextField(10);
		jtf[5]=new JTextField(10);
		jtf[6]=new JTextField(10);
		for(int j=0;j<7;j++){
			jtf[j].setText(getStudent()[j]);
			if(j>1){
				jtf[j].setText(getStudent()[j+1]);
			}
		}
		jtf[0].setEditable(false);  //学号文本框不能编辑
		box[0].add(jl[0]);
		box[0].add(Box.createHorizontalStrut(40));
		box[0].add(jtf[0]);
		box[1].add(jl[1]);
		box[1].add(Box.createHorizontalStrut(40));
		box[1].add(jtf[1]);
		box[2].add(jl[2]);
		box[2].add(Box.createHorizontalStrut(40));
		box[2].add(jtf[2]);
		box[3].add(jl[3]);
		box[3].add(Box.createHorizontalStrut(40));
		box[3].add(jtf[3]);
		box[4].add(jl[4]);
		box[4].add(Box.createHorizontalStrut(40));
		box[4].add(jtf[4]);
		box[5].add(jl[5]);
		box[5].add(Box.createHorizontalStrut(40));
		box[5].add(jtf[5]);
		box[6].add(jl[6]);
		box[6].add(Box.createHorizontalStrut(40));
		box[6].add(jtf[6]);
		for(int i=0;i<7;i++){
			basebox.add(Box.createVerticalStrut(40));
			basebox.add(box[i]);
		}
		basebox.add(Box.createVerticalStrut(40));
		basebox.add(jb);
		jp.add(basebox);
		jb.addMouseListener(this);
		//jp1是修改密码的面板
		jp1=new JPanel();
		jp1.setLayout(new FlowLayout());
		JLabel jl1=new JLabel("原密码：");
		JLabel jl2=new JLabel("新密码：");
		JLabel jl3=new JLabel("确认密码：");
		jpf1=new JPasswordField(10);
		jpf2=new JPasswordField(10);
		jpf3=new JPasswordField(10);
		jb1=new JButton("提交");
		Box box1[]=new Box[4];
		Box basebox1=Box.createVerticalBox();
		for(int a=0;a<4;a++){
			box1[a]=Box.createHorizontalBox();
		}
		box1[0].add(jl1);
		box1[0].add(Box.createHorizontalStrut(40));
		box1[0].add(jpf1);
		box1[1].add(jl2);
		box1[1].add(Box.createHorizontalStrut(40));
		box1[1].add(jpf2);
		box1[2].add(jl3);
		box1[2].add(Box.createHorizontalStrut(30));
		box1[2].add(jpf3);
		box1[3].add(jb1);
		for(int a=0;a<4;a++){
			basebox1.add(Box.createVerticalStrut(40));
			basebox1.add(box1[a]);
		}
		jp1.add(basebox1);
		jb1.addMouseListener(this);
	}

	public void mousePressed(MouseEvent a){
		if(w==1){
			remove(scroll);
			w=0;
		}
		if(x==1){
			remove(jp);
			x=0;
			
		}
		if(y==1){
			remove(jp1);
			y=0;
		}
		//点击成绩查询后，显示学生成绩
		if(a.getSource()==menu1){
			try{
				con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
				sta=con.createStatement();
				SQL="select student.姓名,lesson.课程名,score.分数 from student,lesson,score "
						+ "where student.学号=score.学号 and lesson.课程号=score.课程号 and score.学号='"+id+"'";
				
				rs=sta.executeQuery(SQL);
				int i=0;
				data=new String[rows][col.length];  //数据库中的数据
				while(rs.next()){
					for(int j=0;j<col.length;j++){
						data[i][j]=rs.getString(j+1);
					}
					i++;	
				}
				table=new JTable(data,col);  //设置表格
				scroll=new JScrollPane(table);  //设置滚动面板
				//scroll.setBounds(500,100,800,600);
				scroll.setBackground(Color.BLACK);
				w=1;
				table.repaint();
				add(scroll);
				repaint();
				validate();
				con.close();
			}catch(SQLException e){
				e.getMessage();
			}
		}	
		//点击修改个人信息后
		if(a.getSource()==item1){
			add(jp);
			x=1;
			repaint();
			validate();
		}
		//点击修改个人信息的提交后
		if(a.getSource()==jb){
			String q[]=new String[7];
			for(int i=0;i<7;i++){
				q[i]=jtf[i].getText();
			}
			try{
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update student set 姓名='"+q[1]+"',性别='"+q[2]+"',院系号='"+q[3]+"',班级号='"+q[4]+"',电话='"+q[5]+"',QQ='"+q[6]+"'where 学号='"+id+"'";
			sta.executeUpdate(SQL);
			con.commit();
			con.close();
			}catch(SQLException e){
				e.getMessage();
			}
			JOptionPane.showMessageDialog(this,"修改成功","修改成功",JOptionPane.OK_CANCEL_OPTION);
		}
		//点击修改密码后
		if(a.getSource()==item2){
			add(jp1);
			y=1;
			repaint();
			validate();
		}
		//点击修改密码的提交后
		if(a.getSource()==jb1){
			String old[]=new String[3];
			old[0]=String.valueOf(jpf1.getPassword());
			old[1]=String.valueOf(jpf2.getPassword());
			old[2]=String.valueOf(jpf3.getPassword());
			if(old[1].equals(old[2])){
				String password=getStudent()[2];
				if(old[0].equals(password)){
					try{
						con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
						sta=con.createStatement();
						SQL="update student set 密码='"+old[2]+"' where 学号='"+id+"'";
						sta.executeUpdate(SQL);
						con.commit();
						con.close();
						}catch(SQLException e){
							e.getMessage();
						}
					JOptionPane.showMessageDialog(this,"修改成功","修改成功",JOptionPane.OK_CANCEL_OPTION);
				}
				else{
					JOptionPane.showMessageDialog(this,"输入的原密码错误","修改密码失败",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"两次输入的密码不同，请检查","修改密码失败",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void mouseReleased(MouseEvent a){}
	public void mouseEntered(MouseEvent a){}
	public void mouseExited(MouseEvent a){}
	public void mouseClicked(MouseEvent a){}

	/**
	 * 获得该学生有多少行成绩
	 * @return 返回int型行数
	 * */
	private int getRows(){
		try{
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select student.姓名,lesson.课程名,score.分数 from student,lesson,score "
					+ "where student.学号=score.学号 and lesson.课程号=score.课程号 and score.学号='"+id+"'";
			rs=sta.executeQuery(SQL);
			rs.last();
			rows=rs.getRow();
			con.close();
		}catch(SQLException e){
			e.getMessage();
		}
		return rows;
	}
		
	/**j
	 * 此方法用于从数据库中获取该学生的信息
	 * @return 返回一个String型的一维数组
	 * */	
	public String[] getStudent(){
		String s[]=new String[8];
		SQL="select * from student where 学号='"+id+"'";
		try{
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			rs=sta.executeQuery(SQL);
		
			while(rs.next()){
				for(int i=0;i<8;i++){
					s[i]=rs.getString(i+1);
				}
			}
			con.close();
		}catch(SQLException e){
			e.getMessage();
		}
		return s;
	}
	
}
