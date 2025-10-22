package iuh.se.fit.web;

import iuh.se.fit.entities.Employee;
import iuh.se.fit.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping
    public String list(@RequestParam(value = "q", required = false) String q,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       Model model) {
        Page<Employee> p = service.search(q, PageRequest.of(page, size));
        model.addAttribute("page", p);
        model.addAttribute("q", q);
        return "employees/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("genders", Employee.Gender.values());
        return "employees/form"; // tiêu đề sẽ tự đổi theo employee.id
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Employee e = service.get(id).orElseThrow();
        model.addAttribute("employee", e);
        model.addAttribute("genders", Employee.Gender.values());
        return "employees/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genders", Employee.Gender.values());
            return "employees/form";
        }
        try {
            service.save(employee); // nếu id != null -> UPDATE, ngược lại INSERT
            return "redirect:/employees";
        } catch (DataIntegrityViolationException ex) {
            result.addError(new FieldError("employee","email","Email already exists"));
            model.addAttribute("genders", Employee.Gender.values());
            return "employees/form";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }
}
