import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {
  projectId: number = 0;
  project: any;

  projects = [
    {
      title: 'E-Commerce Platform',
      description: 'A complete online store with product management, cart, checkout and admin panel.',
      image: 'assets/images/project1.png',
      technologies: ['Angular', 'Spring Boot', 'MySQL'],
      link: 'https://github.com/yourprofile/ecommerce-platform'
    },
    {
      title: 'Healthcare Chatbot',
      description: 'AI-driven assistant for hospital appointment and medical FAQs.',
      image: 'assets/images/project2.png',
      technologies: ['Python', 'Rasa', 'Angular'],
      link: 'https://github.com/yourprofile/healthcare-chatbot'
    },
    {
      title: 'Cloud Dashboard',
      description: 'Admin analytics dashboard for cloud performance and usage tracking.',
      image: 'assets/images/project3.png',
      technologies: ['Angular', 'Node.js', 'AWS'],
      link: 'https://github.com/yourprofile/cloud-dashboard'
    }
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.projectId = Number(this.route.snapshot.paramMap.get('id'));
    this.project = this.projects[this.projectId];
  }
}
