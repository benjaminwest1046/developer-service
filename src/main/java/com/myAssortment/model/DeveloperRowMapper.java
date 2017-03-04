package com.myAssortment.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperRowMapper {
    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getLong("ID"));
        developer.setName(rs.getString("NAME"));
        developer.setSlackName(rs.getString("SLACK_NAME"));
        return developer;
    }
}
