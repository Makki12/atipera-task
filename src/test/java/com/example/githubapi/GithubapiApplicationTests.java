package com.example.githubapi;

import com.example.githubapi.model.RepositoryInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubapiApplicationTests {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetRepositoriesHappyPath() {
        String username = "octocat";
        String url = "http://localhost:" + port + "/repositories/" + username;

        ResponseEntity<RepositoryInfo[]> response = restTemplate.getForEntity(url, RepositoryInfo[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        RepositoryInfo[] repos = response.getBody();
        assertThat(repos).isNotNull();
        assertThat(repos.length).isGreaterThan(0);

        RepositoryInfo firstRepo = repos[0];
        assertThat(firstRepo.getRepositoryName()).isNotEmpty();
        assertThat(firstRepo.getOwnerLogin()).isEqualTo(username);
        assertThat(firstRepo.getBranches()).isNotEmpty();
    }
}
