import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEvents extends JFrame {
    private JPanel mousePanel;
    private JLabel statusBar;

    public MouseEvents(){
        super("Mouse Events Title");

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Default Page T");
        add(statusBar, BorderLayout.SOUTH);

        HandlerClass handler = new HandlerClass();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    }
    private class HandlerClass implements  MouseListener, MouseMotionListener{
        public void mouseClicked(MouseEvent event){
            statusBar.setText(String.format("Clicked at %d %d", event.getX(), event.getY()));
        }
        public void mousePressed(MouseEvent event){
            statusBar.setText("You Pressed Down the Mouse");
        }
        public void mouseReleased(MouseEvent event){
            statusBar.setText("You Released the button");
        }
        public void mouseEntered(MouseEvent event){
            statusBar.setText("You Entered the Area");
            mousePanel.setBackground(Color.RED);
        }
        public void mouseExited(MouseEvent event){
            statusBar.setText("The Mouse has left the window");
            mousePanel.setBackground(Color.BLACK);
        }
        // Mouse Motion events
        public void mouseDragged(MouseEvent event){
            statusBar.setText("You are Dragging the Mouse");
        }
        public void mouseMoved(MouseEvent event){
            statusBar.setText("You released the Mouse");
        }
    }
}
