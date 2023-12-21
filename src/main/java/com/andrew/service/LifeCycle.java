package com.andrew.service;


import com.andrew.map.Cell;
import com.andrew.map.GameField;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.reflections.Reflections.log;
@Log4j2
public class LifeCycle {
    private static final String CONFIG_KEY = "service.lifecycle.";
    private ExecutorService executor;
    public LifeCycle(){
        executor = Executors.newFixedThreadPool(2);
    }
    public void start() throws InterruptedException {
        logInfo();
        while (true){
            Future<?> submitAnimalCycle = executor.submit(() ->{

            });
            Future<?> submitPlantCycle = executor.submit(() ->{

            });
            TimeUnit.MICROSECONDS.sleep(ConfigLoader.getIntProperty(CONFIG_KEY + "wait-time"));
        }
    }
    private void logInfo(){
        final GameField gameField = GameField.getInstance();
        for (int i = 0; i < gameField.getHeight(); i++) {
            for (int j = 0; j < gameField.getWidth(); j++) {
                final Cell cell = gameField.getCellAt(i, j);
                log.info("Cell " + i + " " + j);
            }
        }
    }
}
