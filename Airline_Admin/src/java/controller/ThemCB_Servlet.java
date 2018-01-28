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
public class ThemCB_Servlet extends HttpServlet {

    

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
        String macb="",hang="",ngaydi="",giodi="",ngayden="",gioden="",diadiemdi="",diadiemden="",giave_str="";
        int slhktd=0;
        macb=request.getParameter("macb");
        hang=request.getParameter("hang");
        ngaydi=request.getParameter("ngaydi");
        giodi=request.getParameter("giodi");
        ngayden=request.getParameter("ngayden");
        gioden=request.getParameter("gioden");
        diadiemdi=request.getParameter("diadiemdi");
        diadiemden=request.getParameter("diadiemden");
        giave_str=request.getParameter("giave");
        //slhktd=Integer.parseInt(request.getParameter("slhktd"));
        
        String loi="";
        if(macb.trim().length()==0 || hang.trim().length()==0 || ngaydi.trim().length()==0 || giodi.trim().length()==0 || ngayden.trim().length()==0 || gioden.trim().length()==0 || giave_str.length()==0)
        {
            loi="Bạn chưa điền đầy đủ thông tin";
            request.setAttribute("loi", loi);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/themcb.jsp");
            rd.forward(request, response);
        }
        else{
            try{
                ChuyenBayDAOImpl cb=new ChuyenBayDAOImpl();
                int maddi=Integer.parseInt(diadiemdi);
                int madden=Integer.parseInt(diadiemden);
                int giave=Integer.parseInt(giave_str);
                
                if(slhktd==0)
                    slhktd=300;
                if(cb.addCB(macb, hang, ngaydi, giodi, ngayden, gioden, maddi, madden, giave, slhktd)==true)
                {
                    loi="Đã thêm chuyến bay thành công";
                    request.setAttribute("loi",loi);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainForm.jsp");
                    rd.forward(request, response);
                }
                else{
                    loi="Không thể thêm chuyến bay vào csdl";
                    request.setAttribute("loi", loi);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/themcb.jsp");
                    rd.forward(request, response);
                }
            }catch(Exception ex){
                loi="Không thể thêm chuyến bay vào csdl";
                request.setAttribute("loi", loi);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/themcb.jsp");
                rd.forward(request, response);
            }
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
