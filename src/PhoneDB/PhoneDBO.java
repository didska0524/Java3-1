package PhoneDB;

import java.sql.*;
import java.util.ArrayList;


public class PhoneDBO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;

    connectDB db = new connectDB();

    PhoneDBO() {conn = db.connect();}

    public ArrayList<PhoneSet> phoneList(){
        ArrayList<PhoneSet> list = new ArrayList();
        String sql = "select * from user";
        try {
            stmt = conn.createStatement();
            ResultSet rs = this.stmt.executeQuery(sql);

            while(rs.next()) {
                PhoneSet bean = new PhoneSet(
                        rs.getString("name"),
                        rs.getString("phone"));
                list.add(bean);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
            System.out.println("쿼리 출력 오류 : " + var5);
        }

        return list;
    }
    public boolean insertPhone(PhoneSet bean) {
        boolean success = false;
        String sql = "insert into user(name, phone) values(?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getPhone());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                success = true;
            } else {
                success = false;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return success;
    }
    public boolean updatePhone(PhoneSet bean) {
        boolean success = false;
        String sql = "update user set phone=? where name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getPhone());
            pstmt.setString(2, bean.getName());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                success = true;
            } else {
                success = false;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return success;
    }
    public boolean deletePhone(PhoneSet bean) {
        boolean success = false;
        String sql = "delete from user where name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                success = true;
            } else {
                success = false;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return success;
    }
}

