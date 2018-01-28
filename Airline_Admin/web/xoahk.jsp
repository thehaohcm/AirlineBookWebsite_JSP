<%-- 
    Document   : xoahk
    Created on : Apr 4, 2016, 9:11:23 PM
    Author     : thehaohcm
--%>

<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page import="dao.HanhKhachDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/media.css"/>
        <title>Xóa hành khách | CheapAirline</title>
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <%
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
            String mahk_str="";
            int mahk=0;
            if(request.getParameter("mahk")!=null){
                mahk_str=request.getParameter("mahk");
                mahk=Integer.parseInt(mahk_str);
            }
            if(mahk==0){%>
            <h1 class="xoahkH1err">Không thể truy cập thông tin và xóa hành khách</h1>
            
            <br>
            <form action="MainForm.jsp">
                <input class="xoahkreturnHP" type="submit" value="Quay về trang Quản Trị" />
            </form>
            <%}else{%>
                <h1 class="xoahkH1">Xác nhận xóa thông tin về hành khách <%=mahk%></h1>
                

                <br>
                <form method="POST" action="XoaHanhKhach_Servlet">
                    <input type="hidden" name="mahk" value="<%=mahk%>" />
                    <input class="xoahkB" type="submit" value="Xóa Hành Khách"/>
                </form>
                    <br>
                    <br>
                    <br>
                <form action="MainForm.jsp">
                    <input class="xoahkreturnHP" type="submit" value="Quay lại trang Quản Trị" />
                </form>
                    
                    <br>
                    <br>
                    <br>
                    <div><b><u>Lưu ý:</u></b> Việc xóa thông tin Hành Khách <%=mahk%> sẽ ảnh hường đến dữ liệu trong <b>Bảng Vé</b><br>
                        Để hạn chế những vấn đề phát sinh, hệ thống cũng sẽ xóa những thông tin của Hành Khách này trong Bảng Vé.</div><br>
                <br>
                    <br>
            <%}%>
            <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
