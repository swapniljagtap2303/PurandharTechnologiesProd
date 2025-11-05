import { Component, OnInit } from '@angular/core';
import * as AOS from 'aos';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {

  ngOnInit(): void {
    AOS.init({
      duration: 1000, // animation duration (ms)
      easing: 'ease-in-out', // animation easing
      once: true, // whether animation should happen only once
      mirror: false // whether elements animate out while scrolling past them
    });
  }

}
