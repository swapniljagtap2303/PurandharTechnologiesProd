import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  slides = [
    { title: 'Innovative Solutions', description: 'We provide cutting-edge IT solutions.' },
    { title: 'Web & App Development', description: 'Building responsive web and mobile apps.' },
    { title: 'Enterprise IT Services', description: 'Reliable IT services for your business.' }
  ];

  currentIndex = 0;

  constructor() { }

  ngOnInit(): void {
    setInterval(() => {
      this.nextSlide();
    }, 3000); // Change slide every 3 seconds
  }

  nextSlide() {
    this.currentIndex = (this.currentIndex + 1) % this.slides.length;
  }
}
