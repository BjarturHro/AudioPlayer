package hi.vinnsla;

import java.io.IOException;

public class Lagalistar {

    public static final String skra1 = "src/main/resources/hi/vidmot/media/Listi1.txt";

    private Lagalisti[] lagalisti = new Lagalisti[2];
    private int index = 0;

    public Lagalistar(){
        Lagalisti lagalisti1 = new Lagalisti();
        try {
            lagalisti1.lesaLog(skra1);
            add(lagalisti1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Lagalisti lagalisti){
        this.lagalisti[index] = lagalisti;
        index++;
    }

    public Lagalisti get(int index){
        return lagalisti[index];
    }
}

