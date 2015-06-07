package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title></title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("  <button onclick=\"fetch()\" >Fetch Data</button>\n");
      out.write("  <script src=\"//code.jquery.com/jquery-1.11.3.min.js\"></script>\n");
      out.write("  <script src = 'http://code.jquery.com/jquery-migrate-1.2.1.min.js'></script>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("    function fetch(){\n");
      out.write("      $.get('http://localhost:8080/gradle-demo/service/fetch').then(function(data){\n");
      out.write("//        var array = JSON.parse(data);\n");
      out.write("          if(Object.prototype.toString.call(data) === '[object Array]'){\n");
      out.write("              data.forEach(function(item){\n");
      out.write("                  document.write(item.title + \"<br>\");\n");
      out.write("                  document.write(item.content + \"<br><br><br>\");\n");
      out.write("              })\n");
      out.write("          }else{\n");
      out.write("              for(var item in data){\n");
      out.write("                  document.write(data[item] + \"<br>\");\n");
      out.write("              }\n");
      out.write("          }\n");
      out.write("      })\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("  </body>\n");
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
