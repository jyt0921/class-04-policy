package Servlet;

import Bean.bean01;
import Dao.dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "zhuan", value = "/zhuan")
public class zhuan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sel01=request.getParameter("name");
        String sel02=request.getParameter("organ");
//        System.out.println(sel01+sel02+sel03+sel04);
        ArrayList<bean01> book = new ArrayList<bean01>();
        String s1="";
        dao dao = new dao();
        try {
            dao.select0(book,sel01,sel02);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i=0;i<book.size();i++){
            bean01 s=book.get(i);
            s1=s.getText();
            System.out.println(s1);
        }
//        int count1=book.size();
//        String count=""+count1;
//        System.out.println("chen"+count);
//        Map<String,Object> result=new HashMap<String,Object>();
//        result.put("code", 0);
//        result.put("msg", "");
//        result.put("count",count);
//        result.put("data",book);
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString (result);
        System.out.println(s1);
        System.out.println("1111111111111111111/**********");
        response.getWriter().print(s1);
//	    	request.getRequestDispatcher("showall0.html").forward(request, response);


    }
}
