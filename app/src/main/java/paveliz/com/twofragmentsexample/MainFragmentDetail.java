/*
 * Author: Pablo Angel Veliz
 *
 * http://about.me/paveliz
 *
 * https://ar.linkedin.com/in/pabloveliz
 *
 */

package paveliz.com.twofragmentsexample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainFragmentDetail extends Fragment  {

    private Integer indice = -1;

    public MainFragmentDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            indice = arguments.getInt("Indice");
        }

        View rootview = inflater.inflate(R.layout.fragment_detail, container, false);

        String [] clientes = getResources().getStringArray(R.array.alumnos);

        TextView txtv = (TextView) rootview.findViewById(R.id.textView);
        ImageView imgv = (ImageView) rootview.findViewById(R.id.imageView);

        if(indice < 0) {
            txtv.setText(getResources().getString(R.string.sin_alumnos_warning));
        } else {
            txtv.setText(clientes[indice]);
            imgv.setImageResource(getResources().getIdentifier("img"+indice.toString(), "drawable", getActivity().getPackageName()));

        }

        return rootview;
    }

}
