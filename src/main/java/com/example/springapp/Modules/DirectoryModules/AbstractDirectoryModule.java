package com.example.springapp.Modules.DirectoryModules;

import java.io.File;
import com.example.springapp.Modules.Module;

public abstract class AbstractDirectoryModule implements Module {
    @Override
    public boolean isSupportedFormat(File file) {
        return file.isDirectory();
    }

    @Override
    public abstract String getFunctionDescription();

    @Override
    public abstract void function(File file);
}
