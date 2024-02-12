package com.example.resume.resumeproject.Transformers;


import com.example.resume.resumeproject.Entities.Admin;
import com.example.resume.resumeproject.Entities.Applicant;
import com.example.resume.resumeproject.RequestDtos.AddAdminRequest;
import com.example.resume.resumeproject.RequestDtos.AddApplicantRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ApplicantTranforms {

    public static Applicant convertAddApplicantReqToApplicant(AddApplicantRequest addApplicantRequest, MultipartFile resumeFile) throws IOException {
        // Create a new Applicant object
        Applicant applicant = Applicant.builder()
                .firstName(addApplicantRequest.getFirstName())
                .LastName(addApplicantRequest.getLastName())
                .email(addApplicantRequest.getEmail())
                .city(addApplicantRequest.getCity())
                .currentJobTitle(addApplicantRequest.getCurrentJobTitle())
                .currentWorkLocation(addApplicantRequest.getCurrentWorkLocation())
                .experience(addApplicantRequest.getExperience())
                .relevantExperience(addApplicantRequest.getRelevantExperience())
                .skillSet(addApplicantRequest.getSkillSet())
                .mobile(addApplicantRequest.getMobile())
                .qualification(addApplicantRequest.getQualification())
                .zipCode(addApplicantRequest.getZipCode())
                .build();

        // Check if a resume file is provided
        if (resumeFile != null && !resumeFile.isEmpty()) {
            // Set the resume content
            applicant.setResumeContent(resumeFile.getBytes());
        }

        return applicant;
    }
}
