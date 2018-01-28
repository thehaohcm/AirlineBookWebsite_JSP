<%-- 
    Document   : themcb
    Created on : Mar 28, 2016, 10:50:23 PM
    Author     : thehaohcm
--%>

<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page import="model.DiaDiem"%>
<%@page import="dao.DiaDiemDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/media.css"/>
        <title>JSP Page</title>
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
            String loi="";
            if(request.getAttribute("loi")!=null)
                loi=(String)request.getAttribute("loi");
            DiaDiemDAOImpl ddd=new DiaDiemDAOImpl();
            %>
        <h1 class="themcbH1">Thêm chuyến bay</h1>
        <form id="frm" method="POST" action="ThemCB_Servlet">
        <table class="themcbTb">
            <tr>
                <th>Mã Chuyến Bay: </th>
                <th><input type="text" id="macb" name="macb" /></th>
            </tr>
            <tr>
                <th>Hãng Hàng Không: </th>
                <th><input type="text" id="hang" name="hang" /></th>
            </tr>
            <tr>
                <th>Ngày Đi: </th>
                <th><input id="ngaydi" type="text" name="ngaydi" /></th>
            </tr>
            <tr>
                <th>Giờ Đi: </th>
                <th><input id="giodi" type="text" name="giodi" /></th>
            </tr>
            <tr>
                <th>Ngày Đến: </th>
                <th><input type="text" id="ngayden" name="ngayden" /></th>
            </tr>
            <tr>
                <th>Giờ Đến: </th>
                <th><input type="text" id="gioden" name="gioden" /></th>
            </tr>
            <tr>
                <th>Địa Điểm Đi: </th>
                <th>
                    <select id="diadiemdi" name="diadiemdi">
                        <%for(DiaDiem dd:ddd.getListDiaDiem()){%>
                        <option value="<%=dd.getMaDD()%>"><%=dd.getTenDD()%></option>                            
                        <%}%>
                    </select>
                </th>
            </tr>
            <tr>
                <th>Địa Điểm Đến: </th>
                <th>
                    <select id="diadiemden" name="diadiemden">
                        <%for(DiaDiem dd:ddd.getListDiaDiem()){%>
                        <option value="<%=dd.getMaDD()%>"><%=dd.getTenDD()%></option>                            
                        <%}%>
                    </select>
                </th>
            </tr>
            <tr>
                <th>Giá Vé: </th>
                <th><input type="number" id="giave" name="giave" /></th>
            </tr>
            <tr>
                <th>Số Hành Khách Tối Đa: </th>
                <th><input type="number" id="slhktd" name="slhktd" /></th>
            </tr>
        </table>
                    <input class="themcbADD" type="button" onclick="kiemtra()" value="Thêm Chuyến Bay" />
            
        </form>
                        <p style="color:red"><%=loi%></p>
           
                        <form action="MainForm.jsp">
                            <input class="themcbRerturn" type="submit" value="Quay lại trang quản trị" />
                        </form>
                        <br>
                        <br>
                        <br>
                        <br>
        <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
