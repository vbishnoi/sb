/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.uoy.sb.Common;
import com.uoy.sb.Global;
import controller.StoryController;
import controller.UserController;
import controller.UserStoryController;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.AssignedStory;
import model.Story;
import model.User;

/**
 *
 * @author Y0239881
 */
public class AdultHome extends javax.swing.JPanel {

    private LinkedList<Story> allStories = null;
    private LinkedList<Story> createdByMe = null;

    /**
     * Creates new form AdultHome
     */
    public AdultHome() {
        initComponents();

        welcomeUser();

        populateList();
    }

    /**
     * Display welcome message and user's picture
     */
    private void welcomeUser() {
        jLabel1.setText("Welcome, " + Global.loggedInUser);

        User u = new UserController().getUserByName(Global.loggedInUser);

        if (u != null && !u.getImage().equals("")) {
            Image image = null;
            try {
                image = Common.readImage(u.getImage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Cannot read input image");
            }

            JLabel lblimage = new JLabel(new ImageIcon(image.getScaledInstance(100, -1, Image.SCALE_DEFAULT)));
            panelUserImage.setLayout(new FlowLayout());
            panelUserImage.add(lblimage);
        }
    }

    private void populateList() {
        final StoryController sc = new StoryController();
        allStories = sc.getAllStories();
        createdByMe = sc.getStoriesByUser(Global.loggedInUser);

        final DefaultListModel model = new DefaultListModel();
        for (Story s : allStories) {
            model.addElement(s.getTitle());

            // print out to test
//            System.out.println(s.getTitle());
        }

        allStoryList.setModel(model);

        final DefaultListModel createdByMeModel = new DefaultListModel();
        for (Story s : createdByMe) {
            createdByMeModel.addElement(s.getTitle());

            // print out to test
//            System.out.println(s.getTitle());
        }

        createdByMeList.setModel(createdByMeModel);

        allStoryList.addMouseListener(new StoryListMouseListener());
        createdByMeList.addMouseListener(new StoryListMouseListener());
    }

    private class StoryListMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JList list = (JList) e.getSource();

            // double click
            if (e.getClickCount() == 2) {
                int selectedIndex = list.getSelectedIndex();

//                CreatePage pe = null;
                CreateStory story = null;

                if (jTabs.getSelectedIndex() == 0) {
                    story = new CreateStory(createdByMe.get(selectedIndex).getId());
                } else {
                    story = new CreateStory(allStories.get(selectedIndex).getId());
                }

                Global.container.setDisplay(story);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUserImage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabsPanel = new javax.swing.JPanel();
        jTabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        createdByMeList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allStoryList = new javax.swing.JList();
        buttonPanel = new javax.swing.JPanel();
        btnNewStory = new javax.swing.JButton();
        btnManageChildren = new javax.swing.JButton();
        buttonDeleteStory = new javax.swing.JButton();
        buttonViewFeedback = new javax.swing.JButton();
        buttonPrintStory = new javax.swing.JButton();
        btnReadStory = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 650));

        panelUserImage.setPreferredSize(new java.awt.Dimension(100, 100));

