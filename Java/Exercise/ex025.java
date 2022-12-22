public class ex025 {
    public static void main(String[] args) {

        // 연습문제 10-1.
        // i 값이 10보다 큰가?
        int i = 20;
        boolean ans = i > 10;
        System.out.println(ans);

        // 연습문제 10-2.
        // i 값이 10보다 작은가?
        ans = i < 10;
        System.out.println(ans);

        // 연습문제 10-3.
        // i 값이 10보다 크고 30보다 작은가?
        ans = i > 10 && i < 30;
        System.out.println(ans);

        // 연습문제 10-4.
        // i 값이 30과 같거나 작은가?
        ans = i <= 30;
        System.out.println(ans);

        // 연습문제 10-5.
        // i 값이 15와 30 사이인가?
        ans = i >= 15 && i <= 30;
        System.out.println(ans);

        // 연습문제 10-6.
        // i 값이 10보다 크면서 30보다 작은가?
        ans = i > 10 && i < 30;
        System.out.println(ans);

        // 연습문제 10-7.
        // i 값이 10 이상이고 30 미만인가?
        ans = i >= 10 && i < 30;
        System.out.println(ans);

        // 연습문제 10-8.
        // i 값이 10 초과이거나 30 이하인가?
        ans = i > 10 || i <= 30;
        System.out.println(ans);

        // 연습문제 10-9.
        // 10은 4의 배수인가?
        ans = 10 % 4 == 0;
        System.out.println(ans);

        // 연습문제 10-10.
        // 10은 5의 배수이면서 2의 배수인가?
        ans = (10 % 5 == 0) && (10 % 2 == 0);
        System.out.println(ans);

        // 연습문제 11
        // 철수가 시장에 갔다. 사과를 한개 사려는데, 사과값이 1000원 단위이면 사고, 아니면 안살려고 한다. (잔돈을 만들고 싶지 않다)
        // 그리고 5000원 이상이면 안살려고 한다. 사과 값이 3000원일 때, 살지 안살지를 true, false로 표현하시오.
        int price = 3000;
        ans = (price % 1000 == 0) && (price < 5000);
        System.out.println(ans);

    }
}
