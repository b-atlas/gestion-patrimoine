package com.controllers;

import java.util.List;

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

import com.entities.Region;
import com.services.IRegionService;

@Controller
@RequestMapping("/region")
public class RegionController {

	@Autowired
	IRegionService regionService;

	@GetMapping("/list")
	public String showRegionsList(Model model) {

		List<Region> regions = regionService.getAllRegions();

		model.addAttribute("regions", regions);

		return "regions-list";
	}

	@GetMapping("/showAddRegionForm")
	public String showAddregionForm(Model model) {

		Region region = new Region();

		model.addAttribute("region", region);

		return "add-region";
	}

	@PostMapping("/addRegion")
	public String addRegion(@Valid @ModelAttribute("region") Region region, BindingResult results) {

		if (results.hasErrors()) {
			return "add-region";
		}

		regionService.saveRegion(region);

		return "redirect:/region/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("regionId") int regionId, Model model) {

		Region region = regionService.getRegion(regionId);

		model.addAttribute("region", region);

		return "add-region";
	}

	@GetMapping("/deleteRegion")
	public String deleteRegion(@RequestParam("regionId") int regionId, Model model) {

		regionService.deleteRegion(regionId);

		return "redirect:/region/list";
	}

}
