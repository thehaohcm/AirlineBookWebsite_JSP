<%-- 
    Document   : chinhsuadd
    Created on : Mar 26, 2016, 2:35:20 PM
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
        <title>JSP Page</title>
        <script>
            function kiemtra(){
                var tendd=document.getElementById("tendd");
                var tensb=document.getElementById("tensb");
                if(tendd.value.trim()==""){
                    document.getElementById('tendd').style.border = "solid 3px red";
                    alert("Xin vui lòng nhập vào thông tin Tên Địa Điểm");
                    document.getElementById("tendd").focus();
                    return;
                }
                if(tensb.value.trim()==""){
                    document.getElementById('tensb').style.border = "solid 3px red";
                    alert("Xin vui lòng nhập vào thông tin Tên Sân Bay");
                    document.getElementById("tensb").focus();
                    return;
                }
                frm.submit();
            }
        </script>  
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <%  request.setCharacterEncoding("UTF-8");
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
            String madd_string=request.getParameter("madd");
            
            int madd=Integer.parseInt(madd_string);
            DiaDiemDAOImpl DD=new DiaDiemDAOImpl();
            DiaDiem dd=new DiaDiem();
            dd=DD.getElebyMaDD(madd);
            
            String tb="";
            if(request.getAttribute("tb")!=null)
                tb=(String)request.getAttribute("tb");
            
            String loi="";
            if(request.getAttribute("loi")!=null)
                loi=(String)request.getAttribute("loi");
        %>
        <h1 class="chinhsuaddH1">Chỉnh sửa thông tin địa điểm</h1>
        <table class="chinhsuaddTB" border="3">
            <tr>
                <th>Địa Điểm</th>
                <th>Sân Bay</th>
            </tr>
            <form id="frm" method="POST" action="CSDiaDiem_Servlet" accept-charset="UTF-8">
                <input type="hidden" name="madd" value="<%=dd.getMaDD()%>" />
            <tr>
                <td><input type="text" id="tendd" name="tendd" value="<%=dd.getTenDD()%>"/></td>
                <td><input type="text" id="tensb" name="tensb" value="<%=dd.getTenSB()%>"/></td>
            </tr>
        </table>    
                <input class="chinhsuaddb2" type="button" onclick="kiemtra()" value="Sửa thông tin Địa Điểm" />
            </form>
            <form method="POST" action="XoaDiaDiem_Servlet">
                <input type="hidden" name="madd" value="<%=madd_string%>" />
                <input class="chinhsuaddb1" type="submit" value="Xóa Địa Điểm" />
            </form>
            
                <p style="color:red;"><b><%=loi%></b></p>
                <p style="color:blue;"><b><%=tb%></b></p>
                <br>
                <br>
                <br>
                <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
