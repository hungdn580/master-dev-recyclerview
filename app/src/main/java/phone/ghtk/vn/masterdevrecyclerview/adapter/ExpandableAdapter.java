package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.Genre;
import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.holder.ArtistViewHolder;
import phone.ghtk.vn.masterdevrecyclerview.holder.GenreViewHolder;
import phone.ghtk.vn.masterdevrecyclerview.item;
import phone.ghtk.vn.masterdevrecyclerview.item2;

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<GenreViewHolder,ArtistViewHolder > {
    private ArrayList<item> data;

    public ExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }


    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new GenreViewHolder(view);
    }

    @Override
    public ArtistViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
        return new ArtistViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ArtistViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final item2 it = (item2) group.getItems().get(childIndex);
        holder.onBind(it);
    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Genre it2 = (Genre) group;
        holder.onBind(it2);
    }
}
