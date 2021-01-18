package com.tmpl.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {
    public static boolean executeCommand(String cmd) throws IOException {
        boolean isSuccessful = true;
        ProcessBuilder pb=new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process process=pb.start();
        process.getOutputStream().flush();
        process.getOutputStream().close();
        // Get input streams
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String s;
        System.out.println("Standard output: ");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // Read command errors
        System.out.println("Standard error: ");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
            isSuccessful = false;
        }
        return isSuccessful;
    }
}
