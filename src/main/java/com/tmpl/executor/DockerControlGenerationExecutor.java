package com.tmpl.executor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.tmpl.docker1.bean.GenerateArrib;
import com.tmpl.docker1.bean.compose.DockerCompose;
import com.tmpl.docker1.bean.compose.HTests;
import com.tmpl.docker1.bean.compose.Services;
import com.tmpl.utils.TemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DockerControlGenerationExecutor {
    public static String generateDockerComposeFile(GenerateArrib arrib) throws IOException {
        List<String> packageList = TemplateUtils.getPackageToInstall(arrib);
        List<String> featureInfoList = TemplateUtils.getFeatureToInstall(arrib);

        if(arrib.getSource() != null && !arrib.getSource().trim().equals("")){
            TemplateGenerationExecutor.checkoutGitCode(arrib.getSource());
        }

        HTests hTests = new HTests(arrib.imageName, null, null);
        DockerCompose dockerCompose = new DockerCompose(hTests);
        Services services = new Services(dockerCompose);

        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return om.writeValueAsString(services);
    }

    public static void main(String[] args) throws IOException {
        GenerateArrib arrib = new GenerateArrib();
        arrib.imageName = "testimage";
        generateDockerComposeFile(arrib);
    }
}
