package com.badnarrators.tiamad.poll;

import java.util.List;

public class PollRequest {
    private String question;
    private List<String> answers;
    private List<String> targets;

    public PollRequest(String question, List<String> answers, List<String> targets) {
        this.question = question;
        this.answers = answers;
        this.targets = targets;
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
}
