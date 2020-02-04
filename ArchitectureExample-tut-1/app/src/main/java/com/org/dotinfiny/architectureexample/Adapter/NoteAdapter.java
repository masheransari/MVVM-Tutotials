package com.org.dotinfiny.architectureexample.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.dotinfiny.architectureexample.DatabaseOperation.Note;
import com.org.dotinfiny.architectureexample.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note= notes.get(position);
        holder.tvPriority.setText(""+note.getPriority());
        holder.tvDescription.setText(""+note.getDescription());
        holder.tvTitle.setText(""+note.getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvPriority;
        private TextView tvDescription;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.text_view_title);
            tvDescription = (TextView) itemView.findViewById(R.id.text_view_description);
            tvPriority = (TextView) itemView.findViewById(R.id.text_view_priority);
        }
    }
}
