import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-studentregister',
  templateUrl: './studentregister.component.html',
  styleUrls: ['./studentregister.component.css']
})
export class StudentregisterComponent implements OnInit {
  error: string;
  constructor(private auth: AuthService , private router: Router) { }

  register(form: NgForm){
    this.error = null;
    console.log(form.value);
    this.auth.registerstudent(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/studentlogin');
      form.reset();
    }, err => {
      console.log(err);
    });

  }
  ngOnInit() {
  }

}
