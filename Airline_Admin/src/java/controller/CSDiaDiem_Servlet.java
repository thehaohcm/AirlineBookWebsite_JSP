/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DiaDiemDAOImpl;
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
public class CSDiaDiem_Servlet extends HttpServlet {

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
        String madd_string="",tendd="",tensb="";
        String tb="";
        request.setCharacterEncoding("UTF-8");
        madd_string=request.getParameter("madd");
        
        tendd=request.getParameter("tendd");
        tensb=request.getParameter("tensb");
        if(madd_string.length()==0||tendd.length()==0||tensb.length()==0){
            tb="Bạn chưa điền đầy đủ thông tin";
        }
        else{
            int madd=Integer.parseInt(madd_string);
            DiaDiemDAOImpl dd=new DiaDiemDAOImpl();
            if(dd.updateDD(madd, tendd, tensb))
                tb="Đã sửa Địa Điểm thành công";
            else
                tb="Không thể chỉnh sửa Địa Điểm";
        }
        request.setAttribute("tb", tb);
        
        if(tb.equals("Bạn chưa điền đầy đủ thông tin")||tb.equals("Không thể chỉnh sửa Địa Điểm"))
        {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/chinhsuadd.jsp");
                rd.forward(request, response);
        }
        else
        {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainForm.jsp");
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
