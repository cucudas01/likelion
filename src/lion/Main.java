package lion; // 1. 패키지 경로

// 인터페이스 정의
interface WorkPolicy {
    void performTask();
}

// 추상 클래스 정의
abstract class Member implements WorkPolicy {
    protected String name;
    protected String role;

    public Member(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.print("안녕하세요, 저는 " + role + " 역할을 맡은 " + name + "입니다. ");
    }

    // 하위 클래스에서 반드시 구현해야 할 추상 메서드
    @Override
    public abstract void performTask();
}

// 하위 클래스 1: 백엔드
class BackendMember extends Member {
    public BackendMember(String name) {
        super(name);
        this.role = "백엔드";
    }

    @Override
    public void performTask() {
        System.out.println("API 설계 및 데이터베이스 관리를 수행합니다.");
    }
}

// 하위 클래스 2: 프론트엔드
class FrontendMember extends Member {
    public FrontendMember(String name) {
        super(name);
        this.role = "프론트엔드";
    }

    @Override
    public void performTask() {
        System.out.println("UI/UX 개발 및 사용자 인터페이스 구현을 수행합니다.");
    }
}

// 하위 클래스 3: 디자인
class DesignerMember extends Member {
    public DesignerMember(String name) {
        super(name);
        this.role = "디자인";
    }

    @Override
    public void performTask() {
        System.out.println("피그마를 활용한 와이어프레임 제작 및 디자인 에셋을 생성합니다.");
    }
}

// 실행 클래스 (파일 이름과 반드시 일치해야 함)
public class Main {
    public static void main(String[] args) {
        Member[] team = {
                new BackendMember("김멋사"),
                new FrontendMember("이멋사"),
                new DesignerMember("박멋사")
        };

        System.out.println("=== 멋쟁이사자처럼 팀 업무 보고 ===");

        for (Member member : team) {
            member.introduce();
            member.performTask(); // 여기서 메서드를 호출하므로 '사용되지 않음' 경고가 사라집니다.
        }
    }
}