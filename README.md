# 🦁 Mission 06 - Spring Boot 전환 및 수동 빈 등록
**작성자: 양찬승**

## 🎯 과제 목표
- `Spring Initializr`를 활용하여 Spring Boot 프로젝트 환경을 구축하고 웹 의존성(`Spring Web`)을 구성합니다.
- 5주차 순수 자바 기반의 저장소 및 서비스 로직을 Spring Boot 환경으로 안정적으로 이전합니다.
- `@Configuration`과 `@Bean` 어노테이션을 사용하여 스프링 컨테이너에 객체를 직접 수동 등록하는 방식을 실습합니다.
- 생성자 주입 방식을 적용하여 의존성 주입(DI)을 처리하고, 웹 브라우저에서 확인할 수 있는 HTTP API를 구현합니다.

## 🛠️ 체크리스트 구현 항목
1. **Spring Boot 프로젝트 생성 및 환경 구축**
    - Java 17 및 Gradle 빌드 환경 기반의 Spring Boot 프로젝트를 연동했습니다.
2. **5주차 코드 구조 이전 및 수동 빈(Bean) 등록**
    - `@Configuration`이 선언된 `AppConfig` 클래스를 작성했습니다.
    - `memberRepository()`와 `memberService()` 메서드에 `@Bean`을 선언하여 스프링 컨테이너가 직접 객체를 관리하도록 수동 등록했습니다.
3. **생성자 주입을 통한 의존성 주입(DI)**
    - `MemberService`와 `HelloController`에 생성자 주입 패턴을 적용하여 타입 안정성과 결합도를 낮춘 설계를 반영했습니다.
4. **웹 API 구현 (`GET /hello`)**
    - `@RestController`와 `@GetMapping("/hello")`를 활용하여 컨트롤러를 구현했습니다.
    - 브라우저에서 접근 시 비즈니스 로직(회원가입 및 조회)이 정상 작동하며 회원 명단이 콘솔 및 웹 화면에 출력되도록 만들었습니다.

## 💻 실행 및 검증 방법
1. `DemoApplication` 클래스의 `main` 메서드를 실행합니다.
2. 내장 톰캣 서버가 구동되면 브라우저를 열고 `http://localhost:8080/hello`에 접속합니다.
3. 화면에 등록된 회원 명단(`Hello, Spring Boot! 회원 명단: [김멋사, 이멋사]`)이 정상적으로 출력되는지 확인합니다.