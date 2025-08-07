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
    "repositoryName": "Hello-World",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "master",
        "lastCommitSha": "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d"
      },
      {
        "name": "feature-xyz",
        "lastCommitSha": "b3cbd5bbd7e81436d2eee04537ea2b4c0cad4cdf"
      }
    ]
  }
]
        "name": "gh-pages",
        "lastCommitSha": "57523742631876181d95bc268e09fb3fd1a4d85e"
      }
    ]
  }
]
