
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ChuyenBay"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>AvailableForm</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script>
    function kiemtra(){
        var frm1=document.getElementById("frm1");
        var flg=false;
        for(var i=0;i<frm1.length-1;i++){
        if(frm1[i].checked)
            flg=true;
        }
        if(flg==false)
        {
            alert("Bạn chưa chọn Chuyến Bay cần đi");
            return;
        }
        frm1.submit();
    }
</script>    
</head>
 
<body>
   
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
    <div class="clr"></div>
    <div class="clr"></div>
            <%
        
        
       String diadiemdi="",diadiemden="",ngaykhoihanh="";
        
        if(request.getParameter("diadiemdi")!=null)
            diadiemdi=request.getParameter("diadiemdi");
        if(request.getParameter("diadiemden")!=null)
            diadiemden=request.getParameter("diadiemden");

        if(request.getParameter("ngaykhoihanh")!=null)
            ngaykhoihanh=request.getParameter("ngaykhoihanh");

	if(diadiemdi.equals(diadiemden)){
            request.setAttribute("error", "Đã có lỗi xảy ra, bạn vui lòng chọn lại");
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } 
        
        String ngaydi="";
        try{
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date result = formater.parse(ngaykhoihanh);
        SimpleDateFormat AppDateFormat=new SimpleDateFormat("dd-MM-yyyy");
         ngaydi = AppDateFormat.format(result);
        }catch(Exception ex){
            request.setAttribute("error", "Đã có lỗi xảy ra, bạn vui lòng chọn lại");
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
        ChuyenBayDAOImpl CB=new ChuyenBayDAOImpl();
        ArrayList<ChuyenBay> Cb_Arr=new ArrayList();
        if(CB.getListChuyenBay(diadiemdi, diadiemden, ngaydi).size()==0){
            out.println("<br>");
            out.println("<font size='5'><b>Không tìm thấy Thông tin Chuyến Bay bạn cần tìm. Đây là danh sách tất cả mọi Chuyến Bay<b></font>");
            out.println("<br>");
            out.println("<br>");
            Cb_Arr=CB.getListChuyenBay();
        }
        else
            Cb_Arr=CB.getListChuyenBay(diadiemdi, diadiemden, ngaydi);
            
        DiaDiemDAOImpl DD=new DiaDiemDAOImpl();
        %>
 <table class="FormAvailable">
 <tr class="AFormHeader">
     <th>Lựa chọn</th>
    <th>Hãng</th>
    <th>Điểm khởi hành</th>
    <th>Điểm đến</th>
    <th>Giá Vé</th>
    <th>Số chỗ trống</th>
    <th>Hành Khách Tối Đa</th>
  </tr>
<!-- 	<tr>
    	<td><img src="./images/VietNamAirline.jpg " height="40px" ></td>
        <td>Hà Nội</td>
        <td>TP.HCM</td>
        <td>2h50m</td>
        <td>560.000 VNĐ <br></br>
            <input type="radio" >Đặt Ngay</td>
        
        </tr>-->
<form id="frm1" action="InformationForm.jsp">

        <%for(ChuyenBay cb:Cb_Arr){%>
        
        <tr>
            <td>
                 <%if(cb.getSLHKHT()<cb.getSLHKTD()){%>
                 <input class="ChoosePlane" name="macb" id="macb" value="<%=cb.getMaCB()%>" type="radio" >Đặt Ngay</input>
                <%}else{%>
                    <label style="color:red;">Hết chỗ</label>
                <%}%>
            </td>
            <td>
                <%if(cb.getHang().equals("VietNam Airline")){%>
                    <img src="./images/VietNamAirline.jpg " height="40px" >
               <%}
                else if(cb.getHang().equals("VietJet Air")){%>
                    <img src="./images/VietJet.jpg " height="40px" >
                <%}
                else if(cb.getHang().equals("JetStar Airways")){%>
                    <img src="./images/JetStar.jpg " height="40px" >
                <%}
                else{
                    out.println(cb.getHang());
                }%>
                
            </td>

            <td>
                <br>
                <%=DD.getTenDD(cb.getDiaDiem_Di())%><br>
                <%=cb.getGioDi()%> Ngày <%=cb.getNgayDi()%>
                <br><br>
            </td>
            <td>
                <br>
                <%=DD.getTenDD(cb.getDiaDiem_Den())%><br>
                <%=cb.getGioDen()%> Ngày <%=cb.getNgayDen()%>
                <br><br>
            </td>
            
            <td>
                <%=cb.getGiaVe()%>
            </td>
            
            <td>
                <label style="color:green;"><b><%=cb.getSLHKTD()-cb.getSLHKHT()%></b></label>
            </td>
            <td>
                <label style="color:red;"<b><%=cb.getSLHKTD()%></b></label>
                
            </td>
        </tr>
        <%}%>
 </table>
 <input class="AvailableFromBUTTON" type="button" onclick="kiemtra()" value="Tiếp tục" />
        </form>
 </div>
 <div class="clr"></div>
 
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
