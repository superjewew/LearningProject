package norman.com.learningproject.fragment;


import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import norman.com.learningproject.DatabaseHelper;
import norman.com.learningproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConstantsFragment extends ListFragment {

    private DatabaseHelper db;
    AsyncTask task;
    Cursor current;

    public ConstantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constants, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DatabaseHelper(getActivity().getApplicationContext());
        task = new LoadCursorTask();
        task.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(task != null) {
            task.cancel(false);
        }

        ((CursorAdapter) getListAdapter()).getCursor().close();

        db.close();
    }

    abstract private class BaseTask<T> extends AsyncTask<T, Void, Cursor> {
        @Override
        protected void onPostExecute(Cursor cursor) {
            ((CursorAdapter) getListAdapter()).changeCursor(cursor);
            current = cursor;
            task = null;
        }

        Cursor doQuery() {
            Cursor result = db.getReadableDatabase()
                    .query(DatabaseHelper.TABLE,
                            new String[]{"ROWID as _id",
                                    DatabaseHelper.TITLE,
                                    DatabaseHelper.VALUE},
                            null, null, null, null, DatabaseHelper.TITLE);

            result.getCount();

            return result;
        }
    }

    private class LoadCursorTask extends BaseTask<Void> {
        @Override
        protected Cursor doInBackground(Void... voids) {
            return doQuery();
        }
    }

    private class InsertTask extends BaseTask<ContentValues> {
        @Override
        protected Cursor doInBackground(ContentValues... contentValues) {
            db.getWritableDatabase().insert(DatabaseHelper.TABLE, DatabaseHelper.TITLE, contentValues[0]);

            return doQuery();
        }
    }
}
