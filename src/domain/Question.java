/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.List;

/**
 *
 * @author aa769
 */
public class Question {
    private String type;
    private List<List<String>> items;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<String>> getItems() {
        return items;
    }

    public void setItems(List<List<String>> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Question{" +
                "type='" + type + '\'' +
                ", item=" + items +
                '}';
    }
}
