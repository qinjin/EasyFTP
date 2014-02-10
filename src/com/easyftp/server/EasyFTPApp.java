/*
 * EasyFTPApp.java
 */

package com.easyftp.server;

import java.net.URL;
import org.apache.log4j.PropertyConfigurator;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class EasyFTPApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new EasyFTPView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of EasyFTPApp
     */
    public static EasyFTPApp getApplication() {
        return Application.getInstance(EasyFTPApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        URL url = EasyFTPApp.class.getResource("/com/easyftp/server/resources/log4j.properties");
        PropertyConfigurator.configure(url);
        launch(EasyFTPApp.class, args);
    }
}
