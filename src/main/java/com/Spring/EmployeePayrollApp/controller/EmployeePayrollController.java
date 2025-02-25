package com.Spring.EmployeePayrollApp.controller;

import com.Spring.EmployeePayrollApp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
  @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String> getEmployeepayrollDate(){
      return new ResponseEntity<String>("Get call success", HttpStatus.OK);
  }
  @GetMapping("/get/{empId}")
    public ResponseEntity<String> getemployeepayrollDate(@PathVariable("empId") int empId){
      return new ResponseEntity<String>("Get call success for id: "+empId,HttpStatus.OK);
  }
  @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollDate(@RequestBody EmployeePayrollDTO employeePayrollDTO){
      return new ResponseEntity<String>("created Employee Payroll Data for :"+employeePayrollDTO , HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<String> updateEmployeePayData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
      return new ResponseEntity<String>("Updated Employee Payroll Data for: "+employeePayrollDTO,HttpStatus.OK);
  }
  @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollDate(@PathVariable("empId")int empId){
      return new ResponseEntity<String>("Delete call Success for id: "+ empId,HttpStatus.OK);
  }
}
