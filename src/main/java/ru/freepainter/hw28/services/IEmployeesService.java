package ru.freepainter.hw28.services;

public interface IEmployeesService {
    public String getMinSalary(Integer departmentId);

    public String getMaxSalary(Integer departmentId);

    public String getAll(Integer departmentId);

    public String getAll();

    public void addEmployee(String name, String surname, int department, int salary);
}
