
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Enumeration;

public class Zuce extends JFrame implements ActionListener{
	Box basebox,box[]=new Box[8];
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jt1,jt2,jt3;
	JPasswordField jp1,jp2;
	JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5;
	ButtonGroup bg1,bg2;
	JButton jb1,jb2;
	String SQL,SQL1,id,name,password,apassword,sex,ident,cla;
	public Zuce(){
		init();
		this.setBounds(500,80,500,600);
		this.setTitle("注册窗口");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init(){
		for(int i=0;i<8;i++){
			box[i]=Box.createHorizontalBox();
		}
		jl1=new JLabel("ID:");
		jt1=new JTextField(10);
		box[0].add(jl1);
		box[0].add(Box.createHorizontalStrut(50));
		box[0].add(jt1);
		jl2=new JLabel("姓名:");
		jt2=new JTextField(10);
		box[1].add(jl2);
		box[1].add(Box.createHorizontalStrut(35));
		box[1].add(jt2);
		jl3=new JLabel("密码:");
		jp1=new JPasswordField();
		box[2].add(jl3);
		box[2].add(Box.createHorizontalStrut(35));
		box[2].add(jp1);
		jl4=new JLabel("确认密码:");
		jp2=new JPasswordField();
		box[3].add(jl4);
		box[3].add(Box.createHorizontalStrut(10));
		box[3].add(jp2);
		jl7=new JLabel("班级号：");
		jt3=new JTextField(10);
		jt3.setForeground(Color.GRAY);
		jt3.setText("学生输入班级号");
		jt3.addMouseListener(new MouseListener(){   //在文本框中用灰色字提示用户
			public void mousePressed(MouseEvent e){
				jt3.setText("");
				jt3.setForeground(Color.BLACK);
			}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
		});
		box[4].add(jl7);
		box[4].add(Box.createHorizontalStrut(14));
		box[4].add(jt3);
		jl5=new JLabel("性别:");
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		bg1=new ButtonGroup();
		bg1.add(jrb1);
		bg1.add(jrb2);
		box[5].add(jl5);
		box[5].add(Box.createHorizontalStrut(30));
		box[5].add(jrb1);
		box[5].add(Box.createHorizontalStrut(30));
		box[5].add(jrb2);
		jl6=new JLabel("身份:");
		jrb3=new JRadioButton("学生");
		jrb4=new JRadioButton("老师");
		jrb5=new JRadioButton("管理员");
		bg2=new ButtonGroup();
		bg2.add(jrb3);
		bg2.add(jrb4);
		bg2.add(jrb5);
		box[6].add(jl6);
		box[6].add(Box.createHorizontalStrut(20));
		box[6].add(jrb3);
		box[6].add(jrb4);
		box[6].add(jrb5);
		jb1=new JButton("确认");
		jb2=new JButton("取消");
		box[7].add(jb1);
		box[7].add(Box.createHorizontalStrut(50));
		box[7].add(jb2);
		basebox=Box.createVerticalBox();
		for(int i=0;i<7;i++){
			basebox.add(Box.createVerticalStrut(40));
			basebox.add(box[i]);
		}
		basebox.add(Box.createVerticalStrut(40));
		basebox.add(box[7]);
		add(basebox);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
		jrb4.addActionListener(this);
		jrb5.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a){
		Connection con;
		Statement sql;
		ResultSet rs;
		id=jt1.getText();
		name=jt2.getText();
		password=String.valueOf(jp1.getPassword());
		apassword=String.valueOf(jp2.getPassword());
		cla=jt3.getText();
		if(a.getSource()==jb2){
			this.dispose();
		}
		if(a.getSource()==jrb1){
			sex="男";
		}
		if(a.getSource()==jrb2){
			sex="女";
		}
		if(a.getSource()==jrb3){
			ident="student";
			SQL="insert into "+ident+"(学号,姓名,密码,性别,班级号) values('"+id+"','"+name+"','"+password+"','"+sex+"','"+cla+"')";
		}
		if(a.getSource()==jrb4){
			ident="teacher";
			SQL1="insert into "+ident+"(教师号,姓名,密码,性别) ";
		}
		if(a.getSource()==jrb5){
			ident="admin";
			SQL1="insert into "+ident+"(系管号,系管名,密码,性别) ";
		}
		
		if(a.getSource()==jb1){
			if(password.equals(apassword)){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
					String q1=("select * from "+ident);
					sql=con.createStatement();
					rs=sql.executeQuery(q1);
					rs.last();
					int row=rs.getRow();
					rs.beforeFirst();
					int o=1;int n=0;
					while(rs.next()){
						if(id.equals(rs.getString(1))){
							JOptionPane.showMessageDialog(this,"用户已存在，请检查用户名","错误",JOptionPane.ERROR_MESSAGE);
							o=0;
							break;
							
						}
						if(ident=="student"){
						if(!cla.equals(rs.getString(6))){
								n++;
							}
						}
					}
					if(n>=row){
								JOptionPane.showMessageDialog(this,"班级号错误","注册失败",JOptionPane.ERROR_MESSAGE);
								o=0;
							}
					
//					if(ident=="student"){
//						rs.beforeFirst();
//						while(rs.next()){
//							if(!cla.equals(rs.getString(6))){
//								n++;
//							}
//						}
//						if(n>=row){
//								JOptionPane.showMessageDialog(this,"班级号错误","注册失败",JOptionPane.ERROR_MESSAGE);
//								o=0;
//							}
//					}
					if(o==1){
						if(ident!="student"){
							SQL=SQL1+"values ('"+id+"','"+name+"','"+password+"','"+sex+"')";
						}
						sql=con.createStatement();
						sql.executeUpdate(SQL);
						JOptionPane.showMessageDialog(this,"注册成功，欢迎使用本系统","注册成功",JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						new Denglu();
						con.commit();
					}
					con.close();
				}
				catch(ClassNotFoundException e){
					e.getMessage();
				}
				catch(SQLException e){
					e.getMessage();
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"两次输入的密码不同，请检查","注册失败",JOptionPane.ERROR_MESSAGE);
			}
		}
	
	}

}
