package com.hope.nessa.texttimesaver.connector;

import com.hope.nessa.texttimesaver.model.Contact;

public interface EventContacrFragmentListener {

    void onContactAdded(Contact contact);
    void onContactRemoved(Contact contact);
    void onContactModified(Contact contact, Contact newContact);
}
