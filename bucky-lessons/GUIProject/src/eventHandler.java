import javax.swing.JFrame;
public class eventHandler {
    public static void main(String[] args){
        events eventsObject = new events();
        eventsObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventsObject.setSize(600, 400);
        eventsObject.setVisible(true);
    }
}
