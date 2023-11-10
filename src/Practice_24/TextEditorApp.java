package Practice_24;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface IDocument {
    void open();
    void save();
    void close();
}

class TextDocument implements IDocument {
    @Override
    public void open() {
        System.out.println("Открыт текстовый документ");
    }

    @Override
    public void save() {
        System.out.println("Сохранен текстовый документ");
    }

    @Override
    public void close() {
        System.out.println("Закрыт текстовый документ");
    }
}

interface ICreateDocument {
    IDocument createNew();
    IDocument createOpen();
}

class CreateTextDocument implements ICreateDocument {
    @Override
    public IDocument createNew() {
        return new TextDocument();
    }

    @Override
    public IDocument createOpen() {
        return new TextDocument();
    }
}

public class TextEditorApp extends JFrame {
    private IDocument currentDocument;
    private ICreateDocument factory;

    public TextEditorApp(ICreateDocument factory) {
        this.factory = factory;
        this.currentDocument = factory.createNew();
        setTitle("Text Editor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDocument = factory.createNew();
                currentDocument.open();
            }
        });
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDocument = factory.createOpen(); // Теперь используется поле factory
                currentDocument.open();
            }
        });
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDocument.save();
            }
        });
        fileMenu.add(saveMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ICreateDocument textDocumentFactory = new CreateTextDocument();
            TextEditorApp editorApp = new TextEditorApp(textDocumentFactory);
            editorApp.setVisible(true);
        });
    }
}
