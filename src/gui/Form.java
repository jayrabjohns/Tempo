package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class Form {
    protected JFrame form;

    public Form(Dimension size) {
        this.form = new JFrame();
        this.form.setSize(size);
        this.form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.draw();
    }

    public abstract void draw();

    public void show() {
        this.form.setLocationRelativeTo(null);
        this.form.setVisible(true);
    }

    public void hide() {
        this.form.setVisible(false);
    }

    public JFrame getForm() {
        return this.form;
    }
}