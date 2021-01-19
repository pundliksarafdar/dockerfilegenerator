package com.tmpl.utils;

import com.tmpl.executor.CommandExecutor;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;

public class CheckerUtils {
    public static boolean isDockerHealthy(){
        try {
            return CommandExecutor.executeCommand("docker", null);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isGitInstalled(){
        try {
            return CommandExecutor.executeCommand("git", null);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
