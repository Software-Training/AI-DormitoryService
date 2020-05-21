package com.example.mapper;


import com.example.bean.Image;
import com.example.bean.ImageResult;
import org.springframework.stereotype.Service;

@Service
public interface FaceSearchMapper {
    ImageResult faceLogin(Image image);
}
