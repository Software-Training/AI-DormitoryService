package com.example.mapper;


import com.example.bean.Image;
import com.example.bean.ImageResult;
import org.springframework.stereotype.Service;

@Service
public interface FaceRegisterMapper {
    ImageResult register(Image image);
}
