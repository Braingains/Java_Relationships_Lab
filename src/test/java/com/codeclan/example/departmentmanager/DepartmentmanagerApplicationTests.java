package com.codeclan.example.departmentmanager;

import com.codeclan.example.departmentmanager.models.Department;
import com.codeclan.example.departmentmanager.models.Employee;
import com.codeclan.example.departmentmanager.models.Project;
import com.codeclan.example.departmentmanager.repositories.DepartmentRepository;
import com.codeclan.example.departmentmanager.repositories.EmployeeRepository;
import com.codeclan.example.departmentmanager.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
class DepartmentmanagerApplicationTests {
	//Dependency injection
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployeeDepartmentAndProject(){
		Department department = new Department("Management");
		departmentRepository.save(department);

		Employee employee = new Employee("Ned", "Flanders", "123GOD", department);
		employeeRepository.save(employee);

		Project project = new Project("Leftorium", 15.0);
		projectRepository.save(project);

	}
	@Test
	public void canAddEmployeeToProject(){
		Department department = new Department("Management");
		departmentRepository.save(department);

		Employee employee = new Employee("Ned", "Flanders", "123GOD", department);
		employeeRepository.save(employee);

		Project project = new Project("Leftorium", 15.0);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);
		

	}



}
