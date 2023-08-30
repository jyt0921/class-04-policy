package Dao;

import Bean.bean01;
import Bean.bean02;
import Bean.sort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dao {
    public void showall(ArrayList<bean01> book) throws ClassNotFoundException, SQLException {
        String sql1="select name,organ,pubdata,type from policy";
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ResultSet rs =  ps.executeQuery();//获取结果集
        System.out.println(rs);
        while(rs.next()) {
            bean01 A=new bean01();
            A.setName(rs.getString(1));
            A.setOrgan(rs.getString(2));
            A.setPubdata(rs.getString(3));
            A.setType(rs.getString(4));
            book.add(A);
        }
    }

    public void select(ArrayList<bean01> book, String sel01, String sel02, String sel03, String sel04)throws ClassNotFoundException, SQLException  {
//        Connection connection = Util.util.getConnection();
        String sql="select name,organ,pubdata,type from policy where 1=1";
        System.out.println(sql);
        PreparedStatement pre=null;
        Connection connection = Util.util.getConnection();
        List<Object> parmas = new ArrayList<Object>();
        if(sel01!="") {
            sql=sql+" and name like ?";
            parmas.add("%" +sel01+ "%");
        }
        if(sel02!="") {
            sql=sql+" and document like ?";
            parmas.add("%" +sel02+ "%");
        }
        if(sel03!="") {
            sql=sql+" and organ like ?";
            parmas.add("%" +sel03+ "%");
        }
        if(sel04!="") {
            sql=sql+" and text like ?";
            parmas.add("%" +sel04+ "%");
        }
        int i=1;
            PreparedStatement ps=connection.prepareStatement(sql);
            System.out.println(sql);
            for(Object ob:parmas) {
                ps.setString(i,(String)ob);
                System.out.println(i);
                System.out.println((String)ob);
                System.out.println(sql);
                i++;
            }
            System.out.println(sql);
            ResultSet rs =  ps.executeQuery();//获取结果集
            System.out.println(rs);
            while(rs.next()) {
                bean01 A=new bean01();
                A.setName(rs.getString(1));
                A.setOrgan(rs.getString(2));
                A.setPubdata(rs.getString(3));
                A.setType(rs.getString(4));
                book.add(A);
            }

    }

    public void select0(ArrayList<bean01> book, String sel01, String sel02) throws ClassNotFoundException, SQLException{
        String sql1="select text from policy where name = ? AND organ = ?";
        System.out.println("chen");
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        System.out.println(con+"11111111111");
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,sel01);
        ps.setString(2,sel02);
        ResultSet rs =  ps.executeQuery();//获取结果集
        System.out.println(rs);
        while(rs.next()) {
            bean01 A=new bean01();
            A.setText(rs.getString(1));
            System.out.println(rs.getString(1));
            book.add(A);
        }

    }
//查询所有数据
    public void selecttree(ArrayList<bean02> book) throws ClassNotFoundException, SQLException{
        String sql1="select * from policysort";
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ResultSet rs =  ps.executeQuery();//获取结果集
        while(rs.next()) {
            bean02 A=new bean02();
            A.setTitle(rs.getString(2));
            A.setType_ID(rs.getInt(1));
            A.setPrior(rs.getInt(3));
            book.add(A);
        }
    }
    public void selecttree01(ArrayList<bean02> book,String id) throws ClassNotFoundException, SQLException{
        String sql1="select title from policysort where Type_ID = ?";
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,id);
        ResultSet rs =  ps.executeQuery();//获取结果集
        while(rs.next()) {
            bean02 A=new bean02();
            A.setTitle(rs.getString(1));
            System.out.println(rs.getString(1));
            book.add(A);
        }
    }

    //查询所有有子节点的获取所有的子节点
    public void selecttree02(ArrayList<bean02> book,String id) throws ClassNotFoundException, SQLException{
        String sql1="select title from policysort where prior = ?";
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,id);
        ResultSet rs =  ps.executeQuery();//获取结果集
//        System.out.println(rs);
        while(rs.next()) {
            bean02 A=new bean02();
            A.setTitle(rs.getString(1));
            System.out.println(rs.getString(1));
            book.add(A);
        }
    }

    public void selectsum(ArrayList<bean01> book, String sel01)throws ClassNotFoundException, SQLException{
        String sql1="select name,organ,pubdata,type from policy where type =? ";
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,sel01);
        ResultSet rs =  ps.executeQuery();//获取结果集
        while(rs.next()) {
            bean01 A=new bean01();
            A.setName(rs.getString(1));
            A.setOrgan(rs.getString(2));
            A.setPubdata(rs.getString(3));
            A.setType(rs.getString(4));
            book.add(A);
        }
}

    public void selecttree00(ArrayList<bean02> qqq)throws ClassNotFoundException, SQLException{
        String sql1="select title from policysort";
        PreparedStatement pre=null;
        Connection con=Util.util.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ResultSet rs =  ps.executeQuery();//获取结果集
        while(rs.next()) {
            bean02 A=new bean02();
            A.setTitle(rs.getString(1));
//            A.setType_ID(rs.getString(1));
//            A.setPrior(rs.getString(3));
//            A.setIndex(rs.getString(4));
            qqq.add(A);
        }
    }

    public void sort(ArrayList<sort> list)throws ClassNotFoundException, SQLException{
        String sql0 = "SELECT a.Type_ID,a.title,COUNT(b.type) FROM policysort a LEFT JOIN policy b ON b.type=a.Type_ID GROUP BY TYPE  ";
        PreparedStatement pre = null;
        Connection con = Util.util.getConnection();
        PreparedStatement ps = con.prepareStatement(sql0);
        ResultSet rs = ps.executeQuery();//获取结果集
        while (rs.next()) {
            bean01 A = new bean01();
            sort s=new sort();
            s.setTypeid(rs.getString("Type_id"));
            s.setType(rs.getString("title"));
            s.setCount(rs.getString("count(b.type)"));
            add(list,s);
        }
    }
    public void add(ArrayList<sort> list,sort s){
        for(int i=0;i<list.size();i++){
            if(list.get(i).add0(s))
                return;
        }
        list.add(s);
    }
}
