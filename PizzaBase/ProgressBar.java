package PizzaBase;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;
 
public class ProgressBar extends JPanel implements ActionListener, PropertyChangeListener {
 
    private JFrame frame = new JFrame();
    private JProgressBar progressBar;
    private JButton button;
    private JLabel label;
    private Task task;

    private Prefab prefab = new Prefab();
    private DoItYourself diy = new DoItYourself();
    private Beverage beverage = new Beverage();
    private Order order;
 
    class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += 1;
                setProgress(Math.min(progress, 100));
            }
            return null;
        }
 
        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            button.setEnabled(true);
            setCursor(null); //turn off the wait cursor
            label.setText("Finished Serving!");
        }
    }
 
    public ProgressBar(Order order) {
        super(new BorderLayout());

        this.order = order;
 
        //Create the demo's UI.
        button = new JButton("Get Bill");
        button.setEnabled(false);
        button.setFocusable(false);
        button.addActionListener(this);
 
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
 
        label = new JLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
 
        add(progressBar, BorderLayout.PAGE_START);
        add(label, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.PAGE_END);

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
 
    }
 
    /**
     * Invoked when the user presses the start button.
     */
    public void actionPerformed(ActionEvent evt) {
        CustomerBill customerBill = new CustomerBill();
        customerBill.setBill(new Bill(order));
        customerBill.getbill();
        customerBill.setVisible(true);

        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
 
    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);

            if(order.getPizza().size() > 0 && order.getBeverage().size() > 0){
                if(0 < progress && progress < 10){
                    label.setText("Preparing Equipments...");
                }else if(10 < progress && progress < 20){
                    label.setText(prefab.prepare());
                }else if(20 < progress && progress < 30){
                    label.setText(diy.prepare());
                }else if(30 < progress && progress < 40){
                    label.setText(beverage.prepare());
                }else if(40 < progress && progress < 50){
                    label.setText(prefab.process());
                }else if(50 < progress && progress < 60){
                    label.setText(diy.process());
                }else if(60 < progress && progress < 70){
                    label.setText(beverage.process());
                }else if(70 < progress && progress < 80){
                    label.setText(prefab.serve());
                }else if(80 < progress && progress < 90){
                    label.setText(diy.serve());
                }else if(90 < progress && progress < 100){
                    label.setText(beverage.serve());
                }
            }else if(order.getPizza().size() == 0 && order.getBeverage().size() > 0){
                if(0 < progress && progress < 25){
                    label.setText("Preparing Equipments...");
                }else if(25 < progress && progress < 50){
                    label.setText(beverage.prepare());
                }else if(50 < progress && progress < 75){
                    label.setText(beverage.process());
                }else if(75 < progress && progress < 100){
                    label.setText(beverage.serve());
                }
            }else if(order.getPizza().size() > 0 && order.getBeverage().size() == 0){
                if(0 < progress && progress < 15){
                    label.setText("Preparing Equipments...");
                }else if(15 < progress && progress < 29){
                    label.setText(prefab.prepare());
                }else if(29 < progress && progress < 44){
                    label.setText(diy.prepare());
                }else if(44 < progress && progress < 56){
                    label.setText(prefab.process());
                }else if(56 < progress && progress < 70){
                    label.setText(diy.process());
                }else if(70 < progress && progress < 85){
                    label.setText(prefab.serve());
                }else if(85 < progress && progress < 100){
                    label.setText(diy.serve());
                }
            }
        } 
    }
 
 
    /**
     * Create the GUI and show it. As with all GUI code, this must run
     * on the event-dispatching thread.
     */
    public void startProgress() {
        //Create and set up the content pane.
        JComponent newContentPane = new ProgressBar(this.order);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        ImageIcon ic = new ImageIcon("Others/pizzaicon.jpg");

        frame.setTitle("Progress");
        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(ic.getImage());
    }

}
