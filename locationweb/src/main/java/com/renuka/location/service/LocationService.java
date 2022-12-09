package com.renuka.location.service;

import java.util.List;

import com.renuka.location.model.Location;

public interface LocationService {
	
	
	Location saveLocation(Location location);
	
	Location updateLocation(Location location);
	
	void deleteLocation(Location location);
	
	Location getLocationById(int id);
	
	List<Location> getallLocations();
}
