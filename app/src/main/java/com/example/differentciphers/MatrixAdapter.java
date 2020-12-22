package com.example.differentciphers;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MatrixAdapter extends BaseAdapter {
    private final Context mContext;
    private final char[] Matrix;
    public MatrixAdapter(Context context, char [] arr) {
        this.mContext = context;
        this.Matrix = arr;
    }
    @Override
    public int getCount() {
        return Matrix.length;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         final char matr = Matrix[position];
        String cell=String.valueOf(Matrix[position]);
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(cell);
        return dummyTextView;


    }

}