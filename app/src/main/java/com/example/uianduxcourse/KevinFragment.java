package com.example.uianduxcourse;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class KevinFragment extends Fragment {
    private Context context;
    public KevinFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_kevin, container, false);
        final View image = view.findViewById(R.id.kevinImage);
        final View name =view.findViewById(R.id.Name);
        final View detail =view.findViewById(R.id.Detail);
        view.findViewById(R.id.KevinParentView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = null;
                Intent intent=new Intent(context , CharacterDetailsActivity.class);
                intent.putExtra("FragmentNumber", 1) ;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    options = (ActivityOptions) ActivityOptions.makeSceneTransitionAnimation(
                            getActivity(),
                             new Pair[]{new Pair<View, String>((View) image, "Image"),
                                     new Pair<View, String>((View) name, "Name"),
                                     new Pair<View, String>((View) detail, "Detail")
                             });
                }
                startActivity(intent,options.toBundle());
              //  getActivity().overridePendingTransition(R.anim.from_button_current,R.anim.current_to_top );

            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
