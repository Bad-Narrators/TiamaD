package com.badnarrators.tiamad.poll;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @PostMapping("/addPoll")
    public Poll addPoll(@RequestBody PollRequest pollRequest) {
        return pollRepository.addPoll(pollRequest.getQuestion(), pollRequest.getAnswers(), pollRequest.getTargets(),
                pollRequest.getDestructionTime());
    }

    @PutMapping("/votePoll")
    public Poll votePoll(String pollId, int answerId) {
        return pollRepository.votePoll(UUID.fromString(pollId), answerId);
    }

    @DeleteMapping("/deletePoll")
    public void deletePoll(String pollId) {
        pollRepository.deletePoll(UUID.fromString(pollId));
    }

    @GetMapping("/getPoll")
    public Poll getPoll(String pollId) {
        return pollRepository.getPoll(UUID.fromString(pollId));
    }

    @GetMapping("/getPollsByTarget")
    public List<Poll> getPollsByTarget(String target) {
        return pollRepository.getPollsByTarget(target);
    }
}
