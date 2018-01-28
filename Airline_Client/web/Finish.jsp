<%-- 
    Document   : Finish
    Created on : Mar 29, 2016, 2:35:39 PM
    Author     : thehaohcm
--%>

<%@page import="dao.VeDAOImpl"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="model.ChuyenBay"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<%@page import="model.HanhKhach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Đăng ký thành công | Cheap Airline</title>
    </head>
    <body class="FinishFormBG">
        <%
            String macb=request.getParameter("macb");
            ChuyenBayDAOImpl CB=new ChuyenBayDAOImpl();
            DiaDiemDAOImpl DD=new DiaDiemDAOImpl();
            VeDAOImpl V=new VeDAOImpl();
            ChuyenBay cb=new ChuyenBay();
            cb=CB.getEleChuyenBay(macb);
            String tb="";
            if(request.getAttribute("tb")!=null)
                tb=(String)request.getAttribute("tb");
            
            HanhKhach hk=new HanhKhach();
            if(request.getAttribute("hk")!=null)
                hk=(HanhKhach)request.getAttribute("hk");
        %>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="menu_nav">
                        <ul>
                            <li class="active"><a href="index.jsp"><span>Home Page</span></a></li>
                            <li><a href="News.jsp"><span>Thông tin</span></a></li>
                            <li><a href="about.jsp"><span>About Us</span></a></li>


                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="clr"></div>
        <br></br>
        <h1 class="FinishH1"><strong>Đăng ký Vé thành công</strong></h1>
        <h2 class="FinishH2">Thông tin chuyến bay</h2>
        <table border="0" class="FinishTable1">
            <tr>
                <th>Mã Chuyến Bay</th>
                <td><%=cb.getMaCB()%></td>
            </tr>
            <tr>
                <th>Hãng Hàng Không</th>
                <td><%=cb.getHang()%></td>
            </tr>
            <tr>
                <th>Ngày Đi</th>
                <td><%=cb.getNgayDi()%></td>
            </tr>
            <tr>
                <th>Giờ Đi</th>
                <td><%=cb.getGioDi()%></td>
            </tr>
            <tr>
                <th>Ngày Đến</th>
                <td><%=cb.getNgayDen()%></td>
            </tr>
            <tr>
                <th>Giờ Đến</th>
                <td><%=cb.getGioDen()%></td>
            </tr>
            <tr>
                <th>Địa điểm Hiện tại</th>
                <td><%=DD.getTenDD(cb.getDiaDiem_Di())%></td>
            </tr>
            <tr>
                <th>Địa điểm Đến</th>
                <td><%=DD.getTenDD(cb.getDiaDiem_Den())%></td>
            </tr>
            <tr>
                <th>Giá Vé</th>
                <td><%=cb.getGiaVe()%></td>
            </tr>
            <tr>
                <th>Số lượng Hành khách</th>
                <td><%=cb.getSLHKHT()%> / <%=cb.getSLHKTD()%></td>
            </tr>
        </table>
            <br><br>
        <h2 class="FinishH2" >Thông tin về Hành Khách</h2>
        <table border="0" class="FinishTable1a" >
            <tr>
                <th>Mã Hành Khách</th>
                <td><%=hk.getMaHK()%></td>
            </tr>
            <tr>
                <th>Họ Tên: </th>
                <td><%=hk.getHoTen()%></td>
            </tr>
            <tr>
                <th>CMND: </th>
                <td><%=hk.getCMND()%></td>
            </tr>
            <tr>
                <th>Số điện thoại: </th>
                <td><%=hk.getSoDT()%></td>
            </tr>
            <tr>
                <th>Địa chỉ: </th>
                <td><%=hk.getDChi()%></td>
            </tr>
            <tr>
                <th>Email: </th>
                <td><%=hk.getEmail()%></td>
            </tr>
            <tr>
                <th>Giá Vé:</th>
                <td><%=V.getGiaVeHK(cb.getMaCB(), hk.getMaHK())%></td>
            </tr>
        </table>
            <div class="clr"></div>
            
        <form class="ReturnFn" action="index.jsp">
            <input type="submit" value="Quay về Trang Chủ" />
        </form>
            <div class="clr"></div>
            <div class="clr"></div>
            
            <div class="footer">
                <div class="footer_resize">
                    <p class="lf">Copyright by CheapAirline Corp 2016. All Rights Reserved</p>
                    <p class="rf">Design by <a target="_blank" href="index.jsp">CheapAirline</a></p>
                    <div style="clear:both;"></div>
                </div>
            </div>
    </body>
</html>
