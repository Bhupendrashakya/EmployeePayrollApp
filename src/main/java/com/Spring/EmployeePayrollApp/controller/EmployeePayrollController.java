package com.Spring.EmployeePayrollApp.controller;

import com.Spring.EmployeePayrollApp.Service.EmployeePayrollService;
import com.Spring.EmployeePayrollApp.Service.IEmployeePayrollService;
import com.Spring.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.Spring.EmployeePayrollApp.dto.ResponseDTO;
import com.Spring.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
  @Autowired
  private IEmployeePayrollService employeePayrollService;
  @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
    List<EmployeePayrollData> empDataList= null;
    empDataList = employeePayrollService.getEmployeePayrollData();
    ResponseDTO respDTO= new ResponseDTO("Get call Successful ",empDataList);
      return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
  }
  @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
    EmployeePayrollData empData=null;
    empData = employeePayrollService.getEmployeePayrollDataById(empId);
    ResponseDTO respDTO= new ResponseDTO("Get call for ID Successful  ",empData);
    return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
  }
  @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
    EmployeePayrollData empData=null;
    empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
    ResponseDTO respDTO= new ResponseDTO("Created Employee Payroll Data Successfully  ",empData);
      return new ResponseEntity<ResponseDTO>(respDTO , HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDTO> updateEmployeePayData(@RequestBody EmployeePayrollDTO empPayrollDTO){
    EmployeePayrollData empData=null;
    empData = employeePayrollService.updateEmployeePayrollData(empPayrollDTO);
    ResponseDTO respDTO= new ResponseDTO("Updated Employee Payroll Data Successfully  ",empData);
    return new ResponseEntity<ResponseDTO>(respDTO , HttpStatus.OK);
  }
  @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollDate(@PathVariable("empId")int empId){
  employeePayrollService.deleteEmployeePayrollData(empId);
    ResponseDTO respDTO= new ResponseDTO("Deleted Successfully ","Deleted ID:"+ empId);
    return new ResponseEntity<ResponseDTO>( respDTO,HttpStatus.OK);
  }
}
