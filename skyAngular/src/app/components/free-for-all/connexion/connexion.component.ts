import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { ConnexionService } from 'src/app/services/connexion.service';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { map, Observable } from 'rxjs';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  monForm: FormGroup;
  login = '';
  password = '';
  showError = false;
  message = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private connexionService: ConnexionService
  ) {
    this.monForm = new FormGroup({
      login: new FormControl('', Validators.required, this.checkLogin()),
      password: new FormControl('', Validators.required),
    });
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.connexionService.checkLogin(control.value).pipe(
        map((bool) => {
          return bool ? { loginExist: true } : null;
        })
      );
    };
  }

  ngOnInit(): void {}

  submit() {
    let user = {
      login: this.monForm.get('login')?.value,

      type: this.monForm.get('type')?.value,
      password: this.monForm.get('passwordGroup.password')?.value,
    };
    this.authService.auth(this.login, this.password).subscribe({
      next: (user: User) => {
        this.showError = false;
        sessionStorage.setItem('token', btoa(`${this.login}:${this.password}`));
        sessionStorage.setItem('user', JSON.stringify(user));
        // sessionStorage.setItem('type', btoa(`${user.type}`));
        if (user.login == 'admin') {
          sessionStorage.setItem('type', 'admin');
          this.router.navigateByUrl('/profil-admin');
        } else {
          sessionStorage.setItem('type', 'skykid');
          this.router.navigateByUrl('/profil-skykid');
        }
      },
      error: (error: any) => {
        console.log(error);
        this.message = "*erreur d'authentification";
        this.showError = true;
      },
    });
  }
}
