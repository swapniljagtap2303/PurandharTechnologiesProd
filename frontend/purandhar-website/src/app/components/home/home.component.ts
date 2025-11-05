import { Component, ElementRef, ViewChild } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {
  videoUrl: SafeResourceUrl;

  onSubscribe(e: Event) {
    e.preventDefault();
    // replace with your newsletter integration code
    alert('Thanks! We will add this email to the newsletter (demo).');
  }

  constructor(private sanitizer: DomSanitizer) {
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

}
