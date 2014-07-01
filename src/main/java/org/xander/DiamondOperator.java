package org.xander;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DiamondOperator {
    public static void main(String[] args) {
        //before jdk 1.7
        HashMap<String, Set<List<String>>> stringSetHashMap16 = new HashMap<String, Set<List<String>>>();
        HashMap<String, Set<List<String>>> stringSetHashMap17 = new HashMap<>();
        //unchecked warning, bad way
        HashMap<String, Set<List<String>>> stringSetHashMap = new HashMap();
    }
}
