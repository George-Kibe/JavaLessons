import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Combo extends JFrame {
    private JComboBox box;
    private JLabel picture;

    private static String[] filenames = {"avatar.png", "flowers.png"};
    private Icon[] pics = {new ImageIcon(getClass().getResource(filenames[0])), new ImageIcon(getClass().getResource(filenames[1]))};

    public Combo(){
        super("Combo title Comes Here");
        setLayout(new FlowLayout());

        box = new JComboBox(filenames);
        box.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED)
                            picture.setIcon(pics[box.getSelectedIndex()]);
                    }
                }
        );
        add(box);
        picture = new JLabel(pics[0]);
        add(picture);
    }
}
