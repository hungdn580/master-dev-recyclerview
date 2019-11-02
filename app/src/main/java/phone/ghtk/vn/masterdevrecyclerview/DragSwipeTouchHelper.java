package phone.ghtk.vn.masterdevrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class DragSwipeTouchHelper extends ItemTouchHelper.Callback {
    AnimationListernner animationListernner;

    public DragSwipeTouchHelper(AnimationListernner animationListernner) {
        this.animationListernner = animationListernner;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlag = ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        if (animationListernner != null ) {
            animationListernner.onMove(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        }
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (animationListernner != null) {
            animationListernner.onSwipe(viewHolder.getAdapterPosition(), direction);
        }
    }
    interface AnimationListernner{
        void onMove(int fromPosition, int toPosition);
        void onSwipe(int position, int direction);
    }
}
