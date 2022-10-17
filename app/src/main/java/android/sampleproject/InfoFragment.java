package android.sampleproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.sampleproject.databinding.FragmentInfoBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoFragment extends Fragment {

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentInfoBinding binding = FragmentInfoBinding.inflate(inflater);
        // if button is click then number will show
        binding.button.setOnClickListener(view -> {
            Intent dial = new Intent(Intent.ACTION_DIAL);
            dial.setData(Uri.parse(getString(R.string.tel)));
            startActivity(dial);
        });
        return binding.getRoot();
    }
}