/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HanhKhachDAOImpl;
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
public class CSHanhKhach_Servlet extends HttpServlet {

    
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
        String mahk_str="",tenhk="",cmnd="",sdt="",dchi="",hanhly_str="",email="";
        int mahk=0;
        float hanhly=0;
        mahk_str=request.getParameter("mahk");
        mahk=Integer.parseInt(mahk_str);
        tenhk=request.getParameter("tenhk");
        cmnd=request.getParameter("cmnd");
        sdt=request.getParameter("sdt");
        dchi=request.getParameter("dchi");
        hanhly_str=request.getParameter("hanhly");
        hanhly=Float.parseFloat(hanhly_str);
        email=request.getParameter("email");
        
        HanhKhachDAOImpl HK=new HanhKhachDAOImpl();
        if(HK.updateHanhKhach(mahk, tenhk, cmnd, sdt, dchi, hanhly, email)==true){
            request.setAttribute("mahk", mahk_str);
        }
        
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/chinhsuathanhconghk.jsp");
        rd.forward(request, response);
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
