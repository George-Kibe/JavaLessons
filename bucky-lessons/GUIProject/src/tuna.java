import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class tuna extends JFrame {
    private JLabel itemOne;

    public tuna(){
        super("The title bar");
        setLayout(new FlowLayout());

        itemOne = new JLabel("This is a sentence");
        itemOne.setToolTipText("Sentence tooltip on hover");
        add(itemOne);
    }
}
