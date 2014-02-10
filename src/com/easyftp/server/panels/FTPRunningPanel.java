/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FTPRunningPanel.java
 *
 * Created on Mar 27, 2011, 9:35:28 PM
 */

package com.easyftp.server.panels;

import com.easyftp.server.beans.ConfigBean;
import com.easyftp.server.utils.BusyIconAnimation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.ftpserver.ConnectionConfig;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.impl.DefaultConnectionConfig;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author qinjin
 */
public class FTPRunningPanel extends javax.swing.JPanel {
    private static Logger logger = LogManager.getLogger(FTPRunningPanel.class);
    private final static FtpServerFactory serverFactory = new FtpServerFactory();
    private final static ListenerFactory factory = new ListenerFactory();
    private final static FtpServer server = serverFactory.createServer();
    private ConfigBean configBean = new ConfigBean();
    
    /** Creates new form FTPRunningPanel */
    public FTPRunningPanel() {
        initComponents();
    }

    public FTPRunningPanel(ConfigBean configBean) {
        this();
        this.configBean = configBean;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusTable = new org.jdesktop.swingx.JXTreeTable();

        setName("Form"); // NOI18N

        startPanel.setName("startPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.easyftp.server.EasyFTPApp.class).getContext().getResourceMap(FTPRunningPanel.class);
        startButton.setText(resourceMap.getString("startButton.text")); // NOI18N
        startButton.setName("startButton"); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText(resourceMap.getString("stopButton.text")); // NOI18N
        stopButton.setName("stopButton"); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(stopButton))
                .addGap(36, 36, 36))
        );

        statusPanel.setName("statusPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        statusTable.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("statusTable.border.title"))); // NOI18N
        statusTable.setName("statusTable"); // NOI18N
        jScrollPane1.setViewportView(statusTable);

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(startPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(startPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // set the port of the listener
        System.out.println("Port: "+configBean.port);
        factory.setPort(configBean.port);

        // replace the default listener
        Listener listener = factory.createListener();
        serverFactory.addListener("default", listener);
        ConnectionConfig conConfig = new DefaultConnectionConfig(true, 5, 5, 5, 5, 5);
        serverFactory.setConnectionConfig(conConfig);
        serverFactory.setUserManager(createDefaultUserManager());

        // start the server
        try {
            server.start();
        } catch (FtpException ex) {
            JOptionPane.showMessageDialog(startPanel, ex, "FTP server Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
//            logger.error(ex);
        }

        BusyIconAnimation.start();
        JOptionPane.showMessageDialog(startPanel, "Easy FTP server started!");
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        server.stop();
        BusyIconAnimation.stop();
        JOptionPane.showMessageDialog(startPanel, "Easy FTP server stoped!");
        
    }//GEN-LAST:event_stopButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startPanel;
    private javax.swing.JPanel statusPanel;
    private org.jdesktop.swingx.JXTreeTable statusTable;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    private UserManager createDefaultUserManager() {
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        //userManagerFactory.setFile(new File("myusers.properties"));
        userManagerFactory.setPasswordEncryptor(new SaltedPasswordEncryptor());
        UserManager userManager = userManagerFactory.createUserManager();

        BaseUser user = new BaseUser();
        user.setName("test");
        user.setPassword("test");
        user.setHomeDirectory(configBean.severfolder);

        List<Authority> auths = new ArrayList<Authority>();
        Authority auth = new WritePermission();
        auths.add(auth);
        user.setAuthorities(auths);
        try {
            userManager.save(user);
        } catch (FtpException ex) {
            ex.printStackTrace();
        }

        return userManager;
    }

}