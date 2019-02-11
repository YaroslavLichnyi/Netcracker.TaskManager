package View;

import Controller.TaskManagerController;
import Model.ArrayTaskList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFrame extends JFrame{
   // ArrayTaskList arr;
   // Dimension dimension;
    // ArrayTaskList arr, Dimension dimension
   TaskManagerController taskManagerController;
   JCheckBox boxRepeated;

    JTextField txfTitle;
    JLabel lbTitle;

    JLabel lbIsRepeated;
    JButton btNext;

    public AddFrame(final TaskManagerController controller) throws HeadlessException {

        super("Task Manager");
        taskManagerController = controller;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 70, 300, 140);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        //creating panel
        JPanel panel = new JPanel();
        panel.setBackground( new Color(255, 255,255 ) );

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBag = new GridBagConstraints();
        panel.setLayout( gridBagLayout );

        txfTitle = new JTextField( );
        txfTitle.setForeground(new Color( 0,128,255 ));
        gridBag.gridx = 0;
        gridBag.gridy = 1;
        gridBag.gridwidth = 3;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.SOUTH;
        gridBagLayout.setConstraints( txfTitle, gridBag );
        panel.add( txfTitle );

        lbTitle = new JLabel( "Title"  );
        lbTitle.setFont(new Font("TimesRoman", Font.PLAIN, 18));

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbTitle, gridBag );
        panel.add( lbTitle );

        boxRepeated = new JCheckBox( "Task is repeated", false  );
        boxRepeated.setBackground(new Color(255, 255,255 ) );
        gridBag.gridx = 1;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( boxRepeated, gridBag );
        panel.add( boxRepeated );

        btNext = new JButton( "Next"  );
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( btNext, gridBag );
        panel.add( btNext );
        this.add(panel);

        btNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txfTitle.getText().length()<2){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Too short title");
                } else {
                    if (boxRepeated.isSelected()) {
                        AddRepeatedTaskFrame addFrame = new AddRepeatedTaskFrame(txfTitle.getText(), taskManagerController);
                    } else {
                        AddNotRepeatedTaskFrame addFrame = new AddNotRepeatedTaskFrame(txfTitle.getText(), taskManagerController);
                    }
                    dispose();
                }
            }
        });
        this.setVisible(true);
    }
}
