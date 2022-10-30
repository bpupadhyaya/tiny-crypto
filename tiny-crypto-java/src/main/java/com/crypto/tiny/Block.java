package com.crypto.tiny;
/*
  source: https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 */
import java.util.Date;

/*
    Difficulty, this is the number of 0’s they must solve for. Low difficulty like 1 or 2 can be solved nearly
    instantly on most computers, suggest something around 4–6 for testing. As of Dec 2017,  Litecoin’s
    difficulty was around 442,592.
*/

// Proof of Work
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp; //as number of milliseconds since 1/1/1970
    private int nonce;

    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = HashUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty  "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

}
