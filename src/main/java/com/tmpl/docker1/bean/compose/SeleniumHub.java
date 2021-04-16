package com.tmpl.docker1.bean.compose;

import java.util.ArrayList;
import java.util.List;

public class SeleniumHub {
    String image;
    String container_name;
    List<String> ports;
    List<String> environment;

    public SeleniumHub(){
        this.image = "selenium/hub:3.4.0-einsteinium";
        this.container_name = "selenium-hub";
        this.ports = new ArrayList<String>(){{add("4444:4444");}};
        this.environment = new ArrayList<String>(){{add("GRID_BROWSER_TIMEOUT=60");}};
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContainer_name() {
        return container_name;
    }

    public void setContainer_name(String container_name) {
        this.container_name = container_name;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        this.ports = ports;
    }

    public List<String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(List<String> environment) {
        this.environment = environment;
    }
}
