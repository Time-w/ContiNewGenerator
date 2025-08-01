package top.continew.format;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.codeStyle.CodeStyleManager;
import java.io.File;

/**
 * @author lww
 * @date 2025-06-23 19:48
 */
public class IdeaCodeFormatter {

	public static void formatFile(String filePath) {
		Project project = ProjectManager.getInstance().getOpenProjects()[0];
		VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(filePath);

		if (virtualFile != null) {
			WriteCommandAction.runWriteCommandAction(project, () -> {
				try {
					PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
					if (psiFile != null) {
						CodeStyleManager.getInstance(project).reformat(psiFile);
						Document document = FileDocumentManager.getInstance().getDocument(virtualFile);
						if (document != null) {
							EditorFactory.getInstance().getEditors(document)[0].getContentComponent().requestFocus();
						}
					}
				} catch (Exception ignored) {
				}
			});
		}
	}

	public static void formatFile(File file) {
		Project project = ProjectManager.getInstance().getOpenProjects()[0];
		VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(file);
		if (virtualFile != null) {
			WriteCommandAction.runWriteCommandAction(project, () -> {
				try {
					PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
					if (psiFile != null) {
						CodeStyleManager.getInstance(project).reformat(psiFile);
						Document document = FileDocumentManager.getInstance().getDocument(virtualFile);
						if (document != null) {
							EditorFactory.getInstance().getEditors(document)[0].getContentComponent().requestFocus();
						}
					}
				} catch (Exception ignored) {
				}
			});
		}
	}
}
