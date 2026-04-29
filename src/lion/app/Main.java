package lion.app;

import lion.domain.Lion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("전공을 입력하세요: ");
        String major = sc.nextLine();
        System.out.print("기수를 입력하세요: ");
        int ordinal = sc.nextInt();

        // Step 1: 메인에서 직접 유효성 검사
        System.out.println("\n[Step 1] 메인에서 직접 검사 수행");
        if (name.isEmpty() || major.isEmpty() || ordinal < 1) {
            System.out.println("잘못된 입력입니다. 객체를 생성하지 않습니다.");
        } else {
            Lion lion1 = new Lion(name, major, ordinal);
            lion1.showInfo();
        }

        // Step 2: Lion 클래스 내부 메서드로 검사 (책임 분리)
        System.out.println("\n[Step 2] Lion 클래스 메서드로 검사 수행");
        if (Lion.check(name, major, ordinal)) {
            Lion lion2 = new Lion(name, major, ordinal);
            lion2.showInfo();
        } else {
            System.out.println("유효하지 않은 정보입니다.");
        }
    }
}