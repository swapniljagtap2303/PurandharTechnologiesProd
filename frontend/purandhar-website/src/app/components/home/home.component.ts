import { Component, ElementRef, ViewChild } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ToastrService } from 'ngx-toastr';
import { Newsletter } from 'src/app/model/newsletter';
import { NewsletterServiceService } from 'src/app/service/newsletter-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {
  videoUrl: SafeResourceUrl;
  emailData: Newsletter = new Newsletter();

  onSubscribe(e: Event) {
    e.preventDefault();
    // replace with your newsletter integration code
    alert('Thanks! We will add this email to the newsletter (demo).');
  }

  constructor(private sanitizer: DomSanitizer, public newsletterService: NewsletterServiceService, public toastr: ToastrService) {
    this.videoUrl = this.sanitizer.bypassSecurityTrustResourceUrl('assets/videos/purandhar-it-park.mp4');
  }

  @ViewChild('heroVideo') heroVideo!: ElementRef<HTMLVideoElement>;

  ngAfterViewInit(): void {
    const video = this.heroVideo?.nativeElement;
    if (video) {
      video.muted = true;
      video.play().catch(err => {
        console.warn('Autoplay prevented:', err);
      });
    }
  }

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
