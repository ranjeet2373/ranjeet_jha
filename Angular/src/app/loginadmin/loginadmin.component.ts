import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.css']
})
export class LoginadminComponent implements OnInit {
  error: string;
  constructor(private auth: AuthService , private router: Router) { }

  login(form: NgForm) {
    this.error = null;
    console.log(form.value);
    this.auth.loginadmin(form.value).subscribe(data => {
      console.log('Response of login', data);
      if (data && data.description === 'Login successfull') {
        localStorage.setItem('userDetails' , JSON.stringify(data));
        this.router.navigateByUrl('/home');
      }
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error.message;

    });

  }

  ngOnInit() {
  }

}
