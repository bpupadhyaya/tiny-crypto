package com.crypto.tiny;

public class TinyBlockChain {
    public static void main(String... args) {
        Block beginningBlock = new Block("the first block", "0");
        System.out.println("Hash for block 1 : " + beginningBlock.hash);

        Block secondBlock = new Block("the second block",beginningBlock.hash);
        System.out.println("Hash for block 2 : " + secondBlock.hash);

        Block thirdBlock = new Block("the third block",secondBlock.hash);
        System.out.println("Hash for block 3 : " + thirdBlock.hash);
    }
}
