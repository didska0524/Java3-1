package jdbc_study;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
    Connection conn = null;
    Statement stmt = null;
    ConnectDB db = new ConnectDB();

    StudentDAO() {
        conn = db.connect();
    }
    public ArrayList<Student> studentList() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from student";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student bean = new Student(
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("dept")
                );
                list.add(bean);

            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("쿼리 출력 오류 : "+e);
        }
        return list;
    }
    public boolean insertStudent(Student bean){
        boolean success = false;
        String sql= "insert into student(id, name, dept) values(?,?,?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, bean.getName());
            pstmt.setString(3, bean.getDept());
            int result = pstmt.executeUpdate();
            if(result>0){
                success=true;
            }
            else{
                success=false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return success;
    }

    public boolean updateStudent(Student bean) {
        boolean success = false;
        String sql= "update student set name=?,dept=? where id=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getDept());
            pstmt.setString(3, bean.getId());
            int result = pstmt.executeUpdate();
            if(result>0){
                success=true;
            }
            else{
                success=false;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return success;
    }

    public boolean deleteStudent(Student bean) {
        boolean success = false;
        String sql = "delete from student where id=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getId());
            int result = pstmt.executeUpdate();
            if(result>0){
                success=true;
            }
            else{
                success=false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }
}
