package wso2.org.kalagune;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wso2.org.kalagune.forecast.ForeCastItemsAdapter;
import wso2.org.kalagune.forecast.ForecastItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastItemsFragment extends ListFragment {


    public ForecastItemsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new LoadWeatherForecast().execute();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(null);
    }

    private class LoadWeatherForecast extends AsyncTask<Void, Void, List<ForecastItem>>{

        @Override
        protected List<ForecastItem> doInBackground(Void... params) {
            List<ForecastItem> forecastItemList = new ArrayList<>();
            forecastItemList.add(new ForecastItem(getResources().getDrawable(R.drawable.showers), "Showers", "Friday, 13 March", "23°c"));
            forecastItemList.add(new ForecastItem(getResources().getDrawable(R.drawable.showers), "Sunny", "Saturday, 14 March", "35°c"));
            forecastItemList.add(new ForecastItem(getResources().getDrawable(R.drawable.showers), "Showers", "Sunday, 15 March", "24°c"));
            return forecastItemList;
        }

        @Override
        protected void onPostExecute(List<ForecastItem> forecastItems) {
            setListAdapter(new ForeCastItemsAdapter(getActivity(), forecastItems));
        }

    }
}