package com.learning.java9.serialization;

import com.learning.java9.util.Person;

import java.io.*;
import java.math.BigDecimal;

public class SerializeDeserializeEx {

    public static void main(String[] args) {
        byte[] serializeObj = serialize(new Person("Nidish", 32, new BigDecimal(121000)));
        Person deserializeObj = (Person) deserialize(serializeObj);
        System.out.println("Deserializing from object");
        System.out.println(deserializeObj);
        serializeToFile(new Person("Naija", 29, new BigDecimal(121000)));
        System.out.println("Deserializing from file");
        System.out.println(deserializeFromFile(new File("person.obj")));
    }

    public static byte[] serialize(Object person) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(baos)) {
            out.writeObject(person);
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println(e);
        }
        throw new RuntimeException("Serialization failed");
    }

    public static Object deserialize(byte[] byteArr) {
        InputStream is = new ByteArrayInputStream(byteArr);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        throw new RuntimeException("Deserialization failed");
    }

    private static void serializeToFile(Object person){
        try(FileOutputStream fos=new FileOutputStream(new File("person.obj"));ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(person);
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    private static Object deserializeFromFile(File file){
        try(FileInputStream fis=new FileInputStream(file);ObjectInputStream ois=new ObjectInputStream(fis)) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
