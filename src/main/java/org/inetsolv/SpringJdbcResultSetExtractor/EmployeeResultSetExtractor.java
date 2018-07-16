package org.inetsolv.SpringJdbcResultSetExtractor;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>>{
	public List<Employee> extractData(ResultSet rs){
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			while(rs.next())
			{
				Employee employee = new Employee();
				employee.setEid(rs.getInt("eno"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getDouble("salary"));
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;		
	}
}