        org.jdesktop.layout.GroupLayout panelUserImageLayout = new org.jdesktop.layout.GroupLayout(panelUserImage);
        panelUserImage.setLayout(panelUserImageLayout);
        panelUserImageLayout.setHorizontalGroup(
            panelUserImageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        panelUserImageLayout.setVerticalGroup(
            panelUserImageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel1.setText("Welcome, user");

        createdByMeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(createdByMeList);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 473, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 415, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
        );

        jTabs.addTab("My Stories", jPanel1);

        allStoryList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(allStoryList);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        jTabs.addTab("All stories", jPanel2);

        org.jdesktop.layout.GroupLayout tabsPanelLayout = new org.jdesktop.layout.GroupLayout(tabsPanel);
        tabsPanel.setLayout(tabsPanelLayout);
        tabsPanelLayout.setHorizontalGroup(
            tabsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 478, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        tabsPanelLayout.setVerticalGroup(
            tabsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabsPanelLayout.createSequentialGroup()
                .add(jTabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 443, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        btnNewStory.setText("Create new story");
        btnNewStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewStoryActionPerformed(evt);
            }
        });

        btnManageChildren.setText("Manage Children");
        btnManageChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageChildrenActionPerformed(evt);
            }
        });

        buttonDeleteStory.setText("Delete Story");
        buttonDeleteStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteStoryActionPerformed(evt);
            }
        });

        buttonViewFeedback.setText("View Feedback");
        buttonViewFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewFeedbackActionPerformed(evt);
            }
        });

        buttonPrintStory.setText("Print Story");
        buttonPrintStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintStoryActionPerformed(evt);
            }
        });

        btnReadStory.setText("Read Story");
        btnReadStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadStoryActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit Story");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout buttonPanelLayout = new org.jdesktop.layout.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(btnNewStory)
                    .add(btnEdit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnReadStory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnManageChildren, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonDeleteStory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonViewFeedback, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonPrintStory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonPanelLayout.linkSize(new java.awt.Component[] {btnEdit, btnExit, btnManageChildren, btnNewStory, btnReadStory, buttonDeleteStory, buttonPrintStory, buttonViewFeedback}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(buttonPanelLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(btnNewStory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEdit)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnReadStory)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnManageChildren)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(buttonDeleteStory)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(buttonViewFeedback)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(buttonPrintStory)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnExit)
                .addContainerGap())
        );

        buttonPanelLayout.linkSize(new java.awt.Component[] {btnEdit, btnExit, btnManageChildren, btnNewStory, btnReadStory, buttonDeleteStory, buttonPrintStory, buttonViewFeedback}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(panelUserImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(14, 14, 14)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(tabsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panelUserImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tabsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewStoryActionPerformed
        Global.container.setDisplay(new CreateStory());
    }//GEN-LAST:event_btnNewStoryActionPerformed

    private void btnManageChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageChildrenActionPerformed
        Global.container.setDisplay(new UserList());

    }//GEN-LAST:event_btnManageChildrenActionPerformed

    private void btnReadStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadStoryActionPerformed
        Story s = getSelectedStory();
        if (s != null) {
            Global.container.setDisplay(new ReadStory(s.getId()));
        }
    }//GEN-LAST:event_btnReadStoryActionPerformed

    private void buttonDeleteStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteStoryActionPerformed
        if (jTabs.getSelectedIndex() == 0) {
            int selectedIndex = createdByMeList.getSelectedIndex();
            if (selectedIndex >= 0) {

                if (JOptionPane.showConfirmDialog(null, "Do you want to delete this story?", "Delete story?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        Story s = createdByMe.get(selectedIndex);
                        if (s != null) {
                            LinkedList<AssignedStory> assigned = new UserStoryController().getAssignedChidrenToStory(s.getId(), false);

                            if (assigned != null && !assigned.isEmpty()) {
                                if (JOptionPane.showConfirmDialog(null, "This story is associated with some children. \n Do you want to delete it?", "Delete story?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    // delete 
//                                    new UserStoryController().deleteAssignedChildren(s.getId());
                                    new StoryController().deleteStory(s);

                                    populateList();
                                }
                            } else {
                                // delete without confirmation
                                new UserStoryController().deleteAssignedChildren(s.getId());
                                new StoryController().deleteStory(s);

                                populateList();
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(AdultHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a story to delete");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You are not allowed to delete other people's story. \n Please select from \"My Stories\" tab.");
        }
    }//GEN-LAST:event_buttonDeleteStoryActionPerformed

    private void buttonPrintStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintStoryActionPerformed
        Global.container.showModalDialog(new printPanel(getSelectedStory()), "Print story");
    }//GEN-LAST:event_buttonPrintStoryActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Quit program", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Global.container.setVisible(false);
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private Story getSelectedStory() {
        int selectedIndex = -1;
        Story s = null;

        if (jTabs.getSelectedIndex() == 0) {
            selectedIndex = createdByMeList.getSelectedIndex();
            if (selectedIndex != -1) {
                s = createdByMe.get(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select story!");
            }
        } else {
            selectedIndex = allStoryList.getSelectedIndex();
            if (selectedIndex != -1) {
                s = allStories.get(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select story!");
            }
        }

        return s;
    }

    private void buttonViewFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewFeedbackActionPerformed
        int selectedIndex = -1;
        Story s = null;

        if (jTabs.getSelectedIndex() == 0) {
            selectedIndex = createdByMeList.getSelectedIndex();
            s = createdByMe.get(selectedIndex);
        } else {
            selectedIndex = allStoryList.getSelectedIndex();
            s = allStories.get(selectedIndex);
        }

        if (selectedIndex != -1) {
            ViewFeedback vfb = new ViewFeedback(s);

            Global.container.showModalDialog(vfb, "View story feedback");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a story to view.");
        }

    }//GEN-LAST:event_buttonViewFeedbackActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        Story s = getSelectedStory();
        if (s != null) {
            Global.container.setDisplay(new CreateStory(s.getId()));
        }
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList allStoryList;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnManageChildren;
    private javax.swing.JButton btnNewStory;
    private javax.swing.JButton btnReadStory;
    private javax.swing.JButton buttonDeleteStory;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton buttonPrintStory;
    private javax.swing.JButton buttonViewFeedback;
    private javax.swing.JList createdByMeList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabs;
    private javax.swing.JPanel panelUserImage;
    private javax.swing.JPanel tabsPanel;
    // End of variables declaration//GEN-END:variables
}
