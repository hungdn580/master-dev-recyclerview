package phone.ghtk.vn.masterdevrecyclerview.Interface;

public interface ItemTouchListenner {
    void onMove (int oldPosition, int newPosition);

    void swipe (int position, int direction);
}