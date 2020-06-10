package com.test1.art_test1.api.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Property of CODIX SA
 * Date: 5/27/2020 Time: 3:43 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@Service
public class SmsService {
    private final SmsDao smsDao;
    private final NamedParameterJdbcOperations namedTemplate;


    @Autowired
    public SmsService(SmsDao smsDao, NamedParameterJdbcOperations namedTemplate) {
        this.smsDao = smsDao;
        this.namedTemplate = namedTemplate;
    }

    List<String> getAllUserSms(String username) {
        final String sql = "SELECT sms_id,text,reciever FROM SMS WHERE username IN (SELECT username FROM users WHERE id = :id)";
        final SqlParameterSource sp = new MapSqlParameterSource("username", username);

        return namedTemplate.query(sql, sp, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                rs.getString("status");
                ///rs.getString("colm2");
                return rs.getString("status");
            }
        });
    }


}
