import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
public class events extends JFrame {
    private JTextField itemOne;
    private JTextField itemTwo;
    private JTextField itemThree;
    private JPasswordField passwordField;

    public events(){
        super("Title comes here");
        setLayout(new FlowLayout());

        itemOne = new JTextField(10);
        add(itemOne);
        itemTwo = new JTextField("Enter Your text Here");
        add(itemTwo);
        itemThree = new JTextField("uneditabale text here");
        itemThree.setEditable(false);
        add(itemThree);

        passwordField = new JPasswordField("Password");
        add(passwordField);

        theHandler handler = new theHandler();
        itemOne.addActionListener(handler);
        itemTwo.addActionListener(handler);
        itemThree.addActionListener(handler);
        passwordField.addActionListener(handler);
    }
    private class theHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String string = "";
            if(event.getSource() == itemOne)
                string = String.format("Field One: %s", event.getActionCommand());
            else if(event.getSource() == itemTwo)
                string = String.format("Field Two: %s", event.getActionCommand());
            else if(event.getSource() == itemThree)
                string = String.format("Field Three: %s", event.getActionCommand());
            else if(event.getSource() == passwordField)
                string = String.format("Your password is : %s", event.getActionCommand());

            JOptionPane.showMessageDialog(null, string);
        }
    }
}
