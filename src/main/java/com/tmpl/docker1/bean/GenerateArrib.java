package com.tmpl.docker1.bean;

import com.tmpl.anotations.PackageInfo;

public class GenerateArrib {
    //Package
    @PackageInfo(packageName = "SELENIUM")
    public boolean selenium;
    @PackageInfo(packageName = "NODE")
    public boolean nose;
    @PackageInfo(packageName = "CLIPBOARD")
    public boolean clipboard;
    @PackageInfo(packageName = "CONFIG")
    public boolean config;
    @PackageInfo(packageName = "REQUEST")
    public boolean requests;
    @PackageInfo(packageName = "ROBOTFRAMEWORD")
    public boolean robotFramework;

    //Feature
    public boolean testNg;
    public boolean maven;
    public boolean extentReport;

    public String source;
    public String imageName;
    public String imageVersion;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageVersion() {
        return imageVersion;
    }

    public void setImageVersion(String imageVersion) {
        this.imageVersion = imageVersion;
    }

    public boolean isSelenium() {
        return selenium;
    }

    public void setSelenium(boolean selenium) {
        this.selenium = selenium;
    }

    public boolean isNose() {
        return nose;
    }

    public void setNose(boolean nose) {
        this.nose = nose;
    }

    public boolean isClipboard() {
        return clipboard;
    }

    public void setClipboard(boolean clipboard) {
        this.clipboard = clipboard;
    }

    public boolean isConfig() {
        return config;
    }

    public void setConfig(boolean config) {
        this.config = config;
    }

    public boolean isRequests() {
        return requests;
    }

    public void setRequests(boolean requests) {
        this.requests = requests;
    }

    public boolean isRobotFramework() {
        return robotFramework;
    }

    public void setRobotFramework(boolean robotFramework) {
        this.robotFramework = robotFramework;
    }

    public boolean isTestNg() {
        return testNg;
    }

    public void setTestNg(boolean testNg) {
        this.testNg = testNg;
    }

    public boolean isMaven() {
        return maven;
    }

    public void setMaven(boolean maven) {
        this.maven = maven;
    }

    public boolean isExtentReport() {
        return extentReport;
    }

    public void setExtentReport(boolean extentReport) {
        this.extentReport = extentReport;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
