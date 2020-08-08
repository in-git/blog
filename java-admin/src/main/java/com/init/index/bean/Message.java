package com.init.index.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class Message {

  private long id;
  @NotBlank
  private String imgSrc;
  @NotBlank
  private String name;
  @NotBlank
  private String content;
  private long love;
  private long isVip;

}