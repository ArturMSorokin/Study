package ru.innopolis.uni.course2;

/**
 * Created by olymp on 09.11.2016.
 */
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.ws.encoding.MtomCodec;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.security.Permission;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    static public void main(String[] ar) {
        ClassLoader cl = Integer.class.getClassLoader();
        System.out.println(cl);

        ClassLoader clm = Main.class.getClassLoader();
        System.out.println(clm);

        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);
        System.setSecurityManager(new SecurityManager());

        System.out.println(Main.class.getProtectionDomain().getClassLoader());

        Permission permission = new FilePermission("/temp/*","read");
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        String newClass = "package ru.innopolis.uni.course2; class NewClass { int i;}";
        byte[] sourceBytes = newClass.getBytes();
        InputStream source = new ByteArrayInputStream(sourceBytes);
        OutputStream classFile = new ByteArrayOutputStream();
        javaCompiler.run(source,classFile, null);
        return;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        do {
            System.out.println("enter class name:");
            String clName, clBody, clArgs;
            try {
                clName = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("enter class"):
            try {
                clBody = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("enter args");
            try {
                clArgs = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Class clazz = null;
            try {
                Executable executable = (Executable)clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }



        } while (!exit);

    }



}
