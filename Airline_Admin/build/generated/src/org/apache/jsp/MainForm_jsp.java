package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.TaiKhoan;
import dao.ChuyenBayDAOImpl;

public final class MainForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <title>Airline Booking</title>\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("         <link rel=\"stylesheet\" href=\"css/media.css\"/>\n");
      out.write("         <link rel=\"stylesheet\" href=\"css/submit_javascript.css\"/>\n");
      out.write("      \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./header.jsp", out, false);
      out.write("\n");
      out.write("        ");
String username="";
            String password="";
        if(password.length()==0 || username.length()==0){
                Cookie[] cookies =request.getCookies();
                if(cookies==null){
//                    System.out.print("cho nay null");
                    request.setAttribute("timeout", "Đã quá thời gian cho một phiên làm việc. Bạn vui lòng đăng nhập lại");
                    RequestDispatcher rd=request.getRequestDispatcher("/LogForm.jsp");
                    rd.forward(request, response);
                    return;
                }
                else{
                    for(Cookie cookie:cookies){
                        if(cookie.getName().equals("username"))
                            username=cookie.getValue();
                        if(cookie.getName().equals("password"))
                            password=cookie.getValue();
                    }
                }
            }
        if(username.length()==0 || password.length()==0)
        {
            request.setAttribute("tentaikhoan_error", "Vui lòng nhập vào tên tài khoàn");
            request.setAttribute("matkhau_error", "Vui lòng nhập vào mật khẩu");
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/LogPage.jsp");
            rd.forward(request, response);
        }
        
      out.write("\n");
      out.write("    <center><h1 class=\"MainformH1\">Xin chào Quản trị viên ");
      out.print(username);
      out.write("</h1></center>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./dschuyenbay.jsp", out, false);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./dsdiadiem.jsp", out, false);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./dshanhkhach.jsp", out, false);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./Footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
