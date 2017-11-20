package com.rnd.golovach;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(int cacheSize, String  fileName){
        super(fileName);
        this.cacheSize =cacheSize;
        cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);
        if (cache.size() == cacheSize){
            writeEventFromCache();
            cache.clear();
        }
    }

    private void writeEventFromCache()
    {
        for (Event event : cache){
            super.logEvent(event);
        }
    }

    public void destroy(){
        if (!cache.isEmpty())
            writeEventFromCache();
    }
}
