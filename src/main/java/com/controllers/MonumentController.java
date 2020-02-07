package com.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entities.Monument;
import com.entities.Region;
import com.services.IMonumentService;
import com.services.IRegionService;

@Controller
@RequestMapping("/monument")
public class MonumentController {

	@Autowired
	IMonumentService monumentService;

	@Autowired
	IRegionService regionService;

	@GetMapping("/displayMonuments")
	public String displayMonuments(@RequestParam("regionId") int regionId, Model model) {

		Region region = regionService.getRegion(regionId);

		model.addAttribute("region", region);

		Set<Monument> monuments = region.getMonuments();

		model.addAttribute("monuments", monuments);

		return "monuments-list";

	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {

		Monument monument = new Monument();

		model.addAttribute("monument", monument);

		List<Region> regions = regionService.getAllRegions();

		model.addAttribute("regions", regions);

		Region region = new Region();
		
		model.addAttribute("region", region);

		return "add-monument";
	}

	@GetMapping("/deleteMonument")
	public String deleteMonument(@RequestParam("monumentId") int monumentId) {

		monumentService.deleteMonument(monumentId);

		return "redirect:/region/list";
	}

	@PostMapping("/addMonument")
	public String addMonument(@ModelAttribute("region") Region region, @Valid @ModelAttribute("monument") Monument monument, BindingResult results, Model model) {
		
		if(results.hasErrors()) {

			List<Region> regions = regionService.getAllRegions();

			model.addAttribute("regions", regions);

			return "add-monument";
		}
		
		region = regionService.getRegion(region.getId());
		
		monument.setId(0);
		
		region.addMonument(monument);
		
		regionService.saveRegion(region);

		return "redirect:/region/list";

	}

}
