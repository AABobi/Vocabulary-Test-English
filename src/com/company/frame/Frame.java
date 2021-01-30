package com.company.frame;

import com.company.FileRdr;
import com.company.connectionDB.DatabaseConn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Frame implements ActionListener {
    private JButton pointsFrame, mistakesFrame, query, answer1, answer2,
            answer3, answer4, b8,b9, selectEnglishLanguage, selectPolishLanguage;
    JLabel l1;
    private int wordId = 0, trueAnswerPosition, keyId, points = 0, mistakes = 0,language = 0;
    private List<String> listPol = new LinkedList<>();
    private List<String> listEng = new LinkedList<>();
    DatabaseConn dbC = new DatabaseConn();
    private FileRdr fileRdr;
    JFrame frame = new JFrame();

    public Frame(FileRdr fr, int keyId) {
        this.listPol.addAll(fr.right);
        this.listEng.addAll(fr.left);
        this.keyId = keyId;
        this.fileRdr = new FileRdr(fr);
    }

    public void FrameMethod() {
        pointsFrame = new JButton("Points");
        pointsFrame.setBounds(50, 100, 120, 30);
        pointsFrame.addActionListener(this);

        mistakesFrame = new JButton("Mistakes");
        mistakesFrame.setBounds(50, 160, 120, 30);
        mistakesFrame.addActionListener(this);

        query = new JButton("Click to start");
        query.setBounds(200, 420, 230, 30);
        query.addActionListener(this);

        answer1 = new JButton("");
        answer1.setBounds(50, 480, 230, 30);
        answer1.addActionListener(this);

        answer2 = new JButton("");
        answer2.setBounds(50, 540, 230, 30);
        answer2.addActionListener(this);

        answer3 = new JButton("");
        answer3.setBounds(330, 540, 230, 30);
        answer3.addActionListener(this);

        answer4 = new JButton("");
        answer4.setBounds(330, 480, 230, 30);
        answer4.addActionListener(this);

        b8 = new JButton("Start again");
        b8.setBounds(350, 100, 120, 30);
        b8.addActionListener(this);

        b9 = new JButton("Good answer");
        b9.setBounds(50, 200, 120, 30);
        b9.addActionListener(this);

        selectEnglishLanguage = new JButton("Change to eng");
        selectEnglishLanguage.setBounds(350, 200, 120, 30);
        selectEnglishLanguage.addActionListener(this);

        selectPolishLanguage = new JButton("Change to pl");
        selectPolishLanguage.setBounds(350, 250, 120, 30);
        selectPolishLanguage.addActionListener(this);

        l1 = new JLabel();
        l1.setBounds(50, 25, 100, 30);
        l1.setText("");

        frame.add(l1);
        frame.add(pointsFrame);
        frame.add(mistakesFrame);
        frame.add(query);
        frame.add(answer1);
        frame.add(answer2);
        frame.add(answer3);
        frame.add(answer4);
        frame.add(b8);
        frame.add(b9);
        frame.add(selectEnglishLanguage);
        frame.add(selectPolishLanguage);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
    }

    private void setAnswerButtonsTextEng(JButton b4, JButton b5, JButton b6, JButton b7) {
        Random rand = new Random();
        Set<Integer> words = new TreeSet<>();
        int trueWord, word, iterator = 0;
        boolean checker = false;
        trueWord = rand.nextInt(4);

        do {
            if (iterator == trueWord) {
                checker = true;
            }
            if (checker == false) {
                word = rand.nextInt(listEng.size());
                words.add(word);
            } else if (!words.contains(wordId)) {
                words.add(wordId);
                checker = false;
            } else if (words.contains(wordId)) {
                checker = false;
            }
            iterator++;
        } while (words.size() != 4);
        Iterator<Integer> setText = words.iterator();

        ArrayList<Integer> buttonText = new ArrayList<>();
        while (setText.hasNext()) {
            iterator = setText.next();
            buttonText.add(iterator);
        }
        for (int i = 0; i < buttonText.size(); i++) {
            // System.out.println(buttonText.get(i)+" petla\n");
            if (buttonText.get(i) == wordId) {
                trueAnswerPosition = i;
            }
        }

        b4.setText(listEng.get(buttonText.get(0)));
        b5.setText(listEng.get(buttonText.get(1)));
        b6.setText(listEng.get(buttonText.get(2)));
        b7.setText(listEng.get(buttonText.get(3)));
    }

    private void setAnswerButtonsTextPol(JButton b4, JButton b5, JButton b6, JButton b7) {
        Random rand = new Random();
        Set<Integer> words = new TreeSet<>();
        int trueWord, word, iterator = 0;
        boolean checker = false;
        trueWord = rand.nextInt(4);

        do {
            if (iterator == trueWord) {
                checker = true;
            }
            if (checker == false) {
                word = rand.nextInt(listPol.size());
                words.add(word);
            } else if (!words.contains(wordId)) {
                words.add(wordId);
                checker = false;
            } else if (words.contains(wordId)) {
                checker = false;
            }
            iterator++;
        } while (words.size() != 4);
        Iterator<Integer> setText = words.iterator();

        ArrayList<Integer> buttonText = new ArrayList<>();
        while (setText.hasNext()) {
            iterator = setText.next();
            buttonText.add(iterator);
        }
        for (int i = 0; i < buttonText.size(); i++) {
            // System.out.println(buttonText.get(i)+" petla\n");
            if (buttonText.get(i) == wordId) {
                trueAnswerPosition = i;
            }
        }

        b4.setText(listPol.get(buttonText.get(0)));
        b5.setText(listPol.get(buttonText.get(1)));
        b6.setText(listPol.get(buttonText.get(2)));
        b7.setText(listPol.get(buttonText.get(3)));
    }

    private void pointsButton() {
        points++;
        pointsFrame.setText("Points " + String.valueOf(points));
    }

    private void actionButtV2(int languageInside, Object source){
        if(languageInside == 1) {
            actionButtEng(source);
        }else if(languageInside ==2){
            actionButtPol(source);
        }


    }
    private void actionButtEng(Object source) {
        if (source == pointsFrame) {
            //dbC.executeQueryDb(listPol);
        } else if (source == mistakesFrame) {
            /*try {
                dbC.deleteRowsByIdButton(keyId);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }*/
        } else if ((source == selectEnglishLanguage) || (source == query)) {
            answer1.setVisible(true);
            answer2.setVisible(true);
            answer3.setVisible(true);
            answer4.setVisible(true);

            // UNCOMMENT b3 HERE AND COMMENT IN POL

            query.setText(listEng.get(wordId));
            setAnswerButtonsTextPol(answer1, answer2, answer3, answer4);
            System.out.println(query.getText());
            wordId++;
        } else if (source == answer1) {
            if (trueAnswerPosition == 0) {
                pointsButton();
                // points++;
                // b1.setText(String.valueOf(points));
            } else {

                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listEng.get(wordId));
            setAnswerButtonsTextPol(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == answer2) {
            if (trueAnswerPosition == 1) {
                pointsButton();
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listEng.get(wordId));
            setAnswerButtonsTextPol(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == answer3) {
            if (trueAnswerPosition == 2) {
                pointsButton();
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listEng.get(wordId));
            setAnswerButtonsTextPol(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == answer4) {
            if (trueAnswerPosition == 3) {
                pointsButton();
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listEng.get(wordId));
            setAnswerButtonsTextPol(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == b8) {
            frame.setVisible(false);
            Frame s = new Frame(fileRdr, 3);
            s.FrameMethod();
        }
    }

    private void actionButtPol(Object source) {
        if (source == pointsFrame) {
            //dbC.executeQueryDb(listPol);
        } else if (source == mistakesFrame) {
            /*try {
                dbC.deleteRowsByIdButton(keyId);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }*/
        } else if ((source == selectPolishLanguage) || (source == query)) {
            answer1.setVisible(true);
            answer2.setVisible(true);
            answer3.setVisible(true);
            answer4.setVisible(true);
            query.setText(listPol.get(wordId));
            setAnswerButtonsTextEng(answer1, answer2, answer3, answer4);
            System.out.println(query.getText());
            wordId++;
        } else if (source == answer1) {
            if (trueAnswerPosition == 0) {
                pointsButton();
                // points++;
                // b1.setText(String.valueOf(points));
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listPol.get(wordId));
            setAnswerButtonsTextEng(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == answer2) {
            if (trueAnswerPosition == 1) {
                pointsButton();
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listPol.get(wordId));
            setAnswerButtonsTextEng(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == answer3) {
            if (trueAnswerPosition == 2) {
                pointsButton();
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listPol.get(wordId));
            setAnswerButtonsTextEng(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == answer4) {
            if (trueAnswerPosition == 3) {
                pointsButton();
            } else {
                mistakes++;
                mistakesFrame.setText("Mistakes " + String.valueOf(mistakes));
            }
            query.setText(listPol.get(wordId));
            setAnswerButtonsTextEng(answer1, answer2, answer3, answer4);
            wordId++;
        } else if (source == b8) {
            frame.setVisible(false);
            Frame s = new Frame(fileRdr, 3);
            s.FrameMethod();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (wordId == listEng.size()) {
            wordId = 0;
        }
        Object source = e.getSource();
        /*if(source == b3){
            fileRdr.methodRdr();
            this.listPol.addAll(fileRdr.right);
            this.listEng.addAll(fileRdr.left);
        }*/


        if(source == selectEnglishLanguage){
            //actionButtEng(source);\
            language = 1;
            fileRdr.methodRdr();
            this.listPol.addAll(fileRdr.right);
            this.listEng.addAll(fileRdr.left);
        }
        if(source == selectPolishLanguage){
            //actionButtPol(source);
            language = 2;
            fileRdr.methodRdr();
            this.listPol.addAll(fileRdr.right);
            this.listEng.addAll(fileRdr.left);
        }

      //  actionButtEng(source);
        actionButtV2(language,source);
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getTrueAnswerPosition() {
        return trueAnswerPosition;
    }

    public void setTrueAnswerPosition(int trueAnswerPosition) {
        this.trueAnswerPosition = trueAnswerPosition;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<String> getListPol() {
        return listPol;
    }

    public void setListPol(List<String> listPol) {
        this.listPol = listPol;
    }

    public List<String> getListEng() {
        return listEng;
    }

    public void setListEng(List<String> listEng) {
        this.listEng = listEng;
    }

    public FileRdr getFileRdr() {
        return fileRdr;
    }

    public void setFileRdr(FileRdr fileRdr) {
        this.fileRdr = fileRdr;
    }
}
