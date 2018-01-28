<%-- 
    Document   : xoathanhconghk
    Created on : Apr 4, 2016, 9:58:04 PM
    Author     : thehaohcm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/media.css"/>
        <title>Xóa Thông Tin Hành Khách | CheapAirline</title>
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <%
            request.setCharacterEncoding("UTF-8");
            String mahk="";
            if(request.getAttribute("mahk")!=null)
                mahk=(String)request.getAttribute("mahk");
            if(mahk.length()>0){
            %>
                <h1>Đã xóa thành công Thông Tin Hành Khách <%=mahk%></h1>
            <%}else{%>
                <h1>Không thể xóa thành công Thông Tin Hành Khách <%=mahk%></h1>
            <%}%>
            <form action="MainForm.jsp" />
                <input type="submit" class="xoahkreturnHP" value="Quay về trang Quản Trị" />
            </form>
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
