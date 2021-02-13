import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ApiUrlConstant } from '../constant/api-url.constant';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  public getEmployeeById(id:number):Observable<any>{
    return this.http.get(`${ApiUrlConstant.EMPLOYEE.GET_EMPLOYEE_BY_ID_URL}/${id}`)
    .pipe(map((response:any)=>response?.data));
  }

  public getEmployess(page:number,pageSize:number):Observable<any>{

    return this.http.get(`${ApiUrlConstant.EMPLOYEE.GET_ALL_EMPLOYEE_URL}`,{
      params:{
        page:page+"",
        pageSize:pageSize+""
      }
    })
    .pipe(map((response:any)=>response?.data));
  }
}
