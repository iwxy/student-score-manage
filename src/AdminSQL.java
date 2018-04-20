import java.sql.*;

public class AdminSQL {
	Connection con;
	Statement sta;
	ResultSet rs;
	String SQL;
//	String ident;
//	int stu_rows,tea_rows,dep_rows,cla_rows,sco_rows,les_rows;
	public AdminSQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[][] selectAll(String ident){
		String Sdata[][];
		String s[][]=new String[0][0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from "+ident;
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Scol=rs1.getColumnCount();     //获取数据的列数
			rs.last();
			int Srows=rs.getRow();
			Sdata=new String[Srows][Scol];
			rs.beforeFirst();
			int j=0;
			while(rs.next()){
				for(int i=0;i<Scol;i++){
					Sdata[j][i]=rs.getString(i+1);
				}
				j++;
			}
			con.close();
			return Sdata;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectOneLine(String ident,String name,String id){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from "+ident+" where "+name+"="+id;
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectDepOneLine(String id,String las){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from department where 院系号='"+id+"' and 班级号='"+las+"'";
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectClaOneLine(String id,String las){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from class where 班级号='"+id+"' and 课程号='"+las+"'";
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectScoOneLine(String id,String las){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from score where 学号='"+id+"' and 课程号='"+las+"'";
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public void studentUpdate(String id1,String id,String name,String password,String sex,String dep,String cla,String tel,String QQ){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update student set 学号='"+id+"',姓名='"+name+"',密码='"+password+"',性别='"+sex+"',院系号='"+dep+"',班级号='"+cla+"',电话='"+tel+"',QQ='"+QQ+"' where 学号='"+id1+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void teacherUpdate(String id1,String id,String name,String password,String sex,String dep,String tel,String QQ){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update teacher set 教师号='"+id+"',姓名='"+name+"',密码='"+password+"',性别='"+sex+"',院系号='"+dep+"',电话='"+tel+"',QQ='"+QQ+"' where 教师号='"+id1+"'";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void departmentUpdate(String id1,String cla1,String id,String name,String cla,String claname){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update department set 院系号='"+id+"',院系名='"+name+"',班级号='"+cla+"',班级名='"+claname+"' where 院系号='"+id1+"' and 班级号='"+cla1+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void classUpdate(String id1,String les1,String id,String name,String les,String tea){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update class set 班级号='"+id+"',班级名='"+name+"',课程号='"+les+"',教师号='"+tea+"' where 班级号='"+id1+"' and 课程号='"+les1+"'";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void scoreUpdate(String id1,String les1,String id,String les,String tea,String sco){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update score set 学号='"+id+"',课程号='"+les+"',教师号='"+tea+"',分数='"+sco+"' where 学号='"+id1+"' and 课程号='"+les1+"'";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void lessonUpdate(String id1,String id,String name){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update lesson set 课程号='"+id+"',课程名='"+name+"' where 课程号='"+id1+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void adminUpdate(String id,String name,String password,String sex,String tel,String QQ){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update admin set 系管名='"+name+"',密码='"+password+"',性别='"+sex+"',电话='"+tel+"',QQ='"+QQ+"' where 系管号='"+id+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	public void departmentInsert(String id,String name,String cla,String claname){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="insert into department values('"+id+"','"+name+"','"+cla+"','"+claname+"')";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void lessonInsert(String id,String name){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="insert into lesson values('"+id+"','"+name+"')";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void deletedOne(String ident,String z,String id){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="delete from "+ident+" where "+z+"='"+id+"'";
			sta.executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteDepOne(String z,String id){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="delete from department where 院系号='"+z+"' and 班级号='"+id+"'";
			sta.executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
