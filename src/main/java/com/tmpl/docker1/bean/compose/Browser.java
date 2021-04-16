package com.tmpl.docker1.bean.compose;

import java.util.List;

public class Browser {
    String image;
    List<String> ports;
    List<String> depends_on;
    List<String> volumes;

    public Browser(String image, List<String> ports, List<String> depends_on, List<String> volumes){
        this.image = image;
        this.ports = ports;
        this.depends_on = depends_on;
        this.volumes = volumes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        this.ports = ports;
    }

    public List<String> getDepends_on() {
        return depends_on;
    }

    public void setDepends_on(List<String> depends_on) {
        this.depends_on = depends_on;
    }

    public List<String> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }
}
