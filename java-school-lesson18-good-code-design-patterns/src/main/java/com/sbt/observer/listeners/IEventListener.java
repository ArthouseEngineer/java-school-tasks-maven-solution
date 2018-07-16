package com.sbt.observer.listeners;

import java.io.File;

public interface IEventListener {
    public void update(String eventType, File file);
}
