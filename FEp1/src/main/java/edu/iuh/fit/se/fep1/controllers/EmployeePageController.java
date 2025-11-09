package edu.iuh.fit.se.fep1.controllers;

import edu.iuh.fit.se.fep1.dtos.Employee;
import edu.iuh.fit.se.fep1.services.IEmployeeClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class EmployeePageController {
    private final IEmployeeClientService service;
    public EmployeePageController(IEmployeeClientService service) {
        this.service = service;
    }
    @GetMapping({"/", "/employees"})
    public String list(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }
    @GetMapping("/employees/new")
    public String newForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("formTitle", "Add Employee");
        return "employee-form";
    }
    @GetMapping("/employees/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", service.findById(id));
        model.addAttribute("formTitle", "Update Employee");
        return "employee-form";
    }
    @PostMapping("/employees/save")
    public String save(@ModelAttribute Employee e) {
        if (e.getId() == null) service.create(e);
        else service.update(e.getId(), e);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{id}/delete")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/employees";
    }
}
