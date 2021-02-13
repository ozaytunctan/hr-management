import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/core/service/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employee:any;
  constructor(private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getEmployeeById(2).subscribe(data=>{
     this.employee=data;
     console.log(this.employee);
    });

    // this.employeeService.getEmployess(0,10).subscribe(data=>{
    //   console.log(data);
    // });
  }

}
