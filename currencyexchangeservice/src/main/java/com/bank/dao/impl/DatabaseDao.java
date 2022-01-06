package com.bank.dao.impl;

import com.bank.data.MysqlConnection;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseDao {
    private final String[] databaseSQL = {
            "create database if not exists service;",

            "use service;",

            "create table if not exists currency\n" +
                    "(\n" +
                    "id bigint primary key auto_increment not null,\n" +
                    "`code` varchar(10) unique not null,\n" +
                    "rate double not null,\n" +
                    "timeCreation datetime default current_timestamp,\n" +
                    "updated boolean not null default false" +
                    ");",

            "create table if not exists `transactions`\n" +
                    "(\n" +
                    "id bigint primary key auto_increment not null,\n" +
                    "timeCreation datetime default current_timestamp,\n" +
                    "boughtCurrency varchar(20),\n" +
                    "soldCurrency varchar(20),\n" +
                    "amount bigint not null,\n" +
                    "deleted boolean not null default false,\n" +
                    "userId bigint not null\n" +
                    ");",

            "create table if not exists roles\n" +
                    "(\n" +
                    "id bigint primary key auto_increment not null,\n" +
                    "`name` varchar(50) not null\n" +
                    ");",

            "insert into roles(`name`) values('admin'),('user');",

            "create table if not exists `users`\n" +
                    "(\n" +
                    "id bigint primary key auto_increment not null,\n" +
                    "login varchar(100) not null,\n" +
                    "pass varchar(100) not null,\n" +
                    "roleId bigint default 2\n" +
                    ");\n",

            "alter table users\n" +
                    "add constraint U_roleId_fk foreign key (roleId) references roles(id) on delete cascade on update cascade;\n",

            "alter table transactions\n" +
                    "add constraint T_userId_fk foreign key (userID) references users(id) on delete cascade on update cascade;\n",

            "insert into users(login, pass , roleid) value('admin', 'qwerty', '1');"
    };

    @SneakyThrows
    public void createDatabase() {
        Connection connection = MysqlConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        for (String s : databaseSQL) {
            statement.execute(s);
        }
    }
}
