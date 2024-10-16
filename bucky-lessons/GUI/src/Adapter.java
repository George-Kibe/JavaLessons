import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Adapter extends JFrame{
    private String details;
    private JLabel statusBar;

    public Adapter(){
        super("This is the adapter Tile");

        statusBar = new JLabel("This is the default Label");
        add(statusBar, BorderLayout.SOUTH);
        addMouseListener(new MouseClass());
    }
    private class MouseClass extends MouseAdapter{
        public void mouseClicked(MouseEvent event){
            details = String.format("You clicked %d", event.getClickCount());
            if(event.isMetaDown())
                details += "With right mouse Button";
            else if(event.isAltDown())
                details += "With Center mouse Button";
            else
                details += "With Left Mouse Button";
            statusBar.setText(details);
        }
    }
}
