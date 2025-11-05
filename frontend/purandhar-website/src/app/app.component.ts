import { Component } from '@angular/core';
import * as Aos from 'aos';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'purandhar-website';

  ngOnInit() {
  Aos.init({
    duration: 1000,
    easing: 'ease-in-out',
    once: true
  });
}

}
