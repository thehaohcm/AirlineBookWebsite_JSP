/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChuyenBayDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thehaohcm
 */
public class CSChuyenBay_Servlet extends HttpServlet {


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
        String macbcu=request.getParameter("macbcu");
        String macb=request.getParameter("macb");
        String hang=request.getParameter("hang");
        String ngaydi=request.getParameter("ngaydi");
        String giodi=request.getParameter("giodi");
        String ngayden=request.getParameter("ngayden");
        String gioden=request.getParameter("gioden");
        String diadiemdi_str=request.getParameter("diadiemdi");
        String diadiemden_str=request.getParameter("diadiemden");
        String giave_str=request.getParameter("giave");
        String slhktd_str=request.getParameter("slhktd");
        int diadiemdi=0,diadiemden=0,giave=0,slhktd=0;
        diadiemdi=Integer.parseInt(diadiemdi_str);
        diadiemden=Integer.parseInt(diadiemden_str);
        giave=Integer.parseInt(giave_str);
        slhktd=Integer.parseInt(slhktd_str);
        String loi="";
        
        ChuyenBayDAOImpl CB=new ChuyenBayDAOImpl();
        if(CB.updateCB(macbcu, macb,hang, ngaydi, giodi, ngayden, gioden, diadiemdi, diadiemden, giave, slhktd)==true)
            loi="Cập nhật chuyến bay thành công";
        else
            loi="Không thể cập nhật chuyến bay";
        
        try{
            if(loi.equals("Cập nhật chuyến bay thành công")){
                request.setAttribute("loi", loi);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainForm.jsp");
                rd.forward(request, response);
            }
            else{
                request.setAttribute("loi",loi);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/chinhsuacb.jsp?macb="+macb);
                rd.forward(request, response);
            }
        }catch(Exception ex){
            
        }
//        try (PrintWriter out = response.getWriter()) {
//                out.println(macbcu+" "+macb+" "+ngaydi+" "+gioden+" "+ngayden+" "+gioden+" "+diadiemdi+" "+diadiemden+" "+giave+" "+slhktd);
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
