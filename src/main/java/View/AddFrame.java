package View;

import Controller.TaskManagerController;
import Model.ArrayTaskList;
import Model.TaskInfo;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddFrame extends TaskManagerGUI{
    private JCheckBox boxRepeated;
    private JTextField txfTitle;
    private static final Logger log = Logger.getLogger(TaskManagerController.class);

    AddFrame(TaskManagerController controller) throws HeadlessException {
        super();
        setController(controller);
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 70, 300, 140);
        addElements();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    protected void addElements(){
        panel = new JPanel();
        panel.setBackground( new Color(255, 255,255 ) );
        gridBagLayout = new GridBagLayout();
        gridBag = new GridBagConstraints();
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
        JLabel lbTitle = new JLabel("Title");
        lbTitle.setFont(new Font("TimesRoman", Font.PLAIN, 18));

        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTitle, gridBag );
        panel.add(lbTitle);

        boxRepeated = new JCheckBox( "Task is repeated", false  );
        boxRepeated.setBackground(new Color(255, 255,255 ));
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

        JButton btNext = new JButton("Next");
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btNext, gridBag );
        panel.add(btNext);
        btNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (TaskInfo.isNameIncorrect(txfTitle.getText())){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Enter task's title");
                    log.error("Title cannot be blank");
                } else {
                    if (boxRepeated.isSelected()) {
                        AddRepeatedTaskFrame addFrame = new AddRepeatedTaskFrame(txfTitle.getText(), controller);
                    } else {
                        AddNotRepeatedTaskFrame addFrame = new AddNotRepeatedTaskFrame(txfTitle.getText(), controller);
                    }
                    dispose();
                }
            }
        });
        this.add(panel);
    }
}
