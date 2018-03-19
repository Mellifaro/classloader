package com.epam.classloader;

import java.io.*;

public class CustomClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);
    }

    private byte[] loadClassData(String className){

//        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream("C:\\Users\\Viktor\\Desktop\\epam\\classloader\\src\\main\\java\\com\\epam\\classloader\\TryLoad.class"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int len = 0;
        try {
            while((len=is.read())!=-1){
                outputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //convert into byte array
        return outputStream.toByteArray();
    }
}
