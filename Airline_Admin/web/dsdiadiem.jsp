<%-- 
    Document   : dsdiadiem
    Created on : Mar 19, 2016, 11:25:11 PM
    Author     : thehaohcm
--%>

<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách địa điểm | Cheap Airline</title>
        <script>
            function checkRadioDD(){
                var frm1=document.getElementById("frm1");
                var flg=false;
                for(var i=0;i<frm1.length-1;i++){
                    if(frm1[i].checked)
                        flg=true;
                }
                if(flg==false)
                {
                    alert("Bạn chưa chọn Địa Điểm cần chỉnh sửa / xóa");
                    return;
                }
                frm1.submit();
            }
        </script>    
    </head>
    <body>
        <%request.setCharacterEncoding("UTF-8");
        DiaDiemDAOImpl DD=new DiaDiemDAOImpl();%>
        <h1 class="dsdiadiemH1">Danh sách địa điểm</h1>
        <br>
        <table class="dsdiadiemTB" border="5" align-text="center">
            <tr>
                <th>Lựa chọn</th>
                <th>Địa Điểm</th>
                <th>Tên Sân Bay</th>
            </tr>
            <form id="frm1" action="chinhsuadd.jsp" accept-charset="UTF-8">
            <%
                
               for(DiaDiem dd:DD.getListDiaDiem()){
                   %>
                   <tr>
                       <td><input type="radio" id="madd" name="madd" value="<%=dd.getMaDD()%>" /></td>
                       <td><%=dd.getTenDD()%></td>
                       <td><%=dd.getTenSB()%></td>
                   </tr>
            <%}%>
            
        </table>
            <br>
            <input class="dsdiadiemB1" type="button" onclick="checkRadioDD()" value="Chỉnh sửa / Xóa thông tin" />
            </form>
            <form action="themdd.jsp">
                <input class="dsdiadiemB2" type="submit" value="Thêm địa điểm" />
            </form>
    </body>
</html>
