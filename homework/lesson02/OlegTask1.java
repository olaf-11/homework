package lesson02;

public class OlegTask1 {
    public static void main(String[] args) {
        int a = 42;
        int b = 15;
        int x = -42;
        int y = -15;

        /* Побитовый унарный оператор NOT (~) */
        a = ~a; // ~ 0010 1010 (42)  = 1101 0101 (-43)
        b = ~b; // ~ 0000 1111 (15)  = 1111 0000 (-16)
        x = ~x; // ~ 1101 0110 (-42) = 0010 1001 (41)
        y = ~y; // ~ 1111 0001 (-15) = 0000 1110 (14)
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        /* Воостанавливаем начальные значения */
        a = 42;
        b = 15;
        x = -42;
        y = -15;

        /* Побитовый AND (&)
         * Побитовый AND с присваиванием (&=)
         * Выражение:   a = a & b   аналогично выражению:  a &= b */
        a &= b; // 0010 1010 (42)  & 0000 1111 (15)  = 0000 1010 (10)
        x &= y; // 1101 0110 (-42) & 1111 0001 (-15) = 1101 0000 (-48)
        System.out.println("\na = " + a);
        System.out.println("x = " + x);

        /* Воостанавливаем начальные значения */
        a = 42;
        x = -42;

        /* Побитовый OR (|)
         * Побитовый OR с присваиванием (|=)
         * Выражение:   a = a | b   аналогично выражению:  a |= b */
        a |= b; // 0010 1010 (42)  | 0000 1111 (15)  = 0010 1111 (47)
        x |= y; // 1101 0110 (-42) | 1111 0001 (-15) = 1111 0111 (-9)
        System.out.println("\na = " + a);
        System.out.println("x = " + x);

        /* Воостанавливаем начальные значения */
        a = 42;
        x = -42;

        /* Побитовый XOR (^)
         * Побитовый XOR с присваиванием (^=)
         * Выражение:   a = a ^ b   аналогично выражению:  a ^= b */
        a ^= b; // 0010 1010 (42)  ^ 0000 1111 (15)  = 0010 0101 (37)
        x ^= y; // 1101 0110 (-42) ^ 1111 0001 (-15) = 0010 0111 (39)
        System.out.println("\na = " + a);
        System.out.println("x = " + x);

        /* Воостанавливаем начальные значения */
        a = 42;
        x = -42;

        /* Сдвиг вправо (>>)
         * Сдвиг вправо с присваиванием (>>=)
         * Выражение:   a = a >> 2   аналогично выражению:  a >>= 2 */
        a >>= 2; // 00000000 00000000 00000000 00101010 (42)  >> 2 = 00000000 00000000 00000000 00001010 (10)
        b >>= 2; // 00000000 00000000 00000000 00001111 (15)  >> 2 = 00000000 00000000 00000000 00000011 (3)
        x >>= 2; // 11111111 11111111 11111111 11010110 (-42) >> 2 = 11111111 11111111 11111111 11110101 (-11)
        y >>= 2; // 11111111 11111111 11111111 11110001 (-15) >> 2 = 11111111 11111111 11111111 11111100 (-4)
        System.out.println("\na = " + a);
        System.out.println("b = " + b);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        /* Воостанавливаем начальные значения */
        a = 42;
        b = 15;
        x = -42;
        y = -15;

        /* Сдвиг вправо с заполнением нулями (>>>)
         * Сдвиг вправо с заполнением нулями и с присваиванием (>>>=)
         * Выражение:   a = a >>> 2   аналогично выражению:  a >>>= 2 */
        a >>>= 2; // 00000000 00000000 00000000 00101010 (42)  >>> 2 = 00000000 00000000 00000000 00001010 (10)
        b >>>= 2; // 00000000 00000000 00000000 00001111 (15)  >>> 2 = 00000000 00000000 00000000 00000011 (3)
        x >>>= 7; // 11111111 11111111 11111111 11010110 (-42) >>> 7 = 00000001 11111111 11111111 11111111 (33 554 431)
        y >>>= 2; // 11111111 11111111 11111111 11110001 (-15) >>> 2 = 00111111 11111111 11111111 11111100 (1 073 741 820)
        System.out.println("\na = " + a);
        System.out.println("b = " + b);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        /* Воостанавливаем начальные значения */
        a = 42;
        b = 15;
        x = -42;
        y = -15;

        /* Сдвиг влево (<<)
         * Сдвиг влево с присваиванием (<<=)
         * Выражение:   a = a << 2   аналогично выражению:  a <<= 2 */
        a <<= 2; // 00000000 00000000 00000000 00101010 (42)  << 2 = 00000000 00000000 00000000 10101000 (168)
        b <<= 4; // 00000000 00000000 00000000 00001111 (15)  << 2 = 00000000 00000000 00000000 11110000 (240)
        x <<= 7; // 11111111 11111111 11111111 11010110 (-42) << 7 = 11111111 11111111 11101011 00000000 (-5 376)
        y <<= 4; // 11111111 11111111 11111111 11110001 (-15) << 2 = 11111111 11111111 11111111 00010000 (-240)
        System.out.println("\na = " + a);
        System.out.println("b = " + b);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
