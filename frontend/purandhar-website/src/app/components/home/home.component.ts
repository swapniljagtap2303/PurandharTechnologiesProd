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
  email: string = '';
  message: string = '';

  constructor() { }

  ngOnInit(): void {
    setInterval(() => {
      this.nextSlide();
    }, 3000); // Change slide every 3 seconds
  
  
    setInterval(() => {
      this.activeIndex = (this.activeIndex + 1) % this.testimonials.length;
    }, 4000); // every 4 seconds auto-slide
  }

  nextSlide() {
    this.currentIndex = (this.currentIndex + 1) % this.slides.length;
  }
// -------------------------------------------------------------------------------------------
   onSubmit() {
    alert('Your message has been sent! (Backend integration coming soon 🚀)');
  }

// -------------------------------------------------------------------------------------------

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
// --------------------------------------------------------------------

 

  subscribe() {
    if (this.email.trim()) {
      this.message = 'Thank you for subscribing! 🎉';
      this.email = '';
      setTimeout(() => (this.message = ''), 3000);
    }
  }

}
