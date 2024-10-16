import javax.swing.JFrame;
public class apples {
    public static void main(String[] args){
        Adapter go = new Adapter();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(500, 300);
        go.setVisible(true);
    }
}

// ButtonsGui
class checkboxes {
    public static void main(String[] args){
        CheckBoxes go = new CheckBoxes();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(500, 300);
        go.setVisible(true);
    }
}
class gui {
    public static void main(String[] args){
        ButtonsGui go = new ButtonsGui();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(500, 300);
        go.setVisible(true);
    }
}
