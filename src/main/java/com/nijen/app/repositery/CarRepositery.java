package com.nijen.app.repositery;

import com.nijen.app.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositery {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void save(Car car) {

        String sqlQuery = "INSERT INTO car (name, model, model_year) VALUES (?,?,?);";
        jdbcTemplate.update(sqlQuery, car.getCarName(), car.getCarModel(), car.getCarModelYear());
        System.out.println("Query executed successfully");

    }

    public List<Car> findAll(){

        String sqlQuery = "SELECT * FROM car;";

        List<Car> cars = new ArrayList<>();

        RowMapper<Car> mapper = (ResultSet rs, int rowNum) -> {

                Car car = new Car();

                car.setCarName(rs.getString("name"));
                car.setCarModel(rs.getString("model"));
                car.setCarModelYear(rs.getInt("model_year"));

                return car;
        };

        return jdbcTemplate.query(sqlQuery, mapper);

    }
}
