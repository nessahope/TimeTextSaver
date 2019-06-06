package com.hope.nessa.texttimesaver;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hope.nessa.texttimesaver.fragment.AddContactFragment;
import com.hope.nessa.texttimesaver.fragment.ContactFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ContactFragment contactFragment;
    AddContactFragment addContactFragment;

    private String CONTACT_FRAGMENT_TITLE = "Contacts";
    private String ADD_CONTACT_FRAGMENT_TITLE = "Add Contact";

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                contactFragment = new ContactFragment();
                return contactFragment;
            case 1:
                addContactFragment = new AddContactFragment();
                return addContactFragment;

                default: return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return CONTACT_FRAGMENT_TITLE;
        } else if (position == 1){
            return ADD_CONTACT_FRAGMENT_TITLE;
        }
        return "Nothing";
    }
}
