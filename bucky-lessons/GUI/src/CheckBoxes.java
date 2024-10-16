import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckBoxes extends JFrame {
    private JTextField tf;
    private JCheckBox boldBox;
    private JCheckBox italicBox;

    public CheckBoxes(){
        super("Title Comes Here");
        setLayout(new FlowLayout());

        tf = new JTextField("This is a sentence");
        tf.setFont(new Font("Serif", Font.PLAIN, 14));
        add(tf);

        boldBox = new JCheckBox("Bold");
        italicBox = new JCheckBox("Italic");
        add(boldBox);
        add(italicBox);

        HandlerClass handler = new HandlerClass();
        boldBox.addItemListener(handler);
        italicBox.addItemListener(handler);
    }
    private class HandlerClass implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            Font font = null;

            if(boldBox.isSelected() && italicBox.isSelected()){
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            }else if(boldBox.isSelected()){
                font = new Font("Serif", Font.BOLD, 14);
            }else if(italicBox.isSelected()){
                font = new Font("Serif", Font.ITALIC, 14);
            }else
                font = new Font("Serif", Font.PLAIN, 14);

            tf.setFont(font);
        }
    }
}
