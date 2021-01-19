package com.tmpl.executor;

import com.tmpl.docker1.bean.DockerBuild;
import com.tmpl.docker1.bean.GenerateArrib;
import com.tmpl.docker1.controller.MessageController;
import com.tmpl.utils.TemplateUtils;

import java.io.*;
import java.util.List;

public class TemplateGenerationExecutor {
    static String dockerFile = "Dockerfile";
    public static String generateDockerFile(GenerateArrib arrib) {
        List<String> packageList = TemplateUtils.getPackageToInstall(arrib);
        boolean success = openFile();
        if (success) {
            FileWriter writter = getFileWritter(dockerFile);
            if (writter != null) {
                try {
                    // Write base image
                    writter.append(String.format("FROM %s:%s\n", arrib.getImageName(), arrib.getImageVersion()));

                    writter.append(String.format("RUN apt-get install\n"));
                    //Install package
                    for(String packageInstall : packageList){
                        writter.append(String.format("RUN apt-get install %s\n", packageInstall));
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        writter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //Read file again
        String dockerFileContent = "";
        StringBuilder stringBuilder = new StringBuilder();
        FileReader reader = null;
        try {
            reader = new FileReader(dockerFile);
            int i;
            while((i = reader.read()) != -1){
                stringBuilder.append((char)i);
            }
            dockerFileContent = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dockerFileContent;
    }

    public static FileWriter getFileWritter(String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            return myWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void appendToFile(String line) {

    }

    //Creating docker file
    public static boolean openFile() {
        try {
            File myObj = new File(TemplateGenerationExecutor.dockerFile);
            if (myObj.exists()) {
                myObj.delete();
            }
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }

    public static boolean rewriteDockerFile(DockerBuild dockerBuild){
        String dockerFileContent = dockerBuild.getDockerFileContent();

        FileWriter writter = getFileWritter(dockerFile);
        if (writter != null) {
            try {
                // Write base image
                writter.append(String.format(dockerFileContent));
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    writter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void createAndBuildDocker(DockerBuild dockerBuild){
        rewriteDockerFile(dockerBuild);
        MessageController controller = new MessageController();
        try {
            boolean isBuildSuccessfull = CommandExecutor.executeCommand("docker build -t test:latest .", controller);
            if (isBuildSuccessfull){
                //CommandExecutor.executeCommand()
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
