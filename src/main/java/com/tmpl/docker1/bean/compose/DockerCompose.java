package com.tmpl.docker1.bean.compose;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.List;

public class DockerCompose {
    private String version;
    private Browser chrome;
    private Browser firefox;
    private SeleniumHub seleniumhub;
    private HTests htests;

    public DockerCompose(HTests hTests){
        this.version = "3";
        List<String> ports = new ArrayList<String>(){{add("5900:5900");}};
        List<String> dependsOn = new ArrayList<String>(){{add("selenium-hub");}};
        List<String> environment = new ArrayList<String>(){{add("HUB_PORT_4444_TCP_ADDR=selenium-hub"); add("HUB_PORT_4444_TCP_PORT=4444");}};
        this.chrome = new Browser("selenium/node-chrome-debug:3.0.1-aluminum",ports,dependsOn,environment);
        this.firefox = new Browser("selenium/node-firefox-debug:3.4.0-einsteinium",ports,dependsOn,environment);
        this.seleniumhub = new SeleniumHub();
        this.htests = hTests;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Browser getChrome() {
        return chrome;
    }

    public void setChrome(Browser chrome) {
        this.chrome = chrome;
    }

    public Browser getFirefox() {
        return firefox;
    }

    public void setFirefox(Browser firefox) {
        this.firefox = firefox;
    }

    public SeleniumHub getSeleniumhub() {
        return seleniumhub;
    }

    public void setSeleniumhub(SeleniumHub seleniumhub) {
        this.seleniumhub = seleniumhub;
    }

    public HTests getHtests() {
        return htests;
    }

    public void setHtests(HTests htests) {
        this.htests = htests;
    }
}

