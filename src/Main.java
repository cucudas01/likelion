import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        // 1 & 2. Scanner로 아기사자 수 입력받기 및 유효성 검사 (5 미만 시 재입력)
        while (true) {
            System.out.print("아기사자 수를 입력하세요 (5명 이상): ");
            count = scanner.nextInt();

            if (count >= 5) {
                break; // 5 이상이면 반복문 탈출
            } else {
                System.out.println("5 미만은 입력할 수 없습니다. 다시 입력해주세요.");
            }
        }

        // 3. 입력받은 수만큼 배열 생성
        String[] babyLions = new String[count];
        scanner.nextLine(); // 숫자 입력 후 남은 엔터값을 제거하기 위한 코드

        // 4. 반복문으로 아기사자 이름을 입력받아 배열에 저장
        System.out.println(count + "명의 아기사자 이름을 입력하세요.");
        for (int i = 0; i < babyLions.length; i++) {
            System.out.print((i + 1) + "번째 아기사자 이름: ");
            babyLions[i] = scanner.nextLine();
        }

        // 5. 최종 명단을 순회하며 출력
        System.out.println("\n--- 최종 아기사자 명단 ---");
        for (int i = 0; i < babyLions.length; i++) {
            System.out.println((i + 1) + "번 아기사자: " + babyLions[i]);
        }

        System.out.println("\n프로그램을 종료합니다.");
        scanner.close();
    }
}