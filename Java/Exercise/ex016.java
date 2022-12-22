public class ex016 {
    public static void main(String[] args) {

        // ++i : +1이 먼저되고, 그 다음 연산이 수행
        // i++ : 다음줄로 넘어가면서 +1이 됨

        int i = 10;
        i++;
        ++i;
        System.out.println(i);

        i = 10;
        System.out.println(i++); // System.out.println(i) => i = i + 1
        System.out.println(i);
        System.out.println(++i); // i = i + 1 => System.out.println(i)
        System.out.println(i);

        i = 10;
        System.out.println(i++ * i-- / ++i);

    }
}
