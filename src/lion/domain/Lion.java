package lion.domain;

public class Lion {
    // 세 필드 접근 제어자를 다르게 설정함
    public String name;
    String major; // default
    private int ordinal;

    // 생성자 (출력문 없음)
    public Lion(String name, String major, int ordinal) {
        this.name = name;
        this.major = major;
        this.ordinal = ordinal;
    }

    // Step 2용 유효성 검사 메서드
    public static boolean check(String name, String major, int ordinal) {
        if (name.isEmpty() || major.isEmpty() || ordinal < 1) {
            return false;
        }
        return true;
    }

    public void showInfo() {
        System.out.println("이름: " + name + ", 전공: " + major + ", 기수: " + ordinal);
    }
}