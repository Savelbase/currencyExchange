package com.bank.api.listener;

import com.bank.dao.impl.CurrencyDao;
import com.bank.dao.impl.DatabaseDao;
import com.bank.data.MysqlConnection;
import lombok.SneakyThrows;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLOutput;

public class InitListener implements ServletContextListener {
    DatabaseDao dao ;
    CurrencyDao currencyDao ;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dao = new DatabaseDao();
        System.out.println(" InitListener : contextInitialized()");
        try {
            dao.createDatabase();
            System.out.println("CREATE DB");
        }catch (Throwable ex){
            System.out.println(ex.getMessage() + " ERRORR !");
        }
        MysqlConnection.getInstance().getPooledDataSource().setJdbcUrl("jdbc:mariadb://localhost/service");
        currencyDao = new CurrencyDao();
        System.out.println("ConcurencyDAO _ создана");
        currencyDao.getCurrencyRate();
        System.out.println("getCurrencyRate - отработал");
        sce.getServletContext().setAttribute("currencyList", currencyDao.getCurrencyList());
    }

    @SneakyThrows
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection connection = MysqlConnection.getInstance().getConnection();
        connection.prepareStatement("drop database CurrencyExchangeService").executeQuery();
        System.out.println("DROP DB");
    }
}
