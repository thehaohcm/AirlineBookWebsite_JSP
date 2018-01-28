/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChuyenBayDAOImpl;
import dao.HanhKhachDAOImpl;
import dao.TaiKhoanDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ChuyenBay;
import model.HanhKhach;

/**
 *
 * @author thehaohcm
 */
public class ThemHanhKhach_Servlet extends HttpServlet {


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
        String macb="",hoten="",cmnd="",sdt="",dchi="",email="",hanhly_str=""; //thiếu việc lấy dữ liệu từ 'hành lý'
        float hanhly=(float) 0.0;
        macb=request.getParameter("macb");
        hoten=request.getParameter("hoten");
        cmnd=request.getParameter("cmnd");
        sdt=request.getParameter("sdt");
        dchi=request.getParameter("dchi");
        hanhly_str=request.getParameter("hanhly");
        hanhly=Float.parseFloat(hanhly_str);
        email=request.getParameter("email");
        String tb="";
        
        HanhKhachDAOImpl HK=new HanhKhachDAOImpl();
        HanhKhach hk=new HanhKhach();
        if(hoten.trim().length()==0||cmnd.trim().length()==0||sdt.trim().length()==0||dchi.trim().length()==0||email.trim().length()==0)
            tb="Bạn chưa nhập đầy đủ thông tin";
        else
        {
            if(HK.AddHK(macb,hoten, cmnd, sdt, dchi, email)){
                tb="Đã thêm hành khách thành công";
            }
            else{
                tb="Đã có lỗi xảy ra, không thể thêm hành khách vào danh sách";
            }
        }
        request.setAttribute("tb",tb);
        if(tb.equals("Bạn chưa nhập đầy đủ thông tin")||tb.equals("Đã có lỗi xảy ra, không thể thêm hành khách vào danh sách")){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Client/InformationForm.jsp");
            rd.forward(request, response);
        }else{
            hk.setHoTen(hoten);
            hk.setCMND(cmnd);
            hk.setSoDT(sdt);
            hk.setDChi(dchi);
            hk.setEmail(email);
            request.setAttribute("hk", hk);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Client/Finish.jsp");
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
