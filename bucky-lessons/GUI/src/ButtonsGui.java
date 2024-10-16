import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonsGui extends JFrame{
    private JTextField tf;
    private Font pf;
    private Font bf;
    private  Font itf;
    private Font bif;
    private JRadioButton pb;
    private JRadioButton bb;
    private JRadioButton ib;
    private JRadioButton bib;
    private ButtonGroup group;

    public ButtonsGui(){
        super("Radio Buttons testing in Java");
        setLayout(new FlowLayout());

        tf = new JTextField("Random awesome sentence");
        add(tf);

        pb = new JRadioButton("plain", true);
        bb = new JRadioButton("bold", true);
        ib = new JRadioButton("italic", true);
        bib = new JRadioButton("bold and italic", true);

        add(pb);
        add(bb);
        add(ib);
        add(bib);

        group = new ButtonGroup();
        group.add(pb);
        group.add(bb);
        group.add(ib);
        group.add(bib);

        pf = new Font("Serif", Font.PLAIN, 14);
        bf = new Font("Serif", Font.BOLD, 14);
        itf = new Font("Serif", Font.ITALIC, 14);
        bif = new Font("Serif", Font.ITALIC + Font.BOLD, 14);

        // wait for event to happen and then pass in font to constructor
        pb.addItemListener(new HandlerClass(pf));
        bb.addItemListener(new HandlerClass(bf));
        ib.addItemListener(new HandlerClass(itf));
        bib.addItemListener(new HandlerClass(bif));

    }
    private class HandlerClass implements ItemListener{
        private Font font;
        // the font object gets variable font
        public HandlerClass(Font f){
            font = f;
        }
        public void itemStateChanged(ItemEvent event){
            tf.setFont(font);
        }
    }
}
