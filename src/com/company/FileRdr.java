package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileRdr {

    public List<String> left = new LinkedList<>();//eng
    public List<String> right = new LinkedList<>();//pl

    public FileRdr(FileRdr fileRdr){
      this.left = fileRdr.left;
      this.right = fileRdr.right;
    }

    public FileRdr() {

    }

   /* public  FileRdr() {
        try {
            int i = 0;
            File file = new File("ang.txt");
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {

                String str = scanner.nextLine();
                String[] tokens = str.split("-");
                // String tab - replaceAll delete all whitespace and split divides String when found " - "
              for(int j = 0; j < tokens.length; j++){
                  tokens[j] = tokens[j].trim().replaceAll("[ ]{2,}"," ");
              }



                for (String x : tokens) {
                    if ((i % 2) == 0) {
                        left.add(x);
                    } else {
                        right.add(x);
                    }
                    i++;
                }
                // This loop segregates words
            }

           /* System.out.println(left.size());
            for (String x : left) {
                System.out.println(x);
            }
            for (String x : right) {
                System.out.println(x);
            }

            for(int ii = 0; ii < left.size(); ii++){
                System.out.println(left.get(ii)+"  "+right.get(ii));
            }*/

    //    } catch (FileNotFoundException e) {
    //        System.out.println("sth");
   //         e.printStackTrace();
  //      }
 //   }

    public void methodRdr(){
        {
            try {
                int i = 0;
                File file = new File("ang.txt");
                Scanner scanner = new Scanner(file);


                while (scanner.hasNextLine()) {

                    String str = scanner.nextLine();
                    String[] tokens = str.split("-");
                    // String tab - replaceAll delete all whitespace and split divides String when found " - "
                    for(int j = 0; j < tokens.length; j++){
                        tokens[j] = tokens[j].trim().replaceAll("[ ]{2,}"," ");
                    }



                    for (String x : tokens) {
                        if ((i % 2) == 0) {
                            left.add(x);
                        } else {
                            right.add(x);
                        }
                        i++;
                    }
                    // This loop segregates words
                }

           /* System.out.println(left.size());
            for (String x : left) {
                System.out.println(x);
            }
            for (String x : right) {
                System.out.println(x);
            }

            for(int ii = 0; ii < left.size(); ii++){
                System.out.println(left.get(ii)+"  "+right.get(ii));
            }*/

            } catch (FileNotFoundException e) {
                System.out.println("sth");
                e.printStackTrace();
            }
        }
    }

    //This class gets words from lists
    public void generateWordNumber(){
        List<Integer> m = new LinkedList();
        Random generator = new Random();
        int points = 0;
        String s;
        System.out.println("Write 'kk' if you want to exit");
        System.out.println("1 = eng"+"   " +"2 = pol");
        Scanner chooseLang = new Scanner(System.in);
        int chL = chooseLang.nextInt();

        switch (chL){
            case 1:
                do {
                int index = generator.nextInt(left.size()-1);
                String engWord = left.get(index);
                System.out.println(engWord);
                Scanner scanner = new Scanner(System.in);
                s = scanner.nextLine();

                if(right.get(index).equalsIgnoreCase(s)) {
                    System.out.println("Correct");
                    points++;
                }else {
                    if (s.equals("kk")) {
                        System.out.println("Are you sure? y/n");
                        Scanner scanner2 = new Scanner(System.in);
                        String checker = scanner2.nextLine();
                        if (checker.equals("n"))
                            s = "n";
                    } else {
                        System.out.println("nope");
                    }
                }

            }while(!"kk".equals(s));

            case 2:{
                do {
                    int index = generator.nextInt(right.size()-1);
                    String engWord = right.get(index);
                    System.out.println(engWord);
                    Scanner scanner = new Scanner(System.in);
                    s = scanner.nextLine();

                    if(left.get(index).equalsIgnoreCase(s)) {
                        System.out.println("Correct");
                        points++;
                    }else {
                        if (s.equals("kk")) {
                            System.out.println("Are you sure? y/n");
                            Scanner scanner2 = new Scanner(System.in);
                            String checker = scanner2.nextLine();
                            if (checker.equals("n"))
                                s = "n";
                        } else {
                            System.out.println("nope");
                        }
                    }

                }while(!"kk".equals(s));
            }
        }



    }

    public void createSegFile(){


        try{
            File newFile = new File("posegregowane.txt");
            if(newFile.createNewFile()) {
                System.out.println("file created");
            }else{
                    System.out.println("File exist");

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
