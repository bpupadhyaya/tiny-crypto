package com.crypto.tiny;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class TinyBlockChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static void main(String... args) {
        Block beginningBlock = new Block("The first block", "0");
        System.out.println("Hash for block 1 : " + beginningBlock.hash);

        Block secondBlock = new Block("The second block",beginningBlock.hash);
        System.out.println("Hash for block 2 : " + secondBlock.hash);

        Block thirdBlock = new Block("The third block",secondBlock.hash);
        System.out.println("Hash for block 3 : " + thirdBlock.hash);

        blockchain.add(new Block("The first block", "0"));
        blockchain.add(new Block("The second block",blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("The third block",blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}
