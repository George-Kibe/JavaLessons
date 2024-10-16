public class AnimalList {
    private Animal[] animalsList = new Animal[10];
    private int i = 0;

    public void add(Animal a){
        if( i < animalsList.length){
            animalsList[i] = a;
            System.out.println("Animal added at index " + i);
            i++;
        }
    }
}
