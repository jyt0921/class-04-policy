package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.sort;
import Dao.dao;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "search", value = "/search")
public class search extends HttpServlet {
    public search() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        ArrayList<sort> list=new ArrayList<sort>();
        String res = "";
        dao dao=new dao();
        try {
            dao.sort(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObjectMapper MAPPER = new ObjectMapper();
        res = MAPPER.writeValueAsString(list);
        System.out.println(res);
        response.getWriter().append(res);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public void add(ArrayList<sort> list,sort s){
        for(int i=0;i<list.size();i++){
            if(list.get(i).add0(s))
                return;
        }
        list.add(s);
    }
    public void init(ServletConfig servletconfig) {

    }

    public void destroy() {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public String getServletinfo() {
        return null;
    }
}
