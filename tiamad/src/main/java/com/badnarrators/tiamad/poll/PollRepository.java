package com.badnarrators.tiamad.poll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PollRepository {
    private List<Poll> polls;

    public PollRepository() {
        this.polls = new ArrayList<>();
    }

    public Poll getPoll(UUID pollId) {
        return polls.stream().filter(poll -> poll.getId().equals(pollId)).findFirst().orElse(null);
    }

    public List<Poll> getPollsFromTarget(String target) {
        return polls.stream().filter(poll -> poll.getTargets().contains(target))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Poll addPoll(String question, Map<Integer, PollVote> answers, List<String> targets) {
        Poll poll = new Poll(question, answers, targets);
        this.polls.add(poll);

        return poll;
    }

    public Poll updatePoll(UUID pollId, int questionId) {
        Poll poll =
                this.polls.stream().filter(p -> p.getId().equals(pollId)).findFirst().orElse(null);

        if (poll != null) {
            poll.vote(questionId);
        }

        return poll;
    }

    public void deletePoll(UUID pollId) {
        this.polls.removeIf(p -> p.getId().equals(pollId));
    }
}
