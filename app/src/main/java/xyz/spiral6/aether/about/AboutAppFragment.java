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
import xyz.spiral6.aether.BuildConfig;
import xyz.spiral6.aether.R;

public class AboutAppFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_app, container, false);

        TextView versionNumber = view.findViewById(R.id.AboutVersion);
        versionNumber.setText("v" + BuildConfig.VERSION_NAME);

        return view;
    }

}
