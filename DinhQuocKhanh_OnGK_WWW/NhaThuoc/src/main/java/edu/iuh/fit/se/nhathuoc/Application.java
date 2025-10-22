package edu.iuh.fit.se.nhathuoc;

import edu.iuh.fit.se.nhathuoc.utils.JPAUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   5:24 PM
 */
@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JPAUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.destroy();
    }
}
