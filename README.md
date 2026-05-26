# 🦁 Mission 06 - Spring Boot 전환
**작성자: 양찬승**

## 🎯 과제 요약
- `Spring Initializr`를 활용하여 기본 스프링 부트 프로젝트 환경을 구축했습니다.
- 순수 자바 기반의 저장소 및 서비스 로직을 각각 `@Repository`와 `@Service` 어노테이션을 활용해 스프링 빈(Bean)으로 전환했습니다.
- 생성자 주입 방식을 적용하여 스프링 컨테이너가 의존성을 자동으로 주입하도록 설계했습니다.
- `@RestController` 및 `@GetMapping`을 사용하여 웹 브라우저에서 회원 명단을 확인할 수 있는 `GET /hello` API를 구현했습니다.