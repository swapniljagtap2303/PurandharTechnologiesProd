import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ServicesComponent,
    ContactComponent,
    TestimonialComponent,
    NewsletterComponent,
    ProjectsComponent,
    CareersComponent,
    ProjectDetailComponent,
    WebDevelopmentComponent,
    AppDevelopmentComponent,
    CloudSolutionsComponent,
    UiUxDesignComponent,
    ItConsultingComponent,
    SupportMaintenanceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-top-right',
      timeOut: 3000,
      progressBar: true,
      progressAnimation: 'increasing',
      closeButton: true,
      preventDuplicates: true
    }),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
