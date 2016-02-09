package pl.droidsonroids.examplerealmmvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import pl.droidsonroids.examplerealmmvp.R;
import pl.droidsonroids.examplerealmmvp.model.Book;
import pl.droidsonroids.examplerealmmvp.model.utils.BookDetailsUtils;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> implements RealmChangeListener {

    private RealmResults<Book> mBooks;
    private OnBookClickListener mOnBookClickListener;

    public BookListAdapter() {}

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Book book = mBooks.get(position);

        holder.mTextTitle.setText(book.getTitle());
        holder.mTextDetails.setText(BookDetailsUtils.getDetails(book));
        holder.mTextTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mOnBookClickListener != null) {
                    mOnBookClickListener.onBookClick(book.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    @Override
    public void onChange() {
        notifyDataSetChanged();
    }

    public void setOnBookClickListener(final OnBookClickListener onBookClickListener) {
        mOnBookClickListener = onBookClickListener;
    }

    public void setBooks(final RealmResults<Book> books) {
        mBooks = books;
        mBooks.addChangeListener(this);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text_title) TextView mTextTitle;
        @Bind(R.id.text_details) TextView mTextDetails;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnBookClickListener {
        void onBookClick(int id);
    }
}
