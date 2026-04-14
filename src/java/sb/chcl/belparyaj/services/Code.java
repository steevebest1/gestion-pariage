/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sb.chcl.belparyaj.services;

/**
 *
 * @author Steeve
 */
public class Code {
    public static int generateInt(){
        int id=0;
       int a = (int) Math.floor(Math.random()*10000);
       int b = (int) Math.floor(Math.random()*10000);
       int c = (int) Math.floor(Math.random()*10000);
       id = (a+b+c);
        return id;
    }
    public static String generate(String s){
        String code;
        int id = 0; 
       int a = (int) Math.floor(Math.random()*10000);
       int b = (int) Math.floor(Math.random()*10000);
       int c = (int) Math.floor(Math.random()*10000);
       id = (a+b+c);
       code = s.concat("-"+String.valueOf(id));
        return code;
    }
}
