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
  monForm: FormGroup;

  constructor(
    private inscriptionService: InscriptionService,
    private router: Router
  ) {
    this.monForm = new FormGroup({
      login: new FormControl('', Validators.required),
      type: new FormControl('skykid'),
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
      login: this.monForm.get('login')?.value,
      type: this.monForm.get('type')?.value,
      password: this.monForm.get('passwordGroup.password')?.value,
    };
    this.inscriptionService.inscription(compte).subscribe((data) => {
      this.router.navigate(['/inscription-success'], {
        queryParams: { inscription: true },
      });
    });
  }
}
