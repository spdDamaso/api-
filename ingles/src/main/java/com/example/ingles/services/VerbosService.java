
package com.example.ingles.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ingles.dto.VerbosDTO;
import com.example.ingles.model.Verbos;
import com.example.ingles.repository.VerbosRepository;

@Service
public class VerbosService {
    
    private final VerbosRepository verbosRepository;

    @Autowired
    public VerbosService(VerbosRepository verbosRepository) {
        this.verbosRepository = verbosRepository;
    }

    public List<VerbosDTO> getAllVerbos() {
        List<Verbos> verbos = verbosRepository.findAll();    
        return verbos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<VerbosDTO> agregarVerbos(List<VerbosDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        }

        for (VerbosDTO dto : dtos) {
            System.out.println("Verbo en español: " + dto.getVerboEnEspanol());
        }

        verbosRepository.insert(dtos.stream().map(this::convertToVerbos).collect(Collectors.toList()));
        
        return dtos;
    }

    private VerbosDTO convertToDTO(Verbos verbo) {
        VerbosDTO dto = new VerbosDTO();
        dto.setVerboEnEspanol(verbo.getVerboEnEspanol());
        dto.setParticipio(verbo.getParticipio());
        dto.setPasadoSimple(verbo.getPasadoSimple());
        dto.setInfinitivo(verbo.getInfinitivo());
        return dto;
    }

    private Verbos convertToVerbos(VerbosDTO dto) {
        Verbos verbo = new Verbos();
        verbo.setVerboEnEspanol(dto.getVerboEnEspanol());
        verbo.setParticipio(dto.getParticipio());
        verbo.setPasadoSimple(dto.getPasadoSimple());
        verbo.setInfinitivo(dto.getInfinitivo());
        return verbo;
    }
}
