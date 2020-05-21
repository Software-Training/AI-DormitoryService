package com.example.bean;

import lombok.Data;

@Data
public class ImageResult{
    private boolean start;
    private String userId;
    private String msg;
    private int faceNum;
    private String errorMsg;
}
