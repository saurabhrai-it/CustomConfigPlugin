package com.qait.Plugin;

import org.apache.jmeter.testbeans.BeanInfoSupport;

import java.beans.PropertyDescriptor;

/**
 * Created by saurabhrai on 04-Oct-17.
 */


public class StackTraceBeanInfo extends BeanInfoSupport {
    //create a variable for each field
    private static final String StackTrace_FILE_PATH  = "StackTraceFilePath"; //variable name for field in the GUI.

    public StackTraceBeanInfo() {
        super(StackTrace.class);
        PropertyDescriptor p = this.property(StackTrace_FILE_PATH);
        p.setValue("notUndefined", Boolean.TRUE);
        p.setValue("default", "");
    }
}