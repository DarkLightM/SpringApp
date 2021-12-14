package com.example.springapp.Modules.ImageModules;

import com.example.springapp.Modules.Module;
import com.example.springapp.Utils.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractImageModule implements Module {
    static final List<String> _supportedFormats = Arrays.asList("jpg","jpeg","png");

    @Override
    public boolean isSupportedFormat(File file) {
        return _supportedFormats.contains(FileUtils.getFileExtension(file));
    }

    @Override
    public abstract String getFunctionDescription();

    @Override
    public abstract void function(File file);
}
