package phone.ghtk.vn.masterdevrecyclerview.holder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import phone.ghtk.vn.masterdevrecyclerview.Genre;
import phone.ghtk.vn.masterdevrecyclerview.R;


public class GenreViewHolder extends GroupViewHolder {
    private TextView genreTitle;

    public GenreViewHolder(View itemView) {
        super(itemView);
        genreTitle = itemView.findViewById(R.id.tv_item);
    }
    public void onBind(Genre genre){
        genreTitle.setText(genre.getTitle());
    }
}
