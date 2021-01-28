package com.tmpl.utils;

import com.tmpl.docker1.bean.DockerBuild;
import com.tmpl.docker1.bean.GenerateArrib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class TemplateUtils {
    //This method will return packages to install based on input
    //Hear field name should match
    public static List<String> getPackageToInstall(GenerateArrib arrib){
        List<String> packageListToInstall = new ArrayList<>();
        Field[] fields = GenerateArrib.class.getFields();
        for (Field field : fields){
            try {
                Object value = field.get(arrib);
                if (value instanceof Boolean && ((Boolean) value)){
                    com.tmpl.anotations.PackageInfo packageInfo = field.getAnnotation(com.tmpl.anotations.PackageInfo.class);
                    if (packageInfo != null){
                        String pName = packageInfo.packageName();
                        packageListToInstall.add(pName);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return packageListToInstall;
    }

    public static List<String> getFeatureToInstall(GenerateArrib arrib){
        List<String> FeatureListToInstall = new ArrayList<>();
        Field[] fields = GenerateArrib.class.getFields();
        for (Field field : fields){
            try {
                Object value = field.get(arrib);
                if (value instanceof Boolean && ((Boolean) value)){
                    com.tmpl.anotations.FeatureInfo featureInfo = field.getAnnotation(com.tmpl.anotations.FeatureInfo.class);
                    if (featureInfo != null){
                        String fName = featureInfo.featureName();
                        FeatureListToInstall.add(fName);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return FeatureListToInstall;
    }


    public static void main(String[] args) {
        GenerateArrib gA = new GenerateArrib();
        gA.clipboard = true;
        getPackageToInstall(gA);
    }
}
