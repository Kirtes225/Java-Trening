package com.company;
import javafx.concurrent.Task;

public class AsyncTask extends Task {
    @Override
    protected Object call() throws Exception {
        while (true) {
            System.out.println(".");
            if (isCancelled())
                break;
        }
        return null;
    }
}
