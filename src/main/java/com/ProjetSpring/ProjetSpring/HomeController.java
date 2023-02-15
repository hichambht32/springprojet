package com.ProjetSpring.ProjetSpring;

import com.ProjetSpring.ProjetSpring.Repository.DemandeRepository;
import com.ProjetSpring.ProjetSpring.Service.CarService;
import com.ProjetSpring.ProjetSpring.model.Car;
import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;
import com.ProjetSpring.ProjetSpring.model.User;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import org.springframework.http.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private DemandeRepository demandeRepo;
	@Autowired
	private CarService carService;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CarRepository carRepo;


	@GetMapping("")
	public String home(){
		return "home";
	}
	@GetMapping("/admin")
	public String admin(){
		return "This is admin page";
	}
	@GetMapping("/login")
	public String login(){
		return "/login";
	}
	@GetMapping("/users")
	public String users(Model model, Principal principal){
		CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		model.addAttribute("user", userDetails);
		return "users";
	}

	@GetMapping("/logout")
	public String logout(){
		return "/logout";
	}

	@GetMapping("/AjoutCar")
	public String AjoutCar(Model model, Principal principal){
		CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		model.addAttribute("user", userDetails);
		model.addAttribute("car", new Car());
		return "/AjoutCar";
	}

	@GetMapping("/InfosUser/{idUser}")
	public String InfosUser(Model model,Principal principal, @PathVariable Long idUser){
		CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		model.addAttribute("user", userDetails);
		List<Car> listCar = carRepo.findByUserIdUser(idUser);
		model.addAttribute("listCar", listCar);
		return "/InfosUser";
	}
	@PostMapping("/AjoutCarProcess")
	public String processRegister(Car car, Model model,@RequestParam("idUser") Long userId)  {
		User existingUser = userRepo.findById(userId).get();
		car.setUser(existingUser);
		carRepo.save(car);
		return "redirect:/users"; 
	}
	@GetMapping("/DepotDemande")
	public String DepotDemande(Model model, Principal principal){
		CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		model.addAttribute("user", userDetails);
		model.addAttribute("demandeRemboursement", new DemandeRemboursement());
		return "/DepotDemande";
	}
	@PostMapping("/DepotDemandeProcess")
	public String processRegister(DemandeRemboursement demandeRemboursement, Model model,@RequestParam("idUser") Long userId)  {
		User existingUser = userRepo.findById(userId).get();
		demandeRemboursement.setUser(existingUser);
		demandeRepo.save(demandeRemboursement);
		return "redirect:/users"; 
	}
}