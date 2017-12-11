package server;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SelfStarting implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("顺利启动！");

	}

}
