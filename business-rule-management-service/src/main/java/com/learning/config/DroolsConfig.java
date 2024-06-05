package com.learning.config;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class DroolsConfig {
    public KieServices keyKieServices= KieServices.Factory.get();

    private static final String path= "KieRule.xlsx";

//    private static final String path="KieRule.xlsx";

    public KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem=keyKieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(path));
        return kieFileSystem;
    }

//    public KieContainer kieContainer() throws IOException {
//        System.out.println("Initializing kie container");
//        KieBuilder kb=keyKieServices.newKieBuilder(getKieFileSystem());
//        kb.buildAll();
//        KieModule kieModule=kb.getKieModule();
//        KieContainer kieContainer= keyKieServices.newKieContainer(kieModule.getReleaseId());
//        System.out.println("Kie container is created");
//        return kieContainer;
//    }


    @Bean
    public KieContainer kieContainer() throws IOException {
        System.out.println("Initializing kie container");
        Resource rules= ResourceFactory.newClassPathResource(path,getClass());
        compileXlsToDrl(rules);
        KieFileSystem kieFileSystem= keyKieServices.newKieFileSystem().write(rules);
        KieBuilder kb=keyKieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule=kb.getKieModule();
        KieContainer kieContainer= keyKieServices.newKieContainer(kieModule.getReleaseId());
        System.out.println("Kie container is created");
        return kieContainer;
    }


    public KieSession getKieSession() throws IOException {
        System.out.println("Kie Session initialization");
        return kieContainer().newKieSession();
    }

    private static void compileXlsToDrl(Resource resource){
        try {
            InputStream is=resource.getInputStream();
            SpreadsheetCompiler compiler=new SpreadsheetCompiler();
            String drl=compiler.compile(is, InputType.XLS);
            System.out.println(drl);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
