package com.udacity.jwdnd.course1.cloudstorage.model;

import java.sql.Timestamp;

public class ModuleOutput {
    private Integer moduleId;
    private String module_name;
    private String commit_author;
    private String commit_message;
    private String commit_hash;
    private Timestamp execution_date;
    private byte[] output;

    public byte[] getOutput() {
        return output;
    }

    public void setOutput(byte[] output) {
        this.output = output;
    }

    public Timestamp getExecution_date() {
        return execution_date;
    }

    public void setExecution_date(Timestamp execution_date) {
        this.execution_date = execution_date;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getCommit_author() {
        return commit_author;
    }

    public void setCommit_author(String commit_author) {
        this.commit_author = commit_author;
    }

    public String getCommit_message() {
        return commit_message;
    }

    public void setCommit_message(String commit_message) {
        this.commit_message = commit_message;
    }

    public String getCommit_hash() {
        return commit_hash;
    }

    public void setCommit_hash(String commit_hash) {
        this.commit_hash = commit_hash;
    }
}
