import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  registeradmin(admin): Observable<any> {
    return this.http.post('http://localhost:8080/lms/registeradmin', admin);
  }

  loginadmin(admin): Observable<any> {
    return this.http.post('http://localhost:8080/lms/loginadmin', admin);
  }

  registerstudent(student): Observable<any> {
    return this.http.post('http://localhost:8080/lms/registerstudent', student);
  }

  loginstudent(student): Observable<any> {
    return this.http.post('localhost:8080/lms/loginstudent', student);
  }
}
