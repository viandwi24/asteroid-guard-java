/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.viandwi24.asteroidguard;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author viandwi24
 */
public class AsteroidTracker extends javax.swing.JFrame {
    Vector<Object[]> asteroids = new Vector<Object[]>();
    Vector<JSONObject> asteroids_data = new Vector<JSONObject>();
    int fetchCount = 0;

    /**
     * Creates new form AsteroidTracker
     */
    public AsteroidTracker() {
        initComponents();
        setLoading(false);
        jDateChooser1.setDate(new java.util.Date());
        FetchData();
    }

    public void setLoading(boolean loading) {
        PanelLoader.setVisible(loading);
        jDateChooser1.setVisible(!loading);
        jTable1.setEnabled(!loading);
    }

    public void FetchData() {
        // show loader
        setLoading(true);

        // delay 1s
        try {
             String startDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
             String endDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(jDateChooser1.getDate().getTime() + (1000 * 60 * 60 * 24)));
             String apiKey = "S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX";
             HttpRequest request = HttpRequest.get("https://api.nasa.gov/neo/rest/v1/feed?start_date="+startDate+"&end_date="+endDate+"&api_key=" + apiKey);
            int code = 200;
            
             if (request.code() == 200) {
//            if (code == 200) {
//                String rawDataJson = "{\"links\":{\"next\":\"http://www.neowsapp.com/rest/v1/feed?start_date=2021-12-03&end_date=2021-12-04&detailed=false&api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\",\"prev\":\"http://www.neowsapp.com/rest/v1/feed?start_date=2021-12-01&end_date=2021-12-02&detailed=false&api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\",\"self\":\"http://www.neowsapp.com/rest/v1/feed?start_date=2021-12-02&end_date=2021-12-03&detailed=false&api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"element_count\":27,\"near_earth_objects\":{\"2021-12-03\":[{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3735468?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3735468\",\"neo_reference_id\":\"3735468\",\"name\":\"(2015 WY1)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3735468\",\"absolute_magnitude_h\":22.0,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.1058168859,\"estimated_diameter_max\":0.2366137501},\"meters\":{\"estimated_diameter_min\":105.8168859331,\"estimated_diameter_max\":236.6137501138},\"miles\":{\"estimated_diameter_min\":0.0657515442,\"estimated_diameter_max\":0.1470249225},\"feet\":{\"estimated_diameter_min\":347.1682720448,\"estimated_diameter_max\":776.2918559233}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 20:28\",\"epoch_date_close_approach\":1638563280000,\"relative_velocity\":{\"kilometers_per_second\":\"14.575221439\",\"kilometers_per_hour\":\"52470.7971802736\",\"miles_per_hour\":\"32603.3128368206\"},\"miss_distance\":{\"astronomical\":\"0.2513969148\",\"lunar\":\"97.7933998572\",\"kilometers\":\"37608442.978651476\",\"miles\":\"23368802.8411473288\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3736501?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3736501\",\"neo_reference_id\":\"3736501\",\"name\":\"(2015 XG261)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3736501\",\"absolute_magnitude_h\":23.05,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.065246163,\"estimated_diameter_max\":0.1458948557},\"meters\":{\"estimated_diameter_min\":65.2461629789,\"estimated_diameter_max\":145.8948556919},\"miles\":{\"estimated_diameter_min\":0.0405420735,\"estimated_diameter_max\":0.0906548324},\"feet\":{\"estimated_diameter_min\":214.0622213477,\"estimated_diameter_max\":478.6576783481}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 07:30\",\"epoch_date_close_approach\":1638516600000,\"relative_velocity\":{\"kilometers_per_second\":\"31.5747161319\",\"kilometers_per_hour\":\"113668.9780749836\",\"miles_per_hour\":\"70629.4825155364\"},\"miss_distance\":{\"astronomical\":\"0.4288896885\",\"lunar\":\"166.8380888265\",\"kilometers\":\"64160983.864563495\",\"miles\":\"39867786.679606431\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3744834?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3744834\",\"neo_reference_id\":\"3744834\",\"name\":\"(2016 DW1)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3744834\",\"absolute_magnitude_h\":25.9,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0175612318,\"estimated_diameter_max\":0.0392681082},\"meters\":{\"estimated_diameter_min\":17.561231848,\"estimated_diameter_max\":39.2681081809},\"miles\":{\"estimated_diameter_min\":0.0109120402,\"estimated_diameter_max\":0.0244000636},\"feet\":{\"estimated_diameter_min\":57.6155918963,\"estimated_diameter_max\":128.8323800441}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 02:23\",\"epoch_date_close_approach\":1638498180000,\"relative_velocity\":{\"kilometers_per_second\":\"7.1895769655\",\"kilometers_per_hour\":\"25882.4770759105\",\"miles_per_hour\":\"16082.3647141956\"},\"miss_distance\":{\"astronomical\":\"0.4610621882\",\"lunar\":\"179.3531912098\",\"kilometers\":\"68973921.292259134\",\"miles\":\"42858407.3202546892\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3765610?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3765610\",\"neo_reference_id\":\"3765610\",\"name\":\"(2016 XR1)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3765610\",\"absolute_magnitude_h\":24.2,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0384197891,\"estimated_diameter_max\":0.0859092601},\"meters\":{\"estimated_diameter_min\":38.4197891064,\"estimated_diameter_max\":85.9092601232},\"miles\":{\"estimated_diameter_min\":0.0238729428,\"estimated_diameter_max\":0.0533815229},\"feet\":{\"estimated_diameter_min\":126.0491808919,\"estimated_diameter_max\":281.8545369825}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 12:57\",\"epoch_date_close_approach\":1638536220000,\"relative_velocity\":{\"kilometers_per_second\":\"6.2196317673\",\"kilometers_per_hour\":\"22390.6743621374\",\"miles_per_hour\":\"13912.6943001848\"},\"miss_distance\":{\"astronomical\":\"0.1513960046\",\"lunar\":\"58.8930457894\",\"kilometers\":\"22648519.814670202\",\"miles\":\"14073137.6327727076\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3789397?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3789397\",\"neo_reference_id\":\"3789397\",\"name\":\"(2017 VX13)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3789397\",\"absolute_magnitude_h\":23.7,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0483676488,\"estimated_diameter_max\":0.1081533507},\"meters\":{\"estimated_diameter_min\":48.3676488219,\"estimated_diameter_max\":108.1533506775},\"miles\":{\"estimated_diameter_min\":0.0300542543,\"estimated_diameter_max\":0.0672033557},\"feet\":{\"estimated_diameter_min\":158.6865169607,\"estimated_diameter_max\":354.8338390368}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 02:36\",\"epoch_date_close_approach\":1638498960000,\"relative_velocity\":{\"kilometers_per_second\":\"5.407354864\",\"kilometers_per_hour\":\"19466.4775103007\",\"miles_per_hour\":\"12095.7120952199\"},\"miss_distance\":{\"astronomical\":\"0.2996733332\",\"lunar\":\"116.5729266148\",\"kilometers\":\"44830492.342520284\",\"miles\":\"27856376.2243125592\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3841953?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3841953\",\"neo_reference_id\":\"3841953\",\"name\":\"(2019 JY7)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3841953\",\"absolute_magnitude_h\":27.7,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0076657557,\"estimated_diameter_max\":0.0171411509},\"meters\":{\"estimated_diameter_min\":7.6657557353,\"estimated_diameter_max\":17.1411509231},\"miles\":{\"estimated_diameter_min\":0.0047632783,\"estimated_diameter_max\":0.0106510141},\"feet\":{\"estimated_diameter_min\":25.1501180466,\"estimated_diameter_max\":56.2373735944}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 10:09\",\"epoch_date_close_approach\":1638526140000,\"relative_velocity\":{\"kilometers_per_second\":\"15.6058284295\",\"kilometers_per_hour\":\"56180.9823461921\",\"miles_per_hour\":\"34908.6776139436\"},\"miss_distance\":{\"astronomical\":\"0.2628045588\",\"lunar\":\"102.2309733732\",\"kilometers\":\"39315002.222769756\",\"miles\":\"24429209.5837283928\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54209293?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54209293\",\"neo_reference_id\":\"54209293\",\"name\":\"(2021 RW99)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54209293\",\"absolute_magnitude_h\":22.57,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0813869881,\"estimated_diameter_max\":0.1819868378},\"meters\":{\"estimated_diameter_min\":81.3869880675,\"estimated_diameter_max\":181.9868378029},\"miles\":{\"estimated_diameter_min\":0.0505715142,\"estimated_diameter_max\":0.1130813434},\"feet\":{\"estimated_diameter_min\":267.0176859314,\"estimated_diameter_max\":597.0696969372}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 09:09\",\"epoch_date_close_approach\":1638522540000,\"relative_velocity\":{\"kilometers_per_second\":\"5.4097905562\",\"kilometers_per_hour\":\"19475.2460023912\",\"miles_per_hour\":\"12101.160495208\"},\"miss_distance\":{\"astronomical\":\"0.1150888097\",\"lunar\":\"44.7695469733\",\"kilometers\":\"17217040.791955339\",\"miles\":\"10698173.0672441182\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54214055?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54214055\",\"neo_reference_id\":\"54214055\",\"name\":\"(2021 UY5)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54214055\",\"absolute_magnitude_h\":22.77,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0742258153,\"estimated_diameter_max\":0.1659739687},\"meters\":{\"estimated_diameter_min\":74.2258153001,\"estimated_diameter_max\":165.9739686963},\"miles\":{\"estimated_diameter_min\":0.0461217691,\"estimated_diameter_max\":0.1031314109},\"feet\":{\"estimated_diameter_min\":243.5230238691,\"estimated_diameter_max\":544.5340354577}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 15:52\",\"epoch_date_close_approach\":1638546720000,\"relative_velocity\":{\"kilometers_per_second\":\"17.2207503148\",\"kilometers_per_hour\":\"61994.7011334301\",\"miles_per_hour\":\"38521.0963792694\"},\"miss_distance\":{\"astronomical\":\"0.0712075781\",\"lunar\":\"27.6997478809\",\"kilometers\":\"10652502.011618647\",\"miles\":\"6619157.8155934486\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54219287?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54219287\",\"neo_reference_id\":\"54219287\",\"name\":\"(2021 VU10)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54219287\",\"absolute_magnitude_h\":23.487,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0533525248,\"estimated_diameter_max\":0.1192998723},\"meters\":{\"estimated_diameter_min\":53.3525248313,\"estimated_diameter_max\":119.299872294},\"miles\":{\"estimated_diameter_min\":0.0331517117,\"estimated_diameter_max\":0.0741294809},\"feet\":{\"estimated_diameter_min\":175.0410975675,\"estimated_diameter_max\":391.403793017}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 15:30\",\"epoch_date_close_approach\":1638545400000,\"relative_velocity\":{\"kilometers_per_second\":\"16.8548585997\",\"kilometers_per_hour\":\"60677.4909590096\",\"miles_per_hour\":\"37702.6332017246\"},\"miss_distance\":{\"astronomical\":\"0.0716195209\",\"lunar\":\"27.8599936301\",\"kilometers\":\"10714127.777060483\",\"miles\":\"6657450.2905933454\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54224422?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54224422\",\"neo_reference_id\":\"54224422\",\"name\":\"(2021 WZ1)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54224422\",\"absolute_magnitude_h\":26.68,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0122618211,\"estimated_diameter_max\":0.0274182656},\"meters\":{\"estimated_diameter_min\":12.2618211318,\"estimated_diameter_max\":27.4182655787},\"miles\":{\"estimated_diameter_min\":0.0076191401,\"estimated_diameter_max\":0.0170369151},\"feet\":{\"estimated_diameter_min\":40.2290732421,\"estimated_diameter_max\":89.9549424412}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 18:07\",\"epoch_date_close_approach\":1638554820000,\"relative_velocity\":{\"kilometers_per_second\":\"12.9622656392\",\"kilometers_per_hour\":\"46664.1563011376\",\"miles_per_hour\":\"28995.2920083374\"},\"miss_distance\":{\"astronomical\":\"0.0050544066\",\"lunar\":\"1.9661641674\",\"kilometers\":\"756128.461473942\",\"miles\":\"469836.4393547196\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54225511?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54225511\",\"neo_reference_id\":\"54225511\",\"name\":\"(2021 WU4)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54225511\",\"absolute_magnitude_h\":24.937,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0273624497,\"estimated_diameter_max\":0.0611842976},\"meters\":{\"estimated_diameter_min\":27.3624497244,\"estimated_diameter_max\":61.1842976147},\"miles\":{\"estimated_diameter_min\":0.0170022327,\"estimated_diameter_max\":0.0380181482},\"feet\":{\"estimated_diameter_min\":89.7718195538,\"estimated_diameter_max\":200.7358909862}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-03\",\"close_approach_date_full\":\"2021-Dec-03 23:38\",\"epoch_date_close_approach\":1638574680000,\"relative_velocity\":{\"kilometers_per_second\":\"20.0448126807\",\"kilometers_per_hour\":\"72161.3256503846\",\"miles_per_hour\":\"44838.2414853737\"},\"miss_distance\":{\"astronomical\":\"0.0823924864\",\"lunar\":\"32.0506772096\",\"kilometers\":\"12325740.469443968\",\"miles\":\"7658859.9816560384\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false}],\"2021-12-02\":[{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/2438955?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"2438955\",\"neo_reference_id\":\"2438955\",\"name\":\"438955 (2010 LN14)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2438955\",\"absolute_magnitude_h\":21.06,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.163137941,\"estimated_diameter_max\":0.3647875257},\"meters\":{\"estimated_diameter_min\":163.1379409728,\"estimated_diameter_max\":364.7875257245},\"miles\":{\"estimated_diameter_min\":0.1013691855,\"estimated_diameter_max\":0.2266683896},\"feet\":{\"estimated_diameter_min\":535.2294822612,\"estimated_diameter_max\":1196.8095058981}},\"is_potentially_hazardous_asteroid\":true,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 19:30\",\"epoch_date_close_approach\":1638473400000,\"relative_velocity\":{\"kilometers_per_second\":\"10.9805224348\",\"kilometers_per_hour\":\"39529.8807653434\",\"miles_per_hour\":\"24562.3306344435\"},\"miss_distance\":{\"astronomical\":\"0.2972288499\",\"lunar\":\"115.6220226111\",\"kilometers\":\"44464802.847589713\",\"miles\":\"27629147.3089075194\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3548081?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3548081\",\"neo_reference_id\":\"3548081\",\"name\":\"(2010 TK7)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3548081\",\"absolute_magnitude_h\":20.8,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.1838886721,\"estimated_diameter_max\":0.411187571},\"meters\":{\"estimated_diameter_min\":183.8886720703,\"estimated_diameter_max\":411.1875710413},\"miles\":{\"estimated_diameter_min\":0.1142630881,\"estimated_diameter_max\":0.2555000322},\"feet\":{\"estimated_diameter_min\":603.309310875,\"estimated_diameter_max\":1349.040630575}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 10:28\",\"epoch_date_close_approach\":1638440880000,\"relative_velocity\":{\"kilometers_per_second\":\"15.1254936765\",\"kilometers_per_hour\":\"54451.7772353885\",\"miles_per_hour\":\"33834.2168049557\"},\"miss_distance\":{\"astronomical\":\"0.2235287815\",\"lunar\":\"86.9526960035\",\"kilometers\":\"33439429.596095405\",\"miles\":\"20778298.048530389\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3602622?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3602622\",\"neo_reference_id\":\"3602622\",\"name\":\"(2012 HM)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3602622\",\"absolute_magnitude_h\":24.1,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.040230458,\"estimated_diameter_max\":0.0899580388},\"meters\":{\"estimated_diameter_min\":40.2304579834,\"estimated_diameter_max\":89.9580388169},\"miles\":{\"estimated_diameter_min\":0.0249980399,\"estimated_diameter_max\":0.0558973165},\"feet\":{\"estimated_diameter_min\":131.9896957704,\"estimated_diameter_max\":295.1379320721}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 23:16\",\"epoch_date_close_approach\":1638486960000,\"relative_velocity\":{\"kilometers_per_second\":\"8.0068622432\",\"kilometers_per_hour\":\"28824.7040753922\",\"miles_per_hour\":\"17910.5501517347\"},\"miss_distance\":{\"astronomical\":\"0.4201659116\",\"lunar\":\"163.4445396124\",\"kilometers\":\"62855925.421968292\",\"miles\":\"39056860.9665027496\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3766054?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3766054\",\"neo_reference_id\":\"3766054\",\"name\":\"(2016 YH)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3766054\",\"absolute_magnitude_h\":25.5,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0211132445,\"estimated_diameter_max\":0.0472106499},\"meters\":{\"estimated_diameter_min\":21.113244479,\"estimated_diameter_max\":47.2106498806},\"miles\":{\"estimated_diameter_min\":0.0131191578,\"estimated_diameter_max\":0.0293353287},\"feet\":{\"estimated_diameter_min\":69.2691770164,\"estimated_diameter_max\":154.8905885541}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 02:38\",\"epoch_date_close_approach\":1638412680000,\"relative_velocity\":{\"kilometers_per_second\":\"18.635523962\",\"kilometers_per_hour\":\"67087.8862630596\",\"miles_per_hour\":\"41685.8035505106\"},\"miss_distance\":{\"astronomical\":\"0.2586212165\",\"lunar\":\"100.6036532185\",\"kilometers\":\"38689183.125208855\",\"miles\":\"24040343.628457999\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3799712?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3799712\",\"neo_reference_id\":\"3799712\",\"name\":\"(2018 DT)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3799712\",\"absolute_magnitude_h\":27.1,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0101054342,\"estimated_diameter_max\":0.0225964377},\"meters\":{\"estimated_diameter_min\":10.1054341542,\"estimated_diameter_max\":22.5964377109},\"miles\":{\"estimated_diameter_min\":0.0062792237,\"estimated_diameter_max\":0.0140407711},\"feet\":{\"estimated_diameter_min\":33.1543125905,\"estimated_diameter_max\":74.1352966996}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 11:13\",\"epoch_date_close_approach\":1638443580000,\"relative_velocity\":{\"kilometers_per_second\":\"3.4766102321\",\"kilometers_per_hour\":\"12515.79683552\",\"miles_per_hour\":\"7776.8294281596\"},\"miss_distance\":{\"astronomical\":\"0.2493282254\",\"lunar\":\"96.9886796806\",\"kilometers\":\"37298971.450719898\",\"miles\":\"23176506.1506066724\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3956451?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"3956451\",\"neo_reference_id\":\"3956451\",\"name\":\"(2019 YS3)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3956451\",\"absolute_magnitude_h\":24.7,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0305179233,\"estimated_diameter_max\":0.0682401509},\"meters\":{\"estimated_diameter_min\":30.5179232594,\"estimated_diameter_max\":68.2401509401},\"miles\":{\"estimated_diameter_min\":0.0189629525,\"estimated_diameter_max\":0.0424024508},\"feet\":{\"estimated_diameter_min\":100.1244233463,\"estimated_diameter_max\":223.8850168104}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 22:34\",\"epoch_date_close_approach\":1638484440000,\"relative_velocity\":{\"kilometers_per_second\":\"5.6945332715\",\"kilometers_per_hour\":\"20500.3197775293\",\"miles_per_hour\":\"12738.1014750987\"},\"miss_distance\":{\"astronomical\":\"0.200867635\",\"lunar\":\"78.137510015\",\"kilometers\":\"30049370.34793745\",\"miles\":\"18671812.91073881\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54099614?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54099614\",\"neo_reference_id\":\"54099614\",\"name\":\"(2020 XK3)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54099614\",\"absolute_magnitude_h\":21.73,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.1198270801,\"estimated_diameter_max\":0.2679414966},\"meters\":{\"estimated_diameter_min\":119.8270800671,\"estimated_diameter_max\":267.9414965754},\"miles\":{\"estimated_diameter_min\":0.0744570726,\"estimated_diameter_max\":0.1664910757},\"feet\":{\"estimated_diameter_min\":393.1334773674,\"estimated_diameter_max\":879.0731796244}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 05:02\",\"epoch_date_close_approach\":1638421320000,\"relative_velocity\":{\"kilometers_per_second\":\"30.071650006\",\"kilometers_per_hour\":\"108257.9400215525\",\"miles_per_hour\":\"67267.2738983919\"},\"miss_distance\":{\"astronomical\":\"0.4539970437\",\"lunar\":\"176.6048499993\",\"kilometers\":\"67916990.723816919\",\"miles\":\"42201661.1187507222\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54169951?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54169951\",\"neo_reference_id\":\"54169951\",\"name\":\"(2021 NY5)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54169951\",\"absolute_magnitude_h\":20.2,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.2424124811,\"estimated_diameter_max\":0.5420507863},\"meters\":{\"estimated_diameter_min\":242.4124811008,\"estimated_diameter_max\":542.0507863358},\"miles\":{\"estimated_diameter_min\":0.1506280858,\"estimated_diameter_max\":0.3368146392},\"feet\":{\"estimated_diameter_min\":795.3165644948,\"estimated_diameter_max\":1778.3819018419}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 15:33\",\"epoch_date_close_approach\":1638459180000,\"relative_velocity\":{\"kilometers_per_second\":\"13.4425120597\",\"kilometers_per_hour\":\"48393.0434147983\",\"miles_per_hour\":\"30069.5552262673\"},\"miss_distance\":{\"astronomical\":\"0.2002712406\",\"lunar\":\"77.9055125934\",\"kilometers\":\"29960151.016017522\",\"miles\":\"18616374.5885929236\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54215648?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54215648\",\"neo_reference_id\":\"54215648\",\"name\":\"(2021 VW)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54215648\",\"absolute_magnitude_h\":25.03,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0262153087,\"estimated_diameter_max\":0.0586192124},\"meters\":{\"estimated_diameter_min\":26.2153087281,\"estimated_diameter_max\":58.6192123671},\"miles\":{\"estimated_diameter_min\":0.0162894326,\"estimated_diameter_max\":0.0364242786},\"feet\":{\"estimated_diameter_min\":86.0082334874,\"estimated_diameter_max\":192.3202567026}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 18:09\",\"epoch_date_close_approach\":1638468540000,\"relative_velocity\":{\"kilometers_per_second\":\"3.8780447362\",\"kilometers_per_hour\":\"13960.9610502593\",\"miles_per_hour\":\"8674.7982703681\"},\"miss_distance\":{\"astronomical\":\"0.1362363616\",\"lunar\":\"52.9959446624\",\"kilometers\":\"20380669.511909792\",\"miles\":\"12663960.7990354496\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54224161?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54224161\",\"neo_reference_id\":\"54224161\",\"name\":\"(2021 WF1)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54224161\",\"absolute_magnitude_h\":21.838,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.1140131584,\"estimated_diameter_max\":0.2549411725},\"meters\":{\"estimated_diameter_min\":114.0131583771,\"estimated_diameter_max\":254.9411724607},\"miles\":{\"estimated_diameter_min\":0.0708444702,\"estimated_diameter_max\":0.1584130513},\"feet\":{\"estimated_diameter_min\":374.0589305301,\"estimated_diameter_max\":836.4211962561}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 05:19\",\"epoch_date_close_approach\":1638422340000,\"relative_velocity\":{\"kilometers_per_second\":\"19.9132837254\",\"kilometers_per_hour\":\"71687.8214115883\",\"miles_per_hour\":\"44544.0243654394\"},\"miss_distance\":{\"astronomical\":\"0.1122270329\",\"lunar\":\"43.6563157981\",\"kilometers\":\"16788925.078259923\",\"miles\":\"10432154.2982080174\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54224426?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54224426\",\"neo_reference_id\":\"54224426\",\"name\":\"(2021 WF2)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54224426\",\"absolute_magnitude_h\":24.939,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0273372596,\"estimated_diameter_max\":0.0611279707},\"meters\":{\"estimated_diameter_min\":27.3372595791,\"estimated_diameter_max\":61.1279707375},\"miles\":{\"estimated_diameter_min\":0.0169865803,\"estimated_diameter_max\":0.0379831483},\"feet\":{\"estimated_diameter_min\":89.6891747176,\"estimated_diameter_max\":200.5510915144}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 06:02\",\"epoch_date_close_approach\":1638424920000,\"relative_velocity\":{\"kilometers_per_second\":\"12.5846155092\",\"kilometers_per_hour\":\"45304.6158331466\",\"miles_per_hour\":\"28150.526432546\"},\"miss_distance\":{\"astronomical\":\"0.0299949892\",\"lunar\":\"11.6680507988\",\"kilometers\":\"4487186.494993004\",\"miles\":\"2788208.3970472952\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54224433?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54224433\",\"neo_reference_id\":\"54224433\",\"name\":\"(2021 WN2)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54224433\",\"absolute_magnitude_h\":26.686,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0122279872,\"estimated_diameter_max\":0.0273426107},\"meters\":{\"estimated_diameter_min\":12.2279872327,\"estimated_diameter_max\":27.3426106804},\"miles\":{\"estimated_diameter_min\":0.0075981167,\"estimated_diameter_max\":0.0169899053},\"feet\":{\"estimated_diameter_min\":40.1180696327,\"estimated_diameter_max\":89.7067308247}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 23:28\",\"epoch_date_close_approach\":1638487680000,\"relative_velocity\":{\"kilometers_per_second\":\"8.481461878\",\"kilometers_per_hour\":\"30533.2627606503\",\"miles_per_hour\":\"18972.1820748052\"},\"miss_distance\":{\"astronomical\":\"0.0147457096\",\"lunar\":\"5.7360810344\",\"kilometers\":\"2205926.747798552\",\"miles\":\"1370699.3209099376\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54225005?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54225005\",\"neo_reference_id\":\"54225005\",\"name\":\"(2021 WC3)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54225005\",\"absolute_magnitude_h\":28.702,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0048323121,\"estimated_diameter_max\":0.0108053784},\"meters\":{\"estimated_diameter_min\":4.832312108,\"estimated_diameter_max\":10.805378362},\"miles\":{\"estimated_diameter_min\":0.0030026586,\"estimated_diameter_max\":0.0067141488},\"feet\":{\"estimated_diameter_min\":15.8540428564,\"estimated_diameter_max\":35.4507175451}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 09:01\",\"epoch_date_close_approach\":1638435660000,\"relative_velocity\":{\"kilometers_per_second\":\"12.8540716789\",\"kilometers_per_hour\":\"46274.6580440396\",\"miles_per_hour\":\"28753.2729385312\"},\"miss_distance\":{\"astronomical\":\"0.0034728657\",\"lunar\":\"1.3509447573\",\"kilometers\":\"519533.311516059\",\"miles\":\"322823.0302732542\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54225497?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54225497\",\"neo_reference_id\":\"54225497\",\"name\":\"(2021 WK4)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54225497\",\"absolute_magnitude_h\":27.742,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0075189116,\"estimated_diameter_max\":0.0168127974},\"meters\":{\"estimated_diameter_min\":7.5189115612,\"estimated_diameter_max\":16.8127973677},\"miles\":{\"estimated_diameter_min\":0.0046720336,\"estimated_diameter_max\":0.0104469847},\"feet\":{\"estimated_diameter_min\":24.6683458065,\"estimated_diameter_max\":55.1600981159}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 02:34\",\"epoch_date_close_approach\":1638412440000,\"relative_velocity\":{\"kilometers_per_second\":\"10.0688305972\",\"kilometers_per_hour\":\"36247.7901498955\",\"miles_per_hour\":\"22522.9671628615\"},\"miss_distance\":{\"astronomical\":\"0.0116991464\",\"lunar\":\"4.5509679496\",\"kilometers\":\"1750167.382258168\",\"miles\":\"1087503.5831239984\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54225500?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54225500\",\"neo_reference_id\":\"54225500\",\"name\":\"(2021 WL4)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54225500\",\"absolute_magnitude_h\":24.047,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0412244601,\"estimated_diameter_max\":0.0921806951},\"meters\":{\"estimated_diameter_min\":41.224460103,\"estimated_diameter_max\":92.180695126},\"miles\":{\"estimated_diameter_min\":0.025615684,\"estimated_diameter_max\":0.0572784107},\"feet\":{\"estimated_diameter_min\":135.2508576842,\"estimated_diameter_max\":302.4301117971}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 08:36\",\"epoch_date_close_approach\":1638434160000,\"relative_velocity\":{\"kilometers_per_second\":\"10.1156542475\",\"kilometers_per_hour\":\"36416.3552909525\",\"miles_per_hour\":\"22627.7069862032\"},\"miss_distance\":{\"astronomical\":\"0.0817826246\",\"lunar\":\"31.8134409694\",\"kilometers\":\"12234506.443169602\",\"miles\":\"7602169.7864884276\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54225501?api_key=S1dKiTwSlrleYW2zi81hNY65kxaMtC3eqk95qCrX\"},\"id\":\"54225501\",\"neo_reference_id\":\"54225501\",\"name\":\"(2021 WN4)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54225501\",\"absolute_magnitude_h\":24.896,\"estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0278839937,\"estimated_diameter_max\":0.0623505055},\"meters\":{\"estimated_diameter_min\":27.8839937427,\"estimated_diameter_max\":62.3505054929},\"miles\":{\"estimated_diameter_min\":0.0173263051,\"estimated_diameter_max\":0.0387427959},\"feet\":{\"estimated_diameter_min\":91.4829220308,\"estimated_diameter_max\":204.5620324412}},\"is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"2021-12-02\",\"close_approach_date_full\":\"2021-Dec-02 20:26\",\"epoch_date_close_approach\":1638476760000,\"relative_velocity\":{\"kilometers_per_second\":\"7.9766995228\",\"kilometers_per_hour\":\"28716.1182820246\",\"miles_per_hour\":\"17843.0791625169\"},\"miss_distance\":{\"astronomical\":\"0.0316791754\",\"lunar\":\"12.3231992306\",\"kilometers\":\"4739137.163196398\",\"miles\":\"2944763.2827223724\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":false}]}}";
                
                 String rawDataJson = request.body();
                JSONObject jsonObject = new JSONObject(rawDataJson);
                JSONObject nearEarthObjects = jsonObject.getJSONObject("near_earth_objects");

                // delete old data
                asteroids.clear();
                
                // loop through each date
                int currIndex = 0;
                Iterator<String> keys = nearEarthObjects.keys();
                while (keys.hasNext()) {
                    String date = keys.next();
                    JSONArray nearEarthObjectsOnDate = nearEarthObjects.getJSONArray(date);
                    for (int i = 0; i < nearEarthObjectsOnDate.length(); i++) {
                        JSONObject nearEarthObject = nearEarthObjectsOnDate.getJSONObject(i);
                        String name = nearEarthObject.getString("name");
                        JSONArray closeApproachData = nearEarthObject.getJSONArray("close_approach_data");

                        // map orbitting_body from close_approach_data to array and join string with comma
                        String now_orbitting = "";
                        for (int j = 0; j < closeApproachData.length(); j++) {
                            JSONObject closeApproachDataOnDate = closeApproachData.getJSONObject(j);
                            String orbitting = closeApproachDataOnDate.getString("orbiting_body");
                            now_orbitting += orbitting + ", ";
                        }
                        now_orbitting = now_orbitting.substring(0, now_orbitting.length() - 2);

                        asteroids.add(new Object[] { currIndex, date, name, now_orbitting });
                        asteroids_data.add(nearEarthObject);
                        currIndex++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // hide loader
        setLoading(false);

        // update table
        fetchCount++;
        System.out.println("fetchCount: " + fetchCount);
        drawTable();
    }

    public void drawTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.getDataVector().clear();
        for (Object[] asteroid : asteroids) {
            model.addRow(asteroid);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        PanelLoader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        ImgPlanet3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel2.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLoader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/Ellipsis-1s-200px.gif"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Loading ...");

        javax.swing.GroupLayout PanelLoaderLayout = new javax.swing.GroupLayout(PanelLoader);
        PanelLoader.setLayout(PanelLoaderLayout);
        PanelLoaderLayout.setHorizontalGroup(
            PanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoaderLayout.createSequentialGroup()
                .addGroup(PanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoaderLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1))
                    .addGroup(PanelLoaderLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel2)))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        PanelLoaderLayout.setVerticalGroup(
            PanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(PanelLoader, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 220, 820, 110));

        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jDateChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        ImgPlanet3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/planet-11.png"))); // NOI18N
        jPanel2.add(ImgPlanet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 200, 210));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Asteroid Name", "Now Orbitting"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 600, 410));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/background_space.png"))); // NOI18N
        jPanel2.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainMenu win = new MainMenu();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        int row = jTable1.getSelectedRow();
        JSONObject rowData = (JSONObject) asteroids_data.get(row);
        // Object[] rowData = new Object[jTable1.getColumnCount()];
        // System.out.print("aweawe");
        // for (int i = 0; i < jTable1.getColumnCount(); i++) {
        //    rowData[i] = jTable1.getValueAt(0, i);
        //    System.out.print(rowData[i]);
        // }
        AsteroidInformation win = new AsteroidInformation(rowData);
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // System.out.print("aweawe23");
        // int columnIndex = jTable1.getSelectedColumn();
        // check double click or single click
        // AsteroidInformation win = new AsteroidInformation();
        // win.setVisible(true);
        // this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        if (fetchCount > 0) {
            FetchData();
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AsteroidTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsteroidTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsteroidTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsteroidTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsteroidTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel ImgPlanet3;
    private javax.swing.JPanel PanelLoader;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
