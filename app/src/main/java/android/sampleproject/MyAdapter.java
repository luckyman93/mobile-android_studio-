package android.sampleproject;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.sampleproject.databinding.FragmentRowBinding;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final ArrayList<Item> data;
    ClickListener clickListener;
    //TODO: pass in the onClick Method
    // Hint: you will need to change the constructor, the onCreateViewHolder
    // and the ViewHolder class
    public MyAdapter(ArrayList<Item> data, ClickListener clickListener) {
        this.data = data;
        this.clickListener = clickListener;
    }

    // need to change this and construct
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Item item = data.get(position);
        holder.binding.icon.setImageResource(item.getImageID());
        holder.binding.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final FragmentRowBinding binding;

        public ViewHolder(FragmentRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(view -> {
                //ListFragment obj = new ListFragment();
                clickListener.onClick(getLayoutPosition());
                // TODO: set onClickListener
                // make sure onClick method is attach to onClickListener
                // pass in the onClick method from listFragment
                // use getLayoutPosition() method to get position of current row that is selected
            });
        }

    }
}