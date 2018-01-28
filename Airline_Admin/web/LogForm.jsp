<%-- 
    Document   : LogForm
    Created on : Mar 16, 2016, 8:11:38 PM
    Author     : Tran Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cheap Airline</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/media.css" rel="stylesheet">
    <link href="css/LogFormStyle.css" rel="stylesheet">
    </head>
    <body>
        <%
            String timeout="";
            String tentaikhoan_error="",matkhau_error="",dangnhap_error="";
            if(request.getAttribute("tentaikhoan_error")!=null)
                tentaikhoan_error=(String)request.getAttribute("tentaikhoan_error");
            if(request.getAttribute("matkhau_error")!=null)
                matkhau_error=(String)request.getAttribute("matkhau_error");
            if(request.getAttribute("dangnhap_error")!=null)
                dangnhap_error=(String)request.getAttribute("dangnhap_error");
            if(request.getAttribute("timeout")!=null)
                timeout=(String)request.getAttribute("timeout");


            %>
        <jsp:include page="header.jsp"></jsp:include>
        <section id="LogForm"><!--form-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-1">
                        <div class="login-form"><!--login form-->
                            <h2>Đăng nhập tài khoản quản trị</h2>
                            <form method="POST" action="Controller">
                                <p style="color:red"><%=tentaikhoan_error%></p>
                                Tên tài khoản: <input type="text" name="tentaikhoan" placeholder="username" />
                                <p style="color:red"><%=matkhau_error%></p>
                                Mật khẩu: <input type="password" name="matkhau" placeholder="Password" />
                                <p style="color:red"><%=dangnhap_error%></p>
                                <p style="color:red"><%=timeout%></p>
                                <button type="submit" class="btn btn-default">Login</button>
                                
                            </form>
                        </div><!--/login form-->
                    </div>
                </div>
            </div>
        </section><!--/form-->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
