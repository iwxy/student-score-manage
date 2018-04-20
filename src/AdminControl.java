import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;

import javax.swing.*;

public class AdminControl extends JFrame implements MouseListener{
	AdminPanel admin=new AdminPanel();
	AdminSQL sql=new AdminSQL();
	JMenuBar menubar;   //菜单条
	JMenu menu1,menu2,menu3,menu4,menu5,menu6,menu7;
	String id;
	
	public AdminControl(String id){
		this.id=id;
		init();
		setLayout(null);
		setVisible(true);
		setTitle("管理员");
		setBounds(100,10,1000,710);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(this.isUndecorated()){          //运行程序就是最大化窗口
			this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		}else{
			this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}

	}
	public void init(){
		menubar=new JMenuBar();
		menu1=new JMenu("学生");
		menu1.addMouseListener(this);
		menu2=new JMenu("教师");
		menu2.addMouseListener(this);
		menu3=new JMenu("院系");
		menu3.addMouseListener(this);
		menu4=new JMenu("班级");
		menu4.addMouseListener(this);
		menu5=new JMenu("分数");
		menu5.addMouseListener(this);
		menu6=new JMenu("课程");
		menu6.addMouseListener(this);
		menu7=new JMenu("个人中心");
		menu7.addMouseListener(this);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		menubar.add(menu5);
		menubar.add(menu6);
		menubar.add(menu7);
		this.setJMenuBar(menubar);
		
//		admin.Ascore();
//		this.add(admin.scorepanel);
	}
	int x=0;
	public void mousePressed(MouseEvent a){
		
		if(x==1){
			remove(admin.studentpanel);
		}
		if(x==2){
			remove(admin.teacherpanel);
		}
		if(x==3){
			remove(admin.departmentpanel);
		}
		if(x==4){
			remove(admin.classpanel);
		}
		if(x==5){
			remove(admin.scorepanel);
		}
		if(x==6){
			remove(admin.lessonpanel);
		}
		if(x==7){
			remove(admin.a_xadmin);
		}
		if(a.getSource()==menu1){
			admin.Astudent();
			add(admin.studentpanel);
			x=1;
			admin.stu_jb[0].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					for(int i=0;i<8;i++){
						admin.stu_jtf[i+1].setText(sql.selectOneLine("student","学号",admin.stu_jtf[0].getText())[i]);
					}
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.stu_jb[1].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.deletedOne("student","学号",admin.stu_jtf[0].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.stu_jb[2].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.studentUpdate(admin.stu_jtf[0].getText(),admin.stu_jtf[1].getText(),admin.stu_jtf[2].getText(),admin.stu_jtf[3].getText(),admin.stu_jtf[4].getText(),admin.stu_jtf[5].getText(),admin.stu_jtf[6].getText(),admin.stu_jtf[7].getText(),admin.stu_jtf[8].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		if(a.getSource()==menu2){
			admin.Ateacher();
			add(admin.teacherpanel);
			x=2;
			admin.tea_jb[0].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					for(int i=0;i<7;i++){
						admin.tea_jtf[i+1].setText(sql.selectOneLine("teacher","教师号",admin.tea_jtf[0].getText())[i]);
					}
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.tea_jb[1].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.deletedOne("teacher","教师号",admin.tea_jtf[0].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.tea_jb[2].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.teacherUpdate(admin.tea_jtf[0].getText(),admin.tea_jtf[1].getText(),admin.tea_jtf[2].getText(),admin.tea_jtf[3].getText(),admin.tea_jtf[4].getText(),admin.tea_jtf[5].getText(),admin.tea_jtf[6].getText(),admin.tea_jtf[7].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		if(a.getSource()==menu3){
			admin.Adepartment();
			add(admin.departmentpanel);
			x=3;
			admin.dep_jb[0].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.deleteDepOne(admin.dep_jtf[0].getText(),admin.dep_jtf[1].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.dep_jb[1].addMouseListener(new MouseListener(){;
			public void mousePressed(MouseEvent a){
				for(int i=0;i<4;i++){
					admin.dep_jtf[i+2].setText(sql.selectDepOneLine(admin.dep_jtf[0].getText(),admin.dep_jtf[1].getText())[i]);
				}
			}
			public void mouseReleased(MouseEvent a){}
			public void mouseEntered(MouseEvent a){}
			public void mouseExited(MouseEvent a){}
			public void mouseClicked(MouseEvent a){}
			});
			admin.dep_jb[2].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.departmentInsert(admin.dep_jtf[2].getText(),admin.dep_jtf[3].getText(),admin.dep_jtf[4].getText(),admin.dep_jtf[5].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.dep_jb[3].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.departmentUpdate(admin.dep_jtf[0].getText(),admin.dep_jtf[1].getText(),admin.dep_jtf[2].getText(),admin.dep_jtf[3].getText(),admin.dep_jtf[4].getText(),admin.dep_jtf[5].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		if(a.getSource()==menu4){
			admin.Aclass();
			add(admin.classpanel);
			x=4;
			admin.cla_jb[0].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					for(int i=0;i<4;i++){
						System.out.println("1");
						admin.cla_jtf[i+2].setText(sql.selectClaOneLine(admin.cla_jtf[0].getText(),admin.cla_jtf[1].getText())[i]);
					}
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.cla_jb[1].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.classUpdate(admin.cla_jtf[0].getText(),admin.cla_jtf[1].getText(),admin.cla_jtf[2].getText(),admin.cla_jtf[3].getText(),admin.cla_jtf[4].getText(),admin.cla_jtf[5].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		if(a.getSource()==menu5){
			admin.Ascore();
			add(admin.scorepanel);
			x=5;
			admin.sco_jb[0].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					for(int i=0;i<4;i++){
						admin.sco_jtf[i+2].setText(sql.selectScoOneLine(admin.sco_jtf[0].getText(),admin.sco_jtf[1].getText())[i]);
					}
					
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.sco_jb[1].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.scoreUpdate(admin.sco_jtf[0].getText(),admin.sco_jtf[1].getText(),admin.sco_jtf[2].getText(),admin.sco_jtf[3].getText(),admin.sco_jtf[4].getText(),admin.sco_jtf[5].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		if(a.getSource()==menu6){
			admin.Alesson();
			add(admin.lessonpanel);
			x=6;
			admin.les_jb[0].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.deletedOne("lesson","课程号",admin.les_jtf[0].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.les_jb[1].addMouseListener(new MouseListener(){;
			public void mousePressed(MouseEvent a){
				for(int i=0;i<2;i++){
					admin.les_jtf[i+1].setText(sql.selectOneLine("lesson","课程号",admin.les_jtf[0].getText())[i]);
					
				}
			}
			public void mouseReleased(MouseEvent a){}
			public void mouseEntered(MouseEvent a){}
			public void mouseExited(MouseEvent a){}
			public void mouseClicked(MouseEvent a){}
			});
			admin.les_jb[2].addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.lessonInsert(admin.les_jtf[1].getText(),admin.les_jtf[2].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			admin.les_jb[3].addMouseListener(new MouseListener(){;
			public void mousePressed(MouseEvent a){
				sql.lessonUpdate(admin.les_jtf[0].getText(),admin.les_jtf[1].getText(),admin.les_jtf[2].getText());
			}
			public void mouseReleased(MouseEvent a){}
			public void mouseEntered(MouseEvent a){}
			public void mouseExited(MouseEvent a){}
			public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		if(a.getSource()==menu7){
			admin.a_xmessage(id);
			add(admin.a_xadmin);
			x=7;
			admin.a_xjb.addMouseListener(new MouseListener(){
				public void mousePressed(MouseEvent a){
					sql.adminUpdate(admin.a_xjtf[0].getText(),admin.a_xjtf[1].getText(),admin.a_xjtf[2].getText(),admin.a_xjtf[3].getText(),admin.a_xjtf[4].getText(),admin.a_xjtf[5].getText());
				}
				public void mouseReleased(MouseEvent a){}
				public void mouseEntered(MouseEvent a){}
				public void mouseExited(MouseEvent a){}
				public void mouseClicked(MouseEvent a){}
			});
			repaint();
			validate();
		}
		
	}
	public void mouseReleased(MouseEvent a){}
	public void mouseEntered(MouseEvent a){}
	public void mouseExited(MouseEvent a){}
	public void mouseClicked(MouseEvent a){}

}
