package ru.freepainter.hw28.services;

import org.springframework.stereotype.Service;
import ru.freepainter.hw28.exceptions.DepartmentNotFoundException;
import ru.freepainter.hw28.models.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeesService implements IEmployeesService {

    private Map<Integer, List<Employee>> employees = new HashMap<>();

    public EmployeesService() {
        addEmployee("АННА МИХАЙЛОВНА", "ЗАРЕЦКАЯ", 1, 78300);
        addEmployee("ОЛЕГ ВЛАДИМИРОВИЧ", "ВИХРОВ", 1, 93600);
        addEmployee("СЕРГЕЙ НИКОЛАЕВИЧ", "ПОЗДНЯКОВ", 2, 95000);
        addEmployee("АЛЕКСАНДР АНДРЕЕВИЧ", "КУЗНЕЦОВ", 2, 110000);
        addEmployee("АЛЕКСАНДР ГРИГОРЬЕВИЧ", "ПУСТЫНЦЕВ", 3, 88000);
        addEmployee("АНАТОЛИЙ АНТОНОВИЧ", "РЫМАЕВ", 3, 98000);
        addEmployee("СВЕТЛАНА ВЛАДИМИРОВНА", "ШУСТОВА", 3, 93000);
        addEmployee("МИХАИЛ ВЛАДИМИРОВИЧ", "МОРОЗОВ", 4, 120000);
        addEmployee("ГЛЕБ ЕВГЕНЬЕВИЧ", "ВОСТРИКОВ", 4, 94000);
        addEmployee("БОРИС ПЕТРОВИЧ", "АЛЕКСАНДРОВ", 5, 150000);
    }

    /**
     * Возвращает сотрудника с минимальной зарплатой по отделу
     * @param departmentId - ID отдела
     * @return
     */
    @Override
    public String getMinSalary(Integer departmentId) {
        if (!employees.containsKey(departmentId)) {
            throw new DepartmentNotFoundException();
        }
        List<Employee> employeesOfDepartment = employees.get(departmentId);
        return employeesOfDepartment
                .stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .toString();
    }

    /**
     * Возвращает сотрудника с максимальной зарплатой по отделу
     * @param departmentId - ID отдела
     * @return
     */
    @Override
    public String getMaxSalary(Integer departmentId) {
        if (!employees.containsKey(departmentId)) {
            throw new DepartmentNotFoundException();
        }
        List<Employee> employeesOfDepartment = employees.get(departmentId);
        return employeesOfDepartment
                .stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .toString();

    }

    /**
     * Возвращает всех сотрудников по отделу
     * @param departmentId - ID отдела
     * @return
     */
    @Override
    public String getAll(Integer departmentId) {
        if (!employees.containsKey(departmentId)) {
            throw new DepartmentNotFoundException();
        }
        List<Employee> employeesOfDepartment = employees.get(departmentId);
        return employeesOfDepartment
                .stream()
                .map(Employee::toString)
                .collect(Collectors.joining("\r\n"));
    }

    /**
     * Возвращает всех сотрудников с разделением по отделам
     * @return
     */
    @Override
    public String getAll() {
        String result = "";
        for (Integer key : employees.keySet()) {
            result += "Отдел " + key + "\r\n" +
                    getAll(key) + "\r\n" +
                    "================================\r\n";
        }
        return result;
    }


    /**
     * Добавление нового сотрудника
     *
     * @param name       String
     * @param surname    String
     * @param department int
     * @param salary     int
     * @return boolean
     */
    @Override
    public void addEmployee(String name, String surname, int department, int salary) {
        if (!employees.containsKey(department)) {
            employees.put(department, new ArrayList<>());
        }
        Employee employee = new Employee(name, surname, department, salary);
        employees.get(department).add(employee);
    }
}
