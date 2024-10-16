import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Foods extends JFrame {
    private JList leftList;
    private JList rightList;
    private JButton moveButton;
    private static String[] foods = {"Bacon", "Wings", "Ham", "Beef", "Pork", "Pizza"};

    public Foods(){
        super("Foods Title Comes Here");
        setLayout(new FlowLayout());

        leftList = new JList(foods);
        leftList.setVisibleRowCount(3);
        leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(leftList));

        moveButton = new JButton("MOVE -->");
        moveButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                        rightList.setListData(leftList.getSelectedValues());
                    }
                }
        );
        add(moveButton);
        rightList = new JList();
        rightList.setVisibleRowCount(3);
        rightList.setFixedCellWidth(200);
        rightList.setFixedCellHeight(20);
        rightList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(rightList));
    }
}
