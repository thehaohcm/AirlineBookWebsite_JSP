/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DiaDiemDAOImpl;
import dao.TaiKhoanDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thehaohcm
 */
public class ThemDD_Servlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username="",password="";
            Cookie[] cookies=request.getCookies();
            if(cookies==null){
                request.setAttribute("timeout", "Đã quá thời gian cho một phiên làm việc. Bạn vui lòng đăng nhập lại");
                RequestDispatcher rd=request.getRequestDispatcher("/MainForm.jsp");
                rd.forward(request, response);
                return;
            }

            for(Cookie cookie:cookies){
                if(cookie.getName().equals("username"))
                    username=cookie.getValue();
                if(cookie.getName().equals("password"))
                    password=cookie.getValue();
            }
            
            TaiKhoanDAOImpl tkd=new TaiKhoanDAOImpl();
            if(!tkd.CheckAccount(username, password)){
                request.setAttribute("timeout", "Đã quá thời gian cho một phiên làm việc. Bạn vui lòng đăng nhập lại");
                RequestDispatcher rd=request.getRequestDispatcher("/MainForm.jsp");
                rd.forward(request, response);
                return;
            }
        DiaDiemDAOImpl dd=new DiaDiemDAOImpl();
        String loi_dd="",loi_sb="",tc="",tendd="",tensb="",madd_string="";
        int madd = 0;
        if(request.getParameter("madd")!=null)
        {
            madd_string=request.getParameter("madd");
            madd=Integer.parseInt(madd_string);
        }
        if(request.getParameter("tendd")!=null)
            tendd=(String)request.getParameter("tendd");
        if(request.getParameter("tensb")!=null)
            tensb=(String)request.getParameter("tensb");
        
        if(tendd.trim().length()==0){
            loi_dd="Bạn chưa nhập tên Địa Điểm";
            request.setAttribute("loi_dd", loi_dd);
        }
        if(tensb.trim().length()==0){
            loi_sb="Bạn chưa nhập tên Sân Bay";
            request.setAttribute("loi_sb",loi_sb);
            
        }
        if(loi_dd.length()==0 &&loi_sb.length()==0){
            if(dd.AddDiaDiem(madd,tendd, tensb)==true)
                tc="Đã thêm Địa Điểm thành công";
            else
                tc="Không thể thêm Địa Điểm";
            request.setAttribute("tc", tc);
        }
        try{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/themdd.jsp");
            rd.forward(request, response);
        }catch(Exception ex){
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
