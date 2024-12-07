package ru.freepainter.hw28.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.freepainter.hw28.models.Employee;
import ru.freepainter.hw28.services.IEmployeesService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final IEmployeesService employeesService;

    public DepartmentController(IEmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeesService.getMinSalary(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeesService.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public List<Employee> getAll(@RequestParam("departmentId") Integer departmentId) {
        return employeesService.getAll(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAll() {
        return employeesService.getAll();
    }
}
