package com.example.tienbeerv20.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.favoritos.FavoritosFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    private Button dejanos,tresytres,todoyo;

    NavController navController= null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        dejanos=(Button) root.findViewById(R.id.btnDejanos);
        tresytres=(Button) root.findViewById(R.id.btnDejanos);
        todoyo=(Button) root.findViewById(R.id.btnDejanos);



        //final TextView textView = root.findViewById(R.id.text_home);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController=Navigation.findNavController(view);
        view.findViewById(R.id.btnDejanos).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==dejanos.getId()){
            Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_filtro);
        }
    }
}