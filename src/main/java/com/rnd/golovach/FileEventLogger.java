package com.rnd.golovach;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements IEventLogger {

    private String fileName;
    private  File file;

    public FileEventLogger(){}
    public  FileEventLogger(String fileName){
        this.fileName=fileName;
    }

    public void init() throws IOException{
        this.file = new File(fileName);
        file.canWrite();
    }

    public  void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        }
        catch (IOException ex){
            System.out.println("Error has occurred during write in file " +fileName);
        }
    }


}
