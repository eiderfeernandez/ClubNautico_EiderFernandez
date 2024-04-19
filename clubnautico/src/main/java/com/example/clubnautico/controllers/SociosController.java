package com.example.clubnautico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.clubnautico.model.Socio;
import com.example.clubnautico.model.SocioDTO;
import com.example.clubnautico.services.SociosRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/socios")
public class SociosController {

    @Autowired
    private SociosRepository rep;
    
    @GetMapping({"","/"})
    public String mostrarSocios(Model model) {
        List<Socio> socios= rep.findAll();
        model.addAttribute("socios", socios);
        return "socios/index";
    }
    
    @GetMapping("/crear")
    public String mostrarPáginaCrearSocios(Model model) {
        SocioDTO socioDto=new SocioDTO();
        model.addAttribute("socioDto", socioDto);
        return "socios/CrearSocio";
    }
    
    @PostMapping("/crear")
    public String crearSocio(@Valid @ModelAttribute SocioDTO socioDto, BindingResult result) {
        
        if(result.hasErrors()) {
            return "socios/CrearSocio";
        }
        
        Socio socio=new Socio();
        socio.setDni_socio(socioDto.getDni_socio());
        socio.setNom_socio(socioDto.getNom_socio());
        socio.setTlf_socio(socioDto.getTlf_socio());
        socio.setDir_socio(socioDto.getDir_socio());
        
        rep.save(socio);
        
        return "redirect:/socios";
    }
	
	
    @GetMapping("/editar")
    public String mostrarPáginaEditarSocios(Model model, @RequestParam(name = "id") int id) {
		try {
			Socio socio =rep.findById(id).get();
			model.addAttribute("socio", socio);
			
			SocioDTO socioDto = new SocioDTO();
			socioDto.setDni_socio(socio.getDni_socio());
			socioDto.setNom_socio(socio.getNom_socio());
			socioDto.setTlf_socio(socio.getTlf_socio());
			socioDto.setDir_socio(socio.getDir_socio());
			
			model.addAttribute("socioDto",socioDto);
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return "redirect:/socios";
		}
		return "socios/EditarSocio";
	}
	
    @PostMapping("/editar")
    public String editarSocio(Model model, @RequestParam(name = "id") int id, @Valid @ModelAttribute SocioDTO socioDto, BindingResult result) {
		try {
			
			Socio socio =rep.findById(id).get();
			model.addAttribute("socio", socio);
			
			if(result.hasErrors()) {
				return "socios/EditarSocio";
			}
			
			socio.setDni_socio(socioDto.getDni_socio());
			socio.setNom_socio(socioDto.getNom_socio());
			socio.setTlf_socio(socioDto.getTlf_socio());
			socio.setDir_socio(socioDto.getDir_socio());
			
			rep.save(socio);
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			//return "redirect:/socios";
		}
		
		return "redirect:/socios";
	}
	
    @GetMapping("/borrar")
    public String borrarSocio(@RequestParam(name = "id") int id) {
		try {
			Socio socio =rep.findById(id).get();
			rep.delete(socio);
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return "redirect:/socios";
		}
		
		return "redirect:/socios";
	}
	
	
}
