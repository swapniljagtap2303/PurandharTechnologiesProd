import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Newsletter } from 'src/app/model/newsletter';
import { NewsletterServiceService } from 'src/app/service/newsletter-service.service';

@Component({
  selector: 'app-newsletter',
  templateUrl: './newsletter.component.html',
  styleUrls: ['./newsletter.component.css']
})
export class NewsletterComponent {
  // email: string = '';
  message: string = '';

  emailData: Newsletter = new Newsletter();

  constructor(public newsletterService: NewsletterServiceService, public toastr: ToastrService) { }

  subscribe(form: any) {

    this.newsletterService.subscribeNewsletter(this.emailData).subscribe({
      next: (response) => {

        console.log(response);

        if (response.status == 'SUCCESS') {
          this.toastr.success(response.message, 'Subscribed');
        }

        form.resetForm();
      },
      error: (err) => {
        console.error(err);

        const backendMessage = err?.error?.message || 'Server error. Try again later.';
        this.toastr.error(backendMessage, 'Failed');
      }

    })
  }
}
