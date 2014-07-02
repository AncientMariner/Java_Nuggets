package org.xander;

public class BinaryLiterals {
    private static boolean isFifthBitSet(int i) {
        byte mask = (byte) 16; // 10000
        return (i & mask) == mask; // 1010011 && 10000 == 10000
    }

    private static boolean isFifthBitSetInEasyWay(int i) {
        byte mask = 0b10000;
        return (i & mask) == mask;
    }
}
