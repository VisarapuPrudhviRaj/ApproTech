package com.example.prudhvi.approtech.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.prudhvi.approtech.ForestInterface;
import com.example.prudhvi.approtech.R;
import com.example.prudhvi.approtech.adapter.ForestAdapter;
import com.example.prudhvi.approtech.model.Forest;
import com.example.prudhvi.approtech.presenter.ForestPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WildAnimalActivity extends AppCompatActivity implements ForestInterface {

    RecyclerView rv_view;
    ForestAdapter adapter;
    List<Forest> list = new ArrayList<>();
    ForestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_animal);
        setToolBar("Forest", "");
        presenter = new ForestPresenter(this, list, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_view = (RecyclerView) findViewById(R.id.rv_view);
        rv_view.setLayoutManager(linearLayoutManager);
        adapter = new ForestAdapter(WildAnimalActivity.this, list);
        rv_view.setAdapter(adapter);

        loadData();


    }

    public void setToolBar(String titleName, String subtitle) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(titleName);
        toolbar.setSubtitle(subtitle);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

    }


    private void loadData() {
        String data = "{\n" +
                "  \"forest\": {\n" +
                "    \"farmName\": \"Wood land Forest\",\n" +
                "    \"address\": \"Chilkoor, Hyderabad\"\n" +
                "  },\n" +
                "  \"wildAnimals\": [\n" +
                "    {\n" +
                "      \"id\": \"44e5b2bc484331ea24afd85ecfb212c8\",\n" +
                "      \"description\": \"The Bengal tiger is the second largest species of wild cat after the Siberian tiger and also the national animal of India. Panthera tigris tigris listed as endangered mammal and there are 3,890 individuals tigers life in the wild forest of India\",\n" +
                "      \"name\": \"Tiger\",\n" +
                "      \"weight\": 100.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/ax2em68z6mmgxbd/ic_tiger.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1506aeeb8c3a699b1e3c87db03156428\",\n" +
                "      \"description\": \"Indian Leopards are known for their ability of climbing the tress and are powerful swimmers. The Leopards share habitat with other predators but they are also threatened by loss of habitat and fragmentation\",\n" +
                "      \"name\": \"Leopard\",\n" +
                "      \"weight\": 90.00,\n" +
                "      \"birthId\": \"129382\",\n" +
                "      \"url\": \"https://www.dropbox.com/s/z75ut7lkr53ckku/ic_leopard.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9a899bfd978511e9605774e1d5222b67\",\n" +
                "      \"description\": \"Gharial is the longest of all living crocodilians found in the Indian Subcontinent. This fish eating crocodile inhabited river systems of Son River,Mahanadi in Satkosia Gorge,Katarniaghat and Chambal River.\",\n" +
                "      \"name\": \"Crocodile\",\n" +
                "      \"weight\": 300.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/qhjcq2o2rfo5hzh/ic_crocodile.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1a6c48627cecaa2388b702fa33d751ff\",\n" +
                "      \"description\": \"Black Panther is the black color variant of Indian Leopard, mostly found in the Western Ghats region. Kabini Wildlife Sanctuary,Bhadra Wildlife Sanctuary and Dandeli Wildlife Sanctuary are best places to spot Black Panther in India\",\n" +
                "      \"name\": \"Black Panther\",\n" +
                "      \"weight\": 70.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/kghbqlnpizhxh6h/ic_black_panther.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"7ecc19e1a0be36ba2c6f05d06b5d3058\",\n" +
                "      \"description\": \"Indian Lions are one of the five big cats found in India and one of the largest of Indian cat, lives as a single population in Gujarat\",\n" +
                "      \"name\": \"Lion\",\n" +
                "      \"weight\": 200.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/awygpkxswdim483/ic_lion.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"b71bf065b640217dad602f86ac047722\",\n" +
                "      \"description\": \"Elephants are classified as megaherbivores and has been listed as endangered, threatened by habitat loss, degradation and fragmentation\",\n" +
                "      \"name\": \"Elephant\",\n" +
                "      \"weight\": 2000.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/tdjq05tjro9cntc/ic_elephant.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"ef087651eb482bae4624478696f4ad4f\",\n" +
                "      \"description\": \"Indian Rhinoceros are also called great Indian rhinoceros are native to the Indian subcontinent, primarily found in north-eastern states of India\",\n" +
                "      \"name\": \"Rhinoceros\",\n" +
                "      \"weight\": 1500.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/xwc394diarsfwii/ic_rhino.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"8cd283d8b7bacc277f2bae5e26ce6d1e\",\n" +
                "      \"description\": \"Indian Leopards are known for their ability of climbing the tress and are powerful swimmers. The Leopards share habitat with other predators but they are also threatened by loss of habitat and fragmentation\",\n" +
                "      \"name\": \"Panthera pardus fusca\",\n" +
                "      \"weight\": 80.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/vcl2n7cb1kdqmqj/ic_panther.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"04117d2d74f5331f3ee4955da27cca7a\",\n" +
                "      \"description\": \"Indian sloth bears are one of the 4 species of wild bears found in India and distinguished from Asian black bears by their lankier builds. Sloth bears species are native to the Indian subcontinent and listed as vulnerable\",\n" +
                "      \"name\": \"Sloth Bear\",\n" +
                "      \"weight\": 185.00,\n" +
                "      \"birthId\": \"137483\",\n" +
                "      \"url\": \"https://www.dropbox.com/s/bzy61nddl1xh37u/ic_sloth_bear.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"821ae63dbe0c573eff8b69d451fb21bc\",\n" +
                "      \"description\": \"The wild water buffalo is the ancestor of the domestic water buffalo and the second largest wild bovid found in Assam. Wild water buffalo are endangered and live only in a small number of protected areas stretching across Nepal and Bhutan\",\n" +
                "      \"name\": \"Water Buffalo\",\n" +
                "      \"weight\": 130.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/anstaftrnpg45ig/ic_water_buffalo.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"210ab9e731c9c36c2c38db15c28a8d1c\",\n" +
                "      \"description\": \"Indian Wild Ass also called Khur are only found in the dry land of Little Rann of Kutch in Gujarat. The Indian Wild Ass Sanctuary  is home to  large number of  Indian wild ass and the population was estimated at 4,451 individuals.\",\n" +
                "      \"name\": \"Indian Wild Ass\",\n" +
                "      \"weight\": 101.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/zte4hqxtymvfd22/ic_wild_ass.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"d4fae4b45e689707e7dea506afc8c0e7\",\n" +
                "      \"description\": \"The Indian Bison commonly known as Gaur is the largest extant bovine and one of the most strong species of bovine, native to the Indian-Subcontinent.  The Gaur is the tallest of wild cattle species and has been listed as vulnerable\",\n" +
                "      \"name\": \"Indian Bison\",\n" +
                "      \"weight\": 121.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/dgw62v1551z6tg5/ic_bison.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"87f6f9d078c3bc5db5578f3b4add9470\",\n" +
                "      \"description\": \"Nilgai or blue bull is the biggest Asian antelope and one of the most commonly seen species of wild animals in India. Nilgai is a diurnal creature found inhabiting Indian grasslands their range covers national park plains and low hills with shrubs of India\",\n" +
                "      \"name\": \"Blue Bull\",\n" +
                "      \"weight\": 63.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/qvw56jcag0l5qzw/ic_blue_bull.png?dl=1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"nonWildAnimals\": [\n" +
                "    {\n" +
                "      \"id\": \"e2eff6c2dafd909df8508f891b385d88\",\n" +
                "      \"description\": \"These animals are shown in most region of India. Gives us milk and wool\",\n" +
                "      \"name\": \"Sheep\",\n" +
                "      \"weight\": 54.00,\n" +
                "      \"birthId\": \"129382\",\n" +
                "      \"url\": \"https://www.dropbox.com/s/uj87q3i7qmsyr0c/ic_sheep.png?dl=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"901889f4f34f8ca18ac2f53d1fed346e\",\n" +
                "      \"description\": \"Hen is the most wide pet around the rural villages of India. Hen gives us egg and meat\",\n" +
                "      \"name\": \"Hen\",\n" +
                "      \"weight\": 12.00,\n" +
                "      \"url\": \"https://www.dropbox.com/s/nrxh71ihpszpzwr/ic_hen.png?dl=1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"birthLocations\": [\n" +
                "    {\n" +
                "      \"id\": \"129382\",\n" +
                "      \"address\": \"Murugavani Resort\",\n" +
                "      \"location\": {\n" +
                "        \"lat\": 17.352774,\n" +
                "        \"lng\": 78.336234\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"137483\",\n" +
                "      \"address\": \"Citizen Farm\",\n" +
                "      \"location\": {\n" +
                "        \"lat\": 17.316136,\n" +
                "        \"lng\": 78.262665\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {

            JSONObject jsonObject = new JSONObject(data);
            JSONObject forestObj = jsonObject.getJSONObject("forest");

            ((TextView) findViewById(R.id.tv_forestName)).setText(forestObj.getString("farmName"));
            ((TextView) findViewById(R.id.tv_address)).setText(forestObj.getString("address"));

            presenter.setData(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAdapter() {
        adapter.notifyDataSetChanged();
    }
}
