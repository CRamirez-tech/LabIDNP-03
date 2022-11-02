package org.idnp.labidnp_03.validator;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

public class DniFormatWatcher implements TextWatcher {

    private int size;

    public DniFormatWatcher(int size) {
        this.size = size;
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        char hyphen = ' ';
        char c = 0;
        if (editable.length() > 0) {
            c = editable.charAt(editable.length() - 1);
            if (c == hyphen) {
                editable.delete(editable.length() - 1, editable.length());
            }
        }
        if (editable.length() > 0 && (editable.length() % size) == 0) {
            c = editable.charAt(editable.length() - 1);
            if (hyphen == c) {
                editable.delete(editable.length() - 1, editable.length());
            }
        }
        if (editable.length() > 0 && (editable.length() % size) == 0) {
            c = editable.charAt(editable.length() - 1);
            // Only if its a digit where there should be a space we insert a hyphen
            if (Character.isDigit(c) && TextUtils.split(editable.toString(), String.valueOf(hyphen)).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(hyphen));
            }
        }
    }
}
