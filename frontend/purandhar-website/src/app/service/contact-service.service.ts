import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContactServiceService {

  private baseUrl = environment.apiUrl;


  constructor(private http: HttpClient) { }

  saveContact(contactData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/contact/saveContact`, contactData);
  }
}