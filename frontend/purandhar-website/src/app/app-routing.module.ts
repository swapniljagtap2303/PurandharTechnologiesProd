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
import { WebDevelopmentComponent } from './components/services/web-development/web-development.component';
import { AppDevelopmentComponent } from './components/services/app-development/app-development.component';
import { CloudSolutionsComponent } from './components/services/cloud-solutions/cloud-solutions.component';
import { UiUxDesignComponent } from './components/services/ui-ux-design/ui-ux-design.component';
import { ItConsultingComponent } from './components/services/it-consulting/it-consulting.component';
import { SupportMaintenanceComponent } from './components/services/support-maintenance/support-maintenance.component';

const routes: Routes = [


  //  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },

  { path: 'services', component: ServicesComponent },
  { path: 'services/web-development', component: WebDevelopmentComponent },
  { path: 'services/app-development', component: AppDevelopmentComponent },
  { path: 'services/cloud-solutions', component: CloudSolutionsComponent },
  { path: 'services/ui-ux-design', component: UiUxDesignComponent },
  { path: 'services/it-consulting', component: ItConsultingComponent },
  { path: 'services/support-maintenance', component: SupportMaintenanceComponent },

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
