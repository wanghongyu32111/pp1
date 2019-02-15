package com.example.media2.interfaces;

import com.example.media2.bean.ProductEs;

public interface ProductCallBack {

    public void productSussce(ProductEs json);
    public void productError(String json);
}
