package com.renuka.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renuka.location.model.Location;
import com.renuka.location.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap) {
		Location locationSaved = locationService.saveLocation(location);
		String msg = "location saved" +locationSaved.getId();
		modelmap.addAttribute("msg", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displaylocations(ModelMap modelMap) {
		List<Location> locations = locationService.getallLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocation";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelmap){
		Location location = locationService.getLocationById(id);
		locationService.deleteLocation(location);
		List<Location> locations = locationService.getallLocations();
		modelmap.addAttribute("locations",locations);
		return "displayLocation";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelmap) {
		 Location location=locationService.getLocationById(id);
		 modelmap.addAttribute("location", location);
		 return "updateLocation";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@RequestParam("id") int id,Location location,ModelMap modelmap) {
		locationService.updateLocation(location);
		List<Location> locations = locationService.getallLocations();
		modelmap.addAttribute("locations", locations);
		return "displayLocation";
	}
}
