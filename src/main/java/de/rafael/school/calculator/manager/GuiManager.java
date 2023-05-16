package de.rafael.school.calculator.manager;

import de.rafael.school.calculator.interfaces.*;

public class GuiManager {

    private final Calculator calculator;
    private Gui gui;

    public GuiManager(Calculator calculator) {
        this.calculator = calculator;
    }

    public void registerGui(Gui gui) {
        if(this.gui != null) {
            throw new IllegalStateException("Gui already assigned");
        }
        this.gui = gui;
    }

    public Gui gui() {
        return this.gui;
    }

    public Calculator calculator() {
        return this.calculator;
    }

}