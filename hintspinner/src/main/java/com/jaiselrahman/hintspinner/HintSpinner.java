package com.jaiselrahman.hintspinner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

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
