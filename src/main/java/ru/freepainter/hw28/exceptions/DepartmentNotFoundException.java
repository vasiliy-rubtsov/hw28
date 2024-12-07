package ru.freepainter.hw28.exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Отдел не найден";
    }
}
