package com.company.connectionDB;

import java.sql.*;
import java.util.List;


public class DatabaseConn {


    //isItInDatabase - this method takes a value (word) and compares this word with words in database
    private boolean isItInDatabase(ResultSet rs, Object x, String s) throws SQLException {
        String word;
        while (rs.next()) {
            word = rs.getString(s);
          //  System.out.println(word + "   " + x);
            if (word.equalsIgnoreCase((String) x)) {
                return true;
            }
        }
        return false;
    }

    //this methos searches for max id number in db
    private int maxId(ResultSet rs, String s) throws SQLException {
        int itera = 0;
        while (rs.next()) {
            if (itera < rs.getInt(s)) ;
            itera = rs.getInt(s);
        }
        return itera;
    }

    private void deleteRowsById(ResultSet rs, int id, Statement myStmt, String table, String columnName) throws SQLException {

        String sqlCom = new StringBuilder()
                .append("Delete from ")
                .append(table)
                .append(" where ")
                .append(columnName)
                .append(" > ")
                .append(id)
                .toString();
        System.out.println(sqlCom);
        myStmt.executeUpdate(sqlCom);
    }

    //This method delete data from database using id
    public void deleteRowsByIdButton(int id) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdatabase", "root", "1234");

            Statement myStmt = con.createStatement();
            ResultSet rs = myStmt.executeQuery("Select * from Polish");
            String sqlCom = new StringBuilder()
                    .append("Delete from ")
                    .append("Polish")
                    .append(" where ")
                    .append("PolishId")
                    .append(" > ")
                    .append(id)
                    .toString();
          //  System.out.println(sqlCom);
            myStmt.executeUpdate(sqlCom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQueryDb(List<?> listPol) {
        try {
            //jdbc driver - url to DB, user and password
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdatabase", "root", "1234");

            Statement myStmt = con.createStatement();
            for (int i = 0; i < listPol.size(); i++) {
                ResultSet rs = myStmt.executeQuery("Select * from Polish");
                rs.beforeFirst();
                if (isItInDatabase(rs, listPol.get(i), "PolWord")) {
                    continue;
                }

                rs.beforeFirst();
                int newId = maxId(rs, "PolishId") + 1;
            //    System.out.println(newId);
                // String s = "dupa";
                String sqlCommend = new StringBuilder()
                        .append("INSERT INTO polish (PolishId,PolWord) VALUES (")
                        .append(newId)
                        .append(",'")
                        .append(listPol.get(i))
                        .append("')")
                        .toString();
                //rs.beforeFirst();
                //  System.out.println(sqlCommend);
                myStmt.executeUpdate(sqlCommend);

            }


            //ResultSet rs = myStmt.executeQuery("Select * from Polish");


            //deleteRowsById(rs, 3, myStmt, "polish", "PolishId");

            /////////////////////////////
            //executeUpdate, ResultSet executeQuery
          /* myStmt.executeUpdate("INSERT INTO student (idStudent,name) VALUES (9,a)" );

            ResultSet rs = myStmt.executeQuery("Select * from Polish");
            while (rs.next()) {
                System.out.println(rs.getString("PolWord"));
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connectToDatabase(List<?> listPol, List<?> listEng) {

        try {
            //jdbc driver - url to DB, user and password
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdatabase", "root", "1234");

            Statement myStmt = con.createStatement();
            //create statement to communicate with Db
/////////////////////////////
            //ResultSet rs = myStmt.executeQuery("Select * from Polish");
            //  String s = "INSERT INTO polish (PolishId,PolWord) VALUES (9,'aaa')" ;
          /* String ss = new StringBuilder()
                    .append("INSERT INTO polish (PolishId,PolWord) VALUES (")
                    .append(10)
                    .append(",'")
                    .append("dupa")
                    .append("')")
                    .toString();
            System.out.println(ss);

            String sss = "INSERT INTO polish (PolishId,PolWord) VALUES (10,'dupa')";
            System.out.println(ss);
            System.out.println(sss.equalsIgnoreCase(ss));
             myStmt.executeUpdate(ss);
*/
            for (int i = 0; i < listPol.size(); i++) {
                ResultSet rs = myStmt.executeQuery("Select * from Polish");
                rs.beforeFirst();
                if (isItInDatabase(rs, listPol.get(i), "PolWord")) {
                    continue;
                }

                rs.beforeFirst();
                int newId = maxId(rs, "PolishId") + 1;
                System.out.println(newId);
                // String s = "dupa";
                String sqlCommend = new StringBuilder()
                        .append("INSERT INTO polish (PolishId,PolWord) VALUES (")
                        .append(newId)
                        .append(",'")
                        .append(listPol.get(i))
                        .append("')")
                        .toString();
                //rs.beforeFirst();
                //  System.out.println(sqlCommend);
                myStmt.executeUpdate(sqlCommend);

            }


            ResultSet rs = myStmt.executeQuery("Select * from Polish");


            deleteRowsById(rs, 3, myStmt, "polish", "PolishId");

            /////////////////////////////
            //executeUpdate, ResultSet executeQuery
          /* myStmt.executeUpdate("INSERT INTO student (idStudent,name) VALUES (9,a)" );

            ResultSet rs = myStmt.executeQuery("Select * from Polish");
            while (rs.next()) {
                System.out.println(rs.getString("PolWord"));
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
