package com.test1.art_test1.api.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

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
@Repository
public class SmsDao {
    private final NamedParameterJdbcOperations namedTemplate;

    @Autowired
    public SmsDao(NamedParameterJdbcOperations namedTemplate) {
        this.namedTemplate = namedTemplate;
    }

    public String getSmsStatus(String smsId) {
        final String sql = "SELECT status FROM sms WHERE smsId = :smsId";

        final SqlParameterSource sp = new MapSqlParameterSource("smsId", smsId);

        return namedTemplate.queryForObject(sql, sp, String.class);
    }

    public List<String> getSmsStatuses(String smsId) {
        final String sql = "SELECT status, colm2 FROM sms WHERE smsId = :smsId";

        final SqlParameterSource sp = new MapSqlParameterSource("smsId", smsId);

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
