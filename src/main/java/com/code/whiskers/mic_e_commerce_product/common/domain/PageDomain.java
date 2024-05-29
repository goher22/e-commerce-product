package com.code.whiskers.mic_e_commerce_product.common.domain;

public class PageDomain {
    private long total;

    private long sizePage;

    private long currentPage;

    private String basePath;

    public PageDomain(long total, long sizePage, long currentPage, String basePath) {
        this.total = total;
        this.sizePage = sizePage;
        this.currentPage = currentPage;
        this.basePath = basePath;
    }

    public long getTotal() {
        return total;
    }

    public long getSizePage() {
        return sizePage;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public String getBasePath() {
        return basePath;
    }

    public long getPagesTotal() {

        return (long) Math.ceil((float) this.total / (float) this.sizePage);
    }

    public String getNext() {
        return (this.currentPage + 1L <= getPagesTotal())
                ? (this.basePath + "?page=" + (this.currentPage + 1) + "&size=" + this.sizePage)
                : null;
    }

    public String getPrev() {
        return (this.currentPage - 1L > 0L)
                ? (this.basePath + "?page=" + (this.currentPage - 1) + "&size=" + this.sizePage)
                : null;
    }

}
