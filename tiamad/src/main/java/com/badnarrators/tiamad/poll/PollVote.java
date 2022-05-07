package com.badnarrators.tiamad.poll;

import java.util.concurrent.atomic.LongAdder;

public class PollVote {
    private String answer;
    private LongAdder count;

    public PollVote(String answer) {
        this.answer = answer;
        this.count = new LongAdder();
    }

    public void vote() {
        this.count.increment();
    }

    public String getAnswer() {
        return answer;
    }

    public LongAdder getCount() {
        return count;
    }

}
