package com.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/connect")
public class DBController {
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//@RequestMapping("/db")
	//URL-http://localhost:8080/Spring4DB/connect/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void getConnection() {
		System.out.println("getConnection()");
		//String dbDetails = jdbcTemplate.getDataSource().getConnection().getMetaData().toString();
		String sql = "SELECT * FROM LOCATION";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		//List<Map> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			String location = (String) row.get("LOCATION_NAME");
			System.out.println(location);
		}
	}

}
