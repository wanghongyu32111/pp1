package com.example.media2.bean;

import java.util.List;

public class ProductEs {
    public String message;
    public String status;
    public List<ResultEs> result;

    public class ResultEs{
        public String imageUrl;
        public String jumpUrl;
        public int rank;
        public String title;
    }
}
