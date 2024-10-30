package com.example.ingles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ingles.dto.VerbosDTO;
import com.example.ingles.services.VerbosService;


@RestController
@RequestMapping("/api/vervos")
public class VerbosController {
	
	@Autowired
	private VerbosService empleadoService;
	
	@GetMapping("all")	
	public List<VerbosDTO> getAllEmpleados(){
		
		return empleadoService.getAllVerbos();
	}
	
	
	@PostMapping("agregar")
	public List<VerbosDTO> getAgregar(@RequestBody List<VerbosDTO> vervos) {
				
				return empleadoService.agregarVerbos(vervos);
	}
	

}
