package io.github.codetoil.swift_unofficial_plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.LspServerSupportProvider;
import org.jetbrains.annotations.NotNull;

public class SwiftLspServerSupportProvider implements LspServerSupportProvider {
    @Override
    public void fileOpened(@NotNull Project project, @NotNull VirtualFile virtualFile,
                           @NotNull LspServerSupportProvider.LspServerStarter lspServerStarter) {
        if ("swift".equals(virtualFile.getExtension()))
        {
            lspServerStarter.ensureServerStarted(new SwiftLspServerDescriptor(project));
        }
    }
}
