package com.sbt.observer.editor;

import com.sbt.observer.publisher.*;

import java.io.File;
import java.net.URL;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(URL filePath) {
        this.file = new File(filePath.toString());
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (file == null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please, open file first!");
        }
    }
}
