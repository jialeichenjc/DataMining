package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// This class implement ideas from the following paper:
// https://www.eecs.harvard.edu/~michaelm/postscripts/rsa2008.pdf
// To generate random number of hash functions
public class MinHash {

    // k is the number of hash functions
    // m is the mth hash
    public ArrayList<Integer> createMinHash(int inputSize, int m) {
        // sets capacity, not size
        ArrayList<Integer> hashedInput = new ArrayList<>(inputSize);
        for(int i = 0; i < inputSize; i++) {
            int val = (hash1(i) + m * hash2(i)) % 9973;
            hashedInput.add(val);
        }
        return hashedInput;
    }

    public float jaccardSimMinHash(ArrayList<Integer> sig1, ArrayList<Integer> sig2, int t) {
        // sig1 and 2 should both have size t.
        int sim = 0;
        for(int i = 0; i < sig1.size(); i++) {
            if(sig1.get(i) == sig2.get(i)) {
                sim++;
            }
        }
        return (float)sim/t;
    }
    public ArrayList<Integer> getMinHashSig(int m, ArrayList<String> inputUnion,
                                            HashSet<String> kGram) {

        ArrayList<Integer> hashSig = new ArrayList<Integer>(m);
        for(int i = 0; i < m; i++) {
            ArrayList<Integer> currMinHash = createMinHash(inputUnion.size(), i);
            int val = getMinHash(inputUnion, currMinHash, kGram);
            hashSig.add(val);
        }

        return hashSig;
    }

    public int getMinHash(ArrayList<String> input, ArrayList<Integer> hashedVals,
                          HashSet<String> kGram) {
        int minHashVal = input.size();
        for(int i = 0; i < input.size(); i++) {
            if(kGram.contains(input.get(i))) {
                minHashVal = Math.min(minHashVal, hashedVals.get(i));
            }
        }

        return minHashVal;
    }
    // (ax + b) mod p hash functions
    // with prime numbers a, b and p
    public int hash1(int n) {
        return (2459 * n + 17341) % 7979;
    }

    public int hash2(int n) {
        return (5119 * n + 10589) % 9677;
    }

    public ArrayList<String> createUnion(HashSet<String> s1, HashSet<String> s2) {
        HashSet<String> hashedUnion = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        Iterator<String> it1 = s1.iterator();
        Iterator<String> it2 = s2.iterator();
        while(it1.hasNext()) {
            hashedUnion.add(it1.next());
        }

        while(it2.hasNext()) {
            hashedUnion.add(it2.next());
        }
        Iterator<String> it3 = hashedUnion.iterator();
        while(it3.hasNext()) {
            res.add(it3.next());
        }

        return res;
    }

}
