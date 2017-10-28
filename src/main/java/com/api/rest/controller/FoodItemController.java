package com.api.rest.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.dao.SelectDAO;
import com.api.rest.dto.FoodItemDTO;
import com.google.gson.Gson;

@CrossOrigin
@RestController
@RequestMapping(value="/food")
public class FoodItemController {
	
	@Autowired
	SelectDAO selectDAO;
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public String getAllFoodItems() {
		String json = null;
		try {
			List<FoodItemDTO> foodList = selectDAO.selectAllFoodItems();
			System.out.println("Number of items = " + foodList.size());
			json = gson.toJson(foodList);
			System.out.println("JSON = " + json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

}
