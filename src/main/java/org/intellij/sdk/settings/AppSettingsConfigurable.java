// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class AppSettingsConfigurable implements Configurable {

  private AppSettingsComponent mySettingsComponent;

  // A default constructor with no arguments is required because this implementation
  // is registered as an applicationConfigurable EP

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "Index Advisor Settings";
  }


  @Nullable
  @Override
  public JComponent createComponent() {
    mySettingsComponent = new AppSettingsComponent();
    return mySettingsComponent.getPanel();
  }


  @Override
  public boolean isModified() {
    AppSettingsState settings = AppSettingsState.getInstance();
    boolean modified = !mySettingsComponent.getDdlModeText().equals(settings.ddlMode);
    modified |= !mySettingsComponent.getExecModeText().equals(settings.execMode);
    modified |= !mySettingsComponent.getDedupExistingFlagText().equals(settings.dedupExistingFlag);
    modified |= !mySettingsComponent.getValidateText().equals(settings.validate);
    modified |= !mySettingsComponent.getStatsModeText().equals(settings.statsMode);
    modified |= !mySettingsComponent.getLandFlagText().equals(settings.landFlag);
    modified |= !mySettingsComponent.getQueryTypeText().equals(settings.queryType);
    modified |= !mySettingsComponent.getDatabaseTypeText().equals(settings.databaseType);
    modified |= !mySettingsComponent.getHostPortText().equals(settings.hostPort);
    modified |= !mySettingsComponent.getUserNameText().equals(settings.userName);
    modified |= !mySettingsComponent.getPasswordText().equals(settings.password);
    modified |= !mySettingsComponent.getDefaultDatabaseText().equals(settings.defaultDatabase);
    modified |= !mySettingsComponent.getSchemaDatabaseListText().equals(settings.schemaDatabaseList);
    return modified;
  }

  @Override
  public void apply() {
    AppSettingsState settings = AppSettingsState.getInstance();
    settings.ddlMode = mySettingsComponent.getDdlModeText();
    settings.execMode = mySettingsComponent.getExecModeText();
    settings.dedupExistingFlag = mySettingsComponent.getDedupExistingFlagText();
    settings.validate = mySettingsComponent.getValidateText();
    settings.statsMode = mySettingsComponent.getStatsModeText();
    settings.landFlag = mySettingsComponent.getLandFlagText();
    settings.queryType = mySettingsComponent.getQueryTypeText();
    settings.databaseType = mySettingsComponent.getDatabaseTypeText();
    settings.hostPort = mySettingsComponent.getHostPortText();
    settings.userName = mySettingsComponent.getUserNameText();
    settings.password = mySettingsComponent.getPasswordText();
    settings.defaultDatabase = mySettingsComponent.getDefaultDatabaseText();
    settings.schemaDatabaseList = mySettingsComponent.getSchemaDatabaseListText();
  }

  @Override
  public void reset() {
    AppSettingsState settings = AppSettingsState.getInstance();
    mySettingsComponent.setDdlModeText(settings.ddlMode);
    mySettingsComponent.setExecModeText(settings.execMode);
    mySettingsComponent.setDedupExistingFlagText(settings.dedupExistingFlag);
    mySettingsComponent.setValidateText(settings.validate);
    mySettingsComponent.setStatsModeText(settings.statsMode);
    mySettingsComponent.setLandFlagText(settings.landFlag);
    mySettingsComponent.setQueryTypeText(settings.queryType);
    mySettingsComponent.setDatabaseTypeText(settings.databaseType);
    mySettingsComponent.setHostPortText(settings.hostPort);
    mySettingsComponent.setUserNameText(settings.userName);
    mySettingsComponent.setPasswordText(settings.password);
    mySettingsComponent.setDefaultDatabaseText(settings.defaultDatabase);
    mySettingsComponent.setSchemaDatabaseListText(settings.schemaDatabaseList);
  }

  @Override
  public void disposeUIResources() {
    mySettingsComponent = null;
  }

}
