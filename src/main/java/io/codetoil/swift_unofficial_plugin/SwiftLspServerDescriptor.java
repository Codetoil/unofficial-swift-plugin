package io.codetoil.swift_unofficial_plugin;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor;
import kotlin.text.Charsets;
import org.apache.commons.lang3.SystemUtils;
import org.jetbrains.annotations.NotNull;

public class SwiftLspServerDescriptor extends ProjectWideLspServerDescriptor {
    public SwiftLspServerDescriptor(@NotNull Project project) {
        super(project, "Swift");
    }

    @Override
    public boolean isSupportedFile(@NotNull VirtualFile virtualFile) {
        return "swift".equals(virtualFile.getExtension());
    }

    @NotNull
    @Override
    public GeneralCommandLine createCommandLine() throws ExecutionException {
        return new GeneralCommandLine("sourcekit-lsp")
                .withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
                .withCharset(Charsets.UTF_8);
    }
}
