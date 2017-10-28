package com.api.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.rest.dto.FoodItemDTO;
import com.api.rest.util.DBConnection;

@Component
public class SelectDAO {
	
	private Connection conn;
	
	public List<FoodItemDTO> selectAllFoodItems() throws SQLException {
		
		conn = DBConnection.connect();
		List<FoodItemDTO> foodList = new ArrayList<FoodItemDTO>();
		
		String selectQuery = "SELECT \"S_NO\", \"FOOD_NAME\", \"FOOD_ACTUAL_PRICE\", \"FOOD_DISCOUNT_PRICE\"," +
       "\"FOOD_DESC\", \"FOOD_IMAGE_URL\", \"FOOD_CATEGORY\", \"FOOD_AVAILIBLITY_STATUS\","+ 
       "\"FOOD_TIME\" FROM \"FOOD_ITEMS\";";
		PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			
			FoodItemDTO objFoodItem = new FoodItemDTO();
			objFoodItem.setFood_name(resultSet.getString("FOOD_NAME"));
			objFoodItem.setFood_actual_price(resultSet.getString("FOOD_ACTUAL_PRICE"));
			objFoodItem.setFood_discount_price(resultSet.getString("FOOD_DISCOUNT_PRICE"));
			objFoodItem.setFood_desc(resultSet.getString("FOOD_DESC"));
			objFoodItem.setFood_image_url(resultSet.getString("FOOD_IMAGE_URL"));
			objFoodItem.setFood_category(resultSet.getString("FOOD_CATEGORY"));
			objFoodItem.setFood_availablity_status(resultSet.getString("FOOD_AVAILIBLITY_STATUS"));
			objFoodItem.setFood_time(""+resultSet.getInt("FOOD_TIME"));
			
			System.out.println(resultSet.getString("FOOD_NAME"));
			
			foodList.add(objFoodItem);
		}
		
		if(!conn.isClosed()){
			conn.close();
		}
		
		return foodList;
		
	}
	
}
