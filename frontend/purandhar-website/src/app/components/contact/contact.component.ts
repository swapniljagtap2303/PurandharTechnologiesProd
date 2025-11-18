import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Contact } from 'src/app/model/contact';
import { ContactServiceService } from 'src/app/service/contact-service.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css'],
})
export class ContactComponent {

  contactData: Contact = new Contact();

  constructor(private contactService: ContactServiceService, private toastr: ToastrService) { }

  onSubmit() {
  this.contactService.saveContact(this.contactData).subscribe({
    next: (response) => {
      console.log('✅ Response:', response);

      
      if (response.status === 'SUCCESS') {
        this.toastr.success(response.message, 'Success');
      } else {
        this.toastr.warning(response.message || 'Unexpected response', 'Warning');
      }

      this.contactData = { cName: '', cEmail: '', cMessage: '' };
    },
    error: (err) => {

      console.error('❌ Error:', err);
      
      const backendMessage = err?.error?.message || 'Something went wrong ❌';
      this.toastr.error(backendMessage, 'Error');
    }
  });
}

}
