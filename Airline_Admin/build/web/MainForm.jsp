
<%@page import="model.TaiKhoan"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <title>Airline Booking</title>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
         <link rel="stylesheet" href="css/media.css"/>
         <link rel="stylesheet" href="css/submit_javascript.css"/>
      
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <%String username="";
            String password="";
        if(password.length()==0 || username.length()==0){
                Cookie[] cookies =request.getCookies();
                if(cookies==null){
//                    System.out.print("cho nay null");
                    request.setAttribute("timeout", "Đã quá thời gian cho một phiên làm việc. Bạn vui lòng đăng nhập lại");
                    RequestDispatcher rd=request.getRequestDispatcher("/LogForm.jsp");
                    rd.forward(request, response);
                    return;
                }
                else{
                    for(Cookie cookie:cookies){
                        if(cookie.getName().equals("username"))
                            username=cookie.getValue();
                        if(cookie.getName().equals("password"))
                            password=cookie.getValue();
                    }
                }
            }
        if(username.length()==0 || password.length()==0)
        {
            request.setAttribute("tentaikhoan_error", "Vui lòng nhập vào tên tài khoàn");
            request.setAttribute("matkhau_error", "Vui lòng nhập vào mật khẩu");
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/LogPage.jsp");
            rd.forward(request, response);
        }
        %>
    <center><h1 class="MainformH1">Xin chào Quản trị viên <%=username%></h1></center>
        
        <br>
        <jsp:include page="./dschuyenbay.jsp"></jsp:include>
        <br>
        <jsp:include page="./dsdiadiem.jsp"></jsp:include>
        <br>
        <jsp:include page="./dshanhkhach.jsp"></jsp:include>
        <br>
        <br>
        <jsp:include page="./Footer.jsp"></jsp:include>
</body>
</html>