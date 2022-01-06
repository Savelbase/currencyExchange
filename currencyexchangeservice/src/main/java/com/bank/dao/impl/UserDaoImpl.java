package com.bank.dao.impl;

import com.bank.dao.UserDao;
import com.bank.data.MysqlConnection;
import com.bank.dto.UserDto;
import com.bank.entity.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserDaoImpl implements UserDao {

    @Override
    @SneakyThrows
    public User findById(Long id) {
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from users where id=?");
        statement.setLong(1, id);
        ResultSet set = statement.getResultSet();
        if(set.next()) {
            String login = set.getString(2);
            String password = set.getString(3);
            Integer role = set.getInt(4);
            return new User(id, login, password, role);
        }
        return null;
    }

    @SneakyThrows
    @Override
    public User save(User user) {
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into users(login, pass) values (?, ?)");
        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getPassword());
        stmt.execute();
        Statement stetment = connection.createStatement();
        ResultSet resultSet = stetment.executeQuery("select last_insert_id()");
        if(resultSet.next()) {
            long id = resultSet.getLong(1);
            return findById(id);
        }
        return null;
    }



    @SneakyThrows
    @Override
    public User findByLogin(String login) {
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from users where login=?");
        statement.setString(1, login);
        ResultSet set = statement.getResultSet();
        if(set.next()) {
            Long id = set.getLong(1);
            String userLogin = set.getString(2);
            String password = set.getString(3);
            Integer role = set.getInt(4);
            return new User(id, userLogin, password, role);
        }
        return null;
    }


    @SneakyThrows
    public boolean validate(String login, String password) {
        boolean isPresent = false;
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where login=? and pass=?");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        long id = 0;
        if(rs.next()){
            id = rs.getLong(1);
            System.out.println(id + " - ID USER ");
        }
        return id!=0;
    }

    @SneakyThrows
    public User get(User user) {
        System.out.println("UserDaoImpl : get()");
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where login=? and pass=?");
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        ResultSet rs = preparedStatement.executeQuery();
        long id = 0;
        int roleId  =0 ;
        if(rs.next()){
            id = rs.getLong(1);
            roleId = rs.getInt(4);
            System.out.println(id + " - ID USER ");
        }
        if(id!=0){
            return new User(id , user.getLogin() , user.getPassword() , roleId);
        }else return null;
    }


}
