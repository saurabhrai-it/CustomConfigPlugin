package com.qait.Plugin;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.services.FileServer;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;


public class StackTrace  extends ConfigTestElement implements TestBean,TestStateListener {                //TestBean is a marker interface to tell JMeter to make a Test Bean Gui for the class.
                                                                                                          //We need to read the property file before the test plan gets executed. So we need to implement the corresponding interface – TestStateListener.
    private static final Logger log = LoggingManager.getLoggerForClass();
    private String StackTraceFilePath;       //Variable for each field in the GUI.
    private static final long serialVersionUID = 232L;
    public StackTrace() {
        super();
    }
    SampleResult res;
    public void testStarted() {

        if (StringUtils.isNotEmpty(getStackTraceFilePath())) {
            try {
                String e = this.StackTraceFilePath;
                if (!(new File(this.StackTraceFilePath)).isAbsolute()) {
                    e = FileServer.getFileServer().getBaseDir() + File.separator + this.StackTraceFilePath;
                }
                log.info("Property file reader - loading the properties from " + e);
//                JMeterUtils.getJMeterProperties().load(new FileInputStream(e));
                if (!res.isSuccessful()) {
                    new BufferedWriter(new FileWriter(e, true).append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(res.getStartTime())) + "," + res.getSampleLabel() + "," + res.getTime() + "," + res.getRequestHeaders() + "," + res.getUrlAsString() + "," + res.getResponseCode() + "," + res.getResponseMessage() + "," + res.getResponseDataAsString() + " \n\n")).close();
                }

            } catch (Exception e) {
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
    public String getStackTraceFilePath() {
        return this.StackTraceFilePath;
    }

    /**
     * @param StackTraceFilePath the file path to read
     */
    public void setStackTraceFilePath(String StackTraceFilePath) {
        this.StackTraceFilePath = StackTraceFilePath;
    }
}