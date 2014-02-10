/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.easyftp.server.utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.jdesktop.application.ResourceMap;

/**
 *
 * @author qinjin.wang
 */
public class BusyIconAnimation {

    private static Icon[] busyIcons = new Icon[15];
    private static Icon idleIcon;
    
    private static Timer busyIconTimer;
    private static JLabel busyIconLabel;
    private static ResourceMap resourceMap;
    private static int busyIconIndex = 0;
    
    public BusyIconAnimation(){
    }

    public static void init(JLabel busyIcon,ResourceMap rmap){
        busyIconLabel = busyIcon;
        resourceMap = rmap;

        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }

        busyIconTimer = new Timer(0, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                busyIconLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        
        busyIconTimer.setDelay(busyAnimationRate);
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        busyIconLabel.setIcon(idleIcon);
    }

    public static void start(){
        busyIconTimer.start();
    }

    public static void stop(){
        busyIconTimer.stop();
        busyIconLabel.setIcon(idleIcon);
    }

    public static Icon getIdleIcon(){
        return idleIcon;
    }
}
