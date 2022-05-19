package com.chomentowski.mBankHomework.server;

import pl.mbank.exampleRootLibrary.DocumentServer;
import pl.mbank.exampleRootLibrary.fields.ControlInterface;
import pl.mbank.exampleRootLibrary.fields.TextFieldInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private final DocumentServerInterfaceFacade documentServerInterface;
    private final List<ControlInterface> fieldsList = new ArrayList<>();

    public Server() {
        DocumentServer documentServer = new DocumentServer();
        documentServerInterface = new DocumentServerInterfaceFacadeImpl(documentServer.getDocumentServerInterface());
    }

    public void init() {
        TextFieldInterface nameTextField = documentServerInterface.createTextField("name");
        TextFieldInterface surNameTextField = documentServerInterface.createTextField("surName");
        ExtendedSelectionBoxInterface colorSelectionBox = new ExtendedSelectionBoxInterface(documentServerInterface.createSelectionBox("color"));
        ExtendedSelectionBoxInterface countrySelectionBox = new ExtendedSelectionBoxInterface(documentServerInterface.createSelectionBox("country"));

        nameTextField.setValue("Kamil");
        surNameTextField.setValue("Kudynowski");

        colorSelectionBox.addItems("green", "red", "black");
        countrySelectionBox.addItems("Afghanistan", "Pakistan", "Turkmenistan");

        countrySelectionBox.selectItem("Afghanistan");
        colorSelectionBox.selectItem("black");

        addFieldsToList(nameTextField, surNameTextField, colorSelectionBox, countrySelectionBox);
        setFieldsAsReadOnly();
    }

    private void setFieldsAsReadOnly() {
        fieldsList.forEach(e -> e.setReadOnly(true));
    }

    private void addFieldsToList(ControlInterface... fields) {
        fieldsList.addAll(Arrays.asList(fields));
    }
}
