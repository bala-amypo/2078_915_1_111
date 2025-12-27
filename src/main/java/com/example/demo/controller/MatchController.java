package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/compute")
    public MatchResult compute(@RequestParam Long a,
                               @RequestParam Long b) {
        return service.computeMatch(a, b);
    }

    @GetMapping("/student/{id}")
    public List<MatchResult> getMatches(@PathVariable Long id) {
        return service.getMatchesForStudent(id);
    }
}
