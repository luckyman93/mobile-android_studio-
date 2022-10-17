package android.sampleproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.sampleproject.databinding.FragmentDetailBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class DetailFragment extends Fragment {
    private Item item;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable("data");
            //item = getArguments().g
            // TODO: get item instead of get string, int, etc.
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDetailBinding binding = FragmentDetailBinding.inflate(inflater);
        binding.groupName.setText(item.getName());
        binding.description.setText(item.getDescription());
        binding.image.setImageResource(item.getImageID());
        // TODO: receive item object instead each string, int, etc.
        // String name = item.getName();
        // String des = item.getDescription();
        // String imageID = item.getImageID();
        // set them to corresponding widget
        return binding.getRoot();
    }
}