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

package com.jaiselrahman.hintspinner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;

@SuppressWarnings("unused")
public class HintSpinner extends AppCompatSpinner {
    private boolean hasHint = false;

    public HintSpinner(Context context) {
        this(context, null, android.R.attr.spinnerStyle);
    }

    public HintSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.spinnerStyle);
    }

    public HintSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setClickable(true);
    }

    public void setAdapter(HintSpinnerAdapter adapter) {
        super.setAdapter(adapter);
        hasHint = adapter.hasHint();
    }

    @Override
    public void setOnItemSelectedListener(@Nullable final OnItemSelectedListener listener) {
        super.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    if (!hasHint) {
                        listener.onItemSelected(parent, view, position, id);
                    } else if (position > 0) {
                        listener.onItemSelected(parent, view, position - 1, id);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (listener != null) {
                    listener.onNothingSelected(parent);
                }
            }
        });
    }
}
