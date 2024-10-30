package com.example.ingles.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ingles.model.Verbos;


@Repository
public class VerbosRepository {


    private final JdbcTemplate jdbcTemplate;

    public VerbosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Verbos> findAll() {
        String sql = "SELECT * FROM VERBOS";
        
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Verbos vervos = new Verbos();
            vervos.setVerboEnEspanol(rs.getString("verboEs"));
            vervos.setInfinitivo(rs.getString("infinitivo"));
            vervos.setPasadoSimple(rs.getString("pasadoSimple"));
            vervos.setParticipio(rs.getString("participio"));

            //empleado.setSalario(rs.getDouble("salario"));
            return vervos;
        });
    }
	
    
    public int[][] insert(List<Verbos> vervos) {
        String sql = "INSERT INTO VERBOS (verboEs, infinitivo, pasadoSimple, participio) VALUES (?, ?, ?, ?)";

    	return jdbcTemplate.batchUpdate(sql,vervos,vervos.size(),(ps,argumet)->{
    		
    				ps.setString(1, argumet.getVerboEnEspanol());
    				ps.setString(2, argumet.getInfinitivo());
    				ps.setString(3, argumet.getPasadoSimple());
    				ps.setString(4, argumet.getParticipio());
    		});
    }
    
}
