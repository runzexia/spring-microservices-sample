package pl.piomin.services.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Repository;
import pl.piomin.services.employee.model.Employee;

@RefreshScope
@Repository
@ConfigurationProperties(prefix = "repository")
public class EmployeeRepository {

	private List<Employee> employees = new ArrayList<>();
	
	public Employee add(Employee employee) {
		employee.setId((long) (employees.size()+1));
		employees.add(employee);
		return employee;
	}
	
	public Employee findById(Long id) {
		Optional<Employee> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}
	
	public List<Employee> findAll() {
		return employees;
	}
	
	public List<Employee> findByDepartment(Long departmentId) {
		return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
	}
	
	public List<Employee> findByOrganization(Long organizationId) {
		return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}