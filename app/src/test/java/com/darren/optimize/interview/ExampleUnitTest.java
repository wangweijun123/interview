package com.darren.optimize.interview;

import com.darren.optimize.interview.java.Person;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    protected static int numOfInts = 4*1000*1000;

    @Test
    public void testReadWriteNoClose() throws IOException {
        testStreamWrite();
        testStreamRead();
    }

    @Test
    public void testStreamWrite() throws IOException {
        long starttime = System.currentTimeMillis();
//		 DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp")),16*1024*1024));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp_stream.tmp"))));
        for(int i = 0; i < numOfInts; i++){
            dos.writeInt(i);
        }
        /*if(dos != null){ // that an end of file or end of stream has been reached
            dos.close();
        }*/
        long endtime = System.currentTimeMillis();
        // testStreamWrite:290ms
        System.out.println("testStreamWrite:"+(endtime-starttime)+"ms");
    }

    @Test
    public void testStreamRead() throws IOException {
        long starttime = System.currentTimeMillis();
        //DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("temp.tmp")),16*1024*1024));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("temp_stream.tmp"))));
        for(int i = 0; i < numOfInts; i++){
            dis.readInt(); // java.io.EOFException
        }
        if(dis != null){
            dis.close();
        }
        long endtime = System.currentTimeMillis();
        // testStreamRead:403ms
        System.out.println("testStreamRead:"+(endtime-starttime)+"ms");
    }

    @Test
    public void testzhiling() {
        Person p = new Person();
        p.add();
    }
}