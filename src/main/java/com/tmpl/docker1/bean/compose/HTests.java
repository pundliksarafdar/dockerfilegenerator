package com.tmpl.docker1.bean.compose;

import java.util.List;

public class HTests {
    String image;
    String build;
    List<String> depends_on;
    List<String> environment;
    List<String> volumes;

    public HTests(String image, List<String> depends_on,List<String> environment){
        this.image = image;
        this.depends_on = depends_on;
        this.environment = environment;
        this.build = ".";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public List<String> getDepends_on() {
        return depends_on;
    }

    public void setDepends_on(List<String> depends_on) {
        this.depends_on = depends_on;
    }

    public List<String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(List<String> environment) {
        this.environment = environment;
    }

    public List<String> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }
}
