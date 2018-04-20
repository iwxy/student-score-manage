import java.awt.FlowLayout;

import javax.swing.*;

public class AdminPanel {
	AdminSQL Asql=new AdminSQL();

	JPanel studentpanel=new JPanel();
	JLabel stu_label[]=new JLabel[9];
	JTextField stu_jtf[]=new JTextField[9];
	JButton stu_jb[]=new JButton[3];
	
	public void Astudent(){
		for(int i=0;i<9;i++){
			stu_jtf[i]=new JTextField(10);
		}
		stu_label[0]=new JLabel("原始学号：",JLabel.CENTER);
		stu_label[1]=new JLabel("学号：",JLabel.CENTER);
		stu_label[2]=new JLabel("姓名：",JLabel.CENTER);
		stu_label[3]=new JLabel("密码：",JLabel.CENTER);
		stu_label[4]=new JLabel("性别：",JLabel.CENTER);
		stu_label[5]=new JLabel("院系号：",JLabel.CENTER);
		stu_label[6]=new JLabel("班级号：",JLabel.CENTER);
		stu_label[7]=new JLabel("电话：",JLabel.CENTER);
		stu_label[8]=new JLabel("QQ：",JLabel.CENTER);
		stu_jb[0]=new JButton("查询");
		stu_jb[1]=new JButton("删除");
		stu_jb[2]=new JButton("修改");
		
		String stu_col[]={"学号","姓名","密码","性别","院系号","班级号","电话","QQ"};
		JTable stu_tabel=new JTable(Asql.selectAll("student"),stu_col);
		JScrollPane stu_jsp=new JScrollPane(stu_tabel);
		JPanel stu_jp=new JPanel();
		studentpanel.setBounds(10,10,900,900);
		studentpanel.setLayout(null);
		stu_jsp.setBounds(20,20,900,200);
		stu_jp.setLayout(new FlowLayout());
		stu_jp.setBounds(20,230,900,450);
		Box basebox,box[]=new Box[7];
		for(int i=0;i<7;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(stu_label[0]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(stu_jtf[0]);
		box[1].add(stu_jb[0]);
		box[1].add(Box.createHorizontalStrut(80));
		box[1].add(stu_jb[1]);
		box[2].add(stu_label[1]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(stu_jtf[1]);
		box[2].add(Box.createHorizontalStrut(60));
		box[2].add(stu_label[2]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(stu_jtf[2]);
		box[3].add(stu_label[3]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(stu_jtf[3]);
		box[3].add(Box.createHorizontalStrut(60));
		box[3].add(stu_label[4]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(stu_jtf[4]);
		box[4].add(stu_label[5]);
		box[4].add(Box.createHorizontalStrut(8));
		box[4].add(stu_jtf[5]);
		box[4].add(Box.createHorizontalStrut(60));
		box[4].add(stu_label[6]);
		box[4].add(Box.createHorizontalStrut(8));
		box[4].add(stu_jtf[6]);
		box[5].add(stu_label[7]);
		box[5].add(Box.createHorizontalStrut(20));
		box[5].add(stu_jtf[7]);
		box[5].add(Box.createHorizontalStrut(60));
		box[5].add(stu_label[8]);
		box[5].add(Box.createHorizontalStrut(28));
		box[5].add(stu_jtf[8]);
		box[6].add(stu_jb[2]);
		basebox=Box.createVerticalBox();
		for(int i=0;i<7;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		stu_jp.add(basebox);
		studentpanel.add(stu_jsp);
		studentpanel.add(stu_jp);
	}
	
	JPanel teacherpanel=new JPanel();
	JLabel tea_label[]=new JLabel[8];
	JTextField tea_jtf[]=new JTextField[8];
	JButton tea_jb[]=new JButton[3];
	public void Ateacher(){
		for(int i=0;i<8;i++){
			tea_jtf[i]=new JTextField(10);
		}
		tea_label[0]=new JLabel("原始教师号：",JLabel.CENTER);
		tea_label[1]=new JLabel("教师号：",JLabel.CENTER);
		tea_label[2]=new JLabel("姓名：",JLabel.CENTER);
		tea_label[3]=new JLabel("密码：",JLabel.CENTER);
		tea_label[4]=new JLabel("性别：",JLabel.CENTER);
		tea_label[5]=new JLabel("院系号：",JLabel.CENTER);
		tea_label[6]=new JLabel("电话：",JLabel.CENTER);
		tea_label[7]=new JLabel("QQ：",JLabel.CENTER);
		tea_jb[0]=new JButton("查询");
		tea_jb[1]=new JButton("删除");
		tea_jb[2]=new JButton("修改");
		
		String tea_col[]={"教师号","姓名","密码","性别","院系号","电话","QQ"};
		JTable tea_tabel=new JTable(Asql.selectAll("teacher"),tea_col);
		JScrollPane tea_jsp=new JScrollPane(tea_tabel);
		JPanel tea_jp=new JPanel();
		teacherpanel.setBounds(10,10,900,900);
		teacherpanel.setLayout(null);
		tea_jsp.setBounds(20,20,900,200);
		tea_jp.setLayout(new FlowLayout());
		tea_jp.setBounds(20,230,900,450);
		Box basebox,box[]=new Box[7];
		for(int i=0;i<7;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(tea_label[0]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(tea_jtf[0]);
		box[1].add(tea_jb[0]);
		box[1].add(Box.createHorizontalStrut(80));
		box[1].add(tea_jb[1]);
		box[2].add(tea_label[1]);
		box[2].add(Box.createHorizontalStrut(8));
		box[2].add(tea_jtf[1]);
		box[2].add(Box.createHorizontalStrut(60));
		box[2].add(tea_label[2]);
		box[2].add(Box.createHorizontalStrut(14));
		box[2].add(tea_jtf[2]);
		box[3].add(tea_label[3]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(tea_jtf[3]);
		box[3].add(Box.createHorizontalStrut(60));
		box[3].add(tea_label[4]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(tea_jtf[4]);
		box[4].add(tea_label[5]);
		box[4].add(Box.createHorizontalStrut(8));
		box[4].add(tea_jtf[5]);
		box[5].add(tea_label[6]);
		box[5].add(Box.createHorizontalStrut(20));
		box[5].add(tea_jtf[6]);
		box[5].add(Box.createHorizontalStrut(60));
		box[5].add(tea_label[7]);
		box[5].add(Box.createHorizontalStrut(28));
		box[5].add(tea_jtf[7]);
		box[6].add(tea_jb[2]);
		basebox=Box.createVerticalBox();
		for(int i=0;i<7;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		tea_jp.add(basebox);
		teacherpanel.add(tea_jsp);
		teacherpanel.add(tea_jp);
	}

	
	JPanel lessonpanel=new JPanel();
	JLabel les_label[]=new JLabel[3];
	JTextField les_jtf[]=new JTextField[3];
	JButton les_jb[]=new JButton[4];
	
	public void Alesson(){
		for(int i=0;i<3;i++){
			les_jtf[i]=new JTextField(20);
		}
		les_label[0]=new JLabel("原始课程号：",JLabel.CENTER);
		les_label[1]=new JLabel("课程号：",JLabel.CENTER);
		les_label[2]=new JLabel("课程名：",JLabel.CENTER);
		les_jb[0]=new JButton("删除");
		les_jb[1]=new JButton("查询");
		les_jb[2]=new JButton("添加");
		les_jb[3]=new JButton("修改");
		
		String les_col[]={"课程号","课程名"};
		JTable les_tabel=new JTable(Asql.selectAll("lesson"),les_col);
		JScrollPane les_jsp=new JScrollPane(les_tabel);
		JPanel les_jp=new JPanel();
		lessonpanel.setBounds(10,10,900,900);
		lessonpanel.setLayout(null);
		les_jsp.setBounds(20,20,900,200);
		les_jp.setLayout(new FlowLayout());
		les_jp.setBounds(20,230,900,450);
		Box basebox,box[]=new Box[5];
		for(int i=0;i<5;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(les_label[0]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(les_jtf[0]);
		box[1].add(les_jb[0]);
		box[1].add(Box.createHorizontalStrut(80));
		box[1].add(les_jb[1]);
		box[2].add(les_label[1]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(les_jtf[1]);
		box[3].add(les_label[2]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(les_jtf[2]);
		box[4].add(les_jb[2]);
		box[4].add(Box.createHorizontalStrut(80));
		box[4].add(les_jb[3]);
		basebox=Box.createVerticalBox();
		for(int i=0;i<5;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		les_jp.add(basebox);
		lessonpanel.add(les_jsp);
		lessonpanel.add(les_jp); 
	}

	
	JPanel departmentpanel=new JPanel();
	JLabel dep_label[]=new JLabel[6];
	JTextField dep_jtf[]=new JTextField[6];
	JButton dep_jb[]=new JButton[4];
	
	public void Adepartment(){
		for(int i=0;i<6;i++){
			dep_jtf[i]=new JTextField(10);
		}
		dep_label[0]=new JLabel("原始院系号：",JLabel.CENTER);
		dep_label[1]=new JLabel("原始班级号：",JLabel.CENTER);
		dep_label[2]=new JLabel("院系号：",JLabel.CENTER);
		dep_label[3]=new JLabel("院系名：",JLabel.CENTER);
		dep_label[4]=new JLabel("班级号：",JLabel.CENTER);
		dep_label[5]=new JLabel("班级名：",JLabel.CENTER);
		dep_jb[0]=new JButton("删除");
		dep_jb[1]=new JButton("查询");
		dep_jb[2]=new JButton("添加");
		dep_jb[3]=new JButton("修改");
		
		String dep_col[]={"院系号","院系名","班级号","班级名"};
		JTable dep_tabel=new JTable(Asql.selectAll("department"),dep_col);
		JScrollPane dep_jsp=new JScrollPane(dep_tabel);
		JPanel dep_jp=new JPanel();
		departmentpanel.setBounds(10,10,900,900);
		departmentpanel.setLayout(null);
		dep_jsp.setBounds(20,20,900,200);
		dep_jp.setLayout(new FlowLayout());
		dep_jp.setBounds(20,230,900,450);
		Box basebox,box[]=new Box[5];
		for(int i=0;i<5;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(dep_label[0]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(dep_jtf[0]);
		box[0].add(Box.createHorizontalStrut(60));
		box[0].add(dep_label[1]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(dep_jtf[1]);
		box[1].add(dep_jb[0]);
		box[1].add(Box.createHorizontalStrut(80));
		box[1].add(dep_jb[1]);
		box[2].add(dep_label[2]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(dep_jtf[2]);
		box[2].add(Box.createHorizontalStrut(60));
		box[2].add(dep_label[3]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(dep_jtf[3]);
		box[3].add(dep_label[4]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(dep_jtf[4]);
		box[3].add(Box.createHorizontalStrut(60));
		box[3].add(dep_label[5]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(dep_jtf[5]);
		box[4].add(dep_jb[2]);
		box[4].add(Box.createHorizontalStrut(80));
		box[4].add(dep_jb[3]);

		basebox=Box.createVerticalBox();
		for(int i=0;i<5;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		dep_jp.add(basebox);
		departmentpanel.add(dep_jsp);
		departmentpanel.add(dep_jp); 
	}


	JPanel classpanel=new JPanel();
	JLabel cla_label[]=new JLabel[6];
	JTextField cla_jtf[]=new JTextField[6];
	JButton cla_jb[]=new JButton[2];
	
	public void Aclass(){
		for(int i=0;i<6;i++){
			cla_jtf[i]=new JTextField(10);
		}
		cla_label[0]=new JLabel("原始班级号：",JLabel.CENTER);
		cla_label[1]=new JLabel("原始课程号：",JLabel.CENTER);
		cla_label[2]=new JLabel("班级号：",JLabel.CENTER);
		cla_label[3]=new JLabel("班级名：",JLabel.CENTER);
		cla_label[4]=new JLabel("课程号：",JLabel.CENTER);
		cla_label[5]=new JLabel("教师号：",JLabel.CENTER);
		cla_jb[0]=new JButton("查询");
		cla_jb[1]=new JButton("修改");
		
		String cla_col[]={"班级号","班级名","课程号","教师号"};
		JTable cla_tabel=new JTable(Asql.selectAll("class"),cla_col);
		JScrollPane cla_jsp=new JScrollPane(cla_tabel);
		JPanel cla_jp=new JPanel();
		classpanel.setBounds(10,10,900,900);
		classpanel.setLayout(null);
		cla_jsp.setBounds(20,20,900,200);
		cla_jp.setLayout(new FlowLayout());
		cla_jp.setBounds(20,230,900,450);
		Box basebox,box[]=new Box[5];
		for(int i=0;i<5;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(cla_label[0]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(cla_jtf[0]);
		box[0].add(Box.createHorizontalStrut(60));
		box[0].add(cla_label[1]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(cla_jtf[1]);
		box[1].add(cla_jb[0]);
		box[2].add(cla_label[2]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(cla_jtf[2]);
		box[2].add(Box.createHorizontalStrut(60));
		box[2].add(cla_label[3]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(cla_jtf[3]);
		box[3].add(cla_label[4]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(cla_jtf[4]);
		box[3].add(Box.createHorizontalStrut(60));
		box[3].add(cla_label[5]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(cla_jtf[5]);
		box[4].add(cla_jb[1]);
	
		basebox=Box.createVerticalBox();
		for(int i=0;i<5;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		cla_jp.add(basebox);
		classpanel.add(cla_jsp);
		classpanel.add(cla_jp); 
	}

	
	JPanel scorepanel=new JPanel();
	JButton sco_jb[]=new JButton[2];
	JLabel sco_label[]=new JLabel[6];
	JTextField sco_jtf[]=new JTextField[6];

	
	public void Ascore(){
		for(int i=0;i<6;i++){
			sco_jtf[i]=new JTextField(10);
		}
		sco_label[0]=new JLabel("原始学号：",JLabel.CENTER);
		sco_label[1]=new JLabel("原始课程号：",JLabel.CENTER);
		sco_label[2]=new JLabel("学号：",JLabel.CENTER);
		sco_label[3]=new JLabel("课程号：",JLabel.CENTER);
		sco_label[4]=new JLabel("教师号：",JLabel.CENTER);
		sco_label[5]=new JLabel("分数：",JLabel.CENTER);
		sco_jb[0]=new JButton("查询");
		sco_jb[1]=new JButton("修改");
		
		String sco_col[]={"学号","课程名","教师号","分数"};
		JTable sco_tabel=new JTable(Asql.selectAll("score"),sco_col);
		JScrollPane sco_jsp=new JScrollPane(sco_tabel);
		JPanel sco_jp=new JPanel();
		scorepanel.setBounds(10,10,900,900);
		scorepanel.setLayout(null);
		sco_jsp.setBounds(20,20,900,200);
		sco_jp.setLayout(new FlowLayout());
		sco_jp.setBounds(20,230,900,450);
		Box basebox,box[]=new Box[5];
		for(int i=0;i<5;i++){
			box[i]=Box.createHorizontalBox();
		}
		box[0].add(sco_label[0]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(sco_jtf[0]);
		box[0].add(Box.createHorizontalStrut(60));
		box[0].add(sco_label[1]);
		box[0].add(Box.createHorizontalStrut(20));
		box[0].add(sco_jtf[1]);
		box[1].add(sco_jb[0]);
		box[2].add(sco_label[2]);
		box[2].add(Box.createHorizontalStrut(33));
		box[2].add(sco_jtf[2]);
		box[2].add(Box.createHorizontalStrut(60));
		box[2].add(sco_label[3]);
		box[2].add(Box.createHorizontalStrut(10));
		box[2].add(sco_jtf[3]);
		box[3].add(sco_label[4]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(sco_jtf[4]);
		box[3].add(Box.createHorizontalStrut(60));
		box[3].add(sco_label[5]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(sco_jtf[5]);
		box[4].add(sco_jb[1]);
	
		basebox=Box.createVerticalBox();
		for(int i=0;i<5;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		sco_jp.add(basebox);
		scorepanel.add(sco_jsp);
		scorepanel.add(sco_jp); 
	}
	
	
	JPanel a_xadmin;
	JLabel a_xlabel[]=new JLabel[6];
	JTextField a_xjtf[]=new JTextField[6];
	JButton a_xjb=new JButton("修改");
	
	public void a_xmessage(String id){
		a_xadmin=new JPanel();
		a_xadmin.setLayout(new FlowLayout());
		a_xadmin.setBounds(10,10,900,900);
		Box basebox,box[]=new Box[7];
		a_xlabel[0]=new JLabel("ID：");
		a_xlabel[1]=new JLabel("姓名：");
		a_xlabel[2]=new JLabel("密码：");
		a_xlabel[3]=new JLabel("性别：");
		a_xlabel[4]=new JLabel("电话：");
		a_xlabel[5]=new JLabel("QQ：");
		for(int i=0;i<6;i++){
			a_xjtf[i]=new JTextField(10);
			a_xjtf[i].setText(Asql.selectOneLine("admin","系管号",id)[i]);
		}
		
		a_xjtf[0].setEditable(false);
		for(int j=0;j<7;j++){
			box[j]=Box.createHorizontalBox();
		}
		box[0].add(a_xlabel[0]);
		box[0].add(Box.createHorizontalStrut(35));
		box[0].add(a_xjtf[0]);
		box[1].add(a_xlabel[1]);
		box[1].add(Box.createHorizontalStrut(20));
		box[1].add(a_xjtf[1]);
		box[2].add(a_xlabel[2]);
		box[2].add(Box.createHorizontalStrut(20));
		box[2].add(a_xjtf[2]);
		box[3].add(a_xlabel[3]);
		box[3].add(Box.createHorizontalStrut(20));
		box[3].add(a_xjtf[3]);
		box[4].add(a_xlabel[4]);
		box[4].add(Box.createHorizontalStrut(20));
		box[4].add(a_xjtf[4]);
		box[5].add(a_xlabel[5]);
		box[5].add(Box.createHorizontalStrut(28));
		box[5].add(a_xjtf[5]);
		box[6].add(a_xjb);
		basebox=Box.createVerticalBox();
		for(int i=0;i<6;i++){
			basebox.add(Box.createVerticalStrut(30));
			basebox.add(box[i]);
		}
		basebox.add(Box.createVerticalStrut(80));
		basebox.add(box[6]);
		a_xadmin.add(basebox);
	}
	
}
