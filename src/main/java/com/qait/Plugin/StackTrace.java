package com.qait.Plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.services.FileServer;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;


public class StackTrace  extends ConfigTestElement implements TestBean,TestStateListener {                //TestBean is a marker interface to tell JMeter to make a Test Bean Gui for the class.
                                                                                                          //We need to read the property file before the test plan gets executed. So we need to implement the corresponding interface – TestStateListener.
    private static final Logger log = LoggingManager.getLoggerForClass();
    private String propFilePath;       //Variable for each field in the GUI.
    private static final long serialVersionUID = 232L;
    public StackTrace() {
        super();
    }

    public void testStarted() {

        if (StringUtils.isNotEmpty(getPropFilePath())) {
            try {
                String e = this.propFilePath;
                if(!(new File(this.propFilePath)).isAbsolute()) {
                    e = FileServer.getFileServer().getBaseDir() + File.separator + this.propFilePath;
                }
                log.info("Property file reader - loading the properties from " + e);
                JMeterUtils.getJMeterProperties().load(new FileInputStream(e));
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

    }

    public void testStarted(String s) {

    }

    public void testEnded() {

    }

    public void testEnded(String s) {

    }


    //Getter and Setter for each field in the GUI.
    public String getPropFilePath() {
        return this.propFilePath;
    }

    /**
     * @param propFilePath the file path to read
     */
    public void setPropFilePath(String propFilePath) {
        this.propFilePath = propFilePath;
    }
}