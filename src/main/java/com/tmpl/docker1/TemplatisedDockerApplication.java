package com.tmpl.docker1;

import com.tmpl.executor.CommandExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
public class TemplatisedDockerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TemplatisedDockerApplication.class, args);
		//CommandExecutor.executeCommand("cmd --version",null);
	}


}
