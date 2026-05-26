package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

// Repository 인터페이스
interface MemberRepository {
	void save(String name);
	List<String> findAll();
}

// 구현체 (수동 등록을 위해 @Repository 제거)
class MemoryRepository implements MemberRepository {
	private final List<String> store = new ArrayList<>();

	@Override
	public void save(String name) {
		store.add(name);
	}

	@Override
	public List<String> findAll() {
		return store;
	}
}

// Service 클래스 (수동 등록을 위해 @Service 제거, 생성자 주입 유지)
class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void join(String name) {
		memberRepository.save(name);
	}

	public List<String> findAll() {
		return memberRepository.findAll();
	}
}

// [체크리스트] @Configuration + @Bean 수동 등록 방식 완벽 적용
@Configuration
class AppConfig {

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryRepository(); // 빈 수동 등록
	}

	@Bean
	public MemberService memberService() {
		// 생성자 주입을 통해 의존성 주입(DI) 적용
		return new MemberService(memberRepository());
	}
}

// Web Controller (수동 등록된 빈을 주입받아 API 구현)
@RestController
class HelloController {
	private final MemberService memberService;

	// 생성자 주입
	public HelloController(MemberService memberService) {
		this.memberService = memberService;
	}

	// [체크리스트] GET /hello API 정상 동작
	@GetMapping("/hello")
	public String hello() {
		memberService.join("김멋사");
		memberService.join("이멋사");
		return "Hello, Spring Boot! 회원 명단: " + memberService.findAll().toString();
	}
}

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}