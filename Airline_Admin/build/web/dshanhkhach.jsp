<%-- 
    Document   : dshanhkhach
    Created on : Mar 19, 2016, 11:36:00 PM
    Author     : thehaohcm
--%>

<%@page import="dao.VeDAOImpl"%>
<%@page import="model.HanhKhach"%>
<%@page import="dao.HanhKhachDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách hành khách | Cheap Airline</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            HanhKhachDAOImpl HK=new HanhKhachDAOImpl();
        VeDAOImpl V=new VeDAOImpl();%>
        <h1 class="dsHanhKhachH1">Danh sách hành khách</h1>
        <br>
        <table class="dshanhkhachTB" border="5">
            <tr>
                <th>Mã</th>
                <th>Họ Tên</th>
                <th>CMND</th>
                <th>Số ĐT</th>
                <th>Địa Chỉ</th>
                <th>Hành Lý</th>
                <th>Email</th>
                <th>Giá Vé</th>
                <th>Xem thông tin chi tiết</th>
            </tr>
            <form action="xemthongtinhk.jsp">
            <%
               for(HanhKhach hk:HK.getListHanhKhach()){
                   %>
                   <tr>
                       <td><%=hk.getMaHK()%></td>
                       <td><%=hk.getHoTen()%></td>
                       <td><%=hk.getCMND()%></td>
                       <td><%=hk.getSoDT()%></td>
                       <td><%=hk.getDChi()%></td>
                       <td><%=hk.getHanhLy()%></td>
                       <td><%=hk.getEmail()%></td>
                       <td><%=V.getGiaVe(hk.getMaHK())%></td>
                       <td><button class="dshanhkhachcheckinfoB" name="mahk" value="<%=hk.getMaHK()%>"><strong>Xem thông tin</strong></button></td>
                   </tr>
            <%}%>
        </table>
            </form>

    </body>
</html>
