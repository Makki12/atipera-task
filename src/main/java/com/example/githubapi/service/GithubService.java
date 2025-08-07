package com.example.githubapi.service;

import com.example.githubapi.model.BranchInfo;
import com.example.githubapi.model.RepositoryInfo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GithubService {

    private final WebClient webClient;

    public GithubService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .build();
    }

   public List<RepositoryInfo> getNonForkRepositories(String username) {
    try {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> repos = (List<Map<String, Object>>) (List<?>) webClient.get()
                .uri("/users/{username}/repos", username)
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();

        List<RepositoryInfo> result = new ArrayList<>();

        for (Map<String, Object> repo : repos) {
            boolean isFork = (Boolean) repo.get("fork");
            if (!isFork) {
                String repoName = (String) repo.get("name");
                Map<String, Object> owner = (Map<String, Object>) repo.get("owner");
                String ownerLogin = (String) owner.get("login");
                List<BranchInfo> branches = fetchBranches(ownerLogin, repoName);
                result.add(new RepositoryInfo(repoName, ownerLogin, branches));
            }
        }

        return result;
    } catch (WebClientResponseException.NotFound e) {
        throw new RuntimeException("User not found", e);
    }
}

    private List<BranchInfo> fetchBranches(String owner, String repo) {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> branches = (List<Map<String, Object>>) (List<?>) webClient.get()
                .uri("/repos/{owner}/{repo}/branches", owner, repo)
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();

        List<BranchInfo> branchInfos = new ArrayList<>();

        for (Map<String, Object> branch : branches) {
            String name = (String) branch.get("name");
            String sha = ((Map<String, Object>) branch.get("commit")).get("sha").toString();
            branchInfos.add(new BranchInfo(name, sha));
        }

        return branchInfos;
    }
}
