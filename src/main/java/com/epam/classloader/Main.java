package com.epam.classloader;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final String PATH = "C:\\Users\\Viktor\\Desktop\\epam\\classloader\\src\\main\\java\\";
    private static final String FILE_NAME = "com\\epam\\classloader\\TryLoad.txt";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, IOException {

        CustomCompiler compiler = new CustomCompiler();
        compiler.compileTXT(PATH + FILE_NAME);

        CustomClassLoader classLoader = new CustomClassLoader();
        Class<?> clazz = classLoader.findClass(FILE_NAME.replace(".txt", "").replaceAll("\\\\", "."));
        Object object = clazz.newInstance();
        Method md = clazz.getMethod("testShowTryLoad");
        md.invoke(object);
    }


}
