package br.lamentina.resource_sever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.oauth2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ResourceSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceSeverApplication.class, args);
	}



}

@RestController
@RequestMapping("hello")
class HelloController {
	@GetMapping
	public String hello(@AuthenticationPrincipal Jwt jwt){
		return "OlaMundo\n" + jwt.getTokenValue();
	}
}