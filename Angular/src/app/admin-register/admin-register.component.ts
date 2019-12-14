import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit,OnDestroy {

  error: string;
  constructor(private auth: AuthService , private router: Router) { }

  register(form: NgForm) {
    this.error = null;
    console.log(form.value);
    this.auth.registeradmin(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/adminlogin');
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error.message;


    } );

  }

  ngOnInit() {
  }
  ngOnDestroy() {
    this.error = null;
  }

}
