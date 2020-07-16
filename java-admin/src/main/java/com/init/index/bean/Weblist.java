package com.init.index.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Weblist {

    private long id;
    @NotEmpty
    private String icon;
    @NotEmpty
    private String tips;
    @NotEmpty
    private String tipsTitle;
    @NotEmpty
    private String name;
    @NotEmpty
    private String href;

}