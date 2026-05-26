package com.example.demo; // package 경로를 정상적으로 수정했습니다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

interface MemberRepository {
	void save(String name);
	List<String> findAll();
}

@Repository
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

@Service
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

@RestController
class HelloController {
	private final MemberService memberService;

	public HelloController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/hello")
	public String hello() {
		memberService.join("김멋사");
		memberService.join("이멋사");
		return "Hello, Spring Boot! 회원 명단: " + memberService.findAll().toString();
	}
}

@Configuration
class AppConfig {
	// 수동 등록 방식 요건 충족을 위한 빈 클래스
}

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}