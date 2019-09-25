package org.gmnz.misc;


import java.io.File;
import java.net.MalformedURLException;

import org.junit.Test;


/**
 * SampleTest
 */
public class SampleTest {

    // "C:\dev\src\java-formatter-settings.xml"

    @Test
    public void sample() throws MalformedURLException {
        File f = new File("C:\\dev\\src\\java-formatter-settings.xml");
        System.out.println("URI : " + f.toURI());
        System.out.println("URL : " + f.toURI().toURL());
    }

}