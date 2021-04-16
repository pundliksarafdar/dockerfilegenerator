package com.tmpl.docker1.controller;

import com.tmpl.docker1.bean.DockerBuild;
import com.tmpl.docker1.bean.GenerateArrib;
import com.tmpl.docker1.bean.PrerequisiteCheck;
import com.tmpl.executor.DockerControlGenerationExecutor;
import com.tmpl.executor.TemplateGenerationExecutor;
import com.tmpl.utils.CheckerUtils;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TemplateController {

    //This will perform prerequisite
    @GetMapping("/prerequisite")
    public PrerequisiteCheck isPrerequisiteSatisfied(){
        PrerequisiteCheck prerequisiteCheck = new PrerequisiteCheck();
        boolean isDockerInstalled = CheckerUtils.isDockerHealthy();
        prerequisiteCheck.setDocker(isDockerInstalled);

        boolean isGitInstalled = CheckerUtils.isGitInstalled();
        prerequisiteCheck.setGit(isGitInstalled);
        return prerequisiteCheck;
    }

    @PostMapping("/generator")
    public Map<String,String> generator(@RequestBody GenerateArrib generateArrib) {
        Map<String,String> d = new HashMap<String,String>();
        String generateddFIle = TemplateGenerationExecutor.generateDockerFile(generateArrib);
        if (generateddFIle != null){
            d.put("dockerFile", generateddFIle);
        }else{
            d.put("error", "Error while creating docker file check logs");
        }

        return d;
    }

    @PostMapping("/generator_compose")
    public Map<String,String> generatorCompose(@RequestBody GenerateArrib generateArrib) throws IOException {
        Map<String,String> d = new HashMap<String,String>();
        String generateddFIle = DockerControlGenerationExecutor.generateDockerComposeFile(generateArrib);
        if (generateddFIle != null){
            d.put("dockerFile", generateddFIle);
        }else{
            d.put("error", "Error while creating docker file check logs");
        }

        return d;
    }

    @PostMapping("/build")
    public Response buildAndDeployDocker(@RequestBody DockerBuild build){
        Response response = new Response();
        response.setStatus(200);
        TemplateGenerationExecutor.createAndBuildDocker(build);
        return response;
    }
}
