import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ServicesComponent } from './components/services/services.component';
import { ContactComponent } from './components/contact/contact.component';
import { TestimonialComponent } from './components/testimonial/testimonial.component';
import { NewsletterComponent } from './components/newsletter/newsletter.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { CareersComponent } from './components/careers/careers.component';
import { ProjectDetailComponent } from './components/project-detail/project-detail.component';

const routes: Routes = [


  //  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'services', component: ServicesComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'testimonial', component: TestimonialComponent },
  { path: 'newsletter', component: NewsletterComponent },
  { path: 'projects', component: ProjectsComponent },
  { path: 'projects/:id', component: ProjectDetailComponent },
  { path: 'careers', component: CareersComponent },
  { path: '**', redirectTo: '' }

];

@NgModule({
  // imports: [RouterModule.forRoot(routes)],
  imports: [
    RouterModule.forRoot(routes, {
      scrollPositionRestoration: 'top'
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
