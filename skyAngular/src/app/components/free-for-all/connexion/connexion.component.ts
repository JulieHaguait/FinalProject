import { ConnexionService } from './../../../services/connexion.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  styleUrls: ['./connexion.component.css']
})

export class ConnexionComponent implements OnInit {
  monForm: FormGroup;
  constructor( private connexionService: ConnexionService, private router: Router) {
      this.monForm = new FormGroup({
      login: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      })
    }

    ngOnInit(): void {}

    checkLogin(): AsyncValidatorFn {
      return (control: AbstractControl): Observable<ValidationErrors | null> => {
        return this.connexionService.checkLogin(control.value).pipe(
          map((bool) => {
            return bool ? { loginExist: true } : null;
          })
        );
      };
    }

    submit() {
    let compte = {
      login: this.monForm.get('login')?.value,
      password: this.monForm.get('password')?.value,
    };
    this.connexionService.inscription(compte).subscribe((data) => {
      this.router.navigate(['/home'], { queryParams: { inscription: true } });
    });
  }

}
