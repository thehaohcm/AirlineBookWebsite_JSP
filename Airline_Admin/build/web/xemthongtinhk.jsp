<%-- 
    Document   : xemthongtinhk
    Created on : Apr 4, 2016, 7:36:04 PM
    Author     : thehaohcm
--%>

<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<%@page import="model.ChuyenBay"%>
<%@page import="dao.VeDAOImpl"%>
<%@page import="model.HanhKhach"%>
<%@page import="dao.HanhKhachDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/media.css"/>
        <title>JSP Page</title>
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
            String mahk_str = "";
            int mahk = 0;
            if (request.getParameter("mahk") != null) {
                mahk_str = request.getParameter("mahk");
                mahk = Integer.parseInt(mahk_str);
            }

            if (mahk == 0) {
        %>
        <h1>Không thể lấy thông tin hành khách</h1>
        <%} else {
            HanhKhach hk = new HanhKhach();
            HanhKhachDAOImpl HK = new HanhKhachDAOImpl();
            hk = HK.getHanhKhachbymahk(mahk);
            
            ChuyenBayDAOImpl CB=new ChuyenBayDAOImpl();
            ChuyenBay cb=new ChuyenBay();
            cb=CB.getChuyenBay(mahk);

            VeDAOImpl V=new VeDAOImpl(); 
        %>
        <h1 class="xemthongtinhkH1">Thông tin về hành khách <%=mahk%></h1>
        <table class="xemthongtinhktb" border="3">
            <tr>
                <th>Mã Hành Khách</th>
                <td><%=hk.getMaHK()%></td>
            </tr>
            <tr>
                <th>Họ tên Hành Khách</th>
                <td><%=hk.getHoTen()%></td>
            </tr>
            <tr>
                <th>CMND</th>
                <td><%=hk.getCMND()%></td>
            </tr>   
            <tr>
                <th>Số Điện Thoại</th>
                <td><%=hk.getSoDT()%></td>
            </tr>
            <tr>
                <th>Địa chỉ</th>
                <td><%=hk.getDChi()%></td>
            </tr>
            <tr>
                <th>Hành lý</th>
                <td><%=hk.getHanhLy()%></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%=hk.getEmail()%></td>
            </tr>
            <tr>
                <th>Giá Vé</th>
                <td><%=V.getGiaVe(mahk)%></td>
            
            </tr>
            <tr>
                <th>Chuyến Bay</th>
                <td><%=cb.getMaCB()%> (Mã Chuyến Bay: <%=cb.getHang()%>)</td>
            </tr>
        </table>    
        <form action="chinhsuahk.jsp">
            <input type="hidden" name="mahk" value="<%=mahk%>" />
            <input class="xemthongtinhkb1" type="submit" value="Sửa thông tin" />
        </form>
        <form action="xoahk.jsp">
            <input type="hidden" name="mahk" value="<%=mahk%>" />
            <input class="xemthongtinhkb2" type="submit" value="Xóa hành khách" />
        </form>
        <form action="MainForm.jsp">
            <input class="xemthongtinhkb3" type="submit" value="Về trang Quản Trị" />
        </form>
            <br>
            <br>
        <%}%>
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
