package org.inetsolv.SpringJdbcResultSetExtractor;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");
		JdbcTemplate jdbcTemplate = container.getBean(JdbcTemplate.class);
		String sql = "SELECT * FROM emp_tbl";
		List<Employee> empList = jdbcTemplate.query(sql, new EmployeeResultSetExtractor());
		for (Employee employee : empList) {
			System.out.println(employee.getEno() + " " + employee.getEname() + " " + employee.getSalary());
		}
		((AbstractApplicationContext) container).close();
	}
}