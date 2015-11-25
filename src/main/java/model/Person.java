package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by zfx on 15/11/18.
 */
public class Person {
    public TreeMap<Long,Event> list;
    public int user_id;
    public TreeMap<Long,Event> init_list;
    public int days;
    public int n_bug;
    public int n_comment;
    public int n_change;
    public long first_id;
    public long first_time;
    public long gap;

    public Person(){
        list = new TreeMap<Long, Event>();
        init_list = new TreeMap<Long, Event>();
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getN_bug() {
        return n_bug;
    }

    public void setN_bug(int n_bug) {
        this.n_bug = n_bug;
    }

    public int getN_change() {
        return n_change;
    }

    public void setN_change(int n_change) {
        this.n_change = n_change;
    }

    public int getN_comment() {
        return n_comment;
    }

    public void setN_comment(int n_comment) {
        this.n_comment = n_comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getFirst_id() {
        return first_id;
    }

    public void setFirst_id(long first_id) {
        this.first_id = first_id;
    }

    public long getFirst_time() {
        return first_time;
    }

    public void setFirst_time(long first_time) {
        this.first_time = first_time;
    }

    public long getGap() {
        return gap;
    }

    public void setGap(long gap) {
        this.gap = gap;
    }

    public TreeMap<Long, Event> getInit_list() {
        return init_list;
    }

    public void setInit_list(TreeMap<Long, Event> init_list) {
        this.init_list = init_list;
    }

    public TreeMap<Long, Event> getList() {
        return list;
    }

    public void setList(TreeMap<Long, Event> list) {
        this.list = list;
    }
}
