package com.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
private String name;
private double salary;
private String dob;
private String location;
private String emailId;
private long phoneNO;
private String department;
}
