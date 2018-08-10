package xyz.spiral6.aether.units;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class UnitDisplaySearchAdapter extends ArrayAdapter implements Filterable{

    public List<String> names;
    public List<String> filter_names;
    private Filter mFilter;

    public UnitDisplaySearchAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> names) {
        super(context, resource,0, names);
        this.names = new ArrayList<String>(names);
    }

    @Override
    public Filter getFilter(){
        //if(mFilter==null){
            mFilter = new SearchFilter();
        //}

        return mFilter;
    }

    private class SearchFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            ArrayList<String> tempList=new ArrayList<>();
            //constraint is the result from text you want to filter against.
            //objects is your data set you will filter from
            if(constraint != null && names!=null) {
                for(int i = 0; i < names.size(); i++){
                    String item = names.get(i);
                    if(item.contains(constraint)){
                        tempList.add(item);
                    }
                }
                //following two lines is very important
                //as publish result can only take FilterResults names
                filterResults.values = tempList;
                filterResults.count = tempList.size();
            }else{
                for(int i = 0; i < names.size(); i++){
                    tempList.add(names.get(i));
                }

                // Assign the data to the FilterResults
                filterResults.values = tempList;
                filterResults.count = tempList.size();
            }
            return filterResults;
        }
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filter_names = (List<String>) results.values;
            clear();
            addAll(filter_names);

            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }

}

