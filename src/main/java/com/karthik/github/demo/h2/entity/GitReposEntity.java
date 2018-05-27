package com.karthik.github.demo.h2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="T_REPOS_DTLS")
public class GitReposEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="REPOS_ID")
    @Id
    Long reposId;

    @Column(name="REPOS_NAME")
    String reposName;

    @Column(name="DESCRIPTION")
    String description;

    @Column(name="OWNER_ID")
    Long ownerId;

    @Column(name="OWNER_LOGIN")
    String ownerLogin;

    @Column(name="CREATED_TS")
    String createdTs;

    public Long getReposId() {
        return reposId;
    }

    public void setReposId(Long reposId) {
        this.reposId = reposId;
    }

    public String getReposName() {
        return reposName;
    }

    public void setReposName(String reposName) {
        this.reposName = reposName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
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

    @Column(name="UPDATED_TS")
    String updatedTs;
}
