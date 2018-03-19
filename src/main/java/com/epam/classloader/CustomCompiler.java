package com.epam.classloader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class CustomCompiler {

    public void compileTXT(String path) throws IOException {
        String fileTxt;
        String resultStr = null;
        try {
            fileTxt = loadFileToString(path);
            resultStr = addWordTestToMethodNames(fileTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File sourceFile = new File(path.replace("txt", "java"));
        Files.write(sourceFile.toPath(), resultStr.getBytes());

        // Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());
    }

    private String loadFileToString(String className) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(className))){
            while (reader.ready()){
                sb.append(reader.readLine());
            }
        }
        return sb.toString();
    }

    private String addWordTestToMethodNames(String fileTxt){
        return fileTxt.replaceAll("show", "testShow");
    }
}
