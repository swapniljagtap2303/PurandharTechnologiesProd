import { Component } from '@angular/core';

@Component({
  selector: 'app-newsletter',
  templateUrl: './newsletter.component.html',
  styleUrls: ['./newsletter.component.css']
})
export class NewsletterComponent {
  email: string = '';
  message: string = '';

  subscribe() {
    if (this.email.trim()) {
      this.message = 'Thank you for subscribing! 🎉';
      this.email = '';
      setTimeout(() => (this.message = ''), 3000);
    }
  }
}
