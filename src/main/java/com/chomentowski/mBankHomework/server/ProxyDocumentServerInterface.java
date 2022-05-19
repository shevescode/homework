package com.chomentowski.mBankHomework.server;

import pl.mbank.exampleRootLibrary.fields.SelectionBoxInterface;
import pl.mbank.exampleRootLibrary.fields.TextFieldInterface;

public interface ProxyDocumentServerInterface {
    TextFieldInterface createTextField(String name);
    SelectionBoxInterface createSelectionBox(String name);
}

