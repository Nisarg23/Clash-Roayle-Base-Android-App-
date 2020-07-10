package com.example.clashroyalebase;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EmailFragment extends Fragment {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_email, container, false);


        mEditTextMessage = root.findViewById(R.id.edit_text_message);
        mEditTextTo = root.findViewById(R.id.edit_text_to);
        mEditTextSubject = root.findViewById(R.id.edit_text_subject);

        Button buttonSend = root.findViewById(R.id.button_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });



        return root;
    }

    private void sendMail(){
            String recipient = mEditTextTo.getText().toString();
            String[] recipients = recipient.split(",");

        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
