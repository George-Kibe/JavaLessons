public class Animals {
    public static void main(String[] args){
        AnimalList ALO = new AnimalList();
        Dog d = new Dog();
        Fish f = new Fish();
        ALO.add(d); // or ALO[0] = d;
        ALO.add(f); // or ALO[1] = f;
    }
}
