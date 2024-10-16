import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Colors extends JFrame {
    private JList list;
    private static String[] colorNames = {"black", "blue", "red", "white"};
    private static  Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};

    public Colors(){
        super("Colors title Comes Here");
        setLayout(new FlowLayout());

        list = new JList(colorNames);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));

        list.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event) {
                        getContentPane().setBackground(colors[list.getSelectedIndex()]);
                    }
                }
        );
    }

}
