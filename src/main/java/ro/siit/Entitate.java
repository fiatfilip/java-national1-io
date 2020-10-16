package ro.siit;

import java.io.Serializable;

public class Entitate implements Serializable {
    public static final long serialVersionUID = -5297240882726245937L;
    private transient String p1;
    private String p2;
    private transient Subentitate p3;

    public Entitate(String p1, String p2, Subentitate p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    public Subentitate getP3() {
        return p3;
    }
}
