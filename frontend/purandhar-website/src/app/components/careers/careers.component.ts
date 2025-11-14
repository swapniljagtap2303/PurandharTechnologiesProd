import { Component, OnInit } from '@angular/core';
import * as AOS from 'aos';

@Component({
  selector: 'app-careers',
  templateUrl: './careers.component.html',
  styleUrls: ['./careers.component.css']
})
export class CareersComponent implements OnInit {
  showForm = false;
  selectedJob: any = null;

  applicant = {
    name: '',
    email: '',
    message: ''
  };

  jobs = [
    {
      title: 'Java Full Stack Developer',
      location: 'Pune, India',
      experience: '2-5 years',
      description: 'Work on cutting-edge web applications using Angular and Spring Boot.'
    },
    {
      title: 'UI/UX Designer',
      location: 'Remote',
      experience: '1-3 years',
      description: 'Design intuitive, modern, and responsive interfaces for clients.'
    },
    {
      title: 'Project Manager',
      location: 'Hybrid (Pune)',
      experience: '5+ years',
      description: 'Lead technical teams and deliver projects on time with quality.'
    }
  ];

  ngOnInit() {
    AOS.init({ duration: 1000, once: true });
  }

  openForm(job: any) {
    this.selectedJob = job;
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
    this.applicant = { name: '', email: '', message: '' };
  }

  submitApplication() {
    alert(`✅ Application submitted for ${this.selectedJob.title}!`);
    this.closeForm();
  }
}
