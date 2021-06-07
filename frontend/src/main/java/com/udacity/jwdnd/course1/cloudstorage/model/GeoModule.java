package com.udacity.jwdnd.course1.cloudstorage.model;

public class GeoModule {
    private Integer moduleId;
    private String moduleName;
    private String gitURL;
    private Boolean hostedPublicly;
    private String fullHash;
    private Integer userid;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

    public Boolean getHostedPublicly() {
        return hostedPublicly;
    }

    public void setHostedPublicly(Boolean hostedPublicly) {
        this.hostedPublicly = hostedPublicly;
    }

    public String getFullHash() {
        return fullHash;
    }

    public void setFullHash(String fullHash) {
        this.fullHash = fullHash;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
