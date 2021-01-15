package com.example.demo.mycontroller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Chambre;
import com.example.demo.models.Lit;
import com.example.demo.repository.ChambreRepository;
import com.example.demo.repository.LitRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;

@Controller
public class Mycontroller {
	@Autowired
	LitRepository daoLit;
	@Autowired
	ChambreRepository daoChambre;
	@Autowired
	PatientRepository daoPatient;
	@Autowired
	MedecinRepository daomedecin;
@GetMapping("/Ajoutlit")
public String ajoutch(Lit lit , Model m) {
	m.addAttribute("listch",  daoChambre.findAll());
	m.addAttribute("Cham", new Chambre());


return "ajoutlit";
}

@PostMapping("sauvgarderlit")
public String savech( @Valid Lit lit, Model model) {
	
//Lit lit = (Lit) m.getAttribute("newLit");
//System.out.println("chid ="+(Chambre)model.getAttribute("Cham"));
	Optional<Chambre> ch =daoChambre.findById(lit.getNumch());
	lit.setCham(ch.orElse(null));
	daoLit.save(lit);
	
	
	 return "redirect:/Ajoutlit";
}


/*
@GetMapping("/Ajoutpatien")
public String ajoutpatien(Patient patient ) {



return "ajoutpatient";
}

@PostMapping("sauvgarderPatien")
public String savepatien( @Valid Patient patient, Model model) {
	

	
	
	
	 return "redirect:/Ajoutpatien";
}*/

}

