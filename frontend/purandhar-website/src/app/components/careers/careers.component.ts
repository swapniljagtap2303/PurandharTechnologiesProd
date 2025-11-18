import { Component, OnInit } from '@angular/core';
import * as AOS from 'aos';
import { ToastrService } from 'ngx-toastr';
import { Careers } from 'src/app/model/careers';
import { CareersServiceService } from 'src/app/service/careers-service.service';

@Component({
  selector: 'app-careers',
  templateUrl: './careers.component.html',
  styleUrls: ['./careers.component.css']
})
export class CareersComponent implements OnInit {

  showForm = false;
  selectedJob: any = null;

  applicant: Careers = new Careers();
  selectedResume: File | null = null;

  constructor(public careerService: CareersServiceService , private toastr: ToastrService) {}

  jobs = [
    { id: 1, title: 'Java Full Stack Developer', location: 'Pune', experience: '2-5 years', description: '...' },
    { id: 2, title: 'UI/UX Designer', location: 'Remote', experience: '1-3 years', description: '...' },
    { id: 3, title: 'Project Manager', location: 'Hybrid', experience: '5+ years', description: '...' }
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
    this.applicant = new Careers();   // RESET
  }

  onFileSelected(event: any) {
    this.selectedResume = event.target.files[0];
  }

submitApplication() {
  this.applicant.jobId = this.selectedJob.id;

  const formData = new FormData();
  formData.append("resume", this.selectedResume!);
  formData.append("data", new Blob([JSON.stringify(this.applicant)], { type: 'application/json' }));

  this.careerService.applyJob(formData).subscribe({

    next: (response) => {
      console.log('📩 Job Apply Response:', response);

      if (response.status === 'SUCCESS') {
        this.toastr.success(response.message || "Application Submitted Successfully 🎉", "Success");
      } else {
        this.toastr.warning(response.message || "Unexpected Response ⚠️", "Warning");
      }

      this.closeForm();
    },

    error: (err) => {
      console.error('❌ JOB APPLY ERROR:', err);

      const backendMessage = err?.error?.message || "Submission Failed ❌";
      this.toastr.error(backendMessage, "Error");
    }

  });
}


}
