public class ex017 {
    public static void main(String[] args) {

        // ~ 연산자 : 비트반전 연산자 0->1 1->0
        // ! 연산자 : 논리반전 연산자 true->false false->true

        int i = 15;
        System.out.println(Integer.toBinaryString(i));

        i = ~i;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);

    }
}
