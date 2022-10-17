package android.sampleproject;

import android.app.AlertDialog;
import android.os.Bundle;
import android.sampleproject.databinding.FragmentListBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class ListFragment extends Fragment implements ClickListener{
    private ArrayList<Item> data;
    //TODO: have Item Object instead of String, int, etc.
    //private Item selected;
    private Item selected;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
        data.add(new Item(R.drawable.bella, getString(R.string.bella), getString(R.string.bellainfo)));
        data.add(new Item(R.drawable.charlie, getString(R.string.charlie), getString(R.string.charlieinfo)));
        data.add(new Item(R.drawable.cooper, getString(R.string.cooper), getString(R.string.cooperinfo)));
        data.add(new Item(R.drawable.kobe, getString(R.string.kobe), getString(R.string.kobe)));
        data.add(new Item(R.drawable.luna, getString(R.string.luna), getString(R.string.lunainfo)));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListBinding binding = FragmentListBinding.inflate(inflater);
        binding.list.setAdapter(new MyAdapter(data, this));
        return binding.getRoot();
    }

    //TODO: attach to the onClickListener for each row in MyAdapter


    public void goDetail(int position){
        Bundle bundle = new Bundle();
        //TODO: send item object instead of sending string, int, etc.
        // not use putString! use correct method
        selected = data.get(position);
        bundle.putParcelable("data", selected);
        NavController controller = NavHostFragment.findNavController(this);
        controller.navigate(R.id.action_list_to_detail, bundle);
    }

    public void showDialog(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage(R.string.warning);
        builder.setPositiveButton(R.string.yes, (dialog, id) -> {
            goDetail(position);
        }).setNegativeButton(R.string.no, (dialog, id) -> {
            // do nothing
        });
        builder.create().show();
    }

    @Override
    public void onClick(int position) {
        if(position == data.size() -1)
            showDialog(position);
        else goDetail(position);
    }
}