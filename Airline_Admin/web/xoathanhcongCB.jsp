<%-- 
    Document   : xoathanhcongCB
    Created on : Mar 29, 2016, 10:55:09 AM
    Author     : thehaohcm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/media.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String macb=request.getParameter("macb");%>
        <h1 class="xoathanhcongCB">Đã xóa thành công chuyến bay <%=macb%></h1>
        <form action="MainForm.jsp">
            <input  type="submit" class="xoahkreturnHP" value="Quay lại trang Quản Trị"/>
        </form>
    </body>
</html>
