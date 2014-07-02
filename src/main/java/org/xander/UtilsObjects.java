package org.xander;

public class UtilsObjects {
    void foo(String s) {
        if(s == null) throw new NullPointerException("s is null");
    }

    public static void main(String[] args) {
        UtilsObjects r = new UtilsObjects();
//        log.debug("Got" + r == null ? "null" : r.toString());


        UtilsObjects r1 = new UtilsObjects();
//        debug("Got" + Objects.toString(r1, "got it"));

    }
}
