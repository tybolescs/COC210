/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.tyboles.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Tyrone
 */
public class SurveyResults {
    // Attributes
    protected Survey survey;
    protected SurveyResponse responses[];
    protected int numresponses;
    public static int MAXFILES = 100; // assume that we wil never have more than 100 responses
    
    SurveyResults(Survey survey) {
        this.survey = survey;
        this.numresponses = 0;
        this.responses = new SurveyResponse [MAXFILES];
    }
    
    /**
     * Read all the responses from text files in the given directory
     * 
     * @path The relative path where all the responses are stored
     */
    public void readResponses(String path) throws FileNotFoundException {
        File dir = new File(path);
        File files[] = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                Scanner filein = new Scanner (file);
                SurveyResponse response = new SurveyResponse(survey.numquestions);
                int qi = 0; // current question number(index)
                while(filein.hasNextLine()){
                    String line = filein.nextLine();
                    String parts[] = line.split("\\|");
                    if(parts.length!=2){
                        continue;
                    }
                    int scaleResponse = Integer.parseInt(parts[0]);
                    Answer answer = new Answer(survey.questions[qi], scaleResponse, parts[1]);
                    qi++; //advance to the next question
                    response.addAnswer(answer);
                    
                    
                }
                responses[numresponses++] = response;
            }
        }
              
    }
    
    /**
     * Process all the responses by calculating the averages and joining all 
     */
    public void processResponses(){
        // Data we need for the calculations
        double totals [] = new double[survey.numquestions];
        double averages[] = new double [survey.numquestions];
        String comments[] = new String[survey.numquestions];
        
        for (SurveyResponse response : responses) {
            if (response!= null)
            for (int qi=0; qi<response.numanswers; qi++) {
                totals[qi] += response.answers[qi].scaleResponse;
                comments[qi] += "|" + response.answers[qi].additionalResponse;
            }
        }
        
        // Calculate the averages by dividing all the totals by the number of responses
        for (int ti=0; ti<totals.length; ti++){
            totals[ti] = totals[ti] / numresponses;
        }
        
        for (int qi = 0; qi<survey.numquestions; qi++) {
            Question q = survey.questions[qi];
            System.out.println(q.prompt + " - " + totals[qi] + " - " + comments[qi]);
        }
    }
}
