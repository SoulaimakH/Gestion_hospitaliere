package com.example.demo.mycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Chambre;
import com.example.demo.models.Lit;
import com.example.demo.repository.ChambreRepository;
import com.example.demo.repository.LitRepository;

@Controller
public class Mycontroller {
	@Autowired
	LitRepository daoLit;
@GetMapping("/Ajoutlit")
public String ajoutch(Model m) {
	Lit lit =new Lit();
m.addAttribute("newLit",lit);
return "ajoutlit";
}

@PostMapping("sauvgarderlit")
public String savech(Model m) {
	
Lit lit = (Lit) m.getAttribute("newLit");
	daoLit.save(lit);
	return "redirect Litlist";
}
}

