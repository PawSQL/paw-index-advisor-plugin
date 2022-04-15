package org.intellij.sdk.settings;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.tigerose.sqllab.foundation.utils.Config;
import com.tigerose.sqllab.foundation.utils.connector.ServerInfo;
import com.tigerose.sqllab.indexadvisor.IndexAdvisor;

import java.io.File;
import java.util.Arrays;

public class IAAction extends AnAction {
Logger
    @Override
    public void actionPerformed(AnActionEvent e) {
        AppSettingsState settings = AppSettingsState.getInstance();
        Project project = e.getData(CommonDataKeys.PROJECT);
        VirtualFile virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        String resultFile = "";
        String sourcePath = "";
        if (virtualFile.isDirectory()){
            //在本级目录创建目录名+index.sql的文件
            resultFile = virtualFile.getPath()+File.separator+"ia_index.sql";
            sourcePath = virtualFile.getPath();
        }else {
            VirtualFile parent = virtualFile.getParent();
            System.out.println(virtualFile.getName());
            resultFile = parent.getPath()+ File.separator + virtualFile.getName()+"_ia_index.sql";
            sourcePath = parent.getPath();
        }

        Config config = new Config();
        config.setDdlMode(settings.ddlMode);
        config.setExecMode(settings.execMode);
        ServerInfo serverInfo = new ServerInfo(settings.hostPort,settings.userName,settings.password,settings.defaultDatabase,settings.databaseType);
        config.setServer(serverInfo);
        config.setQueryMode(settings.queryType);
        config.setDatabaseList(Arrays.asList(settings.schemaDatabaseList.split(",")));
        config.getServer().setSchemaList(config.getDatabaseList());
        config.setDedupExistingFlag(settings.dedupExistingFlag);
        config.setValidate(settings.validate);

        config.setResultFolder(resultFile);
        System.out.println("resultFile:"+resultFile);
        config.setQueryFolder(sourcePath);
        System.out.println("sourcePath"+sourcePath);
        config.setMapperFolder(sourcePath);
        config.setStatsMode(settings.statsMode);
        config.setLandFlag(Boolean.valueOf(settings.landFlag));
        IndexAdvisor indexAdvisor = new IndexAdvisor(config);
        indexAdvisor.loadStatsAndDDL();
        indexAdvisor.recommendIndexes();

    }

    @Override
    public void update(AnActionEvent event) {

        // Enable/disable depending on whether user is editing
        VirtualFile virtualFile = event.getData(CommonDataKeys.VIRTUAL_FILE);
        event.getPresentation().setEnabled(virtualFile != null);
    }
}
