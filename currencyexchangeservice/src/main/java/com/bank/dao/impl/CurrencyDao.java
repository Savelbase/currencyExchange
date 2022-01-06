package com.bank.dao.impl;

import com.bank.dao.Dao;
import com.bank.data.MysqlConnection;
import com.bank.dto.Currency;
import com.bank.dto.CurrencyDto;
import com.bank.entity.CurrencyEntity;
import com.bank.mapper.CurrencyMapper;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrencyDao implements Dao<CurrencyEntity, Long> {

    private final CurrencyMapper mapper;

    public CurrencyDao() {
        System.out.println("CurrencyDAO : constructor()");
        mapper = new CurrencyMapper();
    }

    @SneakyThrows
    public void getCurrencyRate() {
        ArrayList<CurrencyEntity> entityList = new ArrayList<>(3);
        System.out.println("CURRENCY DAO : getCurrencyRate()");
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.connect();
            try (BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) urlConnection.getContent()))) {
                String line;
                CurrencyDto dto;
                while ((line = br.readLine()) != null) {
                    if (line.contains("USD") || line.contains("RUB") || line.contains("EUR")) {
                        dto = mapper.toDto("{" + line + "}");
                        entityList.add(new CurrencyEntity(null, Currency.valueOf(dto.getCc()), dto.getRate(), new Date(), false));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (CurrencyEntity c : entityList) {
            save(c);
        }
    }

    @SneakyThrows
    public List<CurrencyEntity> getCurrencyList() {
        ArrayList<CurrencyEntity> list = new ArrayList<>(3);
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from currency");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(new CurrencyEntity(
                    resultSet.getLong(1),
                    Currency.valueOf(resultSet.getString(2)),
                    resultSet.getBigDecimal(3),
                    resultSet.getDate(4),
                    resultSet.getBoolean(5)
            ));
        }
        return list;
    }

    @SneakyThrows
    @Override
    public CurrencyEntity save(CurrencyEntity currencyEntity) {
        System.out.println(MysqlConnection.getInstance().getConnection());
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into currency(`code`, rate, timeCreation) value(?,?,?);");
        preparedStatement.setString(1, currencyEntity.getCode().name());
        preparedStatement.setBigDecimal(2, currencyEntity.getRate());
        preparedStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(currencyEntity.getTimeCreation()));
        preparedStatement.executeQuery();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select last_insert_id() from currency");
        if (resultSet.next()) {
            Long id = resultSet.getLong(1);
            System.out.println(id + " - is ID");
            return findById(id);
        }
        return null;
    }

    @SneakyThrows
    @Override
    public CurrencyEntity findById(Long id) {
        System.out.println("CurrencyDAO - findByID()");
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from currency where id = ?");
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet);
        if (resultSet.next()) {
            return new CurrencyEntity(
                    resultSet.getLong(1),
                    Currency.valueOf(resultSet.getString(2)),
                    resultSet.getBigDecimal(3),
                    resultSet.getDate(4),
                    resultSet.getBoolean(5)
            );
        }
        return null;
    }


    @SneakyThrows
    public Date getLastInsertedDate() {
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select max(timeCreation) from currency;");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getDate(1);
        }
        return null;
    }
}
