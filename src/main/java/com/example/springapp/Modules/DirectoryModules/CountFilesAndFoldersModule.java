package com.example.springapp.Modules.DirectoryModules;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CountFilesAndFoldersModule extends AbstractDirectoryModule {
    @Override
    public String getFunctionDescription() {
        return "Возвращает количество файлов и папок.";
    }

    @Override
    public void function(File file) {
        int files = 0;
        int dirs = 0;
        for(File x : file.listFiles()){
            if (x.isDirectory()) dirs++;
            else files++;
        }
        System.out.printf("Number of directories: %d, number of files: %d", dirs, files);
    }
}
