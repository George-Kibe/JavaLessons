public class foods {
    public static void main (String[] args) {
        food[] bucky = new food[2];
        bucky[0] = new potpie();
        bucky[1] = new tunaOne();

        for (int x=0; x<2; x++)
            bucky[x].eat();
    }
}

class poly {
    public static void main (String[] args){
        fatty bucky = new fatty();
        // food foodOne = new food();
        potpie potpieOne = new potpie();

        bucky.digest(potpieOne);
    }
}
