package cz.uhk.mois.edoras.controllers;

import cz.uhk.mois.edoras.Item;
import cz.uhk.mois.edoras.JsonReader;
import net.bytebuddy.matcher.FilterableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ValuesController {
    @Autowired
    public ValuesController() {

    }

    @GetMapping("/values")
    public ResponseEntity<ArrayList<String>> getClients() {
        JSONArray jsonObject = null;
        try {
            jsonObject = JsonReader.readJsonFromUrl("http://localhost:5000/shoppingList");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jsonObject == null) {
            Exception e = new Exception("Something went wrong.");
            e.printStackTrace();
        } else {

        }

        List<Item> items = new ArrayList<>();
        try {

            for (int i = 0; i < jsonObject.length(); i++) {
                JSONObject o = jsonObject.getJSONObject(i);
                Item item = new Item();
                item.setId(o.getLong("id"));
                item.setContent(o.getString("content"));
                item.setCount(o.getInt("count"));
                item.setDate(o.getString("createdAt"));
                item.setState(o.getString("state"));
                items.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String out = "";
        for (Item item : items) {
            System.out.println(item);
            out = out + "\n" + item;

        }

        return new ResponseEntity(out, HttpStatus.OK);
    }
}
