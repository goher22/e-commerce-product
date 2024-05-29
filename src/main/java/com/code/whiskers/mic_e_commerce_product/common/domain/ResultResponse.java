package com.code.whiskers.mic_e_commerce_product.common.domain;

import java.util.List;

public class ResultResponse<T> {
    private PageDomain info;

    private List<T> result;

    public ResultResponse(PageDomain info, List<T> result) {
        this.info = info;
        this.result = result;
    }

    public PageDomain getInfo() {
        return info;
    }

    public List<T> getResult() {
        return result;
    }
}