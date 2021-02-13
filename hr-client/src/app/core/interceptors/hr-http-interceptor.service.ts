import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export class HrHttpInterceptorService implements HttpInterceptor {

  constructor() { }


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let modifiedReq = req.clone({
      setHeaders: {
       HARDWARE_CPU:"1452"
      },
      withCredentials:true
    });
    return next.handle(modifiedReq);
  }
}
