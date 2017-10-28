package com.api.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.api.rest.dto.LocationDTO;
import com.api.rest.util.DBConnection;

@Component
public class InsertDAO {
	
	private Connection conn;
	
	public boolean insertIntoLocationTable(LocationDTO locDTO) throws SQLException {
		
		conn = DBConnection.connect();
		
		String insertQuery = "INSERT INTO \"LOCATION_TRACE\" VALUES (?, ?, ?, ?);";
		PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
		preparedStatement.setString(1, locDTO.getOrder_code());
		preparedStatement.setString(2, locDTO.getDe_code());
		preparedStatement.setString(3, locDTO.getLatitude());
		preparedStatement.setString(4, locDTO.getLongitude());
		int r = preparedStatement.executeUpdate();
		
		if(!conn.isClosed())
			conn.close();
		
		if(r==0)
			return false;
		else
			return true;
	}

}
