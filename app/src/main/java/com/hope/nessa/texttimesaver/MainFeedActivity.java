package com.hope.nessa.texttimesaver;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hope.nessa.texttimesaver.connector.EventContacrFragmentListener;
import com.hope.nessa.texttimesaver.dao.ContactDao;
import com.hope.nessa.texttimesaver.dao.ContactFactory;
import com.hope.nessa.texttimesaver.model.Contact;

public class MainFeedActivity extends AppCompatActivity implements EventContacrFragmentListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_feed_activity);
        getSupportActionBar().hide();

        contactDao = ContactFactory.getContactDao();
        contactDao.addUser(new Contact("Andrew","McFarlane","(514)111-1111"));
        contactDao.addUser(new Contact("Jean-Luc","Trembly","(514)111-1111"));
        contactDao.addUser(new Contact("Vanessa","McFarlane","(514)111-1111"));
        contactDao.addUser(new Contact("Nadia","L'Esperance","(514)111-1111"));

        viewPagerAdapter =  new ViewPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onContactAdded(Contact contact) {

    }

    @Override
    public void onContactRemoved(Contact contact) {

    }

    @Override
    public void onContactModified(Contact contact, Contact newContact) {

    }
}
