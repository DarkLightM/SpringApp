package com.example.springapp.Modules;

import java.io.File;

public interface Module {
    boolean isSupportedFormat(File file);
    String getFunctionDescription();
    void function(File file);
}
