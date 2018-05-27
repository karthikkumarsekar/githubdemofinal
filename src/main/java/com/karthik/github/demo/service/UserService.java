package com.karthik.github.demo.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.github.demo.beans.GitRepos;
import com.karthik.github.demo.beans.GitUser;
import com.karthik.github.demo.beans.UserResponse;
import com.karthik.github.demo.h2.entity.GitReposEntity;
import com.karthik.github.demo.h2.entity.GitUserEntity;
import com.karthik.github.demo.h2.repository.GitUserRespository;
import com.karthik.github.demo.utility.GitUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    GitUserRespository gitUserRespository;

    @Transactional
    public Object getUserDetails (String userName){
        String gitUrl = "https://api.github.com/users/"+userName;
        String reposUrl = "https://api.github.com/users/"+userName+"/repos";

        UserResponse userResponse = new UserResponse();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GitUser> responseEntity = restTemplate.getForEntity(gitUrl, GitUser.class);
        GitUser gitUser = responseEntity.getBody();

        ResponseEntity<GitRepos[]> gitReposResponseEntity = restTemplate.getForEntity(reposUrl, GitRepos[].class);
        List<GitReposEntity> gitReposList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        GitRepos[] gitRepos = gitReposResponseEntity.getBody();
        for(int i=0; i<gitRepos.length;i++){
            gitReposList.add(GitUserConverter.toGitReposEntity(gitRepos[i],gitUser));
        }
        GitUserEntity gitUserEntity = GitUserConverter.toGitUserEntity(gitUser,gitReposList);
        gitUserRespository.save(gitUserEntity);
        userResponse.setStatus(0);
        userResponse.setMessage("Successfully saved user details");

        return userResponse;
    }
}
