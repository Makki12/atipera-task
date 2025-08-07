package com.example.githubapi.model;

public class BranchInfo {
    private String name;
    private String lastCommitSha;

    // Getters, Setters, Constructor
    public BranchInfo(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    public String getName() {
        return name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }
}
