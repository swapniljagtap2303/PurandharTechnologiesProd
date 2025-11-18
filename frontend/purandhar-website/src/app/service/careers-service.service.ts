import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CareersServiceService {

  private baseUrl = environment.apiUrl;

  constructor(public http: HttpClient) { }

  applyJob(formData: FormData): Observable<any> {
    return this.http.post(`${this.baseUrl}/jobs/apply`, formData);
  }


}
