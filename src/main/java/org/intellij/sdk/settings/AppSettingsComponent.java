// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.settings;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.*;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class AppSettingsComponent {

  private final JPanel myMainPanel;

  private final JBTextField ddlMode = new JBTextField();
  private final JBTextField execMode = new JBTextField();
  private final JBTextField dedupExistingFlag = new JBTextField();
  private final JBTextField validate = new JBTextField();
  private final JBTextField statsMode = new JBTextField();
  private final JBTextField landFlag = new JBTextField();

  private final JBTextField queryType = new JBTextField();
  private final JBTextField databaseType = new JBTextField();

  private final JBTextField hostPort = new JBTextField();
  private final JBTextField userName = new JBTextField();
  private final JBTextField password = new JBTextField();
  private final JBTextField defaultDatabase = new JBTextField();
  private final JBTextField schemaDatabaseList = new JBTextField();
  private final JButton resetBt = new JButton("Default Value");

  public AppSettingsComponent() {
    resetBt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        ddlMode.setText(Constant.DDL_MODE);
        execMode.setText(Constant.EXEC_MODE);
        dedupExistingFlag.setText(Constant.DEDUP_EXISTING_FLAG);
        validate.setText(Constant.VALIDATE);
        statsMode.setText(Constant.STATS_MODE);
        landFlag.setText(Constant.LAND_FLAG);
        queryType.setText(Constant.QUERY_TYPE);
        databaseType.setText(Constant.DATABASE_TYPE);
        hostPort.setText(Constant.HOST_PORT);
        userName.setText(Constant.USER_NAME);
        password.setText(Constant.PASSWORD);
        defaultDatabase.setText("");
        schemaDatabaseList.setText("");
      }
    });
    myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(new JBLabel("Ddl Mode: "), ddlMode, 1, false)
            .addLabeledComponent(new JBLabel("Exec Mode: "), execMode, 1, false)
            .addLabeledComponent(new JBLabel("Dedup Existing Flag: "), dedupExistingFlag, 1, false)
            .addLabeledComponent(new JBLabel("Validate: "), validate, 1, false)
            .addLabeledComponent(new JBLabel("Stats Mode: "), statsMode, 1, false)
            .addLabeledComponent(new JBLabel("Land Flag: "), landFlag, 1, false)
            .addLabeledComponent(new JBLabel("Query Type: "), queryType, 1, false)
            .addLabeledComponent(new JBLabel("Database Type: "), databaseType, 1, false)
            .addLabeledComponent(new JBLabel("Database HostPort: "), hostPort, 1, false)
            .addLabeledComponent(new JBLabel("Database UserName: "), userName, 1, false)
            .addLabeledComponent(new JBLabel("Database Password: "), password, 1, false)
            .addLabeledComponent(new JBLabel("Default Database: "), defaultDatabase, 1, false)
            .addLabeledComponent(new JBLabel("Schema/Database List: "), schemaDatabaseList, 1, false)
            .addComponent(resetBt,1)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
  }

  public JPanel getPanel() {
    return myMainPanel;
  }

  @NotNull
  public String getDdlModeText() {
    return ddlMode.getText();
  }

  public void setDdlModeText(@NotNull String newText) {
    ddlMode.setText(newText);
  }

  @NotNull
  public String getExecModeText() {
    return execMode.getText();
  }

  public void setExecModeText(@NotNull String newText) {
    execMode.setText(newText);
  }

  @NotNull
  public String getDedupExistingFlagText() {
    return dedupExistingFlag.getText();
  }

  public void setDedupExistingFlagText(@NotNull String newText) {
    dedupExistingFlag.setText(newText);
  }

  @NotNull
  public String getValidateText() {
    return validate.getText();
  }

  public void setValidateText(@NotNull String newText) {
    validate.setText(newText);
  }

  @NotNull
  public String getStatsModeText() {
    return statsMode.getText();
  }

  public void setStatsModeText(@NotNull String newText) {
    statsMode.setText(newText);
  }

  @NotNull
  public String getLandFlagText() {
    return landFlag.getText();
  }

  public void setLandFlagText(@NotNull String newText) {
    landFlag.setText(newText);
  }

  @NotNull
  public String getQueryTypeText() {
    return queryType.getText();
  }

  public void setQueryTypeText(@NotNull String newText) {
    queryType.setText(newText);
  }

  @NotNull
  public String getDatabaseTypeText() {
    return databaseType.getText();
  }

  public void setDatabaseTypeText(@NotNull String newText) {
    databaseType.setText(newText);
  }

  @NotNull
  public String getHostPortText() {
    return hostPort.getText();
  }

  public void setHostPortText(@NotNull String newText) {
    hostPort.setText(newText);
  }
  @NotNull
  public String getUserNameText() {
    return userName.getText();
  }

  public void setUserNameText(@NotNull String newText) {
    userName.setText(newText);
  }

  @NotNull
  public String getPasswordText() {
    return password.getText();
  }

  public void setPasswordText(@NotNull String newText) {
    password.setText(newText);
  }

  public String getDefaultDatabaseText() {
    return defaultDatabase.getText();
  }

  public void setDefaultDatabaseText(String newText) {
    defaultDatabase.setText(newText);
  }

  public String getSchemaDatabaseListText() {
    return schemaDatabaseList.getText();
  }

  public void setSchemaDatabaseListText(String newText) {
    schemaDatabaseList.setText(newText);
  }



}
