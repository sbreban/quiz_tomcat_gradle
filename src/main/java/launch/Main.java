package launch;

import org.apache.catalina.Context;
import org.apache.catalina.Globals;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {

  public static void main(String[] args) throws Exception {

    String webappDirLocation = "../../src/main/webapp/";
    Tomcat server = new Tomcat();
    server.setPort(8080);
    Context rootCtx = server.addWebapp(server.getHost(), "",
        new File(webappDirLocation).getAbsolutePath());
    rootCtx.getServletContext().setAttribute(Globals.ALT_DD_ATTR, webappDirLocation+"/WEB-INF/web.xml");
    System.out.println("Start server Tomcat embedded");
    server.start();
    server.getServer().await();
  }
}
