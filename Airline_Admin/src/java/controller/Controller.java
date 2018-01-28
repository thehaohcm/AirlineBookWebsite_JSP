/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author thehaohcm
 */
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("command").equals("logout")){
            HttpSession session=request.getSession();
            session.invalidate();
            response.sendRedirect("LogPage.jsp");
        }
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
        String tentaikhoan=request.getParameter("tentaikhoan");
        String matkhau=request.getParameter("matkhau");
        
        String tentaikhoan_error="",matkhau_error="",dangnhap_error="";
        
        if(tentaikhoan.trim().equals("")){
            tentaikhoan_error="Vui lòng nhập vào tên tài khoản";
            request.setAttribute("tentaikhoan_error", tentaikhoan_error);
        }
        if(matkhau.trim().equals("")){
            matkhau_error="Vui lòng nhập mật khẩu";
            request.setAttribute("matkhau_error", matkhau_error);
        }
        TaiKhoanDAOImpl tk=new TaiKhoanDAOImpl();
        if(!tk.CheckAccount(tentaikhoan, matkhau)){
            dangnhap_error="Sai thông tin đăng nhập";
            request.setAttribute("dangnhap_error", dangnhap_error);
        }
        try{
            if(matkhau_error.length()==0 && tentaikhoan_error.length()==0&&dangnhap_error.length()==0)
            {
//                boolean flag_tentaikhoan=false,flag_matkhau=false;
//                Cookie[] cookies=request.getCookies();
//                for(Cookie cookie:cookies){
//                    if(cookie.getName().equals("tentaikhoan"))
//                        flag_tentaikhoan=true;
//                    if(cookie.getName().equals("matkhau"))
//                        flag_matkhau=true;
//                }
//                if(flag_tentaikhoan==false || flag_matkhau==false){
//                    Cookie username=new Cookie("tentaikhoan",tentaikhoan);
//                    Cookie password=new Cookie("matkhau",matkhau);
//                    username.setMaxAge(60*60*24);
//                    password.setMaxAge(60*60*24);
//                }
                Cookie username_cookie = new Cookie("username",tentaikhoan);
                Cookie password_cookie = new Cookie("password",matkhau);
                username_cookie.setMaxAge(10*60);
                password_cookie.setMaxAge(10*60);
                response.addCookie(username_cookie);
                response.addCookie(password_cookie);
                response.sendRedirect("/Airline_Admin/MainForm.jsp");
                
            }
            else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/LogPage.jsp");
                rd.forward(request, response);
            }
            
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
