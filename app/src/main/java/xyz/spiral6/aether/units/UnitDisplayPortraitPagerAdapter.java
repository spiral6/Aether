package xyz.spiral6.aether.units;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import xyz.spiral6.aether.R;

class UnitDisplayPortraitPagerAdapter extends PagerAdapter {
    private Context context;
    private int[] images;
    private LayoutInflater layoutInflater;


    public UnitDisplayPortraitPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.fragment_unit_display_portrait, container, false);

        ImageView imageView = itemView.findViewById(R.id.portrait);
        imageView.setImageResource(images[position]);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(position+1){
                    case 1: Toast.makeText(context, "Default", Toast.LENGTH_SHORT).show(); break;
                    case 2: Toast.makeText(context, "Attack", Toast.LENGTH_SHORT).show(); break;
                    case 3: Toast.makeText(context, "Special", Toast.LENGTH_SHORT).show(); break;
                    case 4: Toast.makeText(context, "Injured", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
