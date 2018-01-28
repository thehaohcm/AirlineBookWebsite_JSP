<%-- 
    Document   : xoathanhcongdd
    Created on : Mar 29, 2016, 11:30:06 AM
    Author     : thehaohcm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <%request.setCharacterEncoding("UTF-8");
        String madd=request.getParameter("madd");%>
        <h1>Đã xóa thành công Địa Điểm <%=madd%></h1>
            <form action="MainForm.jsp">
                <input  type="submit" class="xoahkreturnHP" value="Quay lại trang Quản Trị"/>
            </form>
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
