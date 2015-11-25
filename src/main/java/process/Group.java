package process;

import model.Event;
import model.Person;
import os_db.BugDB;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zfx on 15/11/18.
 */
public class Group {
    public TreeMap<Integer, Person> all;
    public TreeMap<Long,Event> data;
    public long gap;
    public long beg;
    public Group(){
        all = new TreeMap<Integer, Person>();
        gap = 2592000;
    }
    public void init(){
        System.out.println("start");
        BugDB db = new BugDB();
        String sql="select * from events";
        data = db.selectF(sql);
        Iterator<Map.Entry<Long,Event>> it = data.entrySet().iterator();
        /*for(;it.hasNext();){
            Map.Entry<Long,Event> cur = it.next();
            System.out.println(cur.getKey().longValue());
            //System.out.println(cur.getValue().getTime());
        }*/
        System.out.println("end");
    }
    public void createAllList(){

        Iterator<Map.Entry<Long,Event>> it = data.entrySet().iterator();
        for(;it.hasNext();){
            Map.Entry<Long,Event> cur = it.next();
            Integer user_id = new Integer(cur.getValue().getUser_id());
            if(all.containsKey(user_id)){
                all.get(user_id).getList().put(cur.getValue().getTime(),cur.getValue());
            }else{
                Person cur_p = new Person();
                cur_p.getList().put(cur.getValue().getTime(),cur.getValue());
                all.put(user_id,cur_p);
            }
            System.out.println(cur.getKey().longValue());
            //System.out.println(cur.getValue().getTime());
        }
    }
    public void createAllOthers(){
        Iterator<Map.Entry<Integer,Person>> it = all.entrySet().iterator();
        for(;it.hasNext();){
            Map.Entry<Integer,Person> cur = it.next();
            TreeMap<Long,Event> list = cur.getValue().getList();

            //System.out.println(cur.getKey());
            Person p = cur.getValue();
            p.setFirst_id(list.firstEntry().getValue().getId());
            p.setFirst_time(list.firstKey());
            p.setUser_id(cur.getKey());
            p.setN_bug(0);
            p.setN_change(0);
            p.setN_comment(0);
            Iterator<Map.Entry<Long,Event>> lit = list.entrySet().iterator();
            for(;lit.hasNext();){
                Map.Entry<Long,Event> entry = lit.next();
                Event event = entry.getValue();
                if(event.getTime()-p.getFirst_time() <= gap){
                    p.getInit_list().put(event.getTime(),event);
                    if(event.getField().equals("comment")){
                        p.setN_comment(p.getN_comment()+1);

                    }else if(event.getField().equals("bug")){
                        p.setN_bug(p.getN_bug()+1);
                    }else{
                        p.setN_change(p.getN_change()+1);
                    }
                }
            }
            System.out.println(cur.getKey().toString()+" "+String.valueOf(p.getList().size())+" "+
                    String.valueOf(p.getInit_list().size())+" "+String.valueOf(p.getN_bug())+" "+String.valueOf(p.getN_comment())
            +" "+String.valueOf(p.getN_change())+" ");


        }
        System.out.println(all.size());
    }
    public static void main(String[] args){
        Group g = new Group();
        g.init();
        g.createAllList();
        g.createAllOthers();
    }
}
