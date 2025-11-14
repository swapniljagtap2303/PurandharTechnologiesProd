import { Component } from '@angular/core';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent {
  projects = [
    {
      title: 'E-Commerce Platform',
      description: 'A complete shopping solution built with Angular and Spring Boot.',
      image: 'assets/images/project1.png'
    },
    {
      title: 'Healthcare Chatbot',
      description: 'AI-driven assistant for patient queries and appointment booking.',
      image: 'assets/images/project2.png'
    },
    {
      title: 'Cloud Dashboard',
      description: 'Data analytics platform hosted on AWS with secure access.',
      image: 'assets/images/project3.png'
    }
  ];
}
