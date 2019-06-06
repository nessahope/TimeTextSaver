package com.hope.nessa.texttimesaver.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.hope.nessa.texttimesaver.ContactProfile;
import com.hope.nessa.texttimesaver.R;
import com.hope.nessa.texttimesaver.connector.EventContacrFragmentListener;
import com.hope.nessa.texttimesaver.dao.ContactDao;
import com.hope.nessa.texttimesaver.dao.ContactFactory;
import com.hope.nessa.texttimesaver.model.Contact;


public class ContactFragment extends ListFragment {

    private ContactProfile contactProfile;
    private ContactDao contactDao;
    private EventContacrFragmentListener eventContacrFragmentListener;
    private ArrayAdapter<Contact> contactArrayAdapter;

    private final String CONTACT_PROFILE = "Contact Profile Fragment called";

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactDao = ContactFactory.getContactDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        contactArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.one_item);
        contactArrayAdapter.addAll(contactDao.getAll());
        setListAdapter(contactArrayAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        eventContacrFragmentListener = (EventContacrFragmentListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        getListView().setItemChecked(position, true);

        String phonenumber = "";
        for(Contact contact : contactDao.getAll()) {
             phonenumber = contact.getPhoneNumber();
        }
        Bundle bundle = new Bundle();
        bundle.putString("contact", phonenumber);

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        contactProfile = new ContactProfile();
        contactProfile.setArguments(bundle);
        fragmentTransaction.replace(R.id.profileFragmentContainer, contactProfile, CONTACT_PROFILE);
        fragmentTransaction.addToBackStack("Profile");
        fragmentTransaction.commit();

    }
}
