package collabothon.rewardchain;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import collabothon.rewardchain.model.Offer;

/**
 * Created by henrik on 05.10.17.
 */

public class OfferAdapter extends BaseAdapter {

    private Context context;

    public OfferAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_offer, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.offerName);
        TextView coins = (TextView) convertView.findViewById(R.id.offerCoins);
        // Populate the data into the template view using the data object
        name.setText("Test");
        coins.setText("Hallo");
        // Return the completed view to render on screen
        return convertView;
    }
}
