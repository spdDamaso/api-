package com.example.ingles.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ingles.model.Vervos;


@Repository
public class VervosRepository {


    private final JdbcTemplate jdbcTemplate;

    public VervosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vervos> findAll() {
        String sql = "SELECT * FROM vervos";
        
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Vervos vervos = new Vervos();
            vervos.setVerboEnEspanol(rs.getString("verboEs"));
            vervos.setInfinitivo(rs.getString("infinitivo"));
            vervos.setPasadoSimple(rs.getString("pasadoSimple"));
            vervos.setParticipio(rs.getString("participio"));

            //empleado.setSalario(rs.getDouble("salario"));
            return vervos;
        });
    }
	
    
    public int[][] insert(List<Vervos> vervos) {
        String sql = "INSERT INTO vervos (verboEs, infinitivo, pasadoSimple, participio) VALUES (?, ?, ?, ?)";

    	return jdbcTemplate.batchUpdate(sql,vervos,vervos.size(),(ps,argumet)->{
    		
    				ps.setString(1, argumet.getVerboEnEspanol());
    				ps.setString(2, argumet.getInfinitivo());
    				ps.setString(3, argumet.getPasadoSimple());
    				ps.setString(4, argumet.getParticipio());
    		});
    }
    
}
