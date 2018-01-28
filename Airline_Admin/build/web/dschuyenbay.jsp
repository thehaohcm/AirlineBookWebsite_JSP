<%-- 
    Document   : dschuyenbay
    Created on : Mar 19, 2016, 11:00:51 PM
    Author     : thehaohcm
--%>

<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/media.css"/>
        <title>Danh sách chuyến bay | Cheap Airline</title>
        <style>
            table{
                margin-left: 20px;
                text-align: center;
            }
        </style>
        <script>
            function checkRadioCB(){
                var frm=document.getElementById("frm");
                var flg=false;
                for(var i=0;i<frm.length-1;i++){
                    if(frm[i].checked){
                        flg=true;
                    }
                }
                if(flg==false)
                {
                    alert("Bạn chưa chọn chuyến bay cần thay đổi thông tin / xóa");
                    return;
                }
                frm.submit();
            }
        </script>    
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String tb="";
            if(request.getAttribute("loi")!=null){
                tb=(String)request.getAttribute("loi");
            }
            
            ChuyenBayDAOImpl cb=new ChuyenBayDAOImpl();
            DiaDiemDAOImpl dd=new DiaDiemDAOImpl();
        %>
            
        <h1 class="dschuyenbayH1">Danh sách chuyến bay</h1>
        <br>
    <table class="dschuyenbayTB" border="5">
            <tr>
                <th>Lựa chọn</th>
                <th>Hãng</th>
                <th>Ngày đi</th>
                <th>Giờ đi</th>
                <th>Ngày đến</th>
                <th>Giờ đến</th>
                <th>Địa điểm hiện tại</th>
                <th>Địa điểm đến</th>
                <th>Giá vé</th>
                <th>Sân bay Đi</th>
                <th>Sân bay Đến</th>
            </tr>
            <form id="frm" action="chinhsuacb.jsp">
            <%
                for(ChuyenBay c:cb.getListChuyenBay()){%>
                   
                    <tr align="left">
                            <td align="center"><input type="radio" name="macb" id="macb" value="<%=c.getMaCB()%>" /></td>

                            <td><%=c.getHang()%></td>
                            <td><%=c.getNgayDi()%></td>
                            <td><%=c.getGioDi()%></td>
                            <td><%=c.getNgayDen()%></td>
                            <td><%=c.getGioDen()%></td>
                            <td><%=dd.getTenDD(c.getDiaDiem_Di())%></td>
                            <td><%=dd.getTenDD(c.getDiaDiem_Den())%></td>
                            <td><%=c.getGiaVe()%></td>
                            <td><%=dd.getTenSB(c.getDiaDiem_Di())%></td>
                            <td><%=dd.getTenSB(c.getDiaDiem_Den())%></td>
                    </tr>
                <%}%>
        </table>
        <br><br>
        <div style="text-align:right;margin-right: 100px">  
            
                <input class="dschuyenbaybuttons1" type="button" onclick="checkRadioCB()" value="Sửa/Xóa Chuyến Bay" /> 
        </form>
        
        <form action="themcb.jsp">
            <input class="dschuyenbaybuttons2" type="submit" value="Thêm Chuyến Bay" />
        </form>
        <br>
        <br>
        <br>
        <br>
        </div> 
        
        
        <p style="color:blue;"><b><%=tb%></b></p>
    </body>
</html>
