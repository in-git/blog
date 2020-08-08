package com.init.index.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Github {

  private long id;
  @NotBlank
  private String title;
  @NotBlank
  private String description;
  @NotBlank
  private String img;
  @NotBlank
  private String download;
  @NotBlank
  private String address;
  @NotBlank
  private String url;
}