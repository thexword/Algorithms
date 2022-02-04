package com.example.algorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.algorithms.algorithms.searching.BST;
import com.example.algorithms.algorithms.searching.QuickSelect;
import com.example.algorithms.algorithms.sorting.HeapSort;
import com.example.algorithms.algorithms.sorting.Insertion;
import com.example.algorithms.algorithms.sorting.Merge;
import com.example.algorithms.algorithms.sorting.Quick;
import com.example.algorithms.algorithms.sorting.Selection;
import com.example.algorithms.algorithms.sorting.Shell;

import java.util.Iterator;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Algorithms_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] a = new Integer[] {
                3, 5, 8, 6, 2, 1, 9, 6, 345, 1, 2
        };

        Log.d(TAG, "Test QuickSort");
        Quick.sort(a);
        Quick.show(a);

        Log.d(TAG, "Test QuickSelect");
        for (int i = 0; i < a.length; ++i) {
            Log.d(TAG, "select: " + i + ", key: " + QuickSelect.select(a, i));
        }

        BST bst = new BST<Character, Integer>();
        bst.put("b", 1);
        bst.put("c", 4);
        bst.put("a", 2);
        bst.print();

        Log.d(TAG, "get: " + bst.get("l"));
        Log.d(TAG, "minimum: " + bst.minimum());
        Log.d(TAG, "maximum: " + bst.maximum());
        Log.d(TAG, "floor: " + bst.floor("l"));
        Log.d(TAG, "ceiling: " + bst.ceiling("l"));
        Log.d(TAG, "select: " + bst.select(1));
        Log.d(TAG, "rank: " + bst.rank("c"));

//        bst.deleteMin();
//        bst.print();
//
//        bst.delete("k");
//        bst.print();
//
//        bst.delete("b");
//        bst.print();

        Iterable<Character> chars = bst.keys();
        Iterator<Character> iterator = chars.iterator();

        while (iterator.hasNext()) {
            Log.d(TAG, "char: " + iterator.next());
        }

        Log.d(TAG, "%: " + (14 % -3));
    }
}