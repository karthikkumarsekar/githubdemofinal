package com.karthik.github.demo.utility;

import com.karthik.github.demo.beans.GitRepos;
import com.karthik.github.demo.beans.GitUser;
import com.karthik.github.demo.h2.entity.GitReposEntity;
import com.karthik.github.demo.h2.entity.GitUserEntity;

import java.util.List;

public class GitUserConverter {

    public static GitUserEntity toGitUserEntity(GitUser gitUser, List<GitReposEntity> gitReposEntities){
        GitUserEntity gitUserEntity = new GitUserEntity();
        gitUserEntity.setUserId(gitUser.getId());
        gitUserEntity.setCreatedTs(gitUser.getCreated_at());
        gitUserEntity.setEmail(gitUser.getEmail());
        gitUserEntity.setLoginName(gitUser.getLogin());
        gitUserEntity.setName(gitUser.getName());
        gitUserEntity.setReposCnt(gitUser.getPublic_repos());
        gitUserEntity.setUpdatedTs(gitUser.getUpdated_at());
        gitUserEntity.setUrl(gitUser.getUrl());
        gitUserEntity.setReposUrl(gitUser.getRepos_url());
        gitUserEntity.setGitReposEntityList(gitReposEntities);

        return gitUserEntity;

    }

    public static GitReposEntity toGitReposEntity(GitRepos gitRepos, GitUser gitUser){
        GitReposEntity gitReposEntity = new GitReposEntity();
        gitReposEntity.setCreatedTs(gitRepos.getCreated_at());
        gitReposEntity.setDescription(gitRepos.getDescription());
        gitReposEntity.setOwnerId(gitUser.getId());
        gitReposEntity.setOwnerLogin(gitUser.getLogin());
        gitReposEntity.setReposId(gitRepos.getId());
        gitReposEntity.setReposName(gitRepos.getName());
        gitReposEntity.setUpdatedTs(gitRepos.getUpdated_at());

        return gitReposEntity;
    }
}
