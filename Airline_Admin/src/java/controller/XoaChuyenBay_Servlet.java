/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChuyenBayDAOImpl;
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
public class XoaChuyenBay_Servlet extends HttpServlet {

    
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
        String macb=request.getParameter("macb");
        String tb="";
        ChuyenBayDAOImpl cb=new ChuyenBayDAOImpl();
        if(cb.deleteCB(macb)){
            tb="Đã xóa Chuyến Bay thành công";            
        }
        else{
            tb="Không thể xóa Chuyến Bay";
        }
        request.setAttribute("tb", tb);
        if(tb.equals("Đã xóa Chuyến Bay thành công")){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/xoathanhcongCB.jsp?macb="+macb);
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/thongtincb.jsp?macb="+macb);
            rd.forward(request, response);
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
