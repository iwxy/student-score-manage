
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Denglu extends JFrame implements ActionListener{
	Box basebox,box[]=new Box[4];
	JLabel jl1,jl2;
	JTextField jt1;
	JPasswordField jt2;
	JButton jb1,jb2;
	ButtonGroup bg;
	JRadioButton jrb1,jrb2,jrb3;
	Connection con;
	ResultSet rs;
	Statement sql;
	String SQL,xz,pass,pw,user,id;
	public Denglu(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		this.setBounds(500,100,350,400);
		this.setTitle("登录窗口");
	}
	public void init(){
		jl1=new JLabel("用户名");
		jl2=new JLabel("密码");
		jt1=new JTextField(10);
		jt2=new JPasswordField(10);
		jb1=new JButton("登录");
		jb2=new JButton("注册");
		bg=new ButtonGroup();
		jrb1=new JRadioButton("学生");
		jrb2=new JRadioButton("教师");
		jrb3=new JRadioButton("管理员");
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		for(int i=0;i<4;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(jl1);
		box[0].add(Box.createHorizontalStrut(10));
		box[0].add(jt1);
		box[1].add(jl2);
		box[1].add(Box.createHorizontalStrut(23));
		box[1].add(jt2);
		box[2].add(jrb1);
		box[2].add(jrb2);
		box[2].add(jrb3);
		box[3].add(jb1);
		box[3].add(Box.createHorizontalStrut(30));
		box[3].add(jb2);
		basebox=Box.createVerticalBox();
		basebox.add(Box.createVerticalStrut(50));
		basebox.add(box[0]);
		basebox.add(Box.createVerticalStrut(50));
		basebox.add(box[1]);
		basebox.add(Box.createVerticalStrut(50));
		basebox.add(box[2]);
		basebox.add(Box.createVerticalStrut(50));
		basebox.add(box[3]);
		add(basebox);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a){
	
		if(a.getActionCommand()=="注册"){
			Zuce z=new Zuce();
			this.dispose();
		}
		if(a.getActionCommand()=="学生"){
			xz="student";
			id="学号";
		}
		if(a.getActionCommand()=="教师"){
			xz="teacher";
			id="教师号";
		}
		if(a.getActionCommand()=="管理员"){
			xz="admin";
			id="系管号";
		}
		if(a.getActionCommand()=="登录"){
			user=jt1.getText();
			pw=String.valueOf(jt2.getPassword());
			SQL="select * from "+xz+" where "+id+"="+user;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
				
				sql=con.createStatement();
				rs=sql.executeQuery(SQL);
				while(rs.next()){
					pass=rs.getString(3);
				}
				if(pw.equals(pass)){
					if(xz=="student"){
						new Studentwindows(user);
						this.dispose();
					}
					if(xz=="teacher"){
						new Teacher(user);
						this.dispose();
					}
					if(xz=="admin"){
						new AdminControl(user);
						this.dispose();
					}
					//JOptionPane.showMessageDialog(this,"欢迎使用本系统","登录成功",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(this,"登录失败请检查用户名和密码是否正确","登录失败",JOptionPane.ERROR_MESSAGE);
				}
				con.close();
			}catch(SQLException e){
				e.getMessage();
			}
			catch(ClassNotFoundException e){
				e.getMessage();
			}
		}
	}
}
