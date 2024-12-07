package ru.freepainter.hw28.services;

import ru.freepainter.hw28.models.Employee;
import java.util.List;
import java.util.Map;

public interface IEmployeesService {
    public Employee getMinSalary(Integer departmentId);

    public Employee getMaxSalary(Integer departmentId);

    public List<Employee> getAll(Integer departmentId);

    public Map<Integer, List<Employee>> getAll();

    public void addEmployee(String name, String surname, int department, int salary);
}
