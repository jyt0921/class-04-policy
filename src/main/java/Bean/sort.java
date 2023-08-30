package Bean;

import java.util.ArrayList;

public class sort {
    private String typeid;
    private String type;
    private String count;
    private ArrayList<sort> list;

    public sort(){
        list=new ArrayList<sort>();
    }
    public boolean add0(sort s){
        if(typeid.regionMatches(0, s.getTypeid(), 0, 2)){
            list.add(s);
            return true;
        }
        return false;
    }
    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<sort> getList() {
        return list;
    }

    public void setList(ArrayList<sort> list) {
        this.list = list;
    }
}
