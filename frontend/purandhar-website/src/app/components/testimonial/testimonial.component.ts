import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testimonial',
  templateUrl: './testimonial.component.html',
  styleUrls: ['./testimonial.component.css']
})
export class TestimonialComponent implements OnInit {
  testimonials = [
    {
      name: 'Rahul Mehta',
      position: 'Founder, TechNest Pvt Ltd',
      image: 'https://randomuser.me/api/portraits/men/75.jpg',
      quote: 'Purandhar Technologies delivered exactly what we needed. Professional, fast, and reliable!'
    },
    {
      name: 'Sneha Patil',
      position: 'Project Manager, CodeSoft',
      image: 'https://randomuser.me/api/portraits/women/65.jpg',
      quote: 'Their team’s creativity and technical skills made our website stand out beautifully.'
    },
    {
      name: 'Arjun Deshmukh',
      position: 'CTO, BrightWorks',
      image: 'https://randomuser.me/api/portraits/men/78.jpg',
      quote: 'Excellent collaboration and communication throughout our app development process.'
    }
  ];

  activeIndex = 0;

  ngOnInit() {
    setInterval(() => {
      this.activeIndex = (this.activeIndex + 1) % this.testimonials.length;
    }, 4000); // every 4 seconds auto-slide
  }
}
