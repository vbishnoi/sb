/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.uoy.sb.Global;
import controller.UserController;
import java.awt.Dialog;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.User;

/**
 *
 * @author Y0239881
 */
public class MainContainer extends javax.swing.JFrame {

    private final User user;

    /**
     * Creates new form MainContainer
     */
    public MainContainer() {
        initComponents();

        Global.container = this;

        user = new UserController().getUserByName(Global.loggedInUser);

        if (user != null) {
            switch (user.getGroup()) {
                case Adult:
                    getContentPane().add(new AdultHome());
                    break;
                case Child:
                    getContentPane().add(new ChildHome());
                    break;
            }
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    MainContainer.this.setVisible(false);
                    System.exit(0);
                }
            }
        });

        setSize(new Dimension(750, 600));
        setLocationRelativeTo(null);
    }

    /*
     * Set the panel to be displayed 
     * @param panelToDisplay JPanel to be displayed
     */
    public void setDisplay(JPanel panelToDisplay) {
        getContentPane().removeAll();
        getContentPane().add(panelToDisplay);

        pack();

        this.revalidate();
        this.repaint();
    }

    public void showModalDialog(JPanel panel, String title) {
        JDialog dialog = new JDialog(this, title);
        dialog.getContentPane().add(panel);
//        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainContainer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
