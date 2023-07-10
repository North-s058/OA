package com.neo.dto;

public class Page {
    private Integer pageNo;// 当前页
    private Integer pageSize;// 每页显示多少条数
    private Integer pageCount; // 数据库总页数
    private Long count;// 数据库表总记录数
    private Boolean hasNext; // 是否有下一页
    private Boolean hasPre; // 是否有上一页
    private Object page;// 当前页数据

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasPre() {
        return hasPre;
    }

    public void setHasPre(Boolean hasPre) {
        this.hasPre = hasPre;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", count=" + count +
                ", hasNext=" + hasNext +
                ", hasPre=" + hasPre +
                ", page=" + page +
                '}';
    }
}
