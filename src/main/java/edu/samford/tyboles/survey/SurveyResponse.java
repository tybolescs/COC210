/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.tyboles.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Tyrone
 */
public class SurveyResponse {
// Attributes
    protected Answer[] answers;
    protected int numanswers;
    
    public SurveyResponse(int size) {
        this.numanswers = 0;
        this.answers = new Answer[size];
    }

    /**
     * Record the answer into our answers array.
     * @param answer 
     */
    
    public void addAnswer(Answer answer) {
        answers[numanswers++] = answer;
    }

    /**
     * Writes the survey response answers out to a file in this format:
     * 7| I know this topic pretty well.
     * 1| I have no idea what that is.
     * 10| I have written a bunch of programs that do File I/O
     * @param filename
     * @throws FileNotFoundException 
     */
    public void save(String filename) throws FileNotFoundException {
        File f = new File(filename);
        PrintWriter out = new PrintWriter(f);
        for (int i = 0; i < numanswers; i++) {
            Answer answer = answers[i];
            out.println(answer.scaleResponse + "|" + answer.additionalResponse);
            
        }
        out.close();
    }
    
}
