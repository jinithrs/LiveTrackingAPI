package com.api.rest.controller;


import com.api.rest.dao.InsertDAO;
import com.api.rest.dto.LocationDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/location")
public class LocationController {

	@Autowired
	InsertDAO insertDAO;
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/put", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.ALL_VALUE})
	public String receiveLoc(@RequestParam("locationJson") String locationJson){
		System.out.println("In receiveLoc()");
		boolean result = false;		
		try {
			System.out.println(locationJson);
			LocationDTO locationDTO = gson.fromJson(locationJson, LocationDTO.class);
			result = insertDAO.insertIntoLocationTable(locationDTO);
			System.out.println(locationDTO.getLatitude());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Success");
			return "success";
		}
		else {
			System.out.println("Failed");
			return "failed";
		}
	}

}
