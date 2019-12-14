import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { StudentregisterComponent } from './studentregister/studentregister.component';
import { StudentloginComponent } from './studentlogin/studentlogin.component';
import { StudenthomepageComponent } from './studenthomepage/studenthomepage.component';


const routes: Routes = [
  {
    path : '' , component : HomeComponent
   },
   {
     path : 'adminregister' , component : AdminRegisterComponent
   },
   {
     path: 'adminlogin' , component : LoginadminComponent
   },
   {
     path: 'studentregistration' , component: StudentregisterComponent
   },
   {
     path: 'studentlogin' , component: StudentloginComponent
   },
   {
     path: 'studenthomepage' , component: StudenthomepageComponent
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
