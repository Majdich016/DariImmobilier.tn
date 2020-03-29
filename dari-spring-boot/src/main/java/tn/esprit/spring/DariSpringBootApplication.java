package tn.esprit.spring;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.controller.FileUploadController;

@SpringBootApplication
public class DariSpringBootApplication {

	public static void main(String[] args)throws Exception  {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(DariSpringBootApplication.class, args);
	}

}
