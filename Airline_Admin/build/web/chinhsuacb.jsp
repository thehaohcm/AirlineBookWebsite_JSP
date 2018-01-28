<%-- 
    Document   : thongtincb
    Created on : Mar 25, 2016, 11:43:08 AM
    Author     : thehaohcm
--%>

<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page import="dao.DiaDiemDAO"%>
<%@page import="model.DiaDiem"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="model.DiaDiem"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page import="model.ChuyenBay"%>
<%@page import="dao.ChuyenBayDAOImpl"%>
<%@page import="dao.ChuyenBayDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/media.css"/>
        <title>Thông tin chuyến bay | CheapAirline</title>
        <style>
            input[type="text"] {
    width: 150px;
}
        </style>
        
        <script>
            function kiemtra(){
                var macb=document.getElementById("macb").value;
                var hang=document.getElementById("hang").value;
            var ngaydi=document.getElementById("ngaydi").value;
            var ngayden=document.getElementById("ngayden").value;
            var giodi=document.getElementById("giodi").value;
            var gioden=document.getElementById("gioden").value;
            var diadiemdi=document.getElementById("diadiemdi").value;
            var diadiemden=document.getElementById("diadiemden").value;
            var giave=document.getElementById("giave").value;
            var slhktd=document.getElementById("slhktd").value;
            
            var reg = /(0[1-9]|[12][0-9]|3[01])[- -.](0[1-9]|1[012])[- -.](19|20)\d\d/;
            var regngay=/^([0-1]?[0-9]|2[0-4]):([0-5][0-9])?$/;
            if(macb.trim()==""){
                document.getElementById('macb').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập vào Mã Chuyến Bay");
                document.getElementById("macb").focus();
                return;
            }
            if(hang.trim()==""){
                document.getElementById('hang').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập vào Hãng Hàng Không");
                document.getElementById("hang").focus();
                return;
            }
            if (ngaydi.trim()=="" || reg.test(ngaydi)==false) {
                document.getElementById('ngaydi').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập vào đúng dạng DD-MM-YYYY trong phần Ngày Đi");
                document.getElementById("ngaydi").focus();
                return;
            }
            if(ngayden.trim()=="" || reg.test(ngayden)==false){
                document.getElementById('ngayden').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập vào đúng dạng DD-MM-YYYY trong phần Ngày Đến");
                document.getElementById("ngayden").focus();
                return;
            }
            if(giodi.trim()=="" || regngay.test(giodi)==false){
                document.getElementById('giodi').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập vào đúng dạng HH:MM trong phần Giờ Đi");
                document.getElementById("giodi").focus();
                return;
            }
            if(gioden.trim()=="" || regngay.test(gioden)==false){
                document.getElementById('gioden').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập vào đúng dạng HH:MM trong phần Giờ Đến");
                document.getElementById("gioden").focus();
                return;
            }
            if(diadiemdi==diadiemden){
                document.getElementById('diadiemdi').style.border = "solid 3px red";
                document.getElementById('diadiemden').style.border = "solid 3px red";
                alert("Địa Điểm Đi và Địa Điểm Đến không được phép trùng nhau. Bạn vui lòng chọn lại");
                return;
            }
            if(giave.trim()=="" || giave%1!=0 || giave<1){
                document.getElementById('giave').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập lại thông tin về Giá Vé");
                return;
            }
            if(slhktd.trim=="" || slhktd%1!=0 || slhktd<1){
                document.getElementById('slhktd').style.border = "solid 3px red";
                alert("Bạn vui lòng nhập lại thông tin về Số Lượng Hành Khách Tối Đa");
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
            String macb_cu = request.getParameter("macb");
            ChuyenBayDAO CB = new ChuyenBayDAOImpl();
            ChuyenBay cb = new ChuyenBay();
            cb = CB.getEleChuyenBay(macb_cu);
            DiaDiemDAOImpl DD = new DiaDiemDAOImpl();

            String loi = "";
            if (request.getAttribute("loi") != null) {
                loi = (String) request.getAttribute("loi");
            }
            
            String tb="";
            if(request.getAttribute("tb")!=null){
                tb=(String)request.getAttribute("tb");
            }
        %>

        <h1>Thông tin chuyến bay <%=macb_cu%> (Hãng hàng không: <%=cb.getHang()%>)</h1>
        <br>

        <table class="chinhsuacb" border="1">
            <tr>
                <th>Mã chuyến bay</th>
                <th>Hãng Hàng Không</th>
                <th>Ngày Đi</th>
                <th>Giờ Đi</th>
                <th>Ngày Đến</th>
                <th>Giờ Đến</th>
                <th>Địa Điểm Đi</th>
                <th>Địa Điểm Đến</th>
                <th>Giá Vé</th>
                <th>Số Hành Khách Tối Đa</th>
            </tr>
            <form id="frm" method="POST" action="CSChuyenBay_Servlet">
                <tr>
                <input type="hidden" name="macbcu" value="<%=cb.getMaCB()%>" />
                <td><input type="text" id="macb" name="macb" value="<%=cb.getMaCB()%>" /></td>
                <td><input type="text" id="hang" name="hang" value="<%=cb.getHang()%>" /></td>
                <td><input type="text" id="ngaydi" name="ngaydi" value="<%=cb.getNgayDi()%>" /></td>
                <td><input type="text"id="giodi" name="giodi" value="<%=cb.getGioDi()%>" /></td>
                <td><input type="text" id="ngayden" name="ngayden" value="<%=cb.getNgayDen()%>" /></td>
                <td><input type="text" id="gioden" name="gioden" value="<%=cb.getGioDen()%>" /></td>
                <td>
                    <select id="diadiemdi" name="diadiemdi">
                        <%for (DiaDiem dd : DD.getListDiaDiem()) {%>
                        <option value="<%=dd.getMaDD()%>" <%=(dd.getMaDD()==cb.getDiaDiem_Di())?"selected":""%>><%=dd.getTenDD()%></option>
                        <%}%> 
                    </select>
                </td>
                <td>
                    <select id="diadiemden" name="diadiemden">
                        <%for (DiaDiem dd : DD.getListDiaDiem()) {%>
                        <option value="<%=dd.getMaDD()%>" <%=(dd.getMaDD()==cb.getDiaDiem_Den())?"selected":""%>><%=dd.getTenDD()%></option>
                        <%}%> 
                    </select>
                </td>
                <td><input type="number" id="giave" name="giave" value="<%=cb.getGiaVe()%>" /></td>
                <td><input type="number"  id="slhktd" name="slhktd" value="<%=cb.getSLHKTD()%>" /></td>
                </tr>
                 </table>
                <input class="chinhsuacbB1" type="button" onclick="kiemtra()" value="Sửa thông tin chuyến bay"/>
                
            </form>
         
        <p style="color:red"><%=loi%></p>    
        <form method="POST" action="XoaChuyenBay_Servlet">
            <input type="hidden" name="macb" value="<%=macb_cu%>"/>
            <input class="chinhsuacbB3" type="submit" value="Xóa Chuyến Bay"/>
           
        </form>
             
            <p style="color:red"><%=tb%></p>
        <form action="MainForm.jsp">
                <input class="chinhsuacbreturnHP" type="submit" value="Quay lại trang quản trị"/>
            </form>
        <br>
        <br>
        
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
