package com.company;

import com.company.connectionDB.*;
import com.company.frame.Frame;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
        FileRdr fr = new FileRdr();
  //      System.out.println(fr.left.get(0));


        // fr.createSegFile();
      //  fr.generateWordNumber();
        //DatabaseConn dbCn = new DatabaseConn();
       //dbCn.executeQueryDb(fr.right,fr.left);
      // dbCn.deleteRowsByIdButton(3);


      Frame frame = new Frame(fr,3);
      frame.FrameMethod();




    }
}