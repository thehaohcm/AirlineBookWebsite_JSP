/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChuyenBayDAOImpl;
import dao.HanhKhachDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        String macb="",hoten="",cmnd="",sdt="",dchi="",email=""; //thiếu việc lấy dữ liệu từ 'hành lý'
        float hanhly=(float) 0.0;
        macb=request.getParameter("macb");
        hoten=request.getParameter("hoten");
        cmnd=request.getParameter("cmnd");
        sdt=request.getParameter("sdt");
        dchi=request.getParameter("dchi");
        hanhly=Float.parseFloat(request.getParameter("hanhly"));
        email=request.getParameter("email");
        String tb="";
        
        HanhKhachDAOImpl HK=new HanhKhachDAOImpl();
        HanhKhach hk=new HanhKhach();
        ChuyenBayDAOImpl CB=new ChuyenBayDAOImpl();
        ChuyenBay cb=new ChuyenBay();
        cb=CB.getEleChuyenBay(macb);
        if(hoten.trim().length()==0||cmnd.trim().length()==0||sdt.trim().length()==0||dchi.trim().length()==0||email.trim().length()==0)
            tb="Bạn chưa nhập đầy đủ thông tin";
        else
        {
            if(cb.getSLHKHT()<cb.getSLHKTD()){
                if(HK.AddHK(macb,hoten, cmnd, sdt, dchi,hanhly, email)){
                    tb="Đã thêm hành khách thành công";
                }
                else{
                    tb="Đã có lỗi xảy ra, không thể thêm hành khách vào danh sách";
                }
            }
            else{
                tb="Đã hết chỗ ngồi, không thể thêm hành khách vào danh sách";
            }
        }
        request.setAttribute("tb",tb);
        if(tb.equals("Đã thêm hành khách thành công")){
            hk.setHoTen(hoten);
            hk.setCMND(cmnd);
            hk.setSoDT(sdt);
            hk.setDChi(dchi);
            hk.setEmail(email);
            hk.setMaHK(HK.getMaHK(hk));
            request.setAttribute("hk", hk);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Finish.jsp");
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/InformationForm.jsp");
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
