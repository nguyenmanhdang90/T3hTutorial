/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ktphuong
 */
public class Pager {

    public int findStart(int limit, int selectPage) {
        int start = 0;
        if (selectPage > 1) {
            start = (selectPage - 1) * limit;
        }
        return start;
    }

    public int findPages(int count, int limit) {
        int pages = ((count % limit) == 0) ? (count / limit) : (Math.floorDiv(count, limit) + 1);
        return pages;
    }

    public String pageList(int curpage, int pages, String namePage) {
        String page_list = "";

        /* In trang dau tien va nhung link toi trang truoc neu can */
        if ((curpage - 1) > 0) {
            if ((curpage == 0 || pages != 0)) {
                // <li><a href="#">1</a></li>
                page_list += " <li><a href=\"" + namePage + "?page=1\" title=\"Trang đầu\"><<</a></li> ";
            }
            page_list += "<li><a href=\"" + namePage + "?page=" + (curpage - 1) + "\" title=\"Về trang trước\"><</a></li> ";

        }

        /* In ra danh sach cac trang va lam cho trang hien tai dam hon va mat link o chan*/
        for (int i = 1; i <= pages; i++) {
        //    if (i == curpage) {
        //        page_list += "<li>" + i + "</li>";
        //    } else {
                page_list += "<li><a href=\"" + namePage + "?page=" + i + "\" title=\"Trang " + i + "\">" + i + "</a></li>";
        //    }            
        }

        /* In linh cua trang tiep theo va trang cuoi cung neu can*/
        if ((curpage + 1) <= pages) {
            page_list += "<li><a href=\"" + namePage + "?page=" + (curpage + 1) + "\" title=\"Đến trang sau\">></a></li> ";

        }
        if ((curpage != pages) && (pages != 0)) {
            page_list += "<li><a href=\"" + namePage + "?page=" + pages + "\" title=\"Trang cuối\">>></a></li> ";
        }
        
        return page_list;
    }

    public String nextPrev(int curpage, int pages, String namePage) {
        String next_prev = "";

        if ((curpage - 1) <= 0) {
            next_prev += "Trang trước";
        } else {
            next_prev += "<a href=\"" + namePage + "?page=" + (curpage - 1) + "\">Trang trước</a>";
        }
        next_prev += " | ";

        if ((curpage + 1) > pages) {
            next_prev += "Trang sau";
        } else {
            next_prev += "<a href=\"" + namePage + "?page=" + (curpage + 1) + "\">Trang sau</a>";
        }
        return next_prev;
    }
    
    public String pageListQueryString(int curpage, int pages, String namePage, String queryString) {
        String page_list = "";

        /* In trang dau tien va nhung link toi trang truoc neu can */
        if ((curpage - 1) > 0) {
            if ((curpage == 0 || pages != 0)) {
                page_list += "<li><a href=\"" + namePage + "?page=1" + queryString + "\" title=\"Trang đầu\"><<</a></li> ";
            }
            page_list += "<li><a href=\"" + namePage + "?page=" + (curpage - 1)+ queryString + "\" title=\"Về trang trước\"><</a></li> ";

        }

        /* In ra danh sach cac trang va lam cho trang hien tai dam hon va mat link o chan*/
        for (int i = 1; i <= pages; i++) {
        //    if (i == curpage) {
        //        page_list += "<li>" + i + "</li>";
        //    } else {
                page_list += "<li><a href=\"" + namePage + "?page=" + i + queryString + "\" title=\"Trang " + i + "\">" + i + "</a></li>";
        //    }            
        }

        /* In linh cua trang tiep theo va trang cuoi cung neu can*/
        if ((curpage + 1) <= pages) {
            page_list += "<li><a href=\"" + namePage + "?page=" + (curpage + 1) + queryString + "\" title=\"Đến trang sau\">></a></li>";

        }
        if ((curpage != pages) && (pages != 0)) {
            page_list += "<li><a href=\"" + namePage + "?page=" + pages + queryString + "\" title=\"Trang cuối\">>></a></li>";
        }        
        return page_list;
    }
    
    public String nextPrevQueryString(int curpage, int pages, String namePage, String queryString) {
        String next_prev = "";

        if ((curpage - 1) <= 0) {
            next_prev += "Trang trước";
        } else {
            next_prev += "<a href=\"" + namePage + "?page=" + (curpage - 1) + queryString +"\">Trang trước</a>";
        }
        next_prev += " | ";

        if ((curpage + 1) > pages) {
            next_prev += "Trang sau";
        } else {
            next_prev += "<a href=\"" + namePage + "?page=" + (curpage + 1) + queryString + "\">Trang sau</a>";
        }
        return next_prev;
    }

}
