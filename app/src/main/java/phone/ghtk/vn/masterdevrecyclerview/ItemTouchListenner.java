package phone.ghtk.vn.masterdevrecyclerview;

public interface ItemTouchListenner {
    void onMove(int oldPosition, int newPosition);

    void swipe(int position, int direction);
}
