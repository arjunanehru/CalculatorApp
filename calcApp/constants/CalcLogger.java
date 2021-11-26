package com.peerislands.assessment.calcApp.constants;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CalcLogger{
    private static Logger logger;
    private static FileHandler fileHandler;
    private static SimpleFormatter simpleFormatter;
     
    private static final String filename = "./ApplicationLog.log";
     
    private static final int count= 1;
     
    private static final int limit = 1024*100; //100 Kb
     
    private static final boolean append = true;
     
    public static Logger getLogger(String name){
        try {
            logger = Logger.getLogger(name);
             
            simpleFormatter = new SimpleFormatter();
            fileHandler = new FileHandler(filename, limit, count, append);
            fileHandler.setFormatter(simpleFormatter);
             
            logger.addHandler(fileHandler);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return logger;
    }
}
