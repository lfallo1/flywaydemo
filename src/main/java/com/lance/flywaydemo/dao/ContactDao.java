package com.lance.flywaydemo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lance.flywaydemo.annotations.TableName;
import com.lance.flywaydemo.mappers.GenericObjectMapper;
import com.lance.flywaydemo.models.Contact;

public class ContactDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Contact> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM " + Contact.class.getAnnotation(TableName.class).value(), new GenericObjectMapper<Contact>(Contact.class));
    }
    
    public Contact getById(Integer id) {
        return this.jdbcTemplate.query("SELECT * FROM " + Contact.class.getAnnotation(TableName.class).value()
        		+ " WHERE id = " + id, new GenericObjectMapper<Contact>(Contact.class)).get(0);
    }    
}
