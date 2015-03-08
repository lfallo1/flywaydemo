package com.lance.flywaydemo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lance.flywaydemo.annotations.TableName;
import com.lance.flywaydemo.mappers.GenericObjectMapper;
import com.lance.flywaydemo.models.Favorite;

public class FavoriteDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Favorite> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM " + Favorite.class.getAnnotation(TableName.class).value(), new GenericObjectMapper<Favorite>(Favorite.class));
    }
    
    public Favorite getById(Integer id) {
        return this.jdbcTemplate.query("SELECT * FROM " + Favorite.class.getAnnotation(TableName.class).value()
        		+ " WHERE id = " + id, new GenericObjectMapper<Favorite>(Favorite.class)).get(0);
    }    
}
