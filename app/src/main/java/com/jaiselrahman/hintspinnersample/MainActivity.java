/*
 * Copyright 2018 JaiselRahman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jaiselrahman.hintspinnersample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.jaiselrahman.hintspinner.HintSpinner;
import com.jaiselrahman.hintspinner.HintSpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CustomObject[] labels = new CustomObject[]{
            new CustomObject("Label 1"),
            new CustomObject("Label 2"),
            new CustomObject("Label 3"),
            new CustomObject("Label 4"),
            new CustomObject("Label 5"),
            new CustomObject("Label 6"),
            new CustomObject("Label 7"),
            new CustomObject("Label 8"),
            new CustomObject("Label 9"),
            new CustomObject("Label 10"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selected = findViewById(R.id.selected_text);
        selected.setText(getString(R.string.selected, ""));


        final HintSpinnerAdapter hintSpinnerAdapter = new HintSpinnerAdapter<CustomObject>(this, labels, "Select a label") {
            @Override
            public String getLabelFor(CustomObject object) {
                return object.getName();
            }
        };

        HintSpinner hintSpinner = findViewById(R.id.hint_spinner);
        hintSpinner.setAdapter(hintSpinnerAdapter);

        hintSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected.setText(getString(R.string.selected, labels[position].getName()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText hint = findViewById(R.id.hint);

        findViewById(R.id.set_hint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintSpinnerAdapter.setHint(hint.getText().toString());
                hintSpinnerAdapter.notifyDataSetChanged();
            }
        });
    }

    static class CustomObject {
        private String name;

        CustomObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
