package com.tmpl.docker1.bean;

public class DockerBuild {
    String dockerFileContent;
    String imageName;
    String tag;

    public String getDockerFileContent() {
        return dockerFileContent;
    }

    public void setDockerFileContent(String dockerFileContent) {
        this.dockerFileContent = dockerFileContent;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
