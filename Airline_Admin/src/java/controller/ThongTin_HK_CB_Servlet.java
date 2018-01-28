/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.HanhKhach;

/**
 *
 * @author thehaohcm
 */
public class ThongTin_HK_CB_Servlet extends HttpServlet {

    
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
        String hoten="",cmnd="",sdt="",dchi="",hanhly="",email=""; //thiếu lấy dữ liệu từ parameter 'hành lý'
        hoten=request.getParameter("hoten");
        cmnd=request.getParameter("cmnd");
        sdt=request.getParameter("sdt");
        dchi=request.getParameter("dchi");
        hanhly=request.getParameter("hanhly");
        email=request.getParameter("email");
        String tb="";
        
        String macb="";
        macb=request.getParameter("macb");
        
        HanhKhachDAOImpl HK=new HanhKhachDAOImpl();
        
        if(hoten.trim().length()==0||cmnd.trim().length()==0||sdt.trim().length()==0||dchi.trim().length()==0||email.trim().length()==0)
        {
            tb="Bạn chưa nhập đầy đủ thông tin";
            request.setAttribute("tb",tb);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Client/InformationForm.jsp?macb="+macb);
            rd.forward(request, response);
        }
        else
        {
//            if(HK.AddHK(hoten, cmnd, sdt, dchi, email)){
//                tb="Đã thêm hành khách thành công";
//            }
//            else{
//                tb="Đã có lỗi xảy ra, không thể thêm hành khách vào danh sách";
//            }
            
            HanhKhach hk=new HanhKhach(hoten,cmnd,sdt,dchi,email); //constructor HanhKhach thiếu parameter 'hành lý'
            request.setAttribute("tthk", hk);
            request.setAttribute("macb", macb);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Client/Information.jsp?macb="+macb);
            rd.forward(request, response);
        }
//        request.setAttribute("tb",tb);
//        if(tb.equals("Bạn chưa nhập đầy đủ thông tin")||tb.equals("Đã có lỗi xảy ra, không thể thêm hành khách vào danh sách")){
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Client/InformationForm.jsp");
//            rd.forward(request, response);
//        }else{
//            hk.setHoTen(hoten);
//            hk.setCMND(cmnd);
//            hk.setSoDT(sdt);
//            hk.setDChi(dchi);
//            hk.setEmail(email);
//            request.setAttribute("hk", hk);
//            
//        }
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
