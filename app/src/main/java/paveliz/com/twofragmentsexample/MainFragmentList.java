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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainFragmentList extends Fragment {

    public MainFragmentList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_list, container, false);

        ListView mylistview = (ListView) rootView.findViewById(R.id.listView);

        String[] alumnos = getResources().getStringArray(R.array.alumnos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, alumnos);

        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                /**
                 * In the OnItemClickListener() I'm going to pass the position
                 * as a parameter to the second fragment and I'm going to use
                 * the "replace" to update the fragment.
                 *
                 */
                Bundle args = new Bundle();
                args.putInt("Indice", position);

                MainFragmentDetail fragment = new MainFragmentDetail();
                fragment.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_detail, fragment, "frag_detail")
                        .commit();

            }
        });
        return rootView;
    }
}
