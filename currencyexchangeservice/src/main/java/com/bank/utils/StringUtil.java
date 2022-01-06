package com.bank.utils;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringUtil {
    @SneakyThrows
    public static String readAll(InputStream inputStream) {
        String text = null;
        try (BufferedReader rdr = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = rdr.readLine()) != null) {
                builder.append(line);
            }
            text = builder.toString();
        }
        return text;
    }
}
