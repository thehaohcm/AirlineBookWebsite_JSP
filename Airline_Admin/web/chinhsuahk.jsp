<%-- 
    Document   : chinhsuahk
    Created on : Apr 4, 2016, 9:11:16 PM
    Author     : thehaohcm
--%>

<%@page import="dao.TaiKhoanDAOImpl"%>
<%@page import="model.HanhKhach"%>
<%@page import="dao.HanhKhachDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function kiemtra(){
                var elements = document.getElementById("frm").elements;
                var ele=document.getElementById('hanhly');
                for (var i = 0, element; element = elements[i];i++) {
                    if (element.type == "text"){
                        if(element.value.trim()==''){
                            element.style.border="solid 3px red";
                            alert("Bạn chưa nhập vào đầy đủ thông tin \n Vẫn còn thông tin bỏ trống hoặc chứa quá ít ký tự (ít hơn 5 ký tự)");
                            element.focus();
                            return;
                        }
                        else{

                            if(element==ele){
                                break;
                            }
                            if(element.value.trim().length < 5){
                                element.style.border="solid 3px red";
                                alert("Bạn chưa nhập vào đầy đủ thông tin \n Vẫn còn thông tin bỏ trống hoặc chứa quá ít ký tự (ít hơn 5 ký tự)");
                                element.focus();
                                return;
                            }
                            else{
                                element.style.border="solid 1px black";
                            }
                        }
                    }
                }
                
                var cmnd = document.getElementById('cmnd').value;
                var sdt = document.getElementById('sdt').value;
                var email = document.getElementById('email').value;
                var hanhly = document.getElementById('hanhly').value;
                
                var rcmnd9= /^\d{9}$/;
                var rcmnd12=/^\d{12}$/;
                
                var rsdt11= /^\d{11}$/;
                var rsdt10= /^\d{10}$/;
                var rsdt9= /^\d{9}$/;
                var rsdt8= /^\d{8}$/;
                var rsdt7= /^\d{7}$/;
                 
                if(rcmnd9.test(cmnd)==false && rcmnd12.test(cmnd)==false){
                    document.getElementById('cmnd').style.border = "solid 3px red";
                    alert("Mời bạn xem lại phần thông tin Số Chứng Minh Nhân Dân \nSố Chứng Minh Nhân Dân là dãy số gồm 9 hay 12 chữ số");
                    document.getElementById('cmnd').focus();
                    return;
                } 
                else{
                    document.getElementById('cmnd').style.border="solid 1px black";
                }
                 
                if(rsdt7.test(sdt)==false && rsdt8.test(sdt)==false && rsdt9.test(sdt)==false && rsdt10.test(sdt)==false && rsdt11.test(sdt)==false){
                    document.getElementById('sdt').style.border="solid 3px red";
                    alert("Mời bạn xem lại phần thông tin Số Điện Thoại \nSố Điện Thoại là dãy số từ 7 đến 11 chữ số");
                    document.getElementById('sdt').focus();
                    return;
                }
                else{
                    document.getElementById('sdt').style.border="solid 1px black";
                }
                
                if(isNaN(hanhly)==true){
                    document.getElementById('hanhly').style.border="solid 3px red";
                    alert("Mời bạn xem lại phần thông tin Hành Lý \nGiá trị Hành Lý là một chữ số thập phân");
                    document.getElementById('hanhly').focus();
                    return;
                }
                else{
                    document.getElementById('hanhly').style.border="solid 1px black";
                }

                var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                if(re.test(email) == false){
                    document.getElementById('email').style.border="solid 3px red";
                    alert("Mời bạn xem lại phần thông tin Địa Chỉ Email \nĐịa Chỉ email có dạng [username]@[domain]");
                    document.getElementById('email').focus();
                    return;
                }
                else{
                    document.getElementById('email').style.border="solid 1px black";
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
            String mahk_str="";
            int mahk=0;
            if(request.getParameter("mahk")!=null){
                mahk_str=request.getParameter("mahk");
                mahk=Integer.parseInt(mahk_str);
            }
            if(mahk==0){%>
            <h1>Không thể truy cập thông tin và xóa hành khách</h1>
            
            <br>
            <form action="MainForm.jsp">
                <input type="submit" value="Quay về trang Quản Trị" />
            </form>
            <%}else{
            HanhKhachDAOImpl HK=new HanhKhachDAOImpl();
            HanhKhach hk=new HanhKhach();
            hk=HK.getHanhKhachbymahk(mahk);
            %>
            <h1 class="xemthongtinhkH1">Chỉnh sửa thông tin về hành khách <%=mahk%></h1>
            <form id="frm" method="POST" action="CSHanhKhach_Servlet">
                <table class="xemthongtinhktb" border="3">
                    <tr>
                        <th>Mã Hành Khách</th>
                        <td><input type="hidden" name="mahk" value="<%=hk.getMaHK()%>" /><%=hk.getMaHK()%></td> 
                    </tr>
                    <tr>
                        <th>Họ Tên Hành Khách</th>
                        <td><input type="text" id="tenhk" name="tenhk" value="<%=hk.getHoTen()%>"/></td>
                    </tr>
                    <tr>
                        <th>Số CMND</th>
                        <td><input type="text" id="cmnd" name="cmnd" value="<%=hk.getCMND()%>" /></td>
                    </tr>
                    <tr>
                        <th>Số Điện Thoại</th>
                        <td><input type="text" id="sdt" name="sdt" value="<%=hk.getSoDT()%>" /></td>
                    </tr>
                    <tr>
                        <th>Địa Chỉ</th>
                        <td><input type="text" id="dchi" name="dchi" value="<%=hk.getDChi()%>" /></td>
                    </tr>
                    <tr>
                        <th>Hành Lý</th>
                        <td><input type="text" id="hanhly" name="hanhly" value="<%=hk.getHanhLy()%>" /></td> 
                    </tr>
                    <tr>
                        <th>Địa chỉ Email</th>
                        <td><input type="text" id="email" name="email" value="<%=hk.getEmail()%>" /></td>
                    </tr>
                </table>
                <input class="xemthongtinhkb1" type="button" onclick="kiemtra()" value="Chỉnh sửa thông tin Hành Khách" />
            </form>
            
            <br>
            <form action="xoahk.jsp">
                <input type="hidden" name="mahk" value="<%=mahk%>" />
                <input class="xemthongtinhkb2" type="submit" value="Xóa Hành Khách"/>
            </form>
            <form action="MainForm.jsp">
                <input type="hidden" name="mahk" value="<%=mahk%>" />
                <input class="xemthongtinhkb3"  type="submit" value="Quay lại trang Quản Trị" />
            </form>
            <%}%>
            <jsp:include page="./Footer.jsp"></jsp:include>
    </body>
</html>
