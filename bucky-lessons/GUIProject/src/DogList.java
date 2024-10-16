public class DogList {
    private Dog[] dogsList = new Dog[5];
    private int i=0;

    public void add(Dog d){
        if (i < dogsList.length){
            dogsList[i] = d;
            System.out.println("Dog added at index " + i);
            i++;
        }
    }
}
