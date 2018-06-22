package progweb3.poa.ifrs.edu.aula8;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class PicassoFragment extends DialogFragment {

    ImageView imageView;

    public PicassoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picasso, container, false);
        imageView = (ImageView) view.findViewById(R.id.picasso_image);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
        return view;
    }
}
