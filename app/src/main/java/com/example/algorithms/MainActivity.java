package com.example.algorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.algorithms.algorithms.searching.QuickSelect;
import com.example.algorithms.algorithms.sorting.HeapSort;
import com.example.algorithms.algorithms.sorting.Insertion;
import com.example.algorithms.algorithms.sorting.Merge;
import com.example.algorithms.algorithms.sorting.Quick;
import com.example.algorithms.algorithms.sorting.Selection;
import com.example.algorithms.algorithms.sorting.Shell;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Algorithms_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] a = new Integer[] {
                3, 5, 8, 6, 2, 1, 9, 6,
        };

//        Log.d(TAG, "Test QuickSort");
//        Quick.sort(a);
//        Quick.show(a);

        Log.d(TAG, "Test QuickSelect");
        for (int i = 0; i < a.length; ++i) {
            Integer key = (Integer) QuickSelect.select(a, i);
            Log.d(TAG, "select: " + i + ", key: " + key);
        }
        QuickSelect.show(a);
    }
}