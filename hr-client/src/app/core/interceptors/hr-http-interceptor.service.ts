import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, pipe, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

export class HrHttpInterceptorService implements HttpInterceptor {

  constructor() { }


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let modifiedReq = req.clone({
      setHeaders: {
       HARDWARE_CPU:"1452",
       "Accept-Language":"tr"
      },
      withCredentials:true
    }
    );
    return next
    .handle(modifiedReq)
    .pipe(
     catchError(err=>{
       alert(err);
       return throwError(err);
     }
     )
    );
  }
}
