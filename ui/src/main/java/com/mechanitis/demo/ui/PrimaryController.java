package com.mechanitis.demo.ui;

import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class PrimaryController {

    @Value("classpath:/secondary.fxml")
    private Resource chartResource;
    private ApplicationContext applicationContext;
    private String applicationTitle;
//
//     PrimaryController(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }


    @FXML
    private void switchToSecondary() {
       // new StageInitializer(applicationContext,applicationTitle).setChartResource(chartResource);
    }
}
