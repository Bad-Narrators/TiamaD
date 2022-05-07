package com.badnarrators.tiamad.poll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PollRequest {
    private String question;
    private List<String> answers;
    private List<String> targets;
    private Date destructionTime;

    public PollRequest(String question, List<String> answers, List<String> targets, String destructionTime) {
        this.question = question;
        this.answers = answers;
        this.targets = targets;

        SimpleDateFormat destructionTimeFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try {
            this.destructionTime = destructionTimeFormatter.parse(destructionTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    public Date getDestructionTime() {
        return destructionTime;
    }

    public void setDestructionTime(Date destructionTime) {
        this.destructionTime = destructionTime;
    }
}
