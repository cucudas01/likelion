package lion.test;

import lion.domain.Lion;

public class AccessTest {
    public static void main(String[] args) {
        // 다른 패키지에서 객체 생성
        Lion lion = new Lion("박길동", "인공지능공학부", 14);

        // Step 3: 접근 제어자 테스트 (직접 접근 시도)
        System.out.println("이름(public): " + lion.name); // 정상

        // 아래 필드들은 접근이 불가능하여 주석 처리함
        // System.out.println(lion.major);   // default: 다른 패키지라 에러
        // System.out.println(lion.ordinal); // private: 클래스 밖이라 에러

        System.out.println("테스트 완료: public 외에는 외부 패키지에서 접근할 수 없음.");
    }
}