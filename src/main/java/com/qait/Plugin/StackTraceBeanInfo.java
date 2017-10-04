package com.qait.Plugin;

import org.apache.jmeter.testbeans.BeanInfoSupport;

import java.beans.PropertyDescriptor;

/**
 * Created by saurabhrai on 04-Oct-17.
 */


public class StackTraceBeanInfo extends BeanInfoSupport {
    //create a variable for each field
    private static final String FIELD_PROPERTY_FILE_PATH  = "propFilePath"; //variable name for field in the GUI.

    public StackTraceBeanInfo() {
        super(StackTrace.class);
        PropertyDescriptor p = this.property(FIELD_PROPERTY_FILE_PATH);
        p.setValue("notUndefined", Boolean.TRUE);
        p.setValue("default", "");
    }
}