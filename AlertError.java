import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.io.*;
import javax.swing.*;

public class Alert{//extends Frame

   

    public AlertError(){
        //new Alert();
        GridBagConstraints constraints = new GridBagConstraints();
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        JButton button = new JButton("Ok");
        JLabel label = new JLabel("ALERT!");
        JLabel label2 = new JLabel("Spending has exceeded monthly limit");


        constraints.gridx = constraints.gridy = 1;
        frame.add(label, constraints);
        constraints.gridy = 2;
        frame.add(label2, constraints);
        constraints.gridy = 3;
        frame.add(button,constraints);
        button.addActionListener(e -> {
            frame.dispose();
         });

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
