package model;

/**
 * Created by zfx on 15/11/13.
 */
import java.sql.Date;
import java.sql.Timestamp;
public class Event {
    private long id;
    private int issue_id;
    private int field_id;
    private String field;

    private int user_id;
    private long time;

    public Event(long i,int i_id,int f_id,int u_id,String str,Timestamp t){
        id=i;
        issue_id= i_id;
        field_id = f_id;
        field = new String(str);
        user_id = u_id;
        time = t.getTime();

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getField() {
        return field;
    }

}
