package com.badnarrators.tiamad.poll;

import java.util.List;
import java.util.Map;

public class PollRequest {
    private String question;
    private Map<Integer, PollVote> answers;
    private List<String> targets;

    public PollRequest(String question, Map<Integer, PollVote> answers, List<String> targets) {
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

    public Map<Integer, PollVote> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, PollVote> answers) {
        this.answers = answers;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }
}
