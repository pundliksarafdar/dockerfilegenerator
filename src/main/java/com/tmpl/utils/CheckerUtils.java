package com.tmpl.utils;

import com.tmpl.executor.CommandExecutor;

import java.io.IOException;

public class CheckerUtils {
    public static boolean isDockerHealthy(){
        try {
            return CommandExecutor.executeCommand("docker");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isGitInstalled(){
        try {
            return CommandExecutor.executeCommand("git");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
