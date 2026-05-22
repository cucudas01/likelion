package lion;

import java.util.ArrayList;
import java.util.List;

// [조건 1] Repository 인터페이스 정의
interface MemberRepository {
    void save(String name);
    List<String> findAll();
}

// [조건 2] 구현체 1: 메모리 저장소
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

// [조건 2] 구현체 2: 테스트용 가짜 저장소 (Mock)
class MockRepository implements MemberRepository {
    private final List<String> mockStore = new ArrayList<>();

    public MockRepository() {
        // 테스트용 데이터 미리 세팅
        mockStore.add("테스트용_아기사자");
    }

    @Override
    public void save(String name) {
        System.out.println("[Mock] 가짜 저장소이므로 저장하지 않습니다: " + name);
    }

    @Override
    public List<String> findAll() {
        return mockStore;
    }
}

// [조건 3 & 4] Service 클래스가 인터페이스에 의존하고, 생성자로 주입받는 구조
class MemberService {
    private final MemberRepository memberRepository;

    // 생성자 주입 (Constructor Injection)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(String name) {
        memberRepository.save(name);
        System.out.println("[회원가입] " + name + " 등록 완료!");
    }

    public void showAllMembers() {
        System.out.println("--- 회원 명단 출력 ---");
        for (String name : memberRepository.findAll()) {
            System.out.println("회원: " + name);
        }
    }
}

// [조건 5] AppConfig 설정 클래스에서 객체를 생성하고 조립함
class AppConfig {
    // 실제 운영 환경 조립 (MemoryRepository 사용)
    public MemberService memberService() {
        return new MemberService(new MemoryRepository());
    }

    // 상황에 따라 MockRepository로 갈아끼우고 싶다면 아래처럼 변경 가능
    public MemberService mockMemberService() {
        return new MemberService(new MockRepository());
    }
}

// [조건 6] 실행 클래스: 직접 new 하지 않고 AppConfig를 통해 객체 생성
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 멋쟁이사자처럼 미션 05: IoC/DI 시스템 ===");

        // 1. 객체의 생성과 조립을 담당하는 설정 객체 생성
        AppConfig appConfig = new AppConfig();

        // 2. main에서 직접 new MemberService(...) 하지 않고 AppConfig를 통해 가져옴
        MemberService memberService = appConfig.memberService();

        // 3. 비즈니스 로직 실행
        memberService.join("김멋사");
        memberService.join("이멋사");
        memberService.showAllMembers();

        System.out.println("\n=== [테스트] 다른 구현체(Mock)로 외부에서 조립 변경 ===");
        MemberService mockService = appConfig.mockMemberService();
        mockService.join("박멋사");
        mockService.showAllMembers();
    }
}