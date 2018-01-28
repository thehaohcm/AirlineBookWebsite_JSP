
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Information Form</title>
        <script>
            function isNumberKey(evt){
                var charCode=(evt.which) ? evt.which :  event.keyCode;
                if(charCode > 31 && (charCode != 46 &&(charCode < 48 || charCode < 57)))
                    return false;
                return true;
            }
            
            function checkElement(){
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
        <%
            String macb="";
            macb=request.getParameter("macb");
                
            
            String tb="";
            if(request.getAttribute("tb")!=null)
                tb=(String)request.getAttribute("tb");
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
                <div class="clr"></div>
                <div class="content">
                    <div class="InformationForm">
                        <div class="IFbg">
                            <h2>Thông tin khách hàng</h2>
                            <form id="frm" method="POST" action="ThongTin_HK_CB_Servlet">
                                <input type="hidden" name="macb" value="<%=macb%>" />
                                <div ><label>Họ tên :</label>
                                    <input name="hoten" type="text">
                                </div>
<!--                                <div ><label>Giới tính :</label>
                                    <form action="" >
                                        <input type="radio" name="gender" value="male">Nam
                                        <input type="radio" name="gender" value="female">Nữ
                                        <input type="radio" name="gender" value="other">Khác
                                    </form>
                                </div>-->

                                <div ><label>CMND:</label>
                                    <input name="cmnd" type="text" id="cmnd" />
                                    <!--<input name="cmnd" type="number" min="000000000" onkeypress="return isNumberKey(event)"/>-->
                                </div>
                                <div ><label>Số điện thoại:</label>
                                    <input name="sdt" type="text" id="sdt" />
                                    <!--<input name="sdt" type="number" min="00000000000" onkeypress="return isNumberKey(event)"/>-->
                                </div>
                                <div > <label>Địa chỉ:</label>
                                    <input name="dchi" type="text" id="dchi" />
                                    <!--<input name="dchi" type="text" />-->
                                </div>
                                <div ><label>Hành lý:</label>
                                    <input name="hanhly" type="text" id="hanhly" />
                                    <!--<input name="hanhly" type="number" min="0.0" max="50.0" onkeypress="return isNumberKey(event)"/>-->
                                </div >
                                <div ><label>Email:</label>
                                    <input name="email" type="text" id="email" />
                                    <!--<input name="email" type="text" />-->
                                </div>
                                <a href="index.jsp"><input class="BackButton" type="button" value="Về trang chủ" /></a>
                               <input  type="button" onclick="checkElement()" value="Hoàn tất" />
                            </form>
                                <p style="color:red;"><%=tb%></p>
                        </div>
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
