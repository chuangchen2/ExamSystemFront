/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import domain.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aa769
 */
public class QuestionUtil {
    private static List<Question> list;
    private static String name;
    private static Question choice;
    private static Question trueOrFalse;
    private static List<String> choiceAnswer;
    private static List<String> trueOrFalseAnswer;

    public static void setChoiceAnswerItem(int index, String answer) {
        choiceAnswer.set(index, answer);
    }
    
    public static String getChoiceAnswerItem(int index) {
        return choiceAnswer.get(index);
    }
    
    public static void setTrueOrFalseAnswerItem(int index, String answer) {
        trueOrFalseAnswer.set(index, answer);
    }
    
    public static String getTrueOrFalseAnswerItem(int index) {
        return trueOrFalseAnswer.get(index);
    }
    
    public static List<Question> getList() {
        return list;
    }

    public static void setList(List<Question> list) {
        QuestionUtil.list = list;
        for(Question item : list) {
            if(item.getType().equals("0")) {
                QuestionUtil.setChoice(item);
            } else if (item.getType().equals("1")) {
                QuestionUtil.setTrueOrFalse(item);
            }
        }
        choiceAnswer = new ArrayList<>(choice.getItems().size());
        for(int i = 0; i < choice.getItems().size(); i++) {
            choiceAnswer.add("");
        }
        trueOrFalseAnswer = new ArrayList<>(trueOrFalse.getItems().size());
        for(int i = 0; i < trueOrFalse.getItems().size(); i++) {
            trueOrFalseAnswer.add("");
        }
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        QuestionUtil.name = name;
    }

    public static Question getChoice() {
        return choice;
    }

    public static void setChoice(Question choice) {
        QuestionUtil.choice = choice;
    }

    public static Question getTrueOrFalse() {
        return trueOrFalse;
    }

    public static void setTrueOrFalse(Question trueOrFalse) {
        QuestionUtil.trueOrFalse = trueOrFalse;
    }
    
}
