package com.tmpl.docker1.bean.compose;

public class Services {
    private DockerCompose services;
    private Networks networks;

    public Services(DockerCompose services){
        this.services = services;
        this.networks = new Networks();
    }

    public DockerCompose getServices() {
        return services;
    }

    public void setServices(DockerCompose services) {
        this.services = services;
    }

    public Networks getNetworks() {
        return networks;
    }

    public void setNetworks(Networks networks) {
        this.networks = networks;
    }
}
