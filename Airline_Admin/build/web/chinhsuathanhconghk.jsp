<%-- 
    Document   : chinhsuathanhconghk
    Created on : Apr 4, 2016, 11:47:06 PM
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
        <%
            String mahk_str="";
            if(request.getAttribute("mahk")!=null){
                mahk_str=(String)request.getAttribute("mahk");

        %>
        <h1>Đã cập nhật thành công Thông tin Hành Khách <%=mahk_str%></h1>
        <%}
        else{%>
        <h1>Không thể cập nhật Thông tin cho Hành Khách</h1>
        
        <%}%>
        
        <form action="MainForm.jsp">
            <input class="xoahkreturnHP" type="submit" value="Quay về trang Quản Trị" />
        </form>
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
