<%-- 
    Document   : Information
    Created on : Mar 31, 2016, 10:30:54 PM
    Author     : thehaohcm
--%>

<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="model.ChuyenBay"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<%@page import="model.HanhKhach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information</title>
    </head>

    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            HanhKhach hk = new HanhKhach();
            String macb = "";
            if (request.getAttribute("tthk") != null && request.getAttribute("macb") != null) {
                hk = (HanhKhach) request.getAttribute("tthk");
                macb = (String) request.getAttribute("macb");
                ChuyenBayDAOImpl CB = new ChuyenBayDAOImpl();
                ChuyenBay cb = new ChuyenBay();
                cb = CB.getEleChuyenBay(macb);
                DiaDiemDAOImpl DD = new DiaDiemDAOImpl();

                float hanhly = hk.getHanhLy();
                int giahl = 0;
                if (hanhly < 15.0) {
                    giahl = 0;
                } else if (hanhly < 20.0) {
                    giahl = 143000;
                } else if (hanhly < 25.0) {
                    giahl = 165000;
                } else if (hanhly < 30.0) {
                    giahl = 220000;
                } else if (hanhly < 35.0) {
                    giahl = 270000;
                } else if (hanhly < 40.0) {
                    giahl = 320000;
                }
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
        <div class="clr"></div>
        <div class="clr"></div>
        <div class="Confirmback">
             <div class="clr"></div>
                  <div class="clr"></div>
                   <div class="clr"></div>
                  <div class="clr"></div>
            <h1 class="Confirmtb1h1">Thông tin về Hành Khách - Vé</h1>
             
            <h2 class="Confirmtb1h2">Thông tin về Chuyến Bay</h2>
            <h2 class="Confirmtb1h2b">Thông tin về Hành Khách</h2>
            <div class="clr"></div>
        <div class="clr"></div>
        <div class="clr"></div>
            <table class="Confirmtb1" border="2">
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
                    <th>Giá Vé chuẩn</th>
                    <td><%=cb.getGiaVe()%></td>
                </tr>
                <tr>
                    <th>Số lượng Hành khách</th>
                    <td><%=cb.getSLHKHT()%> / <%=cb.getSLHKTD()%></td>
                </tr>
            </table>

            <br>
           
            <table class="Confirmtb2" border="2">
                <tr>
                    <th>Họ Tên</th>
                    <td><%=hk.getHoTen()%></td>
                </tr>
                <tr>
                    <th>CMND</th>
                    <td><%=hk.getCMND()%></td>
                </tr>
                <tr>
                    <th>Số Điện thoại</th>
                    <td><%=hk.getSoDT()%></td>
                </tr>
                <tr>
                    <th>Địa Chỉ</th>
                    <td><%=hk.getDChi()%></td>
                </tr>
                <tr>
                    <th>Hành Lý (kg)</th>
                    <td><%=hk.getHanhLy()%></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><%=hk.getEmail()%></td>
                </tr>
                <tr>
                    <th>Tổng Giá Vé</th>
                    <td><%=cb.getGiaVe()%> + <%=giahl%> = <b><%=cb.getGiaVe() + giahl%></b></td>
                </tr>
            </table>
                <div class="clr"></div>
                
                <div class="clr"></div>
            <form class="SigninIFtb"   method="POST" action="ThemHanhKhach_Servlet">
                <input type="hidden" name="macb" value="<%=macb%>" />
                <input type="hidden" name="hoten" value="<%=hk.getHoTen()%>"/>
                <input type="hidden" name="cmnd" value="<%=hk.getCMND()%>" />
                <input type="hidden" name="sdt" value="<%=hk.getSoDT()%>"/>
                <input type="hidden" name="dchi" value="<%=hk.getDChi()%>" />
                <input type="hidden" name="hanhly" value="<%=hk.getHanhLy()%>" />
                <input type="hidden" name="email" value="<%=hk.getEmail()%>" />
                <input class="SigninIF" type="submit" value="Đăng ký vé máy bay" />
            </form>    
            <%} else {
                    out.println("Không có thông tin về hành khách và chuyến bay ");
                }%>
                
            <form  class="returnHomepageIFtb" action="index.jsp">
                <input class="returnHomepageIF" type="submit" value="Quay về Trang Chủ" />
            </form>
                <div class="clr"></div>
        <div class="clr"></div>
                 <div class="fbg">
                <div class="fbg_resize">
                    <div class="col c1">
                        <h2>Theme</h2>
                        <a href="#"><img src="images/gal1.jpg" width="100" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal2.jpg" width="100" height="75" alt="" class="gal" /></a>
                        <a href="#"><img src="images/gal3.jpg" width="100" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal4.jpg" width="100" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal5.jpg" width="100" height="75" alt="" class="gal" /></a> 
                        <a href="#"><img src="images/gal6.jpg" width="100" height="75" alt="" class="gal" /></a> </div>
                    <div class="col c2">
                        <h2>Overview</h2>
                        <p>Thông tin bản quyền</p>
                        <ul class="fbg_ul">
                            <li><a >CheapAirline Pty Ltd., số GPĐKKD: 33069720243.</a></li>
                            <li><a >CheapAirline Regional Services Pte Ltd, số GPĐKKD: 201229688K. Số Giấy phép kinh doanh đại lý du lịch của Singapore: 02495</a></li>
                            <li><a >CheapAirline Japan Co., Ltd., số Giấy phép kinh doanh đại lý du lịch của Công ty CheapAirline Holidays K.K.: 1829</a></li>
                        </ul>
                    </div>
                    <div class="col c3">
                        <h2><span>Contact</span> us</h2>
                        
                        <p class="contact_info"> <span>Address:</span>1051 Lũy Bán Bích, P.Tân Thành, Q.Tân Phú, Tp.HCM<br />
                            <span>Telephone:</span> +18006590<br />
                            <span>FAX:</span> +458 4578<br />
                            <span>Others:</span> +301  0125  01258<br />
                            <span>E-mail:</span> <a href="mail.google.com">CheapAirline@hotmail.com</a> </p>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="footer">
                <div class="footer_resize">
                    <p class="lf">Copyright by CheapAirline Corp 2016. All Rights Reserved</p>
                    <p class="rf">Design by <a target="_blank" href="index.jsp">CheapAirline</a></p>
                    <div style="clear:both;"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>