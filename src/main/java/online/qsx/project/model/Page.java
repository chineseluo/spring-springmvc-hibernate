package online.qsx.project.model;

/**
 * Created by 84825 on 2018/1/20.
 */
public class Page {
    //当前页数
    private int pageNo = 1;
    //每页显示的记录条数
    private int pageSize = 3;
    //待分页显示的总记录数
    private int pageCount;
    //总页数
    private int totalPage = 1;

    //对总页数进行判断
    public void setTotalPage() {
        if (this.pageCount % pageSize == 0) {
            this.totalPage = this.pageCount / pageSize;
        } else if (this.pageCount % pageSize > 0) {
            this.totalPage = this.pageCount / pageSize + 1;
        } else {
            this.totalPage = 0;
        }
    }

    public int getTotalPage() {
        System.out.println("getTotalPage:" + totalPage);
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {

        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount > 0) {
            this.pageCount = pageCount;
            this.setTotalPage();
        }

    }
}
