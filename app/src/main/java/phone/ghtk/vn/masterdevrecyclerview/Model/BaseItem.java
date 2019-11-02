package phone.ghtk.vn.masterdevrecyclerview.Model;

import java.util.List;

public class BaseItem {
    private String title;
    private List<Integer> mList;

    public String getTitle() {
        return title;
    }

    public BaseItem(String title, List<Integer> mList) {
        this.title = title;
        this.mList = mList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getmList() {
        return mList;
    }

    public void setmList(List<Integer> mList) {
        this.mList = mList;
    }
}
