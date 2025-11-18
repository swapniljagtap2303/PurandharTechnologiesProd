import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NewsletterServiceService {

  private baseUrl = environment.apiUrl;

  constructor(public http: HttpClient) { }

  subscribeNewsletter(emailData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/newsletter/subscribe`, emailData);
  }
}
