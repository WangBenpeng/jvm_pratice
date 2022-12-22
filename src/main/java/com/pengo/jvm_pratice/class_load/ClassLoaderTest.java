package com.pengo.jvm_pratice.class_load;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Benpeng
 * @date 2022/12/20
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (null == is) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Object obj = myLoader.loadClass("com.pengo.jvm_pratice.class_load.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.pengo.jvm_pratice.class_load.ClassLoaderTest);
        System.out.println(obj instanceof ClassLoaderTest);
    }
}
