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

