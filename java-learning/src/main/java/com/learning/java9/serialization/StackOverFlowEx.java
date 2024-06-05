package com.learning.java9.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverFlowEx {

    public static void main(String[] args) {
        System.out.println(stackOverflow().length);
       // System.out.println(deserialize(stackOverflow()));
        System.out.println("Deserializing using filter");
        ObjectInputFilter filter=ObjectInputFilter.Config.createFilter("maxdepth=2;java.base/*;!*");
        System.out.println(deserializeUsingFilter(stackOverflow(),filter));
    }

    private static byte[] stackOverflow(){
        Map map=new HashMap<>();
        List list=new ArrayList<>();
        map.put(list,"");
        list.add(list);
        return serialize(map);
    }

    private static byte[] serialize(Object o)  {
        try(ByteArrayOutputStream baos=new ByteArrayOutputStream(); ObjectOutputStream oos=new ObjectOutputStream(baos)){
            oos.writeObject(o);
            return baos.toByteArray();
        }
        catch(IOException e){
            throw new RuntimeException();
        }
    }

    private static Object deserialize(byte[] byteArr){
        try(ByteArrayInputStream bis=new ByteArrayInputStream(byteArr); ObjectInputStream ois=new ObjectInputStream(bis)){
            return ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static Object deserializeUsingFilter(byte[] byteArr,ObjectInputFilter filter){
        try(ByteArrayInputStream bis=new ByteArrayInputStream(byteArr);ObjectInputStream ois=new ObjectInputStream(bis)){
            ois.setObjectInputFilter(filter);
            return ois.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
