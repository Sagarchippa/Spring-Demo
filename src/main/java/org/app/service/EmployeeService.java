package org.app.service;

import jakarta.transaction.Transactional;
import org.app.dao.EmployeeDao;
import org.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee findById(Integer id) {
        Employee data=employeeDao.getEmployee(id);
        return data;
    }

    public List<Employee> findAll() {
        return employeeDao.getAllEmployees();
    }
}
