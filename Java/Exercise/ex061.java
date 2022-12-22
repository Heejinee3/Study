public class ex061 {
    public static void main(String[] args) {

        // 정렬 알고리즘
        // 대표적인 방법: 버블 정렬, 선택 정렬, 삽입 정렬

        // 1. 버블정렬
        // 모든 자릿수를 오른쪽 자리와 비교해서 맞교환(치환)하는 방식

        int[] numbers = {9, 8, 1, 3, 2};

        // 연습문제 42-1.
        // 모든 자릿수를 비교해보자.
        /*
        9:8 9:1 9:3 9:2
        8:1 8:3 8:2
        1:3 1:2
        3:2
        */

        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                System.out.print(numbers[i] + ":");
                System.out.print(numbers[j] + " ");
            }
            System.out.println();
        }

        // 연습문제 43-1.
        // 버블정렬-오름차순을 구현해보자. 모든 자릿수를 비교해서 오른쪽 값이 더 작으면 치환한다.

        // 정렬
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                if (numbers[i] > numbers[j]){
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        // 정렬된 배열 출력
        System.out.println("정렬된 배열: ");
        for (int j: numbers) {
            System.out.print(j + " ");
        }
        System.out.println();

    }
}
