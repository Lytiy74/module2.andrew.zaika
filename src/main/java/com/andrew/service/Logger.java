package com.andrew.service;

public class Logger {
    private static Logger instance;
    private Logger() {
        log("Logger loaded");
    }
    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public static void log(String text){
        System.out.println("[LOG] " + text);
    }
    public void errLog(String text){
        System.out.println("[ERROR] " + text);
    }
    public void warnLog(String text){
        System.out.println("[WARN] " + text);
    }
}
