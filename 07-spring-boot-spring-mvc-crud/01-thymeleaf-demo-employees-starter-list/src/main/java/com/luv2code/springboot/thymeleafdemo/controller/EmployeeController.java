package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> employees = service.findAll();

		// add to the spring model
		theModel.addAttribute("employees", employees);

		return "employee/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);


		return "employee/save-employees";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(
			@RequestParam("employeeId") int id,
			Model model
	) {
		Employee employee = service.findById(id);
		model.addAttribute("employee", employee);


		return "employee/save-employees";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		service.save(employee);

		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		service.deleteById(id);

		return "redirect:/employees/list";
	}
}









