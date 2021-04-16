package com.tmpl.docker1.bean.compose;

public class Networks {
    private Default defaults;

    public Networks(){
        this.defaults = new Default();
    }

    public Default getDefaults() {
        return defaults;
    }

    public void setDefaults(Default defaults) {
        this.defaults = defaults;
    }

    public static class Default{
        External external = new External();

        public External getExternal() {
            return external;
        }

        public void setExternal(External external) {
            this.external = external;
        }
    }

    public static class External{
        String name = "${hackathon-net}";
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

