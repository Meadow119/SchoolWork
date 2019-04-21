/********************************
 * Bradley Poleski
 * Java Programming I
 * CIS117.2476.W18
 * Professor Koets
 * Word Order Game
 * This program creates a word game in a JFrame window.
 ********************************/

import javax.swing.*; //For JFrame
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.*;


public class WordOrderFun extends JFrame {
    public static void main(String[] args) {


        JFrame frame = new WordOrderFun();
        frame.setTitle("Word Order Game");
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Panels
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel headingPanel = new JPanel(new GridLayout(1, 1));
        JPanel welcomePanel = new JPanel(new GridLayout(1, 1));
        JPanel instructionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel wordArrayPanel = new JPanel(new GridLayout(6, 5));
        JPanel insertWordPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel result= new JLabel(); //for the output later
            resultPanel.add(result);


        //Adding to header panel
        JLabel heading = new JLabel();
        heading.setText("Fun With Words");
        heading.setFont(heading.getFont().deriveFont(26f));
        heading.setPreferredSize(new Dimension(WIDTH, 4 * HEIGHT));
        headingPanel.add(heading);

        //Instruction Panel text
        JLabel welcome = new JLabel("Hey kids! Want to practice your typing and word ordering skills?");
        welcomePanel.add(welcome);
        JLabel instructions = new JLabel("Pick two words from the following list, enter them into the boxes in the correct order, and then press the Done Key.");
        instructionPanel.add(instructions);

        //Word Array
        ArrayList<String> words = new ArrayList<>();
        words.add("dog");
        words.add("tree");
        words.add("ball");
        words.add("cat");
        words.add("cow");
        words.add("eat");
        words.add("dogma");
        words.add("troglodyte");
        words.add("ice");
        words.add("cowboy");
        words.add("snout");
        words.add("pig");
        words.add("man");
        words.add("woman");
        words.add("log");
        words.add("lonely");
        words.add("desk");
        words.add("treason");
        words.add("supercilious");
        words.add("super");
        words.add("zeal");
        words.add("zoo");
        words.add("my");
        words.add("do");
        words.add("scant");
        words.add("bike");
        words.add("dirt");
        words.add("smile");
        words.add("mom");
        words.add("nose");

        for(String word: words){
            JLabel thisWord = new JLabel(word);
            wordArrayPanel.add(thisWord);
        }


        //Creating input areas
        JTextField first = new JTextField(15);
        JLabel goesBefore = new JLabel("goes before");
        JTextField second = new JTextField(15);
        insertWordPanel.add(first);
        insertWordPanel.add(goesBefore);
        insertWordPanel.add(second);

        //Creating Buttons
        JButton done = new JButton("Done");
        ActionListener enter = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (first.getText().equals("")&&(second.getText().equals(""))){
                    result.setText("Enter words in both boxes. Then press done.");
                }
                else if(first.getText().equals("")){
                    result.setText("Please enter a word in the first box.");
                }
                else if(second.getText().equals("")){
                    result.setText("Please enter a word in the second box.");
                }
                else{
                if (first.getText().equals(second.getText())){
                    result.setText("You entered the same words. Try again.");
                }
                else if(!words.contains(first.getText())&&(!words.contains(second.getText()))){
                    result.setText("Neither word is in the word list. Try again.");
                }
                else if(!words.contains(first.getText())){
                    result.setText("First entry not in list - check spelling");
                }
                else if(!words.contains(second.getText())){
                    result.setText("Second entry not in list - check spelling");
                }
                else{
                    int firstWordCount = 0;
                    int secondWordCount = 0;
                    Collections.sort(words);
                    for(String word:words){
                        if (first.getText().equals(word)){
                            break;
                        }
                        firstWordCount++;
                        System.out.println(firstWordCount);
                    }
                    for(String word:words){
                        if (second.getText().equals(word)){
                            break;
                        }
                        secondWordCount++;
                        System.out.println(secondWordCount);
                    }
                    if(firstWordCount<secondWordCount){
                        result.setText("Well done!");
                    }
                    else{
                    result.setText("Wrong. Try again.");}
                }}
            }
        };
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                first.setText("");
                second.setText("");
                result.setText("");
            }
        });

        //adding action listener
        first.addActionListener(enter);
        second.addActionListener(enter);
        done.addActionListener(enter);

        buttonPanel.add(done);
        buttonPanel.add(clear);


        //Add panels to main panel
        mainPanel.add(headingPanel);
        mainPanel.add(welcomePanel);
        mainPanel.add(instructionPanel);
        mainPanel.add(wordArrayPanel);
        mainPanel.add(insertWordPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);


        //Creating Layout
        frame.setLayout(new FlowLayout());
        frame.add(mainPanel);

    }
}
