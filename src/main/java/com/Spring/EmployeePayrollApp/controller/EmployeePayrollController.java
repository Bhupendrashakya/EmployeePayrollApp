package com.Spring.EmployeePayrollApp.controller;

import com.Spring.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.Spring.EmployeePayrollApp.dto.ResponseDTO;
import com.Spring.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
  @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeepayrollDate(){
    EmployeePayrollData empData=null;
    empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj",30000));
    ResponseDTO respDTO= new ResponseDTO("Get call Successful ",empData);
      return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
  }
  @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getemployeepayrollDate(@PathVariable("empId") int empId){
    EmployeePayrollData empData=null;
    empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj",30000));
    ResponseDTO respDTO= new ResponseDTO("Get call for ID Successful  ",empData);
    return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
  }
  @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollDate(@RequestBody EmployeePayrollDTO empPayrollDTO){
    EmployeePayrollData empData=null;
    empData = new EmployeePayrollData(1, empPayrollDTO);
    ResponseDTO respDTO= new ResponseDTO("Created Employee Payroll Data Successfully  ",empData);
      return new ResponseEntity<ResponseDTO>(respDTO , HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDTO> updateEmployeePayData(@RequestBody EmployeePayrollDTO empPayrollDTO){
    EmployeePayrollData empData=null;
    empData = new EmployeePayrollData(1, empPayrollDTO);
    ResponseDTO respDTO= new ResponseDTO("Updated Employee Payroll Data Successfully  ",empData);
    return new ResponseEntity<ResponseDTO>(respDTO , HttpStatus.OK);
  }
  @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollDate(@PathVariable("empId")int empId){
    ResponseDTO respDTO= new ResponseDTO("Deleted Successfully ","Deleted ID:"+ empId);
    return new ResponseEntity<ResponseDTO>( respDTO,HttpStatus.OK);
  }
}
