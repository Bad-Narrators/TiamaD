package com.badnarrators.tiamad.polls.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.badnarrators.tiamad.polls.entity.Poll;
import com.badnarrators.tiamad.polls.entity.PollVote;

import org.springframework.stereotype.Component;

@Component
public class PollManager {
    private List<Poll> polls;

    public PollManager() {
        this.polls = new ArrayList<>();
    }

    public Poll addPoll(String question, Map<Integer, PollVote> answers, List<String> targets) {
        Poll poll = new Poll(question, answers, targets);
        this.polls.add(poll);

        return poll;
    }

    public Poll updatePoll(UUID pollId, int questionId) {
        Poll poll = this.polls.stream().filter(p -> p.getId().equals(pollId)).findFirst().orElse(null);

        if (poll != null) {
            poll.vote(questionId);
        }

        return poll;
    }

    public void deletePoll(UUID id) {
        this.polls.removeIf(p -> p.getId().equals(id));
    }
}
