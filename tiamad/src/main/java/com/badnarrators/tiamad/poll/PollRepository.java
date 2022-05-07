package com.badnarrators.tiamad.poll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PollRepository {
    private List<Poll> polls;

    /**
     * Constructor. Initializes the polls list.
     */
    public PollRepository() {
        this.polls = new ArrayList<>();
    }

    /**
     * Gets a poll based on its id.
     *
     * @param pollId The id of the poll to get.
     * @return the poll with the given id or null if it doesn't exist.
     */
    public Poll getPoll(UUID pollId) {
        return polls.stream().filter(poll -> poll.getId().equals(pollId)).findFirst().orElse(null);
    }

    /**
     * Gets all polls for a given target.
     *
     * @param target The target to get polls for.
     * @return the polls for the given target.
     */
    public List<Poll> getPollsByTarget(String target) {
        return polls.stream().filter(poll -> poll.getTargets().contains(target)).collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll);
    }

    /**
     * Adds a poll to the repository.
     *
     * @param question The question of the poll.
     * @param answers  The list of answers for the poll.
     * @param targets  The list of targets for the poll.
     * @return the added poll.
     */
    public Poll addPoll(String question, List<String> answers, List<String> targets, Date destructionTime) {
        Poll poll = new Poll(question, answers, targets, destructionTime);
        this.polls.add(poll);

        return poll;
    }

    /**
     * Adds a vote to a poll.
     *
     * @param pollId     The id of the poll to vote on.
     * @param questionId The id of the answer to vote on.
     * @return the updated poll.
     */
    public Poll votePoll(UUID pollId, int questionId) {
        Poll poll = this.polls.stream().filter(p -> p.getId().equals(pollId)).findFirst().orElse(null);

        if (poll != null) {
            poll.vote(questionId);
        }

        return poll;
    }

    /**
     * Deletes a poll based on its id.
     *
     * @param pollId The id of the poll to delete.
     */
    public void deletePoll(UUID pollId) {
        this.polls.removeIf(p -> p.getId().equals(pollId));
    }

    @Scheduled(fixedRate = 1000)
    public void test() {
        List<UUID> pollsToDelete = new ArrayList<>();

        for (Poll poll : this.polls) {
            if (poll.getDestructionTime().before(new Date())) {
                pollsToDelete.add(poll.getId());
            }
        }

        for (UUID pollId : pollsToDelete) {
            this.deletePoll(pollId);
        }
    }
}
