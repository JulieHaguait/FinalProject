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
import { InscriptionService } from 'src/app/services/inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;

  constructor(
    private inscriptionService: InscriptionService,
    private router: Router
  ) {
    this.form = new FormGroup({
      type: new FormControl('Skykid'),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', Validators.required),
          confirm: new FormControl(),
        },
        this.passwordAndConfirmEquals
      ),
    });
  }
  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionService.checkLogin(control.value).pipe(
        map((bool) => {
          return bool ? { loginExist: true } : null;
        })
      );
    };
  }

  passwordAndConfirmEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('password')?.errors) {
      return null;
    }
    return group.get('password')?.value == group.get('confirm')?.value
      ? null
      : { passwordAndConfirmNotEquals: true };
  }

  ngOnInit(): void {}

  submit() {
    let compte = {
      login: this.form.get('login')?.value,
      type: this.form.get('type')?.value,
      password: this.form.get('passwordGroup.password')?.value,
    };
    this.inscriptionService.inscription(compte).subscribe((data) => {
      this.router.navigate(['/home'], { queryParams: { inscription: true } });
    });
  }
}
