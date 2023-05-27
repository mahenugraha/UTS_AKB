/**
 *
 * Nama : Mahendra Nugraha
 * Nim : 10120015
 * Kelas : IF 1
 * Email : mahenugrahaa
 *
 */

package com.uts.mahendranugraha_10120015.ui.information;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InformationsViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}