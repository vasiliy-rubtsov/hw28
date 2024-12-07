package ru.freepainter.hw28.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.freepainter.hw28.services.IEmployeesService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final IEmployeesService employeesService;

    public DepartmentController(IEmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping(path = "/min-salary")
    public String getMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeesService.getMinSalary(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public String getMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeesService.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public String getAll(@RequestParam("departmentId") Integer departmentId) {
        return employeesService.getAll(departmentId);
    }

    @GetMapping(path = "/all")
    public String getAll() {
        return employeesService.getAll();
    }

}
