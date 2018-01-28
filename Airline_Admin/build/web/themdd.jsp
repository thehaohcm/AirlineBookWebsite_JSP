<%-- 
    Document   : themdd
    Created on : Mar 26, 2016, 3:25:58 PM
    Author     : thehaohcm
--%>

<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/media.css"/>
         <title>Thêm Địa Điểm | Cheap AirLine</title>
        <script>
            function kiemtra(){
                var tendd=document.getElementById("tendd");
                var tensb=document.getElementById("tensb");
                if(tendd.value.trim()==""){
                    alert("Xin vui lòng nhập vào thông tin Tên Địa Điểm");
                    return;
                }
                if(tensb.value.trim()==""){
                    alert("Xin vui lòng nhập vào thông tin Tên Sân Bay");
                    return;
                }
                frm.submit();
            }
        </script>  
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
            String tc="",loi_dd="",loi_sb="";
            if(request.getAttribute("tc")!=null)
                tc=(String)request.getAttribute("tc");
            if(request.getAttribute("loi_dd")!=null)
                loi_dd=(String)request.getAttribute("loi_dd");
            if(request.getAttribute("loi_sb")!=null)
                loi_sb=(String)request.getAttribute("loi_sb");
            %>
        <h1 class="themddH1">Thêm Địa Điểm - Sân Bay</h1>
        <form id="frm" method="POST" action="ThemDD_Servlet">
            <table class="themddTB">
                <tr>
                    <th>Tên Địa Điểm</th>
                    <th><input type="text" id="tendd" name="tendd" /></th>
                </tr>
                <tr>
                    <th>Tên Sân Bay</th>
                    <th><input type="text" id="tensb" name="tensb" /></th>
                </tr>
                <tr>
                    <th><input class="themddb1" type="button" onclick="kiemtra()" value="Thêm Địa Điểm" /></th>
                </tr>
            </table>
        </form>
        <p style="color:red"><%=loi_dd%></p>
        <p style="color:red"><%=loi_sb%></p>
        <p style="color:blue"><%=tc%></p>
        
        <form action="MainForm.jsp">
            <input class="themddb2" type="submit" value="Quay lại trang quản trị" />
            
        </form>
        <br>
        <br>
        <br>
        
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
