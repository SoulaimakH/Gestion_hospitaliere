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
import com.example.demo.models.EtatLit;
import com.example.demo.models.Lit;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;
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
	
	
	
//preparer les attribut  pour accéder au formulaire ajoutlit
@GetMapping("/Ajoutlit")
public String ajoutch(Lit lit , Model m) {
	
	m.addAttribute("listch",  daoChambre.findAll());
	
    return "ajoutlit";
}




//sauvgarder un lit dans la base de donnée
@PostMapping("sauvgarderlit")
public String savech( @Valid Lit lit, Model model) {
	

	Chambre ch =daoChambre.getOne(lit.getNumch());
	lit.setCham(ch);//affecter un lit a une chambre 
	daoLit.save(lit);
	
	return "redirect:/Ajoutlit";
}


//preparer les attribut  pour accéder au formulaire ajoutPation
@GetMapping("/Ajoutpatient")
public String ajoutpatient(Patient patient, Model m ) {

	m.addAttribute("listlit",  daoLit.findAll());
	
    return "ajoutPatient";
}



//sauvgarder un lit dans la base de donnée
@PostMapping("/sauvgarderPatient")
public String savepatien( @Valid Patient patient, Model model) {
	
	 daoPatient.save(patient);
	 
	 return "redirect:/Ajoutpatient";
}


//preparer les attribut  pour accéder au formulaire ajoutMedecin
@GetMapping("/AjoutMedecin")
public String ajoutmedecin(Medecin medecin) {
	
     return "ajoutMedecin";
}


//sauvgarder un medecin dans la base de donnée
@PostMapping("/sauvgarderMedecin")
public String savemedecin( @Valid Medecin medecin) {
	
	daomedecin.save(medecin);
	
	return "redirect:/AjoutMedecin";
}




//prepare les attributs pour l'affichage des lits
@GetMapping("/Affichelit")
public String Affichelit(Model m) {

	m.addAttribute("listlit",  daoLit.findAll());
	m.addAttribute("Lit", new Lit());//pour form liberation
    m.addAttribute("e", EtatLit.etat_occupe);
    
    return "affichelit";
}

//liberer un lit occupé
@PostMapping("/libere")
public String librelit(@Valid Lit lit, Model m) {
	
    Lit l=daoLit.getOne(lit.getId());//lit qui va etre liberé
	Patient pat = daoPatient.getOne(l.getPid());//patient en relation avec lit 
	
	pat.setLit(null);                //
	pat.setNumlit(0);               //==>update le patient qui se libere de lit
	//pat.setSejour(0);            //
	
	daoPatient.save(pat);
	
	l.setPatient(null);
	l.setPid(null);                    //==>update lit liberé
	l.setEtat(EtatLit.etat_libre);
	
	daoLit.save(l);
	//System.out.println(lit);
	//System.out.println(pat.getIdp());
	
    return "redirect:/Affichelit";
}



//prepare les attributs pour l'affichage des patients
@GetMapping("/AffichePatient")
public String Affichepatient(Patient pa , Model m) {

	m.addAttribute("listpatient",  daoPatient.findAll());
	EtatLit e = EtatLit.etat_libre ;
	m.addAttribute("listlitNonoccuper", daoLit.findAllByEtat(e));
	m.addAttribute("pa",pa);
	

    return "affichepatient";
}


//affecter un lit a un patient
@PostMapping("/affectlitpatient")
public String affectlit(@Valid Patient pa) {
	
	Patient pat = daoPatient.getOne(pa.getIdp());
	
	pat.setLit(daoLit.getOne(pa.getNumlit()));    //
	pat.setNumlit(pa.getNumlit());               //==>update patient
	
	daoPatient.save(pat);
	
	Lit lit = daoLit.getOne(pa.getNumlit());
	
	lit.setPatient(pat);               //
	lit.setEtat(EtatLit.etat_occupe); //==>udate lit
	lit.setPid(pat.getIdp());        //
	
	daoLit.save(lit);
	
	
	 return "redirect:/Affichelit";
}




//prepare les attributs pour l'affichage des medecins
@GetMapping("/Affichemedecin")
public String AfficheMedecin(Model m) {

	m.addAttribute("listmedecin",  daomedecin.findAll());
	m.addAttribute("medecins", new Medecin());

return "affichemedecin";
} 

}

