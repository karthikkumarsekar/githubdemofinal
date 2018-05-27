package com.karthik.github.demo.h2.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="T_USER_DTLS")
public class GitUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="LOGIN_NAME")
    String loginName;

    @Column(name="USER_ID")
    @Id
    Long userId;

    @Column(name="URL")
    String url;

    @Column(name="REPOS_URL")
    String reposUrl;

    @Column(name="NAME")
    String name;

    @Column(name="EMAIL")
    String email;

    @Column(name="PUBLIC_REPOS_CNT")
    Long reposCnt;

    @Column(name="CREATED_TS")
    String createdTs;

    @Column(name="UPDATED_TS")
    String updatedTs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name="userId"), inverseJoinColumns = @JoinColumn(name="ownerId"))
    private List<GitReposEntity> gitReposEntityList;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) { this.url = url; }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getReposCnt() {
        return reposCnt;
    }

    public void setReposCnt(Long reposCnt) {
        this.reposCnt = reposCnt;
    }

    public String getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(String createdTs) {
        this.createdTs = createdTs;
    }

    public String getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(String updatedTs) {
        this.updatedTs = updatedTs;
    }

    public List<GitReposEntity> getGitReposEntityList() {
        return gitReposEntityList;
    }

    public void setGitReposEntityList(List<GitReposEntity> gitReposEntityList) {
        this.gitReposEntityList = gitReposEntityList;
    }
}
