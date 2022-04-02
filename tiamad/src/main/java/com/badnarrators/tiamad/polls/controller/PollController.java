package com.badnarrators.tiamad.polls.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.badnarrators.tiamad.polls.entity.Poll;
import com.badnarrators.tiamad.polls.entity.PollVote;
import com.badnarrators.tiamad.polls.model.PollManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    @PostMapping("/addPoll")
    public Poll getPoll(@RequestBody String question, @RequestBody Map<Integer, PollVote> answers,
            @RequestBody List<String> targets) {

        return pollManager.addPoll(question, answers, targets);
    }

    @GetMapping("/updatePoll")
    public Poll updatePoll(UUID pollId, int answerId) {
        return pollManager.updatePoll(pollId, answerId);
    }

    @GetMapping("/deletePoll")
    public void deletePoll(UUID id) {
        pollManager.deletePoll(id);
    }
}
