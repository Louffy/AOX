package os_db;

import model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by zfx on 15/11/12.
 */
public class BugDB {
    private Connection conn;
    public BugDB(){

        conn = Connector.getConn().getDbc();

    }
    public TreeMap<Long,Event> selectF(String sql){
        Statement stmt=null;
        ResultSet rs=null;
        TreeMap<Long,Event> data = new TreeMap<Long, Event>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                long id = rs.getLong("id");
                int issue_id = rs.getInt("issue_id");
                int field_id = rs.getInt("field_id");
                String field = rs.getString("field");
                int user_id = rs.getInt("changed_by");
                Timestamp time = rs.getTimestamp("changed_on");
                Event current_event = new Event(id,issue_id,field_id,user_id,field,time);
                data.put(new Long(id),current_event);
            }

            if(rs!=null)
                rs.close();
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            return data;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
        return data;
    }
    public static void main(String[] args){
        System.out.println("start");
        BugDB db = new BugDB();
        String sql="select * from events";
        //ResultS rs = db.selectF(sql);
    }


}
