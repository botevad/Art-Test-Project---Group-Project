package com.test1.art_test1.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Demon {
    @Autowired
    private static NamedParameterJdbcOperations namedTemplate;

    @Autowired
    public Demon(NamedParameterJdbcOperations namedTemplate) {
        this.namedTemplate = namedTemplate;
    }

    public static int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    @Scheduled(fixedRate = 5000)
    public static void checkSmsStatus() {
        String status;
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
        namedTemplate.query("SELECT * FROM sms WHERE  status = 'sending'", countCallback);
        int rowCount = countCallback.getRowCount();
        for (int i = 1; i <= rowCount; i++) {
            int n = getRandomInt(1, 3);
            switch (n) {
                case 1:
                    status = "delivered";
                    break;
                case 2:
                    status = "no service";
                    break;
                case 3:
                    status = "no such number";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
            }
                namedTemplate.update("UPDATE sms SET status=:status WHERE status = 'sending'", new MapSqlParameterSource("status", status));
        }
    }

    @Scheduled(fixedRate = 5000)
    public static void checkEmalStatus() {
        String status;
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
        namedTemplate.query("SELECT * FROM email WHERE status = 'sending'", countCallback);
        int rowCount = countCallback.getRowCount();
        for (int i = 1; i <= rowCount; i++) {
            int n = getRandomInt(1, 2);
            switch (n) {
                case 1:
                    status = "sent";
                    break;
                case 2:
                    status = "bad connection";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
            }
            try {
                namedTemplate.update("UPDATE email SET status=:status WHERE status = 'sending'", new MapSqlParameterSource("status", status));


            } catch (DataAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Scheduled(fixedRate = 5000)
    public static void checkCallStatus() {
        String status;
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
        namedTemplate.query("SELECT * FROM call WHERE status = 'calling' ", countCallback);
        int rowCount = countCallback.getRowCount();
        for (int i = 1; i <= rowCount; i++) {
            int n = getRandomInt(1, 3);
            switch (n) {
                case 1:
                    status = "called";
                    break;
                case 2:
                    status = "in_call";
                    break;
                case 3:
                    status = "error";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
            }
            try {
                namedTemplate.update("UPDATE call SET status=:status WHERE status = 'calling'", new MapSqlParameterSource("status", status));


            } catch (DataAccessException e) {
                e.printStackTrace();
            }
        }
    }

}


