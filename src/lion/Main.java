package lion;

import java.util.*;

class Lion {
    // 1. 값이 한 번 정해지면 바뀌지 않으므로 final 권장
    private final String name;
    private final String part;

    public Lion(String name, String part) {
        this.name = name;
        this.part = part;
    }

    public String getName() { return name; }

    // 2. getPart()를 사용하여 경고를 제거함 (필터링 로직 등에서 활용)
    public String getPart() { return part; }

    @Override
    public String toString() {
        return "[" + part + "] " + name;
    }
}

public class Main {
    // 3. 리스트와 맵의 참조 주소가 바뀌지 않으므로 final 권장
    private static final List<Lion> lionList = new ArrayList<>();
    private static final Map<String, List<Lion>> partMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=== 멋쟁이사자처럼 미션 04: 클린 코드 버전 ===");

        registerMember("김멋사", "백엔드");
        registerMember("이멋사", "프론트엔드");
        registerMember("박멋사", "디자인");
        registerMember("최멋사", "백엔드");
        registerMember("김멋사", "백엔드"); // 중복 테스트

        searchByName("이멋사");
        filterByPart("백엔드");
        showAllGroupedMembers();
    }

    public static void registerMember(String name, String part) {
        // 중복 확인 로직
        for (Lion lion : lionList) {
            if (lion.getName().equals(name)) {
                System.out.println("[경고] 이미 등록된 멤버입니다: " + name);
                return;
            }
        }

        Lion newLion = new Lion(name, part);
        lionList.add(newLion);

        // 4. '람다 표현식' 또는 '메서드 참조'로 간결하게 변경
        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(newLion);
        System.out.println("[등록] " + newLion + " 등록 완료");
    }

    public static void searchByName(String name) {
        System.out.println("\n[검색] '" + name + "' 검색 결과:");
        lionList.stream()
                .filter(lion -> lion.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(
                        lion -> System.out.println("-> 찾았습니다: " + lion),
                        () -> System.out.println("-> 해당 이름의 멤버가 없습니다.")
                );
    }

    public static void filterByPart(String part) {
        System.out.println("\n[필터링] " + part + " 파트 멤버:");
        // getPart() 메서드를 실제 로직에서 사용하여 경고 해결
        lionList.stream()
                .filter(lion -> lion.getPart().equals(part))
                .forEach(lion -> System.out.println("-> " + lion.getName()));
    }

    public static void showAllGroupedMembers() {
        System.out.println("\n=== 파트별 전체 명단 (Map 활용) ===");
        partMap.forEach((part, members) -> System.out.println(part + ": " + members));
    }
}