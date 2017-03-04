package com.myAssortment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DeveloperDao {
    public DeveloperDao() {}

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DeveloperDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Developer> findAll(){

        String sql = "SELECT * FROM developers";

        List<Developer> developers = new ArrayList<Developer>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Developer developer = new Developer();
            developer.setId((Long)(row.get("ID")));
            developer.setName((String)row.get("NAME"));
            developer.setSlackName((String)row.get("SLACK_NAME"));
            developers.add(developer);
        }

        return developers;
    }

    public Developer create(Developer developer) {
        String sql = "INSERT INTO developers (name, slack_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, developer.getName(), developer.getSlackName());
        return developer;
    }

    public Developer update(Developer developer) {
        String sql = "UPDATE developers SET name=?, slack_name=? WHERE id=?";
        jdbcTemplate.update(sql, developer.getName(), developer.getSlackName(), developer.getId());
        return developer;
    }

    public Developer findById(long id) {
        String sql = "SELECT * FROM developers WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Developer>() {
            @Override
            public Developer extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    Developer developer = new Developer();
                    developer.setId(rs.getLong("id"));
                    developer.setName(rs.getString("name"));
                    developer.setSlackName(rs.getString("slack_name"));
                    return developer;
                } else {
                    return null;
                }
            }
        });
    }

    public void delete(long id) {
        String sql = "DELETE FROM developers WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
