package com.neo.dto;

public class Page {
    private Integer pageNo;// ��ǰҳ
    private Integer pageSize;// ÿҳ��ʾ��������
    private Integer pageCount; // ���ݿ���ҳ��
    private Long count;// ���ݿ���ܼ�¼��
    private Boolean hasNext; // �Ƿ�����һҳ
    private Boolean hasPre; // �Ƿ�����һҳ
    private Object page;// ��ǰҳ����

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
