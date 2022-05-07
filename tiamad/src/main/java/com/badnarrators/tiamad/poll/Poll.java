package com.badnarrators.tiamad.poll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Poll {
    private UUID id;
    private String question;
    private List<PollVote> answers;
    private List<String> targets;
    private Date destructionTime;

    /**
     * Constructor. Initializes the poll.
     *
     * @param question The question of the poll.
     * @param answers  The list of answers for the poll.
     * @param targets  The list of targets for the poll.
     */
    public Poll(String question, List<String> answers, List<String> targets, Date destructionTime) {
        this.id = UUID.randomUUID();
        this.question = question;
        this.targets = targets;
        this.destructionTime = destructionTime;

        this.answers = new ArrayList<>();

        for (String answer : answers) {
            this.answers.add(new PollVote(answer));
        }
    }

    /**
     * Votes on an answer.
     *
     * @param id The id of the answer to vote on.
     */
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

    public Date getDestructionTime() {
        return destructionTime;
    }
}
