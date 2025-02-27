package com.Spring.EmployeePayrollApp.Service;

import com.Spring.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.Spring.EmployeePayrollApp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    void deleteEmployeePayrollData(int empId);
}