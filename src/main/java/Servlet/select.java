package Servlet;

import Bean.bean01;
import Dao.dao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "select", value = "/select")
public class select extends HttpServlet {
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
        String sel01=request.getParameter("sel01");
        String sel02=request.getParameter("sel02");
        String sel03=request.getParameter("sel03");
        String sel04=request.getParameter("sel04");
        System.out.println(sel01+sel02+sel03+sel04);
        ArrayList<bean01> book = new ArrayList<bean01>();
        dao dao = new dao();
        try {
            dao.select(book,sel01,sel02,sel03,sel04);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int count1=book.size();
        String count=""+count1;
        System.out.println("chen"+count);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",count);
        result.put("data",book);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString (result);
        response.getWriter().print(json.toString()); //传递json给后端
//	    	request.getRequestDispatcher("showall0.html").forward(request, response);


    }
}
