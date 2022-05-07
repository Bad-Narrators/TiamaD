package com.badnarrators.tiamad.poll;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Poll {
    private UUID id;
    private String question;
    private List<PollVote> answers;
    private List<String> targets;

    public Poll(String question, List<String> answers, List<String> targets) {
        this.id = UUID.randomUUID();
        this.question = question;
        this.targets = targets;

        this.answers = new ArrayList<>();

        for (String answer : answers) {
            this.answers.add(new PollVote(answer));
        }
    }

    public void vote(int id) {
        this.answers.get(id - 1).vote();
    }

    public UUID getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<PollVote> getAnswers() {
        return answers;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }
}
