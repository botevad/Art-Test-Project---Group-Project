package com.test1.art_test1.api.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmailDao {
    private final NamedParameterJdbcOperations namedTemplate;

    @Autowired
    public EmailDao(NamedParameterJdbcOperations namedTemplate) {
        this.namedTemplate = namedTemplate;
    }

    public String getEmailStatus(String email_id) {
        final String sql = "SELECT status FROM email WHERE email_id = :email_id";

        final SqlParameterSource sp = new MapSqlParameterSource("email_id", email_id);

        return namedTemplate.queryForObject(sql, sp, String.class);
    }

    public List<String> getEmailStatuses(String email_id) {
        final String sql = "SELECT status FROM email WHERE email_id = :email_id";

        final SqlParameterSource sp = new MapSqlParameterSource("email_id", email_id);

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
