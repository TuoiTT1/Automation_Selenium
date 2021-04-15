package com.selenium.assignment3.core;

public class TestCase {
    private String TCID;
    private String TCName;
    private String result;

    public TestCase(){

    }
    public TestCase(String TCID, String TCName, String result) {
        this.TCID = TCID;
        this.TCName = TCName;
        this.result = result;
    }

    public String getTCID() {
        return TCID;
    }

    public void setTCID(String TCID) {
        this.TCID = TCID;
    }

    public String getTCName() {
        return TCName;
    }

    public void setTCName(String TCName) {
        this.TCName = TCName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
