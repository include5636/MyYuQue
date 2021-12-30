package com.fjx.myYuQue.dao;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Doc implements Serializable{
    private int id;
    private String author;
    private String title;
    private String tag;
    private String content;
}
