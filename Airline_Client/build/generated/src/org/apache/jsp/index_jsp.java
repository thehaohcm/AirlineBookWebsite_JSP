package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import model.DiaDiem;
import dao.DiaDiemDAOImpl;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html >\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>HomePage</title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/coin-slider.css\" />\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/cufon-yui.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/cufon-titillium-250.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/script.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/coin-slider.min.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("         function kiemtra(){\r\n");
      out.write("             var diadiemdi = document.getElementById(\"diadiemdi\");\r\n");
      out.write("             var diadiemden = document.getElementById(\"diadiemden\");\r\n");
      out.write("             var ngaydi = document.getElementById(\"ngaykhoihanh\");\r\n");
      out.write("             if(diadiemdi.value==diadiemden.value){\r\n");
      out.write("                 alert(\"Địa điểm Đi và Đến không được phép trùng nhau.\\n Xin bạn vui lòng chọn lại địa chỉ\");\r\n");
      out.write("                 return;\r\n");
      out.write("                 \r\n");
      out.write("             }\r\n");
      out.write("             if(ngaydi.value.trim()==\"\"){\r\n");
      out.write("                 alert(\"Xin bạn vui lòng chọn Ngày khởi hành\");\r\n");
      out.write("                 return;\r\n");
      out.write("             }\r\n");
      out.write("             frm.submit();\r\n");
      out.write("         }   \r\n");
      out.write("         </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            DiaDiemDAOImpl DD = new DiaDiemDAOImpl();
            String error="";
            if(request.getAttribute("error")!=null)
            error=(String)request.getAttribute("error");
            if(request.getAttribute("error")!=null)
            error=(String)request.getAttribute("error");
        
      out.write("\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("                <div class=\"header_resize\">\r\n");
      out.write("                    <div class=\"menu_nav\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li class=\"active\"><a href=\"index.jsp\"><span>Home Page</span></a></li>\r\n");
      out.write("                            <li><a href=\"News.jsp\"><span>Thông tin</span></a></li>\r\n");
      out.write("                            <li><a href=\"about.jsp\"><span>About Us</span></a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"logo\">\r\n");
      out.write("                        <h1><a href=\"index.jsp\">Cheap<span>Airline</span> <small>We are your best choice</small></a></h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clr\"></div>\r\n");
      out.write("                    <div class=\"slider\">\r\n");
      out.write("                        <div id=\"coin-slider\"> \r\n");
      out.write("                            <a href=\"#\"><img src=\"images/AirSlider1.jpg\" width=\"960\" height=\"360\" alt=\"\" /></a> \r\n");
      out.write("                            <a href=\"#\"><img src=\"images/AirSlider2.jpg\" width=\"960\" height=\"360\" alt=\"\" /></a> \r\n");
      out.write("                            <a href=\"#\"><img src=\"images/AirSlider3.jpg\" width=\"960\" height=\"360\" alt=\"\" /></a> </div>\r\n");
      out.write("                        <div class=\"clr\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clr\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"SearchForm\">\r\n");
      out.write("                <h2>Flight Search</h2>\r\n");
      out.write("                <form class=\"InsideSearchForm\" id=\"frm\" action=\"AvailableForm.jsp\">\r\n");
      out.write("                    <div class=\"wrapper\">\r\n");
      out.write("                        Điểm xuất phát\r\n");
      out.write("\r\n");
      out.write("                        <select id=\"diadiemdi\" name=\"diadiemdi\" >\r\n");
      out.write("                            ");
for (DiaDiem dd : DD.getListDiaDiem()) {
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print(dd.getMaDD());
      out.write('"');
      out.write(' ');
      out.print((dd.getTenDD().equals("Tp. Hồ Chí Minh")) ? "selected" : "");
      out.write(" > ");
      out.print(dd.getTenDD());
      out.write(" </option>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"wrapper\">\r\n");
      out.write("                        Điểm đến:\r\n");
      out.write("                        <select id=\"diadiemden\" name=\"diadiemden\">\r\n");
      out.write("                            ");
for (DiaDiem dd : DD.getListDiaDiem()) {
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print(dd.getMaDD());
      out.write('"');
      out.write('>');
      out.print(dd.getTenDD());
      out.write("</option>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("   \r\n");
      out.write("                            \r\n");
      out.write("                    <div class=\"wrapper\">\r\n");
      out.write("                        Ngày khởi hành:\r\n");
      out.write("                       \r\n");
      out.write("                        <input id=\"ngaykhoihanh\" name=\"ngaykhoihanh\" type=\"date\" min=\"05-04-2016\"  />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input class=\"SearchButton\" type=\"button\" onclick=\"kiemtra()\" value=\"Tìm kiếm\" />\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div align=\"right\"><b><font size=\"10\" color=\"red\">");
      out.print(error);
      out.write("</font></b></div>\r\n");
      out.write("                   \r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <div class=\"content_resize\">\r\n");
      out.write("                    <div class=\"mainbar\">\r\n");
      out.write("                        <div class=\"article\">\r\n");
      out.write("                            <h2><span>Hot </span>News</h2>\r\n");
      out.write("                            <div class=\"clr\"></div>\r\n");
      out.write("                            <div class=\"img\"><img src=\"images/img1.jpg\" width=\"200\" height=\"210\" alt=\"\" class=\"fl\" /></div>\r\n");
      out.write("                            <div class=\"post_content\">\r\n");
      out.write("                                VietJet Air thông báo khai thác đường bay mới Tp. Hồ Chí Minh - Kuala Lumpur và ngược lại từ ngày 01/06/2016 \r\n");
      out.write("                                <p class=\"spec\"><a href=\"News1.jsp\" class=\"rm\">Read more</a></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clr\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"article\">\r\n");
      out.write("                           \r\n");
      out.write("                            <div class=\"clr\"></div>\r\n");
      out.write("                            <div class=\"img\"><img src=\"images/img2.jpg\" width=\"200\" height=\"210\" alt=\"\" class=\"fl\" /></div>\r\n");
      out.write("                            <div class=\"post_content\">\r\n");
      out.write("                                Đáp ứng nhu cầu di chuyển tăng cao của người dân trên hành trình Sài Gòn – Thanh Hóa, hãng hàng không Vietnam Airlines đã quyết định tăng tần suất phục vụ cho hành trình này.  Ngay sau khi thông báo tăng tải hãng hàng không quốc gia đẽ triển khai ngay ưu đãi cực hấp dẫn cho đường bay Sài Gòn – Thanh Hóa...........\r\n");
      out.write("                            \r\n");
      out.write("                                <p class=\"spec\"><a href=\"News2.jsp\" class=\"rm\">Read more</a></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clr\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"sidebar\">\r\n");
      out.write("                        <div class=\"gadget\">\r\n");
      out.write("                            <h2 class=\"star\"><span>Các hãng hàng không</span></h2>\r\n");
      out.write("                            <div class=\"clr\"></div>\r\n");
      out.write("                            <ul class=\"sb_menu\">\r\n");
      out.write("                                <li><a href=\"https://www.vietnamairlines.com/vi/\">Vietnam airlines</a></li>\r\n");
      out.write("                                <li><a href=\"www.airmekong.com.vn/Sites/Web/en-Us/Home\">Air Mekong</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.vietjetair.com/Sites/Web/vi-VN/Home\">Vietjet air</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.jetstar.com/vn/vi/home\">Jetstar Pacific</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.thaiairways.com/\">Thai Airways</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.singaporeair.com/en_UK/vn/home\">Singapore Airlines</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.tigerair.com/sg/en/\">Tiger airways</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.qatarairways.com/vn/en/homepage\">Qatar Airways</a></li>\r\n");
      out.write("                                <li><a href=\"https://www.koreanair.com/global/en.html\">Korean Air</a></li>\r\n");
      out.write("                                <li><a href=\"http://www.hongkongairlines.com/en_HK/homepage\">Hongkong Airlines</a></li>\r\n");
      out.write("                                \r\n");
      out.write("                                \r\n");
      out.write("                                \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                 \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clr\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"fbg\">\r\n");
      out.write("                <div class=\"fbg_resize\">\r\n");
      out.write("                    <div class=\"col c1\">\r\n");
      out.write("                        <h2>Theme</h2>\r\n");
      out.write("                        <a href=\"#\"><img src=\"images/gal1.jpg\" width=\"100\" height=\"75\" alt=\"\" class=\"gal\" /></a> \r\n");
      out.write("                        <a href=\"#\"><img src=\"images/gal2.jpg\" width=\"100\" height=\"75\" alt=\"\" class=\"gal\" /></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"images/gal3.jpg\" width=\"100\" height=\"75\" alt=\"\" class=\"gal\" /></a> \r\n");
      out.write("                        <a href=\"#\"><img src=\"images/gal4.jpg\" width=\"100\" height=\"75\" alt=\"\" class=\"gal\" /></a> \r\n");
      out.write("                        <a href=\"#\"><img src=\"images/gal5.jpg\" width=\"100\" height=\"75\" alt=\"\" class=\"gal\" /></a> \r\n");
      out.write("                        <a href=\"#\"><img src=\"images/gal6.jpg\" width=\"100\" height=\"75\" alt=\"\" class=\"gal\" /></a> </div>\r\n");
      out.write("                    <div class=\"col c2\">\r\n");
      out.write("                        <h2>Overview</h2>\r\n");
      out.write("                        <p>Thông tin bản quyền</p>\r\n");
      out.write("                        <ul class=\"fbg_ul\">\r\n");
      out.write("                            <li><a >CheapAirline Pty Ltd., số GPĐKKD: 33069720243.</a></li>\r\n");
      out.write("                            <li><a >CheapAirline Regional Services Pte Ltd, số GPĐKKD: 201229688K. Số Giấy phép kinh doanh đại lý du lịch của Singapore: 02495</a></li>\r\n");
      out.write("                            <li><a >CheapAirline Japan Co., Ltd., số Giấy phép kinh doanh đại lý du lịch của Công ty CheapAirline Holidays K.K.: 1829</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col c3\">\r\n");
      out.write("                        <h2><span>Contact</span> us</h2>\r\n");
      out.write("                        \r\n");
      out.write("                        <p class=\"contact_info\"> <span>Address:</span>1051 Lũy Bán Bích, P.Tân Thành, Q.Tân Phú, Tp.HCM<br />\r\n");
      out.write("                            <span>Telephone:</span> +18006590<br />\r\n");
      out.write("                            <span>FAX:</span> +458 4578<br />\r\n");
      out.write("                            <span>Others:</span> +301  0125  01258<br />\r\n");
      out.write("                            <span>E-mail:</span> <a href=\"mail.google.com\">CheapAirline@hotmail.com</a> </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clr\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer\">\r\n");
      out.write("                <div class=\"footer_resize\">\r\n");
      out.write("                    <p class=\"lf\">Copyright by CheapAirline Corp 2016. All Rights Reserved</p>\r\n");
      out.write("                    <p class=\"rf\">Design by <a target=\"_blank\" href=\"index.jsp\">CheapAirline</a></p>\r\n");
      out.write("                    <div style=\"clear:both;\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
