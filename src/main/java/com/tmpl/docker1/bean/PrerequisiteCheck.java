package com.tmpl.docker1.bean;

public class PrerequisiteCheck {
    boolean docker;
    boolean git;

    public boolean isDocker() {
        return docker;
    }

    public void setDocker(boolean docker) {
        this.docker = docker;
    }

    public boolean isGit() {
        return git;
    }

    public void setGit(boolean git) {
        this.git = git;
    }
}
