/*
Name Project: Election Generator
Author: Nunzio Emanuele Sgroi

Description
This Java program is perfect for creating a voting system.
The user write down the candidates until he decides to stop and then
the program will generate the election counting and the winner will be announced.
 */

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectionGenerator {
    public static void main(String[] args) {

        System.out.println("""
                WELCOME USER
                This is the...
                <<<<<<<<<<<<<<<<< ELECTION GENERATOR >>>>>>>>>>>>>>>>>
                """);
        System.out.println("""
                Would you like a tutorial before start?
                [ 1 ] Yes, I want a tutorial!
                [ 2 ] No, let's vote!""");

        Scanner input = new Scanner(System.in);

        while(true) {
            String tutorial = input.nextLine();
            if (tutorial.equals("1")) {
                System.out.println("""
                        Tutorial:
                        Write in the name of the candidate and press enter.
                        Repeat this step as many time as you want.
                        If you want to vote the same candidate, write in his name again the next line.
                        Enter one vote per line only.
                        If  you enter [ -1 ] or the program detect an empty line,
                        the elections will terminate and the the program will tells you who got more votes
                        and the winner will be announced.
                        If the program will detect 0 votes the election will terminate with no result.\s""");
                System.out.println("Right, let's vote!!!\n");
                break;
            } else if (tutorial.equals("2")) {
                System.out.println("Right, let's vote!!!\n" +
                        "");
                break;
            } else {
                System.out.println("Please enter [ 1 ] to open the tutorial or [ 2 ] to skip");

            }
        }

// Election program starts here

        ArrayList <String> names = new ArrayList<>();
        ArrayList <Integer> votesCount = new ArrayList<>();

        System.out.println("Enter the votes, one vote per line");
        System.out.println("Close the election with [ -1 ] or empty line");

        boolean exit = false;

        while(true) {

            String vote = input.nextLine().trim().toUpperCase();

            if(vote.equals("-1") || vote.equals("")) {

                if(votesCount.isEmpty()){ //Close program if there are no candidates
                    System.out.println("There are no candidates\n" +
                            "Thanks for using ELECTION GENERATOR");
                    System.exit(1);
                }
                else { //End election
                    System.out.println("The Scoreboard:\n" +
                            "---------------------");
                    break;
                }
            }
            else {

                //Grow list and add votes
                for(int i = 0; i < names.size(); i++) {

                    if(!names.contains(vote)){
                        names.add(vote);
                        votesCount.add(1);
                        break;
                    }

                    if(names.get(i).equals(vote)) {
                        votesCount.set(i, votesCount.get(i) + 1);
                        exit = true;
                        break;
                    }

                }

                //Store candidates and votes
                if(!exit) {
                    names.add(vote);
                    votesCount.add(1);
                }

            }
        }

        //Third ArrayList to see if there is only one winner
        ArrayList <String> winners = new ArrayList<>();
        int highestVote = 0;

        for(int i = 0; i < votesCount.size(); i++){
            int count = votesCount.get(i);

            if(count > highestVote){
                highestVote = count;
            }
        }

        for(int i = 0; i < names.size(); i++){
            int count = votesCount.get(i);

            if(count == highestVote){
                winners.add(names.get(i));
            }
            //Scoreboard
            System.out.println(names.get(i) + " received " + votesCount.get(i) + " votes");
            System.out.println("---------------------");
        }

        //announce winner
        if(winners.size() == 1){
            System.out.println();
            System.out.println("The winner is:\n" +
                    ">>>>>" + winners.get(0) + "<<<<<") ;
            System.out.println("Congratulations!!!");
        }
        //in case of draw
        else{
            String drawList = winners.toString().replace(",","\n").replace("[","")
                    .replace("]","").replace(" ","").trim();
            System.out.println();
            System.out.println("The following candidates received the same amount of votes:");
            System.out.println(drawList);
            System.out.println();
            System.out.println(">>>>>DRAW<<<<<");
        }
        System.out.println();
        System.out.println("Thanks for using the ELECTION GENERATOR");

    }
}
