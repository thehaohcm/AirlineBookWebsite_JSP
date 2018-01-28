<%-- 
    Document   : index
    Created on : May 18, 2016, 1:39:22 PM
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
        <%
            RequestDispatcher rd=request.getRequestDispatcher("/MainForm.jsp");
            rd.forward(request, response);
            %>
    </body>
</html>
