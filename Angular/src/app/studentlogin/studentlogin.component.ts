import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-studentlogin',
  templateUrl: './studentlogin.component.html',
  styleUrls: ['./studentlogin.component.css']
})
export class StudentloginComponent implements OnInit {
  error: string;
  constructor(private auth: AuthService , private router: Router) { }

  login(form: NgForm) {
    this.error = null;
    console.log(form.value);
    this.auth.loginstudent(form.value).subscribe(data => {
      console.log('Response of login' , data);
      if (data && data.description === 'Login successfull') {
        localStorage.setItem('userDetails', JSON.stringify(data));
        this.router.navigateByUrl('/studenthomepage');
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
