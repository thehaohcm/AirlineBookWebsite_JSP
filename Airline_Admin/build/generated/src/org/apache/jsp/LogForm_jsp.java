package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LogForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cheap Airline</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\">\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/media.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/LogFormStyle.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String timeout="";
            String tentaikhoan_error="",matkhau_error="",dangnhap_error="";
            if(request.getAttribute("tentaikhoan_error")!=null)
                tentaikhoan_error=(String)request.getAttribute("tentaikhoan_error");
            if(request.getAttribute("matkhau_error")!=null)
                matkhau_error=(String)request.getAttribute("matkhau_error");
            if(request.getAttribute("dangnhap_error")!=null)
                dangnhap_error=(String)request.getAttribute("dangnhap_error");
            if(request.getAttribute("timeout")!=null)
                timeout=(String)request.getAttribute("timeout");


            
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <section id=\"LogForm\"><!--form-->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-4 col-sm-offset-1\">\n");
      out.write("                        <div class=\"login-form\"><!--login form-->\n");
      out.write("                            <h2>Đăng nhập tài khoản quản trị</h2>\n");
      out.write("                            <form method=\"POST\" action=\"Controller\">\n");
      out.write("                                <p style=\"color:red\">");
      out.print(tentaikhoan_error);
      out.write("</p>\n");
      out.write("                                Tên tài khoản: <input type=\"text\" name=\"tentaikhoan\" placeholder=\"username\" />\n");
      out.write("                                <p style=\"color:red\">");
      out.print(matkhau_error);
      out.write("</p>\n");
      out.write("                                Mật khẩu: <input type=\"password\" name=\"matkhau\" placeholder=\"Password\" />\n");
      out.write("                                <p style=\"color:red\">");
      out.print(dangnhap_error);
      out.write("</p>\n");
      out.write("                                <p style=\"color:red\">");
      out.print(timeout);
      out.write("</p>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-default\">Login</button>\n");
      out.write("                                \n");
      out.write("                            </form>\n");
      out.write("                        </div><!--/login form-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section><!--/form-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
