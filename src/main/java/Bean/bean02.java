package Bean;

import java.util.ArrayList;

public class bean02 {
    private int Type_ID;
    private int prior;
    private String title;
    private String index;
    private ArrayList<bean02> children;
    public void bean01(){
        children=new ArrayList<bean02>();
    }

    public ArrayList<bean02> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<bean02> children) {
        this.children = children;
    }

    public void add0(bean02 s){
     children.add(s);
    }
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType_ID() {
        return Type_ID;
    }

    public void setType_ID(int type_ID) {
        Type_ID = type_ID;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }
}
