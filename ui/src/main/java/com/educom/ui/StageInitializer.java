package com.educom.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StockChartApplication.StageReadyEvent> {

    @Value("classpath:/lehre.fxml")
    private Resource chartResource;

    private ApplicationContext applicationContext;
    private String applicationTitle;

    StageInitializer(ApplicationContext applicationContext,
                     @Value("${spring.application.ui.title}") String applicationTitle) {
        this.applicationContext = applicationContext;
        this.applicationTitle = applicationTitle;
    }

    @Override
    public void onApplicationEvent(StockChartApplication.StageReadyEvent stageReadyEvent) {

        try {
            Stage stage = stageReadyEvent.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(getChartResource().getURL());
            fxmlLoader.setControllerFactory(aClass -> this.applicationContext.getBean(aClass));

            Parent load = fxmlLoader.load();
            Scene scene=new Scene(load, 800, 600);
            scene.getStylesheets().add("/ui.css");
            stage.setScene(scene);
            stage.setTitle(applicationTitle);


            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Resource getChartResource() {
        return chartResource;
    }

}
