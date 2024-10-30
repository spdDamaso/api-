package com.example.ingles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ingles.dto.VervosDTO;
import com.example.ingles.services.VervosService;

@RestController
@RequestMapping("/api/vervos")
public class VervosController {
	
	@Autowired
	private VervosService empleadoService;
	
	@GetMapping("all")	
	public List<VervosDTO> getAllEmpleados(){
		
		return empleadoService.getAllEmpleados();
	}
	
	
	@PostMapping("agregar")
	public List<VervosDTO> getAgregar(@RequestBody List<VervosDTO> vervos) {
				
				return empleadoService.getAgregarVervos(vervos);
	}
	

}
