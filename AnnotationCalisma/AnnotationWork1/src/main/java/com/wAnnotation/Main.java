package com.wAnnotation;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static void main(String[] args) {


//        try {
//            FileWriter writer = new FileWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String xmlFilePath=".\\src\\xmlfile\\deneme.xml";

        List<Jobs> jobslist=new ArrayList<Jobs>();
        jobslist.add(new Jobs("job1",1));
        jobslist.add(new Jobs("job2",2));

//        try {
//            Employee emp1=new Employee("can",1);
//            emp1.setJobs(jobslist);
//            convertoXML(emp1,xmlFilePath);
//
//        } catch (IllegalClassFormatException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        parseXml(xmlFilePath);
    }

    public static void convertoXML(Object obj,String xmlFilePath) throws IllegalClassFormatException, ParserConfigurationException, IllegalAccessException {


        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document =  documentBuilder.newDocument();


        Element root=document.createElement("Employees");
        document.appendChild(root);

        Class<? extends Object> rootObject =obj.getClass();


        Element rootElement=document.createElement(rootObject.getSimpleName());
        root.appendChild(rootElement);


        Field[] fields = rootObject.getDeclaredFields();

        for(Field field:fields){
            //System.out.println(field.getName());
            field.setAccessible(true);
            if(field.isAnnotationPresent(XmlField.class)){


                String tag= field.getAnnotation(XmlField.class).tag();
                String tagAtt = field.getAnnotation(XmlField.class).tagAtt();
                //verilen tag att. göre Tag oluşturur
                Element tagEmployee= document.createElement(tag);
                tagEmployee.appendChild(document.createTextNode(field.get(obj).toString()));
                //tagElement.setAttribute(tagAtt,field.get(obj).toString());
                tagEmployee.setAttribute(tagAtt, field.getType().toString());
                rootElement.appendChild(tagEmployee);


            }
            else if(field.isAnnotationPresent(XmlFieldReference.class)){

                field.setAccessible(true);
                String tag= field.getAnnotation(XmlFieldReference.class).tag();
                String type = field.getAnnotation(XmlFieldReference.class).type();


                Element childRoot=document.createElement(tag);
                rootElement.appendChild(childRoot);

                Object value = field.get(obj);
                if(value instanceof List<?>){
                    //System.out.println(value.getClass());
                    List<?> objList=(List<?>) value;

                   for(Object job:objList){

                       Class<? extends Object> childObject=job.getClass();
                       Field[] childfields = childObject.getDeclaredFields();
                       for(Field childfield:childfields) {
                           childfield.setAccessible(true);
                           if(childfield.isAnnotationPresent(XmlField.class)){
                               //create tag
                               tag= childfield.getAnnotation(XmlField.class).tag();
                               Element tagElement = document.createElement(tag);

                               tagElement.appendChild(document.createTextNode(childfield.get(job).toString()));
                               //there is no attribute
                               childRoot.appendChild(tagElement);

                           }
                       }

                   }


                }


            }



        }


        // create the xml file
        //transform the DOM Object to an XML File
        try {

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xmlFilePath));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

            System.out.println("\n XMLFile Created");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    public static void parseXml(String xmlFilePath) {


        try {
            File inputFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Employee");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    //System.out.println(eElement.getNodeName()+":");
                    System.out.println("Name:" + eElement.getElementsByTagName("Name").item(0).getTextContent());
                    System.out.println("id:" + eElement.getElementsByTagName("Id").item(0).getTextContent());

                    NodeList childrenList = eElement.getElementsByTagName("Jobs").item(0).getChildNodes();
                    for (int i = 0; i < childrenList.getLength(); i++) {
                        Node current = childrenList.item(i);
                        //Only want stuff from ELEMENT nodes
                        if (current.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println(current.getNodeName() + ": " + current.getTextContent());
                        }


                    }


                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


}
