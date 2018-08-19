package xyz.spiral6.aether.about;

import android.app.Fragment;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ru.noties.markwon.Markwon;
import xyz.spiral6.aether.R;

public class AboutAttributionFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_attribution, container, false);

        String filename = "attribution.txt";
        StringBuilder licenseText = new StringBuilder();
        AssetManager am = getActivity().getAssets();
        try {
            InputStream inputStream = am.open("licenses/" + filename);
            BufferedReader reader;
            reader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            // do reading, usually loop until end of file reading
            String mLine = "";
            while ((mLine = reader.readLine()) != null) {
                licenseText.append(mLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView attribution = view.findViewById(R.id.AboutAttribution);
        Markwon.setMarkdown(attribution, licenseText.toString());

        return view;
    }

}
