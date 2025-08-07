# GitHub API Integration – Recruitment Task

This project was created as a part of a recruitment process at Atipera.

## 🚀 Goal

Expose a REST API that returns all non-fork GitHub repositories for a given user, including their branches and latest commit SHA.

## ✅ Features

- Fetch all **non-fork** repositories of a GitHub user
- For each repository:
  - Repository name
  - Owner login
  - List of branches
    - Branch name
    - Last commit SHA
- Error handling for non-existing users (returns `404` with JSON)

## 📬 Example Response

[
  {
    "repositoryName": "git-consortium",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "master",
        "lastCommitSha": "b33a9c7c02ad93f621fa38f0e9fc9e867e12fa0e"
      }
    ]
  },
  {
    "repositoryName": "hello-worId",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "master",
        "lastCommitSha": "7e068727fdb347b685b658d2981f8c85f7bf0585"
      }
    ]
  },
  {
    "repositoryName": "Hello-World",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "master",
        "lastCommitSha": "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d"
      },
      {
        "name": "octocat-patch-1",
        "lastCommitSha": "b1b3f9723831141a31a1a7252a213e216ea76e56"
      },
      {
        "name": "test",
        "lastCommitSha": "b3cbd5bbd7e81436d2eee04537ea2b4c0cad4cdf"
      }
    ]
  },
  {
    "repositoryName": "octocat.github.io",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "gh-pages",
        "lastCommitSha": "c0e4a095428f36b81f0bd4239d353f71918cbef3"
      },
      {
        "name": "master",
        "lastCommitSha": "3a9796cf19902af0f7e677391b340f1ae4128433"
      }
    ]
  },
  {
    "repositoryName": "Spoon-Knife",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "change-the-title",
        "lastCommitSha": "f439fc5710cd87a4025247e8f75901cdadf5333d"
      },
      {
        "name": "main",
        "lastCommitSha": "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9"
      },
      {
        "name": "test-branch",
        "lastCommitSha": "58060701b538587e8b4ab127253e6ed6fbdc53d1"
      }
    ]
  },
  {
    "repositoryName": "test-repo1",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "gh-pages",
        "lastCommitSha": "57523742631876181d95bc268e09fb3fd1a4d85e"
      }
    ]
  }
]
