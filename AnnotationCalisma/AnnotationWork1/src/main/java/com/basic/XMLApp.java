package com.basic;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XMLApp {


    public static void main(String[] args) {

//        Employee e1=new Employee("Can",5);
//
//        try {
//            FileOutputStream outStream=new FileOutputStream(new File(".\\src\\xmlfile\\basicxml.xml"));
//
//            XMLEncoder encoder=new XMLEncoder(outStream);
//            encoder.writeObject(e1);
//            encoder.close();
//            outStream.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            XMLDecoder decoder=new XMLDecoder(new FileInputStream(new File(".\\src\\xmlfile\\basicxml.xml")));
            Object readObject= decoder.readObject();
            System.out.println(readObject.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
