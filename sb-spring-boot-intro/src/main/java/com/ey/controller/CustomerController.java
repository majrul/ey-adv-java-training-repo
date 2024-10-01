package com.ey.controller;

import com.ey.dto.RegistrationStatus;
import com.ey.dto.Status;
import com.ey.dto.UploadDetails;
import com.ey.entity.Customer;
import com.ey.exception.CustomerServiceException;
import com.ey.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/register")
    public RegistrationStatus register(@RequestBody Customer customer) {
        RegistrationStatus status = new RegistrationStatus();

        try {
            int id = customerService.register(customer);
            status.setStatus(true);
            status.setMessageIfAny("Registration successful!");
            status.setCustomerId(id);
            return status;
        }
        catch (CustomerServiceException e) {
            status.setStatus(false);
            status.setMessageIfAny(e.getMessage());
            return status;
        }
    }

    @PostMapping("/customer/upload")
    public Status upload(UploadDetails uploadDetails) {
        //store the uploaded file
        try {
            String fileName = uploadDetails.getProfilePic().getOriginalFilename();
            String generatedFileName = fileName; //code to generate a unique name for the file

            InputStream is = uploadDetails.getProfilePic().getInputStream();
            FileOutputStream os = new FileOutputStream("c:/uploads/" + generatedFileName);
            FileCopyUtils.copy(is, os);

            customerService.updateProfilePic(uploadDetails.getCustomerId(), generatedFileName);

            Status status = new Status();
            status.setStatus(true);
            status.setMessageIfAny("Profile Pic uploaded successfully!");
            return status;
        }
        catch (IOException e) {
            Status status = new Status();
            status.setStatus(false);
            status.setMessageIfAny(e.getMessage());
            return status;
        }
    }

    @GetMapping(path = "/customer/profilePic/{customerId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getProfilePic(@PathVariable int customerId) throws IOException {
        String profilePic = customerService.getProfilePic(customerId);
        return Files.readAllBytes(Paths.get("c:/uploads/" + profilePic));
    }
}
