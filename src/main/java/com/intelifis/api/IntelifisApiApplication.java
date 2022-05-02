package com.intelifis.api;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelifis.api.controller.files.FilesStorageService;

@SpringBootApplication
public class IntelifisApiApplication implements CommandLineRunner {

	  @Resource
	  FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(IntelifisApiApplication.class, args);
	}





  @Override
  public void run(String... arg) throws Exception {
    storageService.deleteAll();
    storageService.init();
  }
}

