package com.example.ingles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ingles.dto.VervosDTO;
import com.example.ingles.model.Vervos;
import com.example.ingles.repository.VervosRepository;

@Service
public class VervosService {
	
	private VervosRepository empleadoRepository = null;
	
	public VervosService(VervosRepository empleado) {
			this.empleadoRepository=empleado;
	}
	
	
	
	public List<VervosDTO> getAllEmpleados(){
		List<Vervos> empleados= empleadoRepository.findAll();	
		return empleados.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public List<VervosDTO> getAgregarVervos(List<VervosDTO> dto) {
		
				for(VervosDTO lista:dto) {
					System.out.println("vervo en españo "+ lista.getVerboEnEspanol());
				}
		
				empleadoRepository.insert(dto.stream().map(this::convertVervos).collect(Collectors.toList()));
				
					//System.out.println("Vernvo en españo "+ datos.getVervoEnEspanol());
				
				
			return dto;
			//empleadoRepository.insert(convertToDTO(dto));
				
	}
	
	
	private VervosDTO convertToDTO(Vervos vervos) {
        VervosDTO dto = new VervosDTO();
        dto.setVerboEnEspanol(vervos.getVerboEnEspanol());
        dto.setParticipio(vervos.getParticipio());
        dto.setPasadoSimple(vervos.getPasadoSimple());
        dto.setInfinitivo(vervos.getInfinitivo());
        return dto;
    }
	private Vervos convertVervos(VervosDTO vervos) {
        Vervos dto = new Vervos();
        dto.setVerboEnEspanol(vervos.getVerboEnEspanol());
        dto.setParticipio(vervos.getParticipio());
        dto.setPasadoSimple(vervos.getPasadoSimple());
        dto.setInfinitivo(vervos.getInfinitivo());
        return dto;
    }
	
	

}
