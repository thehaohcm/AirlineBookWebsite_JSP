<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/qlvemaybay?autoReconnect=true&useSSL=false", "root", "root");
    //PreparedStatement testconnect = con.prepareStatement(string);
%>

<html>
    <style> .haha{ background-color: black; text-shadow: 
              2px 2px 2px violet; color: pink; border-bottom:  double #0000cc 
              ; font-size: 30px }
        .table{} .table td{background-color: white; text-shadow:-1px -1px -1px 1px 1px 1px red; color: black ; text-align: center; padding: 2px}
     </style>
    
<%
    String sql1 = "select * from qlvemaybay.TaiKhoan;";
    String sql2 = "select * from qlvemaybay.HanhKhach;";
    PreparedStatement pr=con.prepareStatement(sql2);
    ResultSet rs=pr.executeQuery();
    int k=0,n=0;
    String s,x,t,d;
  //  ArrayList<String> s = new ArrayList();
    //ArrayList<String> x = new ArrayList();
        
    out.print("<table class='table' border='1px solid blue'><tr><td>ho ten</td><td>toan</td><td>ly</td><td>hoa</td></tr>");
    
    while (rs.next())
           {
               s=rs.getString("MaHK");
               x=rs.getString("HoTen");
               t=rs.getString("ChuyenBay");
               d=rs.getString("ChoNgoi");
               out.print("<tr><td width='40%'>"+s+"</td><td witdh='20%'>"+x+"</td><td width='20%'>"+t+"</td><td width='20%'>"+d+"</td></tr>");
             // s.add(rs.getString(1));
              //x.add(rs.getString(4));
              //k++;
           }
    out.print("</table>");
    
    
    
   /* out.print("<table border='1px solid blue'>");
    for(int i=0; i<s.size() ;i++)
    {
        out.print("<tr>");
        for(int j=0;j<1 ;j++)
        {
            out.print("<td>" + s.get(i)+"</td>");
            out.print("<td>" + x.get(i) + "</td>");
        }
        out.print("</tr>");
    }
    out.print("</table>");
*/
 %>
 
 <%
    pr=con.prepareStatement(sql1);
    rs=pr.executeQuery();
    if(rs.next())
    {
        String a=rs.getString("username");
               
        out.print("<b>"+a+"</b>");
    }
    con.close();
    %>
 

</HTML